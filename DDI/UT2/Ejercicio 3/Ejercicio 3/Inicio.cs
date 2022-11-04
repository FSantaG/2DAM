using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Ejercicio_3
{
    public partial class Inicio : Form
    {
        String[] callesDisponibles = { "Calle San José", "Calle Ramón y Cajal",
        "Calle Burguense", "Calle Molinillo", "Calle Andrés Martinez Zatorre",
        "Calle Santa Clara", "Calle Mateo Cerezo", "Calle Dr. Fleming",
        "Calle Padre Salaverri", "Calle Diego de Siloe", "Calle Cartuja de Miraflores",
        "Calle Hijos de Santiago Rodriguez", "Calle Nicolás de Vergara",
        "Calle Obispo Don Mauricio" };
        public Inicio()
        {
            InitializeComponent();

            menuNormal.Checked = false;
            menuVegano.Checked = false;
            rellenarCalles();
        }
        private void menuNormal_CheckedChanged(object sender, EventArgs e)
        {
            habilitarBtnReserva();
        }

        private void menuVegano_CheckedChanged(object sender, EventArgs e)
        {
            habilitarBtnReserva();
        }

        private void nombre_TextChanged(object sender, EventArgs e)
        {
            char[] caracteresNombre = nombre.Text.ToCharArray();
            realizarComprobacion(checkCaracteresLetras(caracteresNombre), nombre, "Por favor, introduzca sólo letras");
        }

        private void telefono_TextChanged(object sender, EventArgs e)
        {
            char[] numTelefono = telefono.Text.ToCharArray();
            if(telefono.Text.Length < 9)
            {
                errorSeleccion.SetError(telefono, "Introduzca un número de teléfono válido");
            }
            else
            {
                realizarComprobacion(checkCaracteresNums(numTelefono), telefono, "Por favor, introduzca sólo caracteres numéricos");
            }
        }

        private void num_TextChanged(object sender, EventArgs e)
        {
            char[] numeroCalle = num.Text.ToCharArray();
            realizarComprobacion(checkCaracteresNums(numeroCalle), num, "Por favor, introduzca sólo caracteres numéricos");
        }

        private void piso_TextChanged(object sender, EventArgs e)
        {
            char[] numPiso = piso.Text.ToCharArray();
            realizarComprobacion(checkCaracteresNums(numPiso), piso, "Por favor, introduzca sólo caracteres numéricos");
        }

        private void letra_TextChanged(object sender, EventArgs e)
        {
            char[] letraPiso = letra.Text.ToCharArray();
            realizarComprobacion(checkCaracteresLetras(letraPiso), letra, "Sólo se admite una letra");
        }

        private void btnReserva_Click(object sender, EventArgs e)
        {
            String menuElegido = "";
            if (menuNormal.Checked)
            {
                menuElegido = "Normal";
            }
            else if (menuVegano.Checked) 
            {
                menuElegido = "Vegano";
            }
            using (Pedido ventanaPedidos = new Pedido(nombre.Text, menuElegido))
                ventanaPedidos.ShowDialog();
        }

        private void btnSalir_Click(object sender, EventArgs e)
        {
            this.Close();
        }
        //Métodos Propios
        private void habilitarBtnReserva()
        {
            if((menuNormal.Checked || menuVegano.Checked) && nombre.Text != "" 
                && telefono.Text != "" && selectCalle.SelectedIndex != -1 
                && num.Text != "" && piso.Text != "" && letra.Text != "")
            {
                btnReserva.Enabled = true;
            }
            else
            {
                btnReserva.Enabled = false;
            }
        }

        private void deshabilitarBtnReserva()
        {
            btnReserva.Enabled = false;
        }

        private void rellenarCalles()
        {
            for(int i = 0; i < callesDisponibles.Length; i++)
            {
                selectCalle.Items.Add(callesDisponibles[i]);
            }
        }
        private Boolean checkCaracteresLetras(char[] caracteres)
        {
            for (int i = 0; i < caracteres.Length; i++)
            {
                if (!Char.IsLetter(caracteres[i]))
                {
                    return false;
                }
            }
            return true;
        }

        private Boolean checkCaracteresNums(char[] caracteres)
        {
            for (int i = 0; i < caracteres.Length; i++)
            {
                if (Char.IsLetter(caracteres[i]))
                {
                    return false;
                }
            }
            return true;
        }

        private void realizarComprobacion(Boolean verificador,TextBox campo ,String mensajeError)
        {
            if (!verificador)
            {
                errorSeleccion.SetError(campo, mensajeError);
                deshabilitarBtnReserva();
            }
            else
            {
                errorSeleccion.SetError(campo, "");
                habilitarBtnReserva();
            }
        }

        
    }
}
