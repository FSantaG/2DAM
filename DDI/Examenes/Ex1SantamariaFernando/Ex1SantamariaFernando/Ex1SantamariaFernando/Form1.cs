using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Ex1SantamariaFernando
{
    public partial class Form1 : Form
    {
        private int aforoMaxPersonas = 3000;
        private int aforoMaxParking = 500;

        private int aforoActualPersonas = 0;
        private int aforoActualParking = 0;

        private Dictionary<string, string> listaTelefonos = new Dictionary<string, string>();
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            rbNo.Checked = true;
            actualizarAforos();
        }

        private void rbSi_CheckedChanged(object sender, EventArgs e)
        {
            habilitarCamposVehiculo(true);
            habilitarBtnCalcular(false);
        }

        private void rbNo_CheckedChanged(object sender, EventArgs e)
        {
            habilitarCamposVehiculo(false);
            habilitarBtnCalcular(true);
            matricula.Text = "";
            telefono.Text = "";
        }
        private void matricula_TextChanged(object sender, EventArgs e)
        {
            if(matricula.Text == "")
            {
                habilitarBtnCalcular(false);
                errorPanel1.SetError(matricula, "Introduzca una matrícula válida.");
            }
            else
            {
                habilitarBtnCalcular(true);
                errorPanel1.SetError(matricula, "");
            }
        }
        private void telefono_TextChanged(object sender, EventArgs e)
        {
            if(!int.TryParse(telefono.Text, out int n) && telefono.Text != "")
            {
                habilitarBtnCalcular(false);
                errorPanel1.SetError(telefono, "Introduzca sólo números, por favor.");
            }
            else if(telefono.Text == "")
            {
                habilitarBtnCalcular(false);
                errorPanel1.SetError(telefono, "Campo obligatorio");
            }else if (telefono.Text.Length != 9 || (telefono.Text.Substring(0, 1) != "6" && telefono.Text.Substring(0, 1) != "7"))
            {
                habilitarBtnCalcular(false);
                errorPanel1.SetError(telefono, "Introduzca un número de contacto válido, por favor");
            }
            else
            {
                habilitarBtnCalcular(true);
                errorPanel1.SetError(telefono, "");
            }
        }

        private void menores16_TextChanged(object sender, EventArgs e)
        {
            if(int.TryParse(menores16.Text, out int n))
            {
                if (Int16.Parse(menores16.Text) < 0)
                {
                    errorPanel1.SetError(menores16, "Introduzca un número válido");
                    habilitarBtnCalcular(false);
                }
                else if(Int16.Parse(menores16.Text) >= 0)
                {
                    if(Int16.Parse(menores16.Text) > 0 && Int16.Parse(mayores16.Text) == 0)
                    {
                        errorPanel1.SetError(menores16, "Los menores de 16 tienen que ir acompañados de un adulto.");
                        habilitarBtnCalcular(false);
                    }
                    else
                    {
                        errorPanel1.SetError(menores16, "");
                        habilitarBtnCalcular(true);
                    }
                }
                else
                {
                    errorPanel1.SetError(menores16, "");
                    habilitarBtnCalcular(true);
                }
            }
            else
            {
                errorPanel1.SetError(menores16, "Introduzca un número válido");
                habilitarBtnCalcular(false);
            }
        }

        private void mayores16_TextChanged(object sender, EventArgs e)
        {
            if (int.TryParse(mayores16.Text, out int n))
            {
                if (Int16.Parse(mayores16.Text) < 0)
                {
                    errorPanel1.SetError(mayores16, "Introduzca un número válido");
                    habilitarBtnCalcular(false);
                }
                else if (Int16.Parse(mayores16.Text) >= 0)
                {
                    if (Int16.Parse(mayores16.Text) == 0 && Int16.Parse(menores16.Text) > 0)
                    {
                        errorPanel1.SetError(menores16, "Los menores de 16 tienen que ir acompañados de un adulto.");
                        habilitarBtnCalcular(false);
                    }
                    else
                    {
                        errorPanel1.SetError(mayores16, "");
                        errorPanel1.SetError(menores16, "");
                        habilitarBtnCalcular(true);
                    }
                }
                else
                {
                    errorPanel1.SetError(mayores16, "");
                    errorPanel1.SetError(menores16, "");
                    habilitarBtnCalcular(true);
                }
            }
            else
            {
                errorPanel1.SetError(mayores16, "Introduzca un número válido");
                habilitarBtnCalcular(false);
            }
        }
        private void btnCalcular_Click(object sender, EventArgs e)
        {
            int asistentes = Int16.Parse(mayores16.Text) + Int16.Parse(menores16.Text);
            aforoActualPersonas += asistentes;
            if (rbSi.Checked) aforoActualParking++;

            if(aforoActualParking < aforoMaxParking && aforoActualPersonas < aforoMaxPersonas)
            {
                string mensaje = (rbSi.Checked ?
                    "Se accede con vehículo. Matrícula: " + matricula.Text + ", Teléfono: " + telefono.Text
                    : "No se accede con vehiculo" )+
                    ".\nMenores de 16: " + menores16.Text +
                    ".\nMayores de 16: " + mayores16.Text +
                    ".\n Mascotas: " + mascotas.Text +
                    "Total a pagar: " + calcularPrecio().ToString() + "€";
                MessageBoxButtons botones = MessageBoxButtons.OK;
                MessageBox.Show(mensaje, "Ticket", botones);
                actualizarAforos();
                listaTelefonos.Add(matricula.Text, telefono.Text);
            }
        }

        private void btnConsultar_Click(object sender, EventArgs e)
        {
            string matriculaBuscada = matriculaABuscar.Text;
            foreach (KeyValuePair<string, string> coche in listaTelefonos)
            {
                if(matriculaBuscada.ToLower() == coche.Key.ToLower())
                {
                    string mensaje = "Teléfono: " + coche.Value;
                    MessageBoxButtons botones = MessageBoxButtons.OK;
                    MessageBox.Show(mensaje, "Resultado de la búsqueda de " + matriculaBuscada, botones);
                }
            }
        }

        private void btnSalir_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        //METODOS PROPIOS
        private void habilitarCamposVehiculo(bool habilitador)
        {
            if (habilitador)
            {
                labelMatricula.Visible = true;
                labelTelefono.Visible = true;
                matricula.Visible = true;
                telefono.Visible = true;
            }
            else
            {
                labelMatricula.Visible = false;
                labelTelefono.Visible = false;
                matricula.Visible = false;
                telefono.Visible = false;
            }
        }

        private void habilitarBtnCalcular(bool habilitador)
        {
            if (habilitador)
            {
                if (rbSi.Checked)
                {
                    if(matricula.Text != "" && telefono.Text != "")
                    {
                        btnCalcular.Enabled = true;
                    }
                }
                else
                {
                    btnCalcular.Enabled = true;
                }
            }
            else
            {
                btnCalcular.Enabled = false;
            }
        }

        private int calcularPrecio()
        {
            int precio = 0;
            precio += 1 * Int16.Parse(menores16.Text);
            precio += 5 * Int16.Parse(mayores16.Text);
            if (rbSi.Checked) precio += 10;
            precio += 5 * Int16.Parse(mascotas.Text);
            return precio;
        }

        private void actualizarAforos()
        {
            aforoVehiculos.Text = aforoActualParking.ToString();
            aforoPersonas.Text = aforoActualPersonas.ToString();
        }

        
    }
}
