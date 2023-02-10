using ClosedXML.Excel;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Repaso2daEvaluacion
{
    public partial class Consultar : Form
    {
        public Consultar()
        {
            InitializeComponent();
        }

        private void Consultar_Load(object sender, EventArgs e)
        {
            dateInicio.Value = DateTime.Now;
            dateFin.Value = dateInicio.Value;
        }

        private void btnbuscar_Click(object sender, EventArgs e)
        {
            //control de fecha fin mayor que fecha inicio
            if(dateFin.Value < dateInicio.Value)
            {
                MessageBox.Show("Por favor, introduzca una fecha válida (La fecha de fin no puede ser menor que la de inicio)", "¡Alerta!", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }
            else
            {
                //vaciar datagrid por si tuviese datos anteriores
                dgvdata.Rows.Clear();

                //comprobación de que el número de empelado está vacío
                if(txtbusqueda.Text.Trim() == "")
                {
                    listarSinNumero();
                }
                else
                {
                    listar();
                }
                if(dgvdata.RowCount == 0)
                {
                    MessageBox.Show("No se han encontrado valores, o el empleado es inexistente", "Información", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
            }
        }

        private void btnexportar_Click(object sender, EventArgs e)
        {
                if (dgvdata.Rows.Count < 1)
                {
                    MessageBox.Show("No hay datos para exportar", "Mensaje", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                }
                else
                {
                    DataTable dt = new DataTable();

                    foreach (DataGridViewColumn columna in dgvdata.Columns)
                    {
                        if (columna.HeaderText != "" && columna.Visible)
                            dt.Columns.Add(columna.HeaderText, typeof(string));
                    }

                    foreach (DataGridViewRow row in dgvdata.Rows)
                    {
                        if (row.Visible)
                            dt.Rows.Add(new object[] {
                            row.Cells[1].Value.ToString(),
                            row.Cells[2].Value.ToString(),
                            row.Cells[3].Value.ToString(),
                            row.Cells[4].Value.ToString(),
                            row.Cells[5].Value.ToString(),
                            row.Cells[6].Value.ToString()
                        });
                    }
                    string finicio = dateInicio.Value.ToString("yyyyMMdd");
                    string ffin = dateFin.Value.ToString("yyyyMMdd");
                    SaveFileDialog savefile = new SaveFileDialog();
                    savefile.FileName = string.Format("InformeFichaje_{0}.xlsx", finicio + "-a-" + ffin);
                    savefile.Filter = "Excel Files | *.xlsx";

                    if (savefile.ShowDialog() == DialogResult.OK)
                    {

                        try
                        {
                            XLWorkbook wb = new XLWorkbook();
                            var hoja = wb.Worksheets.Add(dt, "Informe");
                            hoja.ColumnsUsed().AdjustToContents();
                            wb.SaveAs(savefile.FileName);
                            MessageBox.Show("Reporte Generado", "Mensaje", MessageBoxButtons.OK, MessageBoxIcon.Information);

                        }
                        catch
                        {
                            MessageBox.Show("Error al generar reporte", "Mensaje", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                        }

                    }

                }
        }

        public void listarSinNumero()
        {
            List<Fichaje> lista = new List<Fichaje>();
            try
            {
                using (SqlConnection conexion = new SqlConnection(Conexion.cadena))
                {
                    conexion.Open();
                    StringBuilder query = new StringBuilder();

                    query.AppendLine("SELECT IdFichaje, empnum, empNombre, serNombre, ");
                    query.AppendLine("CONVERT(NVARCHAR, ficfechahora, 103) as fecha, ");
                    query.AppendLine("CONVERT(NVARCHAR, ficfechahora, 8) as hora, ");
                    query.AppendLine("fictipomov AS tipo from fichaje");
                    query.AppendLine("INNER join personal on fichaje.IdEmpleado = personal.IdEmpleado");
                    query.AppendLine("INNER join servicio on personal.idServicio = servicio.idservicio");
                    query.AppendLine("where convert(varchar, ficfechahora, 112) between Convert(datetime, @fechainicio, 112) and Convert(datetime, @fechafin, 112)");
                    query.AppendLine("order by fecha, empnum, hora");

                    //convertir fechas seleccionadas a formato compatible consulta sql
                    string finicio = dateInicio.Value.ToString("yyyyMMdd");
                    string ffin = dateFin.Value.ToString("yyyyMMdd");

                    SqlCommand cmd = new SqlCommand(query.ToString(), conexion);
                    cmd.Parameters.AddWithValue("@fechainicio", finicio);
                    cmd.Parameters.AddWithValue("@fechafin", ffin);
                    cmd.CommandType = System.Data.CommandType.Text;

                    using (SqlDataReader dr = cmd.ExecuteReader())
                    {
                        while (dr.Read())
                        {
                            dgvdata.Rows.Add(new object[]
                            {
                                Convert.ToInt32(dr["idFichaje"]),
                                Convert.ToInt32(dr["empnum"]),
                                dr["sernombre"].ToString(),
                                dr["empNombre"].ToString(),
                                dr["fecha"].ToString(),
                                dr["hora"].ToString(),
                                dr["tipo"].ToString() == "1" ? "Entrada" : "Salida"
                            });
                        }
                    }
                }
            }
            catch(Exception e)
            {
                lista = new List<Fichaje>();
                MessageBox.Show("Error en el acceso a la base de datos:" + e.Message, "Error");
            }
        }

        public void listar()
        {
            List<Fichaje> lista = new List<Fichaje>();
            try
            {
                using (SqlConnection conexion = new SqlConnection(Conexion.cadena))
                {
                    conexion.Open();
                    StringBuilder query = new StringBuilder();

                    query.AppendLine("SELECT IdFichaje, empnum, empNombre, serNombre, ");
                    query.AppendLine("CONVERT(NVARCHAR, ficfechahora, 103) as fecha, ");
                    query.AppendLine("CONVERT(NVARCHAR, ficfechahora, 8) as hora, ");
                    query.AppendLine("fictipomov AS tipo from fichaje");
                    query.AppendLine("INNER join personal on fichaje.IdEmpleado = personal.IdEmpleado");
                    query.AppendLine("INNER join servicio on personal.idServicio = servicio.idservicio");
                    query.AppendLine("where convert(varchar, ficfechahora, 112) between Convert(datetime, @fechainicio, 112) and Convert(datetime, @fechafin, 112)");
                    query.AppendLine("and empnum = @numEmpleado");
                    query.AppendLine("order by fecha, empnum, hora");

                    //convertir fechas seleccionadas a formato compatible consulta sql
                    string finicio = dateInicio.Value.ToString("yyyyMMdd");
                    string ffin = dateFin.Value.ToString("yyyyMMdd");
                    int numEmpleado = Convert.ToInt32(txtbusqueda.Text);

                    SqlCommand cmd = new SqlCommand(query.ToString(), conexion);
                    cmd.Parameters.AddWithValue("@fechainicio", finicio);
                    cmd.Parameters.AddWithValue("@fechafin", ffin);
                    cmd.Parameters.AddWithValue("@numEmpleado", numEmpleado);
                    cmd.CommandType = System.Data.CommandType.Text;

                    using (SqlDataReader dr = cmd.ExecuteReader())
                    {
                        while (dr.Read())
                        {
                            dgvdata.Rows.Add(new object[]
                            {
                                Convert.ToInt32(dr["idFichaje"]),
                                Convert.ToInt32(dr["empnum"]),
                                dr["sernombre"].ToString(),
                                dr["empNombre"].ToString(),
                                dr["fecha"].ToString(),
                                dr["hora"].ToString(),
                                dr["tipo"].ToString() == "1" ? "Entrada" : "Salida"
                            });
                        }
                    }
                }
            }
            catch (Exception e)
            {
                lista = new List<Fichaje>();
                MessageBox.Show("Error en el acceso a la base de datos:" + e.Message, "Error");
            }
        }

        public void limpiar()
        {
            dgvdata.Rows.Clear();
            txtbusqueda.Text = "";
        }
    }
}
