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

        public void listarSinNumero()
        {
            List<Fichaje> lista = new List<Fichaje>();
            try
            {
                using (SqlConnection conexion = new SqlConnection(Conexion.cadena))
                {
                    conexion.Open();
                    StringBuilder query = new StringBuilder();

                    query.AppendLine("SELECT IdFichaje, empnum, empNombre, serNombre, " +
                        "CONVERT(NVARCHAR, ficfechahora, 103) as fecha, " +
                        "CONVERT(NVARCHAR, ficfechahora, 8) as hora, " +
                        "fictipomov AS tipo from fichaje");
                    query.AppendLine("INNER join personal on fichaje.IdEmpleado = personal.IdEmpelado");
                    query.AppendLine("INNVER join servicio on personal.idServicio = servicio.idservicio");
                    query.AppendLine("where convert(varchar, ficfhecahora, 112) between Convert(datetime, @fechainicio, 112) and Convert(datetime, @fechafin, 112)");
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
                                dr["sernombre"].ToString()
                            })
                        }
                    }
                }
            }
            catch(Exception e)
            {

            }
        }

        private void Consultar_Load(object sender, EventArgs e)
        {
            dateInicio.Value = DateTime.Now;
            dateFin.Value = dateInicio.Value;
        }

    }
}
