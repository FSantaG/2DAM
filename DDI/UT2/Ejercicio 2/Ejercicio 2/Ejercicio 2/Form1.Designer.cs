namespace Ejercicio_2
{
    partial class formularioReserva
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
            this.components = new System.ComponentModel.Container();
            this.panelInicioSesion = new System.Windows.Forms.Panel();
            this.password = new System.Windows.Forms.TextBox();
            this.usuario = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.btnIniciarSesion = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.panelReserva = new System.Windows.Forms.Panel();
            this.label10 = new System.Windows.Forms.Label();
            this.label9 = new System.Windows.Forms.Label();
            this.cerrarSesion = new System.Windows.Forms.Button();
            this.precioComida = new System.Windows.Forms.TextBox();
            this.precioBebida = new System.Windows.Forms.TextBox();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.sala1 = new System.Windows.Forms.RadioButton();
            this.sala2 = new System.Windows.Forms.RadioButton();
            this.sala3 = new System.Windows.Forms.RadioButton();
            this.label8 = new System.Windows.Forms.Label();
            this.selectHora = new System.Windows.Forms.ComboBox();
            this.btnReservar = new System.Windows.Forms.Button();
            this.label7 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.selectComida = new System.Windows.Forms.ComboBox();
            this.selectBebida = new System.Windows.Forms.ComboBox();
            this.label5 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.numAsistentes = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.errorLogin = new System.Windows.Forms.ErrorProvider(this.components);
            this.errorReserva = new System.Windows.Forms.ErrorProvider(this.components);
            this.btnSalir = new System.Windows.Forms.Button();
            this.label11 = new System.Windows.Forms.Label();
            this.panelInicioSesion.SuspendLayout();
            this.panelReserva.SuspendLayout();
            this.groupBox1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.errorLogin)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.errorReserva)).BeginInit();
            this.SuspendLayout();
            // 
            // panelInicioSesion
            // 
            this.panelInicioSesion.BackColor = System.Drawing.Color.Cornsilk;
            this.panelInicioSesion.Controls.Add(this.password);
            this.panelInicioSesion.Controls.Add(this.usuario);
            this.panelInicioSesion.Controls.Add(this.label2);
            this.panelInicioSesion.Controls.Add(this.btnIniciarSesion);
            this.panelInicioSesion.Controls.Add(this.label1);
            this.panelInicioSesion.Location = new System.Drawing.Point(12, 12);
            this.panelInicioSesion.Name = "panelInicioSesion";
            this.panelInicioSesion.Size = new System.Drawing.Size(776, 108);
            this.panelInicioSesion.TabIndex = 0;
            // 
            // password
            // 
            this.password.Location = new System.Drawing.Point(379, 47);
            this.password.Name = "password";
            this.password.PasswordChar = '*';
            this.password.Size = new System.Drawing.Size(154, 20);
            this.password.TabIndex = 5;
            // 
            // usuario
            // 
            this.usuario.Location = new System.Drawing.Point(379, 18);
            this.usuario.Name = "usuario";
            this.usuario.Size = new System.Drawing.Size(154, 20);
            this.usuario.TabIndex = 4;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Arial Rounded MT Bold", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.ForeColor = System.Drawing.SystemColors.Desktop;
            this.label2.Location = new System.Drawing.Point(243, 46);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(130, 18);
            this.label2.TabIndex = 3;
            this.label2.Text = "CONTRASEÑA:";
            // 
            // btnIniciarSesion
            // 
            this.btnIniciarSesion.Font = new System.Drawing.Font("Arial Rounded MT Bold", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnIniciarSesion.Location = new System.Drawing.Point(190, 78);
            this.btnIniciarSesion.Name = "btnIniciarSesion";
            this.btnIniciarSesion.Size = new System.Drawing.Size(389, 27);
            this.btnIniciarSesion.TabIndex = 2;
            this.btnIniciarSesion.Text = "INICIAR SESIÓN";
            this.btnIniciarSesion.UseVisualStyleBackColor = true;
            this.btnIniciarSesion.Click += new System.EventHandler(this.btnIniciarSesion_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Arial Rounded MT Bold", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.SystemColors.Desktop;
            this.label1.Location = new System.Drawing.Point(283, 17);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(90, 18);
            this.label1.TabIndex = 0;
            this.label1.Text = "USUARIO:";
            // 
            // panelReserva
            // 
            this.panelReserva.BackColor = System.Drawing.Color.Cornsilk;
            this.panelReserva.Controls.Add(this.label11);
            this.panelReserva.Controls.Add(this.label10);
            this.panelReserva.Controls.Add(this.label9);
            this.panelReserva.Controls.Add(this.cerrarSesion);
            this.panelReserva.Controls.Add(this.precioComida);
            this.panelReserva.Controls.Add(this.precioBebida);
            this.panelReserva.Controls.Add(this.groupBox1);
            this.panelReserva.Controls.Add(this.label8);
            this.panelReserva.Controls.Add(this.selectHora);
            this.panelReserva.Controls.Add(this.btnReservar);
            this.panelReserva.Controls.Add(this.label7);
            this.panelReserva.Controls.Add(this.label6);
            this.panelReserva.Controls.Add(this.selectComida);
            this.panelReserva.Controls.Add(this.selectBebida);
            this.panelReserva.Controls.Add(this.label5);
            this.panelReserva.Controls.Add(this.label4);
            this.panelReserva.Controls.Add(this.numAsistentes);
            this.panelReserva.Controls.Add(this.label3);
            this.panelReserva.Enabled = false;
            this.panelReserva.Location = new System.Drawing.Point(12, 135);
            this.panelReserva.Name = "panelReserva";
            this.panelReserva.Size = new System.Drawing.Size(776, 288);
            this.panelReserva.TabIndex = 1;
            // 
            // label10
            // 
            this.label10.AutoSize = true;
            this.label10.Location = new System.Drawing.Point(376, 164);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(37, 13);
            this.label10.TabIndex = 23;
            this.label10.Text = "Precio";
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Location = new System.Drawing.Point(187, 164);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(37, 13);
            this.label9.TabIndex = 22;
            this.label9.Text = "Precio";
            // 
            // cerrarSesion
            // 
            this.cerrarSesion.BackColor = System.Drawing.SystemColors.ControlLight;
            this.cerrarSesion.Font = new System.Drawing.Font("Arial Rounded MT Bold", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.cerrarSesion.ForeColor = System.Drawing.Color.Black;
            this.cerrarSesion.Location = new System.Drawing.Point(636, 242);
            this.cerrarSesion.Name = "cerrarSesion";
            this.cerrarSesion.Size = new System.Drawing.Size(114, 31);
            this.cerrarSesion.TabIndex = 21;
            this.cerrarSesion.Text = "Cerrar Sesión";
            this.cerrarSesion.UseVisualStyleBackColor = false;
            this.cerrarSesion.Click += new System.EventHandler(this.cerrarSesion_Click);
            // 
            // precioComida
            // 
            this.precioComida.Cursor = System.Windows.Forms.Cursors.Default;
            this.precioComida.Location = new System.Drawing.Point(373, 180);
            this.precioComida.Name = "precioComida";
            this.precioComida.ReadOnly = true;
            this.precioComida.Size = new System.Drawing.Size(57, 20);
            this.precioComida.TabIndex = 20;
            this.precioComida.Text = "0";
            this.precioComida.TextChanged += new System.EventHandler(this.precioComida_TextChanged);
            // 
            // precioBebida
            // 
            this.precioBebida.Cursor = System.Windows.Forms.Cursors.Default;
            this.precioBebida.Location = new System.Drawing.Point(182, 180);
            this.precioBebida.Name = "precioBebida";
            this.precioBebida.ReadOnly = true;
            this.precioBebida.Size = new System.Drawing.Size(57, 20);
            this.precioBebida.TabIndex = 19;
            this.precioBebida.Text = "0";
            this.precioBebida.TextChanged += new System.EventHandler(this.precioBebida_TextChanged);
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.sala1);
            this.groupBox1.Controls.Add(this.sala2);
            this.groupBox1.Controls.Add(this.sala3);
            this.groupBox1.Location = new System.Drawing.Point(139, 3);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(518, 67);
            this.groupBox1.TabIndex = 18;
            this.groupBox1.TabStop = false;
            // 
            // sala1
            // 
            this.sala1.AutoSize = true;
            this.sala1.Location = new System.Drawing.Point(6, 30);
            this.sala1.Name = "sala1";
            this.sala1.Size = new System.Drawing.Size(141, 17);
            this.sala1.TabIndex = 0;
            this.sala1.TabStop = true;
            this.sala1.Text = "Sala 1 (máx. 8 personas)";
            this.sala1.UseVisualStyleBackColor = true;
            // 
            // sala2
            // 
            this.sala2.AutoSize = true;
            this.sala2.Location = new System.Drawing.Point(153, 30);
            this.sala2.Name = "sala2";
            this.sala2.Size = new System.Drawing.Size(147, 17);
            this.sala2.TabIndex = 1;
            this.sala2.TabStop = true;
            this.sala2.Text = "Sala 2 (máx. 10 personas)";
            this.sala2.UseVisualStyleBackColor = true;
            // 
            // sala3
            // 
            this.sala3.AutoSize = true;
            this.sala3.Location = new System.Drawing.Point(312, 30);
            this.sala3.Name = "sala3";
            this.sala3.Size = new System.Drawing.Size(200, 17);
            this.sala3.TabIndex = 2;
            this.sala3.TabStop = true;
            this.sala3.Text = "Sala 3 / Comedor (máx. 20 personas)";
            this.sala3.UseVisualStyleBackColor = true;
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Font = new System.Drawing.Font("Arial Rounded MT Bold", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label8.ForeColor = System.Drawing.SystemColors.Desktop;
            this.label8.Location = new System.Drawing.Point(306, 98);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(165, 18);
            this.label8.TabIndex = 17;
            this.label8.Text = "Hora de la Reserva:";
            // 
            // selectHora
            // 
            this.selectHora.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.selectHora.FormattingEnabled = true;
            this.selectHora.Location = new System.Drawing.Point(477, 95);
            this.selectHora.Name = "selectHora";
            this.selectHora.Size = new System.Drawing.Size(121, 21);
            this.selectHora.TabIndex = 16;
            this.selectHora.SelectedIndexChanged += new System.EventHandler(this.selectHora_SelectedIndexChanged);
            // 
            // btnReservar
            // 
            this.btnReservar.BackColor = System.Drawing.SystemColors.ControlLight;
            this.btnReservar.Font = new System.Drawing.Font("Arial Rounded MT Bold", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnReservar.ForeColor = System.Drawing.Color.Red;
            this.btnReservar.Location = new System.Drawing.Point(618, 162);
            this.btnReservar.Name = "btnReservar";
            this.btnReservar.Size = new System.Drawing.Size(153, 65);
            this.btnReservar.TabIndex = 15;
            this.btnReservar.Text = "RESERVAR";
            this.btnReservar.UseVisualStyleBackColor = false;
            this.btnReservar.Click += new System.EventHandler(this.btnReservar_Click);
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(325, 183);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(49, 13);
            this.label7.TabIndex = 14;
            this.label7.Text = "Bocadito";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(136, 183);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(40, 13);
            this.label6.TabIndex = 13;
            this.label6.Text = "Bebida";
            // 
            // selectComida
            // 
            this.selectComida.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.selectComida.FormattingEnabled = true;
            this.selectComida.Location = new System.Drawing.Point(309, 206);
            this.selectComida.Name = "selectComida";
            this.selectComida.Size = new System.Drawing.Size(121, 21);
            this.selectComida.TabIndex = 12;
            this.selectComida.SelectedIndexChanged += new System.EventHandler(this.selectComida_SelectedIndexChanged);
            // 
            // selectBebida
            // 
            this.selectBebida.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.selectBebida.FormattingEnabled = true;
            this.selectBebida.Location = new System.Drawing.Point(118, 206);
            this.selectBebida.Name = "selectBebida";
            this.selectBebida.Size = new System.Drawing.Size(121, 21);
            this.selectBebida.TabIndex = 11;
            this.selectBebida.SelectedIndexChanged += new System.EventHandler(this.selectBebida_SelectedIndexChanged);
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Arial Rounded MT Bold", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label5.ForeColor = System.Drawing.SystemColors.Desktop;
            this.label5.Location = new System.Drawing.Point(23, 175);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(94, 18);
            this.label5.TabIndex = 10;
            this.label5.Text = "Aperitivos:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Arial Rounded MT Bold", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.ForeColor = System.Drawing.SystemColors.Desktop;
            this.label4.Location = new System.Drawing.Point(23, 98);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(189, 18);
            this.label4.TabIndex = 9;
            this.label4.Text = "Número de Asistentes:";
            // 
            // numAsistentes
            // 
            this.numAsistentes.Location = new System.Drawing.Point(218, 96);
            this.numAsistentes.Name = "numAsistentes";
            this.numAsistentes.Size = new System.Drawing.Size(62, 20);
            this.numAsistentes.TabIndex = 8;
            this.numAsistentes.TextChanged += new System.EventHandler(this.numAsistentes_TextChanged);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Arial Rounded MT Bold", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.ForeColor = System.Drawing.SystemColors.Desktop;
            this.label3.Location = new System.Drawing.Point(23, 27);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(110, 18);
            this.label3.TabIndex = 6;
            this.label3.Text = "Tipo de Sala:";
            // 
            // errorLogin
            // 
            this.errorLogin.BlinkStyle = System.Windows.Forms.ErrorBlinkStyle.NeverBlink;
            this.errorLogin.ContainerControl = this;
            // 
            // errorReserva
            // 
            this.errorReserva.ContainerControl = this;
            // 
            // btnSalir
            // 
            this.btnSalir.BackColor = System.Drawing.SystemColors.ControlLight;
            this.btnSalir.Font = new System.Drawing.Font("Arial Rounded MT Bold", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnSalir.ForeColor = System.Drawing.Color.Black;
            this.btnSalir.Location = new System.Drawing.Point(657, 426);
            this.btnSalir.Name = "btnSalir";
            this.btnSalir.Size = new System.Drawing.Size(105, 22);
            this.btnSalir.TabIndex = 22;
            this.btnSalir.Text = "Salir";
            this.btnSalir.UseVisualStyleBackColor = false;
            this.btnSalir.Click += new System.EventHandler(this.btnSalir_Click);
            // 
            // label11
            // 
            this.label11.AutoSize = true;
            this.label11.Location = new System.Drawing.Point(36, 193);
            this.label11.Name = "label11";
            this.label11.Size = new System.Drawing.Size(67, 13);
            this.label11.TabIndex = 24;
            this.label11.Text = "(< o = 2,50€)";
            // 
            // formularioReserva
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Khaki;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.btnSalir);
            this.Controls.Add(this.panelReserva);
            this.Controls.Add(this.panelInicioSesion);
            this.Name = "formularioReserva";
            this.Text = "Agencia Petecander";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.panelInicioSesion.ResumeLayout(false);
            this.panelInicioSesion.PerformLayout();
            this.panelReserva.ResumeLayout(false);
            this.panelReserva.PerformLayout();
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.errorLogin)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.errorReserva)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel panelInicioSesion;
        private System.Windows.Forms.TextBox password;
        private System.Windows.Forms.TextBox usuario;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button btnIniciarSesion;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Panel panelReserva;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.RadioButton sala3;
        private System.Windows.Forms.RadioButton sala2;
        private System.Windows.Forms.RadioButton sala1;
        private System.Windows.Forms.Button btnReservar;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.ComboBox selectComida;
        private System.Windows.Forms.ComboBox selectBebida;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox numAsistentes;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.ComboBox selectHora;
        private System.Windows.Forms.ErrorProvider errorLogin;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.ErrorProvider errorReserva;
        private System.Windows.Forms.Button btnSalir;
        private System.Windows.Forms.Button cerrarSesion;
        private System.Windows.Forms.TextBox precioComida;
        private System.Windows.Forms.TextBox precioBebida;
        private System.Windows.Forms.Label label10;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.Label label11;
    }
}

