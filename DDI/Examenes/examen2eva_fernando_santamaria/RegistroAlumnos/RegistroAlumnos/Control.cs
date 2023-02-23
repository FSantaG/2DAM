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
    public partial class Control : Form
    {
        public Control()
        {
            InitializeComponent();
        }

        private void Control_Load(object sender, EventArgs e)
        {
            comprobarHoras();
            timer1.Enabled = true;
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            txtFecha.Text = DateTime.Now.ToString();
        }

        private void btnRegistro_Click(object sender, EventArgs e)
        {
            string mensaje = "Hola";
            if (!(rbEntrada.Checked || rbSalida.Checked))
            {
                MessageBox.Show("Selecciona un valor, por favor", "Aviso", MessageBoxButtons.OK);
            }
            else
            {
                int numero = 0;
                if (txtNumAlumno.Text.Trim() == "" || int.TryParse(txtNumAlumno.Text, out numero) == false) //Esto comprueba si lo introducido es numérico o no está vacío
                {
                    MessageBox.Show("Introduzca un número válido, o el nombre del alumno a buscar", "Aviso", MessageBoxButtons.OK);
                }
                else
                {
                    int resulado = registrar();
                    if (resulado == 1)
                    {
                        mensaje = "Registro realizado con éxito";
                        limpiar();
                    }
                    else
                    {
                        mensaje = "No se ha podido registrar el registro. Comprueba el número de alumno introducido";
                    }
                    label7.Text = mensaje.ToString();
                }
            }
        }

        private void btnBuscarAlumno_Click(object sender, EventArgs e)
        {
            try
            {
                using (SqlConnection conexion = new SqlConnection(Conexion.cadena))
                {
                    conexion.Open();
                    string query = "select alunum from dbo.alumno where aluNombre=@nombre and aluestado = 1";

                    SqlCommand cmd = new SqlCommand(query.ToString(), conexion);
                    cmd.Parameters.AddWithValue("@nombre", txtNombre.Text);

                    using (SqlDataReader dr = cmd.ExecuteReader())
                        while (dr.Read())
                        {
                            txtNumAlumno.Text = dr["alunum"].ToString();
                        }
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error de acceso a la base de datos: " + ex.Message, "Error");
            }
        }

        public void limpiar()
        {
            txtNumAlumno.Text = "";
            label7.Text = "";
        }

        private int registrar()
        {
            int filasAfectadas = 0;
            try
            {
                using (SqlConnection conexion = new SqlConnection(Conexion.cadena))
                {
                    conexion.Open();
                    StringBuilder query = new StringBuilder();
                    query.AppendLine("insert into dbo.registro(idAlumno, regtipomov)");
                    query.AppendLine("values ((select Idalumno from dbo.alumno where alunum = @numero and aluestado = 1), @acceso)");

                    SqlCommand cmd = new SqlCommand(query.ToString(), conexion);
                    cmd.Parameters.AddWithValue("@numero", txtNumAlumno.Text);
                    cmd.Parameters.AddWithValue("@acceso", rbEntrada.Checked == true ? "1" : "0");
                    filasAfectadas = cmd.ExecuteNonQuery();
                }
            }
            catch (Exception e)
            {
                MessageBox.Show("Error de acceso a la base de datos: " + e.Message);
            }
            return filasAfectadas;
        }

        private void comprobarHoras()
        {
            int hora = DateTime.Now.Hour;
            if ((hora >= 9 && hora <= 10) || (hora >= 16 && hora <= 17))
            {
                rbEntrada.Checked = true;
                rbSalida.Checked = false;
            }
            else
            {
                rbEntrada.Checked = false;
                rbSalida.Checked = true;
            }
        }
    }
}
