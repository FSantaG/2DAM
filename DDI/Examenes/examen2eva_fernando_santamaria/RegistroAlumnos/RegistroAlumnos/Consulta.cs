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

namespace RegistroAlumnos
{
    public partial class Consulta : Form
    {
        public Consulta()
        {
            InitializeComponent();
        }

        private void Consulta_Load(object sender, EventArgs e)
        {
            dateInicio.Value = DateTime.Now;
            dateFin.Value = DateTime.Now;
        }

        private void btnbuscar_Click(object sender, EventArgs e)
        {
            //control de fecha fin mayor que fecha inicio
            if (dateFin.Value < dateInicio.Value)
            {
                MessageBox.Show("Por favor, introduzca una fecha válida (La fecha de fin no puede ser menor que la de inicio)", "¡Alerta!", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }
            else
            {
                dgvdata.Rows.Clear();

                if (txtbusqueda.Text.Trim() == "")
                {
                    listarSinNumero();
                }
                else
                {
                    listar();
                }
                if (dgvdata.RowCount == 0)
                {
                    MessageBox.Show("No se han encontrado valores, o el alumno no existe", "Información", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
            }
        }

        private void btnlimpiarbuscador_Click(object sender, EventArgs e)
        {
            limpiar();
        }

        public void listarSinNumero()
        {
            try
            {
                using (SqlConnection conexion = new SqlConnection(Conexion.cadena))
                {
                    conexion.Open();
                    StringBuilder query = new StringBuilder();

                    query.AppendLine("SELECT Idregistro, alunum, aluNombre, Cnombre, ");
                    query.AppendLine("CONVERT(NVARCHAR, regfechahora, 103) as fecha, ");
                    query.AppendLine("CONVERT(NVARCHAR, regfechahora, 8) as hora, ");
                    query.AppendLine("regtipomov AS tipo from registro");
                    query.AppendLine("INNER join alumno on registro.Idalumno = alumno.Idalumno");
                    query.AppendLine("INNER join curso on alumno.IdCurso = curso.IdCurso");
                    query.AppendLine("where convert(varchar, regfechahora, 112) between Convert(datetime, @fechainicio, 112) and Convert(datetime, @fechafin, 112)");
                    query.AppendLine("and aluestado = 1");
                    query.AppendLine("order by fecha, alunum, hora");

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
                                Convert.ToInt32(dr["Idregistro"]),
                                Convert.ToInt32(dr["alunum"]),
                                dr["aluNombre"].ToString(),
                                dr["Cnombre"].ToString(),
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
                MessageBox.Show("Error en el acceso a la base de datos:" + e.Message, "Error");
            }
        }

        public void listar()
        {
            try
            {
                using (SqlConnection conexion = new SqlConnection(Conexion.cadena))
                {
                    conexion.Open();
                    StringBuilder query = new StringBuilder();

                    query.AppendLine("SELECT Idregistro, alunum, aluNombre, Cnombre, ");
                    query.AppendLine("CONVERT(NVARCHAR, regfechahora, 103) as fecha, ");
                    query.AppendLine("CONVERT(NVARCHAR, regfechahora, 8) as hora, ");
                    query.AppendLine("regtipomov AS tipo from registro");
                    query.AppendLine("INNER join alumno on registro.Idalumno = alumno.Idalumno");
                    query.AppendLine("INNER join curso on alumno.IdCurso = curso.IdCurso");
                    query.AppendLine("where convert(varchar, regfechahora, 112) between Convert(datetime, @fechainicio, 112) and Convert(datetime, @fechafin, 112)");
                    query.AppendLine("and alunum = @numAlumno");
                    query.AppendLine("and aluestado = 1");
                    query.AppendLine("order by fecha, alunum, hora");


                    string finicio = dateInicio.Value.ToString("yyyyMMdd");
                    string ffin = dateFin.Value.ToString("yyyyMMdd");

                    SqlCommand cmd = new SqlCommand(query.ToString(), conexion);
                    cmd.Parameters.AddWithValue("@fechainicio", finicio);
                    cmd.Parameters.AddWithValue("@fechafin", ffin);
                    cmd.Parameters.AddWithValue("@numAlumno", Convert.ToInt32(txtbusqueda.Text));
                    cmd.CommandType = System.Data.CommandType.Text;

                    using (SqlDataReader dr = cmd.ExecuteReader())
                    {
                        while (dr.Read())
                        {
                            dgvdata.Rows.Add(new object[]
                            {
                                Convert.ToInt32(dr["Idregistro"]),
                                Convert.ToInt32(dr["alunum"]),
                                dr["aluNombre"].ToString(),
                                dr["Cnombre"].ToString(),
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
