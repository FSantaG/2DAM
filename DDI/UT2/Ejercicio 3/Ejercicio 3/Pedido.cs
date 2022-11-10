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
 * Ventana de Creación del Pedido
 * @author Fernando Santamaría
 **/
namespace Ejercicio_3
{
    public partial class Pedido : Form
    {
        //Menú elegido en la vista anterior
        String menuElegido;
        //Nombre del Usuario
        String nomUsuario;

        //Opciones para el menú normal
        String[] primerPlatoN = { "Canelones de Carne", "Hamburguesa Casera", 
            "Filete de Ternera con Patatas Panaderas"};
        String[] segundoPlatoN = { "Sopa de Marisco", "Lenguado con patatas fritas",
            "Ensalada Variada" };
        String[] postreN = { "Flan de Huevo Casero", "Tarta de Whitsky", "Helado de Chocolate" };

        //Opciones para el menú vegano
        String[] primerPlatoV = { "Hamburguesa de Aguacate y Quinoa", "Tacos de Garbanzos y Soja",
            "Curry de Garbanzos con Mango"};
        String[] segundoPlatoV = { "Mantequilla de Anacardos", "Tortilla Vegana de Calabacín",
            "Falafel ligero" };
        String[] postreV = { "Mousse de Coco Napolitano", "Tarta de Limón", "Helado de 4 sabores" };

        //Opciones globales

        //Bebidas
        Dictionary<String, Double> bebidas = new Dictionary<string, double>();
        String[] arrayBebidas = { "Refresco", "Vino", "Café", "Cerveza", "Champán" };
        Double[] arrayPrecios = { 1.60, 3.40, 2.60, 2.00, 5.90 };

        //Precios
        Double precioPrimero; //Precio del primer plato del menú elegido
        Double precioSegundo; //Precio del segundo plato del menú elegido
        Double precioPrimeroN = 4.4;
        Double precioPrimeroV = 4.4 + (4.4 * 20 / 100);
        Double precioSegundoN = 5.5;
        Double precioSegundoV = 5.5 + (5.5 * 20 / 100);
        Double total;

        /**
         * Constructor
        **/
        public Pedido(String nombre, String menuElegido)
        {
            InitializeComponent();
            this.nomUsuario = nombre;
            this.menuElegido = menuElegido;
        }

        /**
         * Evento de carga del formulario.
         * Valora si el menú escogido en la anterior ventana
         * es el normal o el vegano, y en función de ello
         * carga unos valores u otros dentro de los campos
         * Primer Plato, Segundo Plato y Postre
         **/
        private void Pedido_Load(object sender, EventArgs e)
        {
            bienvenido.Text += nomUsuario;
            rellenarBebidas();
            switch (menuElegido)
            {
                case "Normal":
                    rellenarPlato(primerPlatoN, selectPrimero);
                    primerPlato.Text += precioPrimeroN.ToString() + "€)";
                    rellenarPlato(segundoPlatoN, selectSegundo);
                    segundoPlato.Text += precioSegundoN.ToString() + "€)";
                    rellenarPlato(postreN, selectPostre);
                    precioPrimero = precioPrimeroN;
                    precioSegundo = precioSegundoN;
                    break;
                case "Vegano":
                    rellenarPlato(primerPlatoV, selectPrimero);
                    primerPlato.Text += precioPrimeroV.ToString() + "€)";
                    rellenarPlato(segundoPlatoV, selectSegundo);
                    segundoPlato.Text += precioSegundoV.ToString() + "€)";
                    rellenarPlato(postreV, selectPostre);
                    precioPrimero = precioPrimeroV;
                    precioSegundo = precioSegundoV;
                    break;
            }
        }

        /**
         * Evento de selección de valores del segundo plato
         * 
         * Cómo es el único obligatorio, este habilitará
         * el botón
         **/
        private void selectSegundo_SelectedIndexChanged(object sender, EventArgs e)
        {
            if(selectSegundo.SelectedIndex != -1)
            {
                btnVerPedido.Enabled = true;
            }
        }

        /**
         * Evento de selección de bebida.
         * 
         * Cambia en tiempo real el precio de la bebida según el índice
         * seleccionado, mostrándolo en la etiqueta superior.
         **/
        private void selectBebida_SelectedIndexChanged(object sender, EventArgs e)
        {
            limpiarPrecioBebida();
            bebidaPrecio.Text += "(" +
                bebidas[arrayBebidas[selectBebida.SelectedIndex]] +
                "€)";
        }

        /**
         * Evento de click del botón Ver Pedido
         * 
         * Calcula el precio a pagar por el plato, mostrándolo en un
         * modal que, al cerrarlo, cerrará la aplicación
         **/
        private void btnVerPedido_Click(object sender, EventArgs e)
        {
            if(selectPrimero.SelectedIndex != -1) {
                total += precioPrimero;
            }
            total += precioSegundo;
            if(selectPostre.SelectedIndex != -1)
            {
                total += 3;
            }
            if(selectBebida.SelectedIndex != -1)
            {
                total += bebidas[arrayBebidas[selectBebida.SelectedIndex]];
            }
            if (quierePan.Checked)
            {
                total += 0.8;
            }
            string mensaje = "Precio a Pagar: " + total + "€. " +
                "\nPulse el botón para salir";
            MessageBoxButtons botones = MessageBoxButtons.OK;
            MessageBox.Show(mensaje, "Recibo", botones);

            Application.Exit();
        }

        /**
         * Evento del botón Volver.
         * 
         * Cierra la ventana actual para modificar datos en la anterior vista
         **/
        private void btnVolver_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        //METODOS PROPIOS

        /**
         * Rellena los platos
         * @param String[] platos Lista de platos disponibles
         * @param ComboBox campo ComboBox donde se desglosarán los platos del menú seleccionado
         **/
        private void rellenarPlato(String[] platos, ComboBox campo)
        {
            for(int i = 0; i < platos.Length; i++)
            {
                campo.Items.Add(platos[i]);
            }
        }

        /**
         * Rellena el ComboBox de bebidas, y asigna pares Bebida -> Precio
         * Dentro del diccionario de bebidas
         **/
        private void rellenarBebidas()
        {
            bebidas = new Dictionary<string, double>();
            for(int i = 0; i < arrayBebidas.Length; i++)
            {
                bebidas.Add(arrayBebidas[i], arrayPrecios[i]);
            }

            foreach(String key in bebidas.Keys)
            {
                selectBebida.Items.Add(key);
            }
        }

        /**
         * Limpia de la etiqueta Bebida el precio para que esta quede más clara
         **/
        private void limpiarPrecioBebida()
        {
            bebidaPrecio.Text = "Bebida ";
        }
    }
}
