namespace Ejercicio_3
{
    partial class Pedido
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
            this.components = new System.ComponentModel.Container();
            this.debug = new System.Windows.Forms.TextBox();
            this.selectPrimero = new System.Windows.Forms.ComboBox();
            this.selectSegundo = new System.Windows.Forms.ComboBox();
            this.selectPostre = new System.Windows.Forms.ComboBox();
            this.selectBebida = new System.Windows.Forms.ComboBox();
            this.btnVerPedido = new System.Windows.Forms.Button();
            this.btnVolver = new System.Windows.Forms.Button();
            this.bienvenido = new System.Windows.Forms.Label();
            this.primerPlato = new System.Windows.Forms.Label();
            this.segundoPlato = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.errorPlatos = new System.Windows.Forms.ErrorProvider(this.components);
            this.quierePan = new System.Windows.Forms.CheckBox();
            ((System.ComponentModel.ISupportInitialize)(this.errorPlatos)).BeginInit();
            this.SuspendLayout();
            // 
            // debug
            // 
            this.debug.Location = new System.Drawing.Point(608, 31);
            this.debug.Name = "debug";
            this.debug.Size = new System.Drawing.Size(100, 20);
            this.debug.TabIndex = 0;
            // 
            // selectPrimero
            // 
            this.selectPrimero.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.selectPrimero.FormattingEnabled = true;
            this.selectPrimero.Location = new System.Drawing.Point(54, 117);
            this.selectPrimero.Name = "selectPrimero";
            this.selectPrimero.Size = new System.Drawing.Size(184, 21);
            this.selectPrimero.TabIndex = 1;
            // 
            // selectSegundo
            // 
            this.selectSegundo.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.selectSegundo.FormattingEnabled = true;
            this.selectSegundo.Location = new System.Drawing.Point(306, 117);
            this.selectSegundo.Name = "selectSegundo";
            this.selectSegundo.Size = new System.Drawing.Size(184, 21);
            this.selectSegundo.TabIndex = 2;
            // 
            // selectPostre
            // 
            this.selectPostre.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.selectPostre.FormattingEnabled = true;
            this.selectPostre.Location = new System.Drawing.Point(559, 117);
            this.selectPostre.Name = "selectPostre";
            this.selectPostre.Size = new System.Drawing.Size(184, 21);
            this.selectPostre.TabIndex = 3;
            // 
            // selectBebida
            // 
            this.selectBebida.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.selectBebida.FormattingEnabled = true;
            this.selectBebida.Location = new System.Drawing.Point(210, 236);
            this.selectBebida.Name = "selectBebida";
            this.selectBebida.Size = new System.Drawing.Size(133, 21);
            this.selectBebida.TabIndex = 4;
            // 
            // btnVerPedido
            // 
            this.btnVerPedido.BackColor = System.Drawing.Color.Gold;
            this.btnVerPedido.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnVerPedido.Location = new System.Drawing.Point(252, 309);
            this.btnVerPedido.Name = "btnVerPedido";
            this.btnVerPedido.Size = new System.Drawing.Size(123, 56);
            this.btnVerPedido.TabIndex = 6;
            this.btnVerPedido.Text = "Visualizar Pedido";
            this.btnVerPedido.UseVisualStyleBackColor = false;
            // 
            // btnVolver
            // 
            this.btnVolver.BackColor = System.Drawing.Color.Gold;
            this.btnVolver.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnVolver.ForeColor = System.Drawing.Color.Red;
            this.btnVolver.Location = new System.Drawing.Point(433, 309);
            this.btnVolver.Name = "btnVolver";
            this.btnVolver.Size = new System.Drawing.Size(123, 56);
            this.btnVolver.TabIndex = 7;
            this.btnVolver.Text = "VOLVER";
            this.btnVolver.UseVisualStyleBackColor = false;
            this.btnVolver.Click += new System.EventHandler(this.btnVolver_Click);
            // 
            // bienvenido
            // 
            this.bienvenido.AutoSize = true;
            this.bienvenido.Font = new System.Drawing.Font("Microsoft Sans Serif", 15F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.bienvenido.ForeColor = System.Drawing.Color.Teal;
            this.bienvenido.Location = new System.Drawing.Point(302, 31);
            this.bienvenido.Name = "bienvenido";
            this.bienvenido.Size = new System.Drawing.Size(131, 25);
            this.bienvenido.TabIndex = 10;
            this.bienvenido.Text = "Bienvenido, ";
            // 
            // primerPlato
            // 
            this.primerPlato.AutoSize = true;
            this.primerPlato.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.primerPlato.ForeColor = System.Drawing.Color.MediumTurquoise;
            this.primerPlato.Location = new System.Drawing.Point(65, 94);
            this.primerPlato.Name = "primerPlato";
            this.primerPlato.Size = new System.Drawing.Size(117, 20);
            this.primerPlato.TabIndex = 11;
            this.primerPlato.Text = "Primer Plato (";
            // 
            // segundoPlato
            // 
            this.segundoPlato.AutoSize = true;
            this.segundoPlato.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.segundoPlato.ForeColor = System.Drawing.Color.MediumTurquoise;
            this.segundoPlato.Location = new System.Drawing.Point(303, 94);
            this.segundoPlato.Name = "segundoPlato";
            this.segundoPlato.Size = new System.Drawing.Size(138, 20);
            this.segundoPlato.TabIndex = 12;
            this.segundoPlato.Text = "Segundo Plato (";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.ForeColor = System.Drawing.Color.MediumTurquoise;
            this.label3.Location = new System.Drawing.Point(604, 94);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(98, 20);
            this.label3.TabIndex = 13;
            this.label3.Text = "Postre (3€)";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.ForeColor = System.Drawing.Color.MediumTurquoise;
            this.label4.Location = new System.Drawing.Point(218, 213);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(76, 20);
            this.label4.TabIndex = 14;
            this.label4.Text = "Bebida (";
            // 
            // errorPlatos
            // 
            this.errorPlatos.ContainerControl = this;
            // 
            // quierePan
            // 
            this.quierePan.AutoSize = true;
            this.quierePan.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.quierePan.ForeColor = System.Drawing.Color.MediumAquamarine;
            this.quierePan.Location = new System.Drawing.Point(454, 233);
            this.quierePan.Name = "quierePan";
            this.quierePan.Size = new System.Drawing.Size(131, 24);
            this.quierePan.TabIndex = 16;
            this.quierePan.Text = "Pan (+0.80€)";
            this.quierePan.UseVisualStyleBackColor = true;
            // 
            // Pedido
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.PaleGoldenrod;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.quierePan);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.segundoPlato);
            this.Controls.Add(this.primerPlato);
            this.Controls.Add(this.bienvenido);
            this.Controls.Add(this.btnVolver);
            this.Controls.Add(this.btnVerPedido);
            this.Controls.Add(this.selectBebida);
            this.Controls.Add(this.selectPostre);
            this.Controls.Add(this.selectSegundo);
            this.Controls.Add(this.selectPrimero);
            this.Controls.Add(this.debug);
            this.Name = "Pedido";
            this.Text = "Restaurante Petecander";
            this.Load += new System.EventHandler(this.Pedido_Load);
            ((System.ComponentModel.ISupportInitialize)(this.errorPlatos)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox debug;
        private System.Windows.Forms.ComboBox selectPrimero;
        private System.Windows.Forms.ComboBox selectSegundo;
        private System.Windows.Forms.ComboBox selectPostre;
        private System.Windows.Forms.ComboBox selectBebida;
        private System.Windows.Forms.Button btnVerPedido;
        private System.Windows.Forms.Button btnVolver;
        private System.Windows.Forms.Label bienvenido;
        private System.Windows.Forms.Label primerPlato;
        private System.Windows.Forms.Label segundoPlato;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.ErrorProvider errorPlatos;
        private System.Windows.Forms.CheckBox quierePan;
    }
}