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
    public partial class Fichar : Form
    {
        public Fichar()
        {
            InitializeComponent();
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            txtFecha.Text = DateTime.Now.ToString();
        }

        private void Fichar_Load(object sender, EventArgs e)
        {
            limpiar();
            timer1.Enabled = true;
        }

        private void btnFichar_Click(object sender, EventArgs e)
        {
            //Control checkbutton seleccionado
            string mensaje = "Hola";
            if(!(rbEntrada.Checked || rbSalida.Checked))
            {
                MessageBox.Show("Selecciona un valor, por favor", "Aviso", MessageBoxButtons.OK);
            }
            else
            {
                int numero = 0;
                if(txtNumEmpleado.Text.Trim() == "" || int.TryParse(txtNumEmpleado.Text, out numero) == false) //Esto comprueba si lo introducido es numérico o no está vacío
                {
                    MessageBox.Show("Introduzca un número válido, o el nombre del empleado a buscar", "Aviso", MessageBoxButtons.OK);
                }
                else
                {
                    int resulado = fichar();
                    if(resulado == 1)
                    {
                        mensaje = "Fichaje realizado con éxito";
                    }
                    else
                    {
                        mensaje = "No se ha podido registrar el fichaje. Comprueba el número de empelado introducido";
                    }
                    label7.Text = mensaje.ToString();
                }
            }
        }

        private void btnBuscarEmpleado_Click(object sender, EventArgs e)
        {
                try
                {
                    using (SqlConnection conexion = new SqlConnection(Conexion.cadena))
                    {
                        conexion.Open();
                        string query = "select empnum from dbo.personal where empNombre=@nombre";

                        SqlCommand cmd = new SqlCommand(query.ToString(), conexion);
                        cmd.Parameters.AddWithValue("@nombre", txtNombre.Text);

                        using (SqlDataReader dr = cmd.ExecuteReader())
                            while (dr.Read())
                            {
                                txtNumEmpleado.Text = dr["empnum"].ToString();
                            }
                    }
                }
                catch (Exception)
                {
                    MessageBox.Show("Error de acceso a la base de datos: ");
                }
            }

        public void limpiar()
        {
            txtNumEmpleado.Text = "";
            label7.Text = "";
            label8.Visible = false;
            int hora = DateTime.Now.Hour;
            if((hora >= 7 && hora <= 11) || (hora >= 15 && hora <= 16))
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

        private int fichar()
        {
            int filasAfectadas = 0;
            try
            {
                using (SqlConnection conexion = new SqlConnection(Conexion.cadena))
                {
                    conexion.Open();
                    StringBuilder query = new StringBuilder();
                    query.AppendLine("insert into dbo.fichaje(idEmpleado, fictipomov)");
                    query.AppendLine("values ((select idEmpleado from dbo.Personal where empnum = @empleado), @acceso)");

                    SqlCommand cmd = new SqlCommand(query.ToString(), conexion);
                    cmd.Parameters.AddWithValue("@empleado", txtNumEmpleado.Text);
                    cmd.Parameters.AddWithValue("@acceso", rbEntrada.Checked == true ? "1" : "0");
                    filasAfectadas = cmd.ExecuteNonQuery();
                }
            }catch(Exception e)
            {
                MessageBox.Show("Error de acceso a la base de datos: " + e.Message);
            }
            return filasAfectadas;  //Devuelve 1 o 0, dado que realizamos una isnerción de un sólo valor. 
        }

        
    }
}
