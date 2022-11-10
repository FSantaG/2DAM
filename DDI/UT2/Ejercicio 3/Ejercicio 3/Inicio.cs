using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
/**
 * Ventana de Inicio
 * @author Fernando Santamaría
 */
namespace Ejercicio_3
{
    public partial class Inicio : Form
    {
        //Array de calles
        String[] callesDisponibles = { "Calle San José", "Calle Ramón y Cajal",
        "Calle Burguense", "Calle Molinillo", "Calle Andrés Martinez Zatorre",
        "Calle Santa Clara", "Calle Mateo Cerezo", "Calle Dr. Fleming",
        "Calle Padre Salaverri", "Calle Diego de Siloe", "Calle Cartuja de Miraflores",
        "Calle Hijos de Santiago Rodriguez", "Calle Nicolás de Vergara",
        "Calle Obispo Don Mauricio" };
        /**
         * Constructor
         */
        public Inicio()
        {
            InitializeComponent();
        }

        /**
         * Evento de carga del formulario
         * 
         * Rellena el campo Calles, y establece los 2 radio buttons como no marcados
         **/
        private void Inicio_Load(object sender, EventArgs e)
        {
            menuNormal.Checked = false;
            menuVegano.Checked = false;
            rellenarCalles();
        }
        /**
         * Evento de Cambio de Selección en el campo Menú Normal
         * 
         * Realiza una comprobación de valores para habilitar el botón de Reservar
         **/
        private void menuNormal_CheckedChanged(object sender, EventArgs e)
        {
            habilitarBtnReserva();
        }

        /**
         * Evento de Cambio de Selección en el campo Menú Vegano
         * 
         * Realiza una comprobación de valores para habilitar el botón de Reservar
         **/
        private void menuVegano_CheckedChanged(object sender, EventArgs e)
        {
            habilitarBtnReserva();
        }

        /**
         * Evento de Cambio de Texto en el campo Nombre
         * 
         * Realiza una comprobación del campo para ver si es válido o no
         **/
        private void nombre_TextChanged(object sender, EventArgs e)
        {
            if (nombre.Text == "")
            {
                errorSeleccion.SetError(nombre, "Introduzca nombre");
                deshabilitarBtnReserva();
            }
            else {
                char[] caracteresNombre = nombre.Text.ToCharArray();
                realizarComprobacion(checkCaracteresLetras(caracteresNombre), nombre, "Por favor, introduzca sólo letras");
            }
        }
        /**
         * Evento de Cambio de Texto en el campo Teléfono
         * 
         * Realiza una comprobación del campo para ver si es válido o no
         **/
        private void telefono_TextChanged(object sender, EventArgs e)
        {
            char[] numTelefono = telefono.Text.ToCharArray();
            if(telefono.Text.Length < 9)
            {
                errorSeleccion.SetError(telefono, "Introduzca un número de teléfono válido");
                deshabilitarBtnReserva();
            }
            else
            {
                realizarComprobacion(checkCaracteresNums(numTelefono), telefono, "Por favor, introduzca sólo caracteres numéricos");
            }
        }

        /**
         * Evento de Cambio de Texto en el campo Número
         * 
         * Realiza una comprobación del campo para ver si es válido o no
         **/
        private void num_TextChanged(object sender, EventArgs e)
        {
            char[] numeroCalle = num.Text.ToCharArray();
            realizarComprobacion(checkCaracteresNums(numeroCalle), num, "Por favor, introduzca sólo caracteres numéricos");
        }

        /**
         * Evento de Cambio de Texto en el campo Piso
         * 
         * Realiza una comprobación del campo para ver si es válido o no
         **/
        private void piso_TextChanged(object sender, EventArgs e)
        {
            char[] numPiso = piso.Text.ToCharArray();
            realizarComprobacion(checkCaracteresNums(numPiso), piso, "Por favor, introduzca sólo caracteres numéricos");
        }

        /**
         * Evento de Cambio de Texto en el campo Letra
         * 
         * Realiza una comprobación del campo para ver si es válido o no
         **/
        private void letra_TextChanged(object sender, EventArgs e)
        {
            char[] letraPiso = letra.Text.ToCharArray();
            realizarComprobacion(checkCaracteresLetras(letraPiso), letra, "Sólo se admite una letra");
        }

        /**
         * Evento de Click sobre el botón Reservar
         * 
         * Crea la ventana del formulario pedido, pasándole como parámetros el tipo de menú
         * y el nombre
         **/
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

        /**
         * Evento de Click sobre el botón Reservar
         * 
         * Cierra la ventana
         **/
        private void btnSalir_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        //MÉTODOS PROPIOS
        /**
         * Realiza comprobaciones de los campos para
         * habilitar el botón de reserva
         **/
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

        /**
         * Deshabilita el botón de Reserva en caso de error
         **/
        private void deshabilitarBtnReserva()
        {
            btnReserva.Enabled = false;
        }

        /**
         * Rellena el ComboBox de calles
         **/
        private void rellenarCalles()
        {
            for(int i = 0; i < callesDisponibles.Length; i++)
            {
                selectCalle.Items.Add(callesDisponibles[i]);
            }
        }

        /**
         * Comprueba si los campos de texto introducidos contienen 
         * sólo caracteres alfabéticos
         * 
         * @param char[] caracteres Array de los caracteres que conforman el valor introducido
         **/
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

        /**
         * Comprueba si los campos de texto introducidos contienen 
         * sólo caracteres numéricos         
         * @param char[] caracteres Array de los caracteres que conforman el valor introducido
         **/
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

        /**
         * Realiza la verificación de los datos introducidos
         * 
         * @param Boolean verificador Función del tipo de comprobación a realizar (Numérica o alfabética)
         * @param TextBox campo Campo a verificar
         * @param String mensajeError Mensaje de error a mostrar por pantalla en caso de que la verificación sea errónea
         */
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
