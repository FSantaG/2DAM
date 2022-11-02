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
    public partial class Form1 : Form
    {
        String[] callesDisponibles = { "Calle San José", "Calle Ramón y Cajal",
        "Calle Burguense", "Calle Molinillo", "Calle Andrés Martinez Zatorre",
        "Calle Santa Clara", "Calle Mateo Cerezo", "Calle Dr. Fleming",
        "Calle Padre Salaverri", "Calle Diego de Siloe", "Calle Cartuja de Miraflores",
        "Calle Hijos de Santiago Rodriguez", "Calle Nicolás de Vergara",
        "Calle Obispo Don Mauricio" };
        public Form1()
        {
            InitializeComponent();

            menuNormal.Checked = false;
            menuVegano.Checked = false;
            rellenarCalles();
        }
        private void nombre_TextChanged(object sender, EventArgs e)
        {
            char[] caracteres = nombre.Text.ToCharArray();
            if (!checkCaracteres(caracteres))
            {
                errorSeleccion.SetError(nombre, "Por favor, introduzca sólo letras");
                deshabilitarBtnReserva();
            }
            else
            {
                errorSeleccion.SetError(nombre, "");
                habilitarBtnReserva();
            }
        }

        private void telefono_TextChanged(object sender, EventArgs e)
        {
            char[] numTelefono = telefono.Text.ToCharArray();
            if (checkCaracteres(numTelefono))
            {
                errorSeleccion.SetError(telefono, "Por favor, introduzca sólo caracteres numéricos");
                deshabilitarBtnReserva();
            }
            else
            {
                errorSeleccion.SetError(telefono, "");
                habilitarBtnReserva();
            }
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
        //TODO
        //Modificar esto, y hacer 2 verificadores separados
        private Boolean checkCaracteres(char[] caracteres)
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

        
    }
}
