namespace Ejercicio_3
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
            this.components = new System.ComponentModel.Container();
            this.label1 = new System.Windows.Forms.Label();
            this.menuNormal = new System.Windows.Forms.RadioButton();
            this.menuVegano = new System.Windows.Forms.RadioButton();
            this.label2 = new System.Windows.Forms.Label();
            this.nombre = new System.Windows.Forms.TextBox();
            this.telefono = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.panel1 = new System.Windows.Forms.Panel();
            this.label11 = new System.Windows.Forms.Label();
            this.letra = new System.Windows.Forms.TextBox();
            this.label10 = new System.Windows.Forms.Label();
            this.piso = new System.Windows.Forms.TextBox();
            this.textBox4 = new System.Windows.Forms.TextBox();
            this.label9 = new System.Windows.Forms.Label();
            this.label8 = new System.Windows.Forms.Label();
            this.selectCalle = new System.Windows.Forms.ComboBox();
            this.label7 = new System.Windows.Forms.Label();
            this.num = new System.Windows.Forms.TextBox();
            this.btnReserva = new System.Windows.Forms.Button();
            this.btnSalir = new System.Windows.Forms.Button();
            this.errorSeleccion = new System.Windows.Forms.ErrorProvider(this.components);
            this.panel1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.errorSeleccion)).BeginInit();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.Color.Teal;
            this.label1.Location = new System.Drawing.Point(203, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(342, 25);
            this.label1.TabIndex = 0;
            this.label1.Text = "Servicio de Entrega a Domicilio";
            // 
            // menuNormal
            // 
            this.menuNormal.AutoSize = true;
            this.menuNormal.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.menuNormal.Location = new System.Drawing.Point(208, 77);
            this.menuNormal.Name = "menuNormal";
            this.menuNormal.Size = new System.Drawing.Size(116, 20);
            this.menuNormal.TabIndex = 1;
            this.menuNormal.Text = "Menú Normal";
            this.menuNormal.UseVisualStyleBackColor = true;
            this.menuNormal.CheckedChanged += new System.EventHandler(this.menuNormal_CheckedChanged);
            // 
            // menuVegano
            // 
            this.menuVegano.AutoSize = true;
            this.menuVegano.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.menuVegano.Location = new System.Drawing.Point(425, 77);
            this.menuVegano.Name = "menuVegano";
            this.menuVegano.Size = new System.Drawing.Size(120, 20);
            this.menuVegano.TabIndex = 2;
            this.menuVegano.Text = "Menú Vegano";
            this.menuVegano.UseVisualStyleBackColor = true;
            this.menuVegano.CheckedChanged += new System.EventHandler(this.menuVegano_CheckedChanged);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.ForeColor = System.Drawing.Color.MediumTurquoise;
            this.label2.Location = new System.Drawing.Point(284, 45);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(197, 20);
            this.label2.TabIndex = 3;
            this.label2.Text = "Escoja un tipo de menú";
            // 
            // nombre
            // 
            this.nombre.Location = new System.Drawing.Point(357, 143);
            this.nombre.Name = "nombre";
            this.nombre.Size = new System.Drawing.Size(124, 20);
            this.nombre.TabIndex = 4;
            this.nombre.TextChanged += new System.EventHandler(this.nombre_TextChanged);
            // 
            // telefono
            // 
            this.telefono.Location = new System.Drawing.Point(357, 178);
            this.telefono.MaxLength = 9;
            this.telefono.Name = "telefono";
            this.telefono.Size = new System.Drawing.Size(124, 20);
            this.telefono.TabIndex = 5;
            this.telefono.TextChanged += new System.EventHandler(this.telefono_TextChanged);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.ForeColor = System.Drawing.Color.MediumTurquoise;
            this.label3.Location = new System.Drawing.Point(298, 111);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(165, 20);
            this.label3.TabIndex = 6;
            this.label3.Text = "Detalles del Cliente";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.Location = new System.Drawing.Point(285, 144);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(66, 16);
            this.label4.TabIndex = 7;
            this.label4.Text = "Nombre:";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.BackColor = System.Drawing.Color.Transparent;
            this.label5.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label5.Location = new System.Drawing.Point(278, 179);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(73, 16);
            this.label5.TabIndex = 8;
            this.label5.Text = "Teléfono:";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.BackColor = System.Drawing.Color.Transparent;
            this.label6.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label6.Location = new System.Drawing.Point(310, 234);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(153, 16);
            this.label6.TabIndex = 9;
            this.label6.Text = "Dirección de Entrega";
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.Color.LemonChiffon;
            this.panel1.Controls.Add(this.label11);
            this.panel1.Controls.Add(this.letra);
            this.panel1.Controls.Add(this.label10);
            this.panel1.Controls.Add(this.piso);
            this.panel1.Controls.Add(this.textBox4);
            this.panel1.Controls.Add(this.label9);
            this.panel1.Controls.Add(this.label8);
            this.panel1.Controls.Add(this.selectCalle);
            this.panel1.Controls.Add(this.label7);
            this.panel1.Controls.Add(this.num);
            this.panel1.Location = new System.Drawing.Point(88, 253);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(616, 100);
            this.panel1.TabIndex = 10;
            // 
            // label11
            // 
            this.label11.AutoSize = true;
            this.label11.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label11.Location = new System.Drawing.Point(506, 41);
            this.label11.Name = "label11";
            this.label11.Size = new System.Drawing.Size(46, 16);
            this.label11.TabIndex = 19;
            this.label11.Text = "Letra:";
            // 
            // letra
            // 
            this.letra.Location = new System.Drawing.Point(558, 39);
            this.letra.MaxLength = 1;
            this.letra.Name = "letra";
            this.letra.Size = new System.Drawing.Size(38, 20);
            this.letra.TabIndex = 18;
            this.letra.TextChanged += new System.EventHandler(this.letra_TextChanged);
            // 
            // label10
            // 
            this.label10.AutoSize = true;
            this.label10.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label10.Location = new System.Drawing.Point(409, 40);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(42, 16);
            this.label10.TabIndex = 17;
            this.label10.Text = "Piso:";
            // 
            // piso
            // 
            this.piso.Location = new System.Drawing.Point(457, 40);
            this.piso.Name = "piso";
            this.piso.Size = new System.Drawing.Size(43, 20);
            this.piso.TabIndex = 16;
            this.piso.TextChanged += new System.EventHandler(this.piso_TextChanged);
            // 
            // textBox4
            // 
            this.textBox4.Location = new System.Drawing.Point(360, 39);
            this.textBox4.Name = "textBox4";
            this.textBox4.Size = new System.Drawing.Size(43, 20);
            this.textBox4.TabIndex = 15;
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label9.Location = new System.Drawing.Point(281, 40);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(73, 16);
            this.label9.TabIndex = 14;
            this.label9.Text = "Escalera:";
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label8.Location = new System.Drawing.Point(194, 40);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(32, 16);
            this.label8.TabIndex = 13;
            this.label8.Text = "N.º:";
            // 
            // selectCalle
            // 
            this.selectCalle.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.selectCalle.FormattingEnabled = true;
            this.selectCalle.Location = new System.Drawing.Point(67, 39);
            this.selectCalle.Name = "selectCalle";
            this.selectCalle.Size = new System.Drawing.Size(121, 21);
            this.selectCalle.TabIndex = 12;
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label7.Location = new System.Drawing.Point(14, 40);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(47, 16);
            this.label7.TabIndex = 11;
            this.label7.Text = "Calle:";
            // 
            // num
            // 
            this.num.Location = new System.Drawing.Point(232, 39);
            this.num.Name = "num";
            this.num.Size = new System.Drawing.Size(43, 20);
            this.num.TabIndex = 11;
            this.num.TextChanged += new System.EventHandler(this.num_TextChanged);
            // 
            // btnReserva
            // 
            this.btnReserva.BackColor = System.Drawing.Color.Gold;
            this.btnReserva.Enabled = false;
            this.btnReserva.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnReserva.Location = new System.Drawing.Point(239, 372);
            this.btnReserva.Name = "btnReserva";
            this.btnReserva.Size = new System.Drawing.Size(145, 37);
            this.btnReserva.TabIndex = 11;
            this.btnReserva.Text = "RESERVAR";
            this.btnReserva.UseVisualStyleBackColor = false;
            this.btnReserva.Click += new System.EventHandler(this.btnReserva_Click);
            // 
            // btnSalir
            // 
            this.btnSalir.BackColor = System.Drawing.Color.Gold;
            this.btnSalir.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnSalir.ForeColor = System.Drawing.Color.Red;
            this.btnSalir.Location = new System.Drawing.Point(425, 372);
            this.btnSalir.Name = "btnSalir";
            this.btnSalir.Size = new System.Drawing.Size(145, 37);
            this.btnSalir.TabIndex = 12;
            this.btnSalir.Text = "SALIR";
            this.btnSalir.UseVisualStyleBackColor = false;
            this.btnSalir.Click += new System.EventHandler(this.btnSalir_Click);
            // 
            // errorSeleccion
            // 
            this.errorSeleccion.ContainerControl = this;
            // 
            // Inicio
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.PaleGoldenrod;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.btnSalir);
            this.Controls.Add(this.btnReserva);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.telefono);
            this.Controls.Add(this.nombre);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.menuVegano);
            this.Controls.Add(this.menuNormal);
            this.Controls.Add(this.label1);
            this.Name = "Inicio";
            this.Text = "Restaurante Petecander";
            this.Load += new System.EventHandler(this.Inicio_Load);
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.errorSeleccion)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.RadioButton menuNormal;
        private System.Windows.Forms.RadioButton menuVegano;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox nombre;
        private System.Windows.Forms.TextBox telefono;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Label label11;
        private System.Windows.Forms.TextBox letra;
        private System.Windows.Forms.Label label10;
        private System.Windows.Forms.TextBox piso;
        private System.Windows.Forms.TextBox textBox4;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.ComboBox selectCalle;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.TextBox num;
        private System.Windows.Forms.Button btnReserva;
        private System.Windows.Forms.Button btnSalir;
        private System.Windows.Forms.ErrorProvider errorSeleccion;
    }
}

