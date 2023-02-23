namespace RegistroAlumnos
{
    partial class Inicio
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Inicio));
            this.menuTitulo = new System.Windows.Forms.MenuStrip();
            this.label1 = new System.Windows.Forms.Label();
            this.backgroundWorker1 = new System.ComponentModel.BackgroundWorker();
            this.Menu = new System.Windows.Forms.MenuStrip();
            this.menucontrol = new FontAwesome.Sharp.IconMenuItem();
            this.menuconsulta = new FontAwesome.Sharp.IconMenuItem();
            this.btnSalir = new FontAwesome.Sharp.IconButton();
            this.contenedor = new System.Windows.Forms.Panel();
            this.Menu.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuTitulo
            // 
            this.menuTitulo.AutoSize = false;
            this.menuTitulo.BackColor = System.Drawing.Color.SteelBlue;
            this.menuTitulo.Location = new System.Drawing.Point(0, 0);
            this.menuTitulo.Name = "menuTitulo";
            this.menuTitulo.Size = new System.Drawing.Size(1094, 73);
            this.menuTitulo.TabIndex = 2;
            this.menuTitulo.Text = "menuStrip2";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.BackColor = System.Drawing.Color.SteelBlue;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 20.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.label1.Location = new System.Drawing.Point(78, 16);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(401, 31);
            this.label1.TabIndex = 5;
            this.label1.Text = "Registro de Asistencia a Cursos";
            // 
            // Menu
            // 
            this.Menu.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.menucontrol,
            this.menuconsulta});
            this.Menu.Location = new System.Drawing.Point(0, 73);
            this.Menu.Name = "Menu";
            this.Menu.RightToLeft = System.Windows.Forms.RightToLeft.No;
            this.Menu.Size = new System.Drawing.Size(1094, 73);
            this.Menu.TabIndex = 6;
            this.Menu.Text = "Menu";
            // 
            // menucontrol
            // 
            this.menucontrol.AutoSize = false;
            this.menucontrol.IconChar = FontAwesome.Sharp.IconChar.SchoolCircleCheck;
            this.menucontrol.IconColor = System.Drawing.Color.Black;
            this.menucontrol.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.menucontrol.IconSize = 50;
            this.menucontrol.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
            this.menucontrol.Name = "menucontrol";
            this.menucontrol.Size = new System.Drawing.Size(122, 69);
            this.menucontrol.Text = "Control";
            this.menucontrol.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText;
            this.menucontrol.Click += new System.EventHandler(this.menucontrol_Click);
            // 
            // menuconsulta
            // 
            this.menuconsulta.AutoSize = false;
            this.menuconsulta.IconChar = FontAwesome.Sharp.IconChar.SearchPlus;
            this.menuconsulta.IconColor = System.Drawing.Color.Black;
            this.menuconsulta.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.menuconsulta.IconSize = 50;
            this.menuconsulta.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
            this.menuconsulta.Name = "menuconsulta";
            this.menuconsulta.Size = new System.Drawing.Size(122, 69);
            this.menuconsulta.Text = "Consulta";
            this.menuconsulta.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText;
            this.menuconsulta.Click += new System.EventHandler(this.menuconsulta_Click);
            // 
            // btnSalir
            // 
            this.btnSalir.BackColor = System.Drawing.Color.SteelBlue;
            this.btnSalir.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnSalir.ForeColor = System.Drawing.Color.Azure;
            this.btnSalir.IconChar = FontAwesome.Sharp.IconChar.DoorOpen;
            this.btnSalir.IconColor = System.Drawing.Color.Black;
            this.btnSalir.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.btnSalir.Location = new System.Drawing.Point(10, 4);
            this.btnSalir.Name = "btnSalir";
            this.btnSalir.Size = new System.Drawing.Size(62, 66);
            this.btnSalir.TabIndex = 7;
            this.btnSalir.UseVisualStyleBackColor = false;
            this.btnSalir.Click += new System.EventHandler(this.btnSalir_Click);
            // 
            // contenedor
            // 
            this.contenedor.Dock = System.Windows.Forms.DockStyle.Fill;
            this.contenedor.Location = new System.Drawing.Point(0, 146);
            this.contenedor.Name = "contenedor";
            this.contenedor.Size = new System.Drawing.Size(1094, 603);
            this.contenedor.TabIndex = 8;
            // 
            // Inicio
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1094, 749);
            this.ControlBox = false;
            this.Controls.Add(this.contenedor);
            this.Controls.Add(this.btnSalir);
            this.Controls.Add(this.Menu);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.menuTitulo);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "Inicio";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Inicio";
            this.Menu.ResumeLayout(false);
            this.Menu.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuTitulo;
        private System.Windows.Forms.Label label1;
        private System.ComponentModel.BackgroundWorker backgroundWorker1;
        private System.Windows.Forms.MenuStrip Menu;
        private FontAwesome.Sharp.IconMenuItem menucontrol;
        private FontAwesome.Sharp.IconMenuItem menuconsulta;
        private FontAwesome.Sharp.IconButton btnSalir;
        private System.Windows.Forms.Panel contenedor;
    }
}

