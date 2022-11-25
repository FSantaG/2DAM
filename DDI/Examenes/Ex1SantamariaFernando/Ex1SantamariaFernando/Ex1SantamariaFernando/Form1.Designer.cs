namespace Ex1SantamariaFernando
{
    partial class Form1
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
            this.panel1 = new System.Windows.Forms.Panel();
            this.label6 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.mascotas = new System.Windows.Forms.TextBox();
            this.label7 = new System.Windows.Forms.Label();
            this.telefono = new System.Windows.Forms.TextBox();
            this.matricula = new System.Windows.Forms.TextBox();
            this.labelTelefono = new System.Windows.Forms.Label();
            this.labelMatricula = new System.Windows.Forms.Label();
            this.mayores16 = new System.Windows.Forms.TextBox();
            this.label5 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.menores16 = new System.Windows.Forms.TextBox();
            this.rbNo = new System.Windows.Forms.RadioButton();
            this.rbSi = new System.Windows.Forms.RadioButton();
            this.label2 = new System.Windows.Forms.Label();
            this.aforoPersonas = new System.Windows.Forms.Label();
            this.aforoVehiculos = new System.Windows.Forms.Label();
            this.btnCalcular = new System.Windows.Forms.Button();
            this.panel2 = new System.Windows.Forms.Panel();
            this.btnConsultar = new System.Windows.Forms.Button();
            this.btnSalir = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.errorPanel1 = new System.Windows.Forms.ErrorProvider(this.components);
            this.label8 = new System.Windows.Forms.Label();
            this.matriculaABuscar = new System.Windows.Forms.TextBox();
            this.panel1.SuspendLayout();
            this.panel2.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.errorPanel1)).BeginInit();
            this.SuspendLayout();
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.Color.LavenderBlush;
            this.panel1.Controls.Add(this.aforoVehiculos);
            this.panel1.Controls.Add(this.label6);
            this.panel1.Controls.Add(this.label3);
            this.panel1.Controls.Add(this.mascotas);
            this.panel1.Controls.Add(this.label7);
            this.panel1.Controls.Add(this.telefono);
            this.panel1.Controls.Add(this.matricula);
            this.panel1.Controls.Add(this.labelTelefono);
            this.panel1.Controls.Add(this.labelMatricula);
            this.panel1.Controls.Add(this.mayores16);
            this.panel1.Controls.Add(this.label5);
            this.panel1.Controls.Add(this.label4);
            this.panel1.Controls.Add(this.menores16);
            this.panel1.Controls.Add(this.rbNo);
            this.panel1.Controls.Add(this.rbSi);
            this.panel1.Controls.Add(this.label2);
            this.panel1.Controls.Add(this.aforoPersonas);
            this.panel1.Controls.Add(this.btnCalcular);
            this.panel1.Location = new System.Drawing.Point(13, 44);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(775, 157);
            this.panel1.TabIndex = 0;
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label6.Location = new System.Drawing.Point(396, 17);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(52, 16);
            this.label6.TabIndex = 20;
            this.label6.Text = "Aforo: ";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.BackColor = System.Drawing.Color.Transparent;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(150, 17);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(186, 16);
            this.label3.TabIndex = 19;
            this.label3.Text = "Vehículos Estacionados:  ";
            // 
            // mascotas
            // 
            this.mascotas.Location = new System.Drawing.Point(527, 122);
            this.mascotas.Name = "mascotas";
            this.mascotas.Size = new System.Drawing.Size(76, 20);
            this.mascotas.TabIndex = 17;
            this.mascotas.Text = "0";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label7.Location = new System.Drawing.Point(452, 125);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(69, 13);
            this.label7.TabIndex = 16;
            this.label7.Text = "Mascotas: ";
            // 
            // telefono
            // 
            this.telefono.Location = new System.Drawing.Point(565, 62);
            this.telefono.MaxLength = 9;
            this.telefono.Name = "telefono";
            this.telefono.Size = new System.Drawing.Size(123, 20);
            this.telefono.TabIndex = 15;
            this.telefono.Visible = false;
            this.telefono.TextChanged += new System.EventHandler(this.telefono_TextChanged);
            // 
            // matricula
            // 
            this.matricula.Location = new System.Drawing.Point(277, 62);
            this.matricula.Name = "matricula";
            this.matricula.Size = new System.Drawing.Size(130, 20);
            this.matricula.TabIndex = 14;
            this.matricula.Visible = false;
            this.matricula.TextChanged += new System.EventHandler(this.matricula_TextChanged);
            // 
            // labelTelefono
            // 
            this.labelTelefono.AutoSize = true;
            this.labelTelefono.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelTelefono.Location = new System.Drawing.Point(427, 65);
            this.labelTelefono.Name = "labelTelefono";
            this.labelTelefono.Size = new System.Drawing.Size(133, 13);
            this.labelTelefono.TabIndex = 13;
            this.labelTelefono.Text = "Teléfono de contacto:";
            this.labelTelefono.Visible = false;
            // 
            // labelMatricula
            // 
            this.labelMatricula.AutoSize = true;
            this.labelMatricula.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelMatricula.Location = new System.Drawing.Point(210, 65);
            this.labelMatricula.Name = "labelMatricula";
            this.labelMatricula.Size = new System.Drawing.Size(65, 13);
            this.labelMatricula.TabIndex = 12;
            this.labelMatricula.Text = "Matrícula:";
            this.labelMatricula.Visible = false;
            // 
            // mayores16
            // 
            this.mayores16.Location = new System.Drawing.Point(331, 122);
            this.mayores16.Name = "mayores16";
            this.mayores16.Size = new System.Drawing.Size(76, 20);
            this.mayores16.TabIndex = 11;
            this.mayores16.Text = "0";
            this.mayores16.TextChanged += new System.EventHandler(this.mayores16_TextChanged);
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label5.Location = new System.Drawing.Point(231, 125);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(94, 13);
            this.label5.TabIndex = 10;
            this.label5.Text = "Mayores de 16:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.Location = new System.Drawing.Point(26, 125);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(95, 13);
            this.label4.TabIndex = 9;
            this.label4.Text = "Menores de 16:";
            // 
            // menores16
            // 
            this.menores16.Location = new System.Drawing.Point(127, 122);
            this.menores16.Name = "menores16";
            this.menores16.Size = new System.Drawing.Size(76, 20);
            this.menores16.TabIndex = 8;
            this.menores16.Text = "0";
            this.menores16.TextChanged += new System.EventHandler(this.menores16_TextChanged);
            // 
            // rbNo
            // 
            this.rbNo.AutoSize = true;
            this.rbNo.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.rbNo.Location = new System.Drawing.Point(162, 65);
            this.rbNo.Name = "rbNo";
            this.rbNo.Size = new System.Drawing.Size(41, 17);
            this.rbNo.TabIndex = 5;
            this.rbNo.TabStop = true;
            this.rbNo.Text = "No";
            this.rbNo.UseVisualStyleBackColor = true;
            this.rbNo.CheckedChanged += new System.EventHandler(this.rbNo_CheckedChanged);
            // 
            // rbSi
            // 
            this.rbSi.AutoSize = true;
            this.rbSi.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.rbSi.Location = new System.Drawing.Point(114, 65);
            this.rbSi.Name = "rbSi";
            this.rbSi.Size = new System.Drawing.Size(38, 17);
            this.rbSi.TabIndex = 4;
            this.rbSi.TabStop = true;
            this.rbSi.Text = "Sí";
            this.rbSi.UseVisualStyleBackColor = true;
            this.rbSi.CheckedChanged += new System.EventHandler(this.rbSi_CheckedChanged);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(3, 65);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(108, 13);
            this.label2.TabIndex = 3;
            this.label2.Text = "¿Traes Vehículo?";
            // 
            // aforoPersonas
            // 
            this.aforoPersonas.AutoSize = true;
            this.aforoPersonas.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.aforoPersonas.Location = new System.Drawing.Point(445, 17);
            this.aforoPersonas.Name = "aforoPersonas";
            this.aforoPersonas.Size = new System.Drawing.Size(17, 16);
            this.aforoPersonas.TabIndex = 2;
            this.aforoPersonas.Text = "A";
            // 
            // aforoVehiculos
            // 
            this.aforoVehiculos.AutoSize = true;
            this.aforoVehiculos.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.aforoVehiculos.Location = new System.Drawing.Point(331, 18);
            this.aforoVehiculos.Name = "aforoVehiculos";
            this.aforoVehiculos.Size = new System.Drawing.Size(17, 16);
            this.aforoVehiculos.TabIndex = 1;
            this.aforoVehiculos.Text = "V";
            // 
            // btnCalcular
            // 
            this.btnCalcular.BackColor = System.Drawing.Color.Violet;
            this.btnCalcular.Enabled = false;
            this.btnCalcular.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnCalcular.ForeColor = System.Drawing.Color.SpringGreen;
            this.btnCalcular.Location = new System.Drawing.Point(646, 101);
            this.btnCalcular.Name = "btnCalcular";
            this.btnCalcular.Size = new System.Drawing.Size(117, 44);
            this.btnCalcular.TabIndex = 0;
            this.btnCalcular.Text = "CALCULAR";
            this.btnCalcular.UseVisualStyleBackColor = false;
            this.btnCalcular.Click += new System.EventHandler(this.btnCalcular_Click);
            // 
            // panel2
            // 
            this.panel2.BackColor = System.Drawing.Color.LavenderBlush;
            this.panel2.Controls.Add(this.matriculaABuscar);
            this.panel2.Controls.Add(this.label8);
            this.panel2.Controls.Add(this.btnConsultar);
            this.panel2.Location = new System.Drawing.Point(13, 217);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(775, 201);
            this.panel2.TabIndex = 1;
            // 
            // btnConsultar
            // 
            this.btnConsultar.BackColor = System.Drawing.Color.Violet;
            this.btnConsultar.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnConsultar.ForeColor = System.Drawing.Color.SpringGreen;
            this.btnConsultar.Location = new System.Drawing.Point(315, 112);
            this.btnConsultar.Name = "btnConsultar";
            this.btnConsultar.Size = new System.Drawing.Size(147, 75);
            this.btnConsultar.TabIndex = 1;
            this.btnConsultar.Text = "CONSULTAR";
            this.btnConsultar.UseVisualStyleBackColor = false;
            this.btnConsultar.Click += new System.EventHandler(this.btnConsultar_Click);
            // 
            // btnSalir
            // 
            this.btnSalir.BackColor = System.Drawing.Color.Violet;
            this.btnSalir.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnSalir.ForeColor = System.Drawing.Color.SpringGreen;
            this.btnSalir.Location = new System.Drawing.Point(347, 424);
            this.btnSalir.Name = "btnSalir";
            this.btnSalir.Size = new System.Drawing.Size(110, 25);
            this.btnSalir.TabIndex = 2;
            this.btnSalir.Text = "SALIR";
            this.btnSalir.UseVisualStyleBackColor = false;
            this.btnSalir.Click += new System.EventHandler(this.btnSalir_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.Color.OrangeRed;
            this.label1.Location = new System.Drawing.Point(301, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(174, 18);
            this.label1.TabIndex = 3;
            this.label1.Text = "¡Bienvenido al Parque!";
            // 
            // errorPanel1
            // 
            this.errorPanel1.ContainerControl = this;
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label8.ForeColor = System.Drawing.Color.OrangeRed;
            this.label8.Location = new System.Drawing.Point(263, 48);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(247, 20);
            this.label8.TabIndex = 21;
            this.label8.Text = "Introduzca aquí una matrícula";
            // 
            // matriculaABuscar
            // 
            this.matriculaABuscar.Location = new System.Drawing.Point(315, 71);
            this.matriculaABuscar.Name = "matriculaABuscar";
            this.matriculaABuscar.Size = new System.Drawing.Size(147, 20);
            this.matriculaABuscar.TabIndex = 21;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Pink;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.btnSalir);
            this.Controls.Add(this.panel2);
            this.Controls.Add(this.panel1);
            this.Name = "Form1";
            this.Text = "Parque Petecander";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.panel2.ResumeLayout(false);
            this.panel2.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.errorPanel1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Button btnCalcular;
        private System.Windows.Forms.Panel panel2;
        private System.Windows.Forms.Button btnConsultar;
        private System.Windows.Forms.Button btnSalir;
        private System.Windows.Forms.Label aforoVehiculos;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox mascotas;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.TextBox telefono;
        private System.Windows.Forms.TextBox matricula;
        private System.Windows.Forms.Label labelTelefono;
        private System.Windows.Forms.Label labelMatricula;
        private System.Windows.Forms.TextBox mayores16;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox menores16;
        private System.Windows.Forms.RadioButton rbNo;
        private System.Windows.Forms.RadioButton rbSi;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label aforoPersonas;
        private System.Windows.Forms.ErrorProvider errorPanel1;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.TextBox matriculaABuscar;
    }
}

