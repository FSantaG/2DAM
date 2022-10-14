﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
/**
 *TODO
 *Terminar funcionalidad de los selects de comida/bebida
 *Añadir funcionalidad del botón
 *Pulir posibles errores
 */
namespace Ejercicio_2
{
    public partial class formularioReserva : Form
    {
        //array de credenciales
        string[] arrayCredenciales;
        //Diccionario de credenciales
        Dictionary<string, string> usuariosRegistrados;
        //Horas
        String[] horasDisponibles = {"8:00", "9:00", "10:00", "11:00", "12:00",
            "13:00", "14:00", "15:00", "16:00", "17:00" };
        //Horas ocupadas por comedor
        String[] horasOcupadas = { "13:00", "14:00", "15:00", "16:00" };

        //COmida y Bebida
        String[] bebidasDisponibles = { "Agua", "Café y Leche", "Zumo de Naranja" };
        String[] bocaditosDisponibles = { "Cruasán", "Jamón", "Vegetal" };
        public formularioReserva()
        {
            InitializeComponent();

            //Inserción de las horas en su campo correspondiente
            visualizarHoras();
            visualizarBocaditos();
            visualizarBebidas();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void btnIniciarSesion_Click(object sender, EventArgs e)
        {
            //Se asignan los valores de las credenciales
            usuariosRegistrados = new Dictionary<string, string>();

            String credenciales = Properties.Resources.credenciales.ToString();
            arrayCredenciales = credenciales.Split(new[] { ";" }, StringSplitOptions.RemoveEmptyEntries);
            
            for (int i = 0; i < arrayCredenciales.Length; i += 2)
            {
                usuariosRegistrados.Add(arrayCredenciales[i], arrayCredenciales[i + 1]);
            }

            string user = usuario.Text;
            string pass = password.Text;

            foreach (var usuarioRegistrado in usuariosRegistrados)
            {
                if (user == usuarioRegistrado.Key && pass == usuarioRegistrado.Value)
                {
                    errorLogin.SetError(password, "");
                    panelReserva.Enabled = true;
                    panelInicioSesion.Enabled = false;
                    btnSalir.Enabled = false;
                    break;
                }
                else
                {
                    errorLogin.SetError(password, "El usuario y la contraseña no coinciden");
                }
            }
        }

        private void numAsistentes_TextChanged(object sender, EventArgs e)
        {
            if (!(numAsistentes.Text.All(Char.IsDigit)) || (numAsistentes.Text == ""))
            {
                errorReserva.SetError(numAsistentes, "Por favor, ingrese un número");
            }
            else
            {
                validarAsistentes();
            }
        }

        private void selectHora_SelectedIndexChanged(object sender, EventArgs e)
        {
            for (int i = 0; i < horasOcupadas.Length; i++)
            {
                if (sala3.Checked && selectHora.SelectedItem.ToString() == horasOcupadas[i])
                {
                    errorReserva.SetError(selectHora, "La sala 3 tiene horario de comedor de 13:00 a 16:00. Elija una hora ajena a este intervalo, por favor");
                    break;
                }
                else
                {
                    errorReserva.SetError(selectHora, "");
                }
            }
        }

        private void cerrarSesion_Click(object sender, EventArgs e)
        {
            panelReserva.Enabled = false;
            panelInicioSesion.Enabled = true;
            btnSalir.Enabled = true;
        }

        private void btnSalir_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnReservar_Click(object sender, EventArgs e)
        {

        }

        //MÉTODOS PROPIOS
        private void validarAsistentes()
        {
            int numAsist = Int16.Parse(numAsistentes.Text);
            if (sala1.Checked)
            {
                if(numAsist > 8)
                {
                    errorReserva.SetError(numAsistentes, "El número de asistentes introducidos supera el máximo permitido. Cambie de sala, o introduzca un valor inferior.");
                }
                else
                {
                    errorReserva.SetError(numAsistentes, "");
                }

            }
            else if (sala2.Checked)
            {
                if (numAsist > 10)
                {
                    errorReserva.SetError(numAsistentes, "El número de asistentes introducidos supera el máximo permitido. Cambie de sala, o introduzca un valor inferior.");
                }
                else
                {
                    errorReserva.SetError(numAsistentes, "");
                }
            }
            else if (sala3.Checked)
            {
                if (numAsist > 20)
                {
                    errorReserva.SetError(numAsistentes, "El número de asistentes introducidos supera el máximo permitido. Cambie de sala, o introduzca un valor inferior.");
                }
                else
                {
                    errorReserva.SetError(numAsistentes, "");
                }
            }
        }
        private void visualizarHoras()
        {
            for (int i = 0; i < horasDisponibles.Length; i++)
            {
                selectHora.Items.Add(horasDisponibles[i]);
            }
        }

        private void visualizarBocaditos()
        {
            for (int i = 0; i < bocaditosDisponibles.Length; i++)
            {
                selectComida.Items.Add(bocaditosDisponibles[i]);
            }
        }

        private void visualizarBebidas()
        {
            for (int i = 0; i < bebidasDisponibles.Length; i++)
            {
                selectBebida.Items.Add(bebidasDisponibles[i]);
            }
        }
    }
}
