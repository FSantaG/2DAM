namespace Ejercicio_3___Sistema_Ventas_FSG
{
    partial class Login
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Login));
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.iconPictureBox1 = new FontAwesome.Sharp.IconPictureBox();
            this.txtUser = new System.Windows.Forms.TextBox();
            this.txtPass = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.btnIniciar = new FontAwesome.Sharp.IconButton();
            this.btnSalir = new FontAwesome.Sharp.IconButton();
            this.label5 = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.iconPictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.BackColor = System.Drawing.Color.SteelBlue;
            this.label1.Dock = System.Windows.Forms.DockStyle.Left;
            this.label1.Location = new System.Drawing.Point(0, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(276, 275);
            this.label1.TabIndex = 0;
            // 
            // label2
            // 
            this.label2.BackColor = System.Drawing.Color.SteelBlue;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.ForeColor = System.Drawing.Color.White;
            this.label2.Location = new System.Drawing.Point(33, 241);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(208, 25);
            this.label2.TabIndex = 1;
            this.label2.Text = "SISTEMA DE VENTA";
            // 
            // iconPictureBox1
            // 
            this.iconPictureBox1.BackColor = System.Drawing.Color.SteelBlue;
            this.iconPictureBox1.IconChar = FontAwesome.Sharp.IconChar.Store;
            this.iconPictureBox1.IconColor = System.Drawing.Color.White;
            this.iconPictureBox1.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.iconPictureBox1.IconSize = 238;
            this.iconPictureBox1.Location = new System.Drawing.Point(0, 0);
            this.iconPictureBox1.Name = "iconPictureBox1";
            this.iconPictureBox1.Size = new System.Drawing.Size(276, 238);
            this.iconPictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.CenterImage;
            this.iconPictureBox1.TabIndex = 2;
            this.iconPictureBox1.TabStop = false;
            // 
            // txtUser
            // 
            this.txtUser.Location = new System.Drawing.Point(308, 103);
            this.txtUser.Name = "txtUser";
            this.txtUser.Size = new System.Drawing.Size(203, 20);
            this.txtUser.TabIndex = 3;
            // 
            // txtPass
            // 
            this.txtPass.Location = new System.Drawing.Point(308, 184);
            this.txtPass.Name = "txtPass";
            this.txtPass.PasswordChar = '•';
            this.txtPass.Size = new System.Drawing.Size(203, 20);
            this.txtPass.TabIndex = 4;
            this.txtPass.UseSystemPasswordChar = true;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(313, 76);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(81, 24);
            this.label3.TabIndex = 5;
            this.label3.Text = "Usuario";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.Location = new System.Drawing.Point(313, 157);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(116, 24);
            this.label4.TabIndex = 6;
            this.label4.Text = "Contraseña";
            // 
            // btnIniciar
            // 
            this.btnIniciar.BackColor = System.Drawing.Color.RoyalBlue;
            this.btnIniciar.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnIniciar.FlatAppearance.BorderColor = System.Drawing.Color.White;
            this.btnIniciar.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnIniciar.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnIniciar.ForeColor = System.Drawing.Color.White;
            this.btnIniciar.IconChar = FontAwesome.Sharp.IconChar.DoorOpen;
            this.btnIniciar.IconColor = System.Drawing.Color.White;
            this.btnIniciar.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.btnIniciar.IconSize = 21;
            this.btnIniciar.Location = new System.Drawing.Point(292, 229);
            this.btnIniciar.Name = "btnIniciar";
            this.btnIniciar.Size = new System.Drawing.Size(118, 34);
            this.btnIniciar.TabIndex = 7;
            this.btnIniciar.Text = "Iniciar Sesión";
            this.btnIniciar.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.btnIniciar.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
            this.btnIniciar.UseVisualStyleBackColor = false;
            this.btnIniciar.Click += new System.EventHandler(this.iconButton1_Click);
            // 
            // btnSalir
            // 
            this.btnSalir.BackColor = System.Drawing.Color.Firebrick;
            this.btnSalir.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnSalir.FlatAppearance.BorderColor = System.Drawing.Color.White;
            this.btnSalir.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnSalir.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnSalir.ForeColor = System.Drawing.Color.White;
            this.btnSalir.IconChar = FontAwesome.Sharp.IconChar.XmarkCircle;
            this.btnSalir.IconColor = System.Drawing.Color.White;
            this.btnSalir.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.btnSalir.IconSize = 21;
            this.btnSalir.Location = new System.Drawing.Point(416, 229);
            this.btnSalir.Name = "btnSalir";
            this.btnSalir.Size = new System.Drawing.Size(106, 34);
            this.btnSalir.TabIndex = 8;
            this.btnSalir.Text = "Salir";
            this.btnSalir.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.btnSalir.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
            this.btnSalir.UseVisualStyleBackColor = false;
            this.btnSalir.Click += new System.EventHandler(this.btnSalir_Click);
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label5.Location = new System.Drawing.Point(327, 25);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(184, 25);
            this.label5.TabIndex = 9;
            this.label5.Text = "INICIAR SESIÓN";
            // 
            // Login
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.White;
            this.ClientSize = new System.Drawing.Size(548, 275);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.btnSalir);
            this.Controls.Add(this.btnIniciar);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.txtPass);
            this.Controls.Add(this.txtUser);
            this.Controls.Add(this.iconPictureBox1);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "Login";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Login";
            ((System.ComponentModel.ISupportInitialize)(this.iconPictureBox1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private FontAwesome.Sharp.IconPictureBox iconPictureBox1;
        private System.Windows.Forms.TextBox txtUser;
        private System.Windows.Forms.TextBox txtPass;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private FontAwesome.Sharp.IconButton btnIniciar;
        private FontAwesome.Sharp.IconButton btnSalir;
        private System.Windows.Forms.Label label5;
    }
}