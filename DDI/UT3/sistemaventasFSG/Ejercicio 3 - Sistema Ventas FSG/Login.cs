using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

using capaNegocio;
using capaEntidad;

namespace Ejercicio_3___Sistema_Ventas_FSG
{
    public partial class Login : Form
    {
        public Login()
        {
            InitializeComponent();
        }

        private void btnIniciar_Click(object sender, EventArgs e)
        {
            //List<Usuario> TEST = new CN_Usuario().Listar();
            Usuario ousuario = new CN_Usuario().Listar().Where(u => u.documento == txtUser.Text && u.clave == txtPass.Text).FirstOrDefault();
            if(ousuario != null)
            {
                Inicio form = new Inicio(ousuario);
                form.Show();
                this.Hide();

                form.FormClosing += frm_closing;
                txtUser.Text = "";
                txtPass.Text = "";
            }
            else
            {
                MessageBox.Show("Usuario erróneo o no existente", "¡Alerta!", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
            }

            
        }

        private void btnSalir_Click(object sender, EventArgs e)
        {
            this.Close();
        }
        
        private void frm_closing(object sender, FormClosingEventArgs e)
        {
            this.Show();
        }
    }
}
