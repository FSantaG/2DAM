namespace Ejercicio_3___Sistema_Ventas_FSG
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
            this.menu = new System.Windows.Forms.MenuStrip();
            this.menuUsuarios = new FontAwesome.Sharp.IconMenuItem();
            this.menuAdmin = new FontAwesome.Sharp.IconMenuItem();
            this.menuVentas = new FontAwesome.Sharp.IconMenuItem();
            this.menuCompras = new FontAwesome.Sharp.IconMenuItem();
            this.menuClientes = new FontAwesome.Sharp.IconMenuItem();
            this.menuProveedores = new FontAwesome.Sharp.IconMenuItem();
            this.menuInformes = new FontAwesome.Sharp.IconMenuItem();
            this.acercaDe = new FontAwesome.Sharp.IconMenuItem();
            this.menuTitulo = new System.Windows.Forms.MenuStrip();
            this.label1 = new System.Windows.Forms.Label();
            this.menu.SuspendLayout();
            this.SuspendLayout();
            // 
            // menu
            // 
            this.menu.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.menuUsuarios,
            this.menuAdmin,
            this.menuVentas,
            this.menuCompras,
            this.menuClientes,
            this.menuProveedores,
            this.menuInformes,
            this.acercaDe});
            this.menu.Location = new System.Drawing.Point(0, 33);
            this.menu.Name = "menu";
            this.menu.Size = new System.Drawing.Size(800, 73);
            this.menu.TabIndex = 0;
            this.menu.Text = "menuStrip1";
            // 
            // menuUsuarios
            // 
            this.menuUsuarios.AutoSize = false;
            this.menuUsuarios.IconChar = FontAwesome.Sharp.IconChar.UserCog;
            this.menuUsuarios.IconColor = System.Drawing.Color.Black;
            this.menuUsuarios.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.menuUsuarios.IconSize = 50;
            this.menuUsuarios.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
            this.menuUsuarios.Name = "menuUsuarios";
            this.menuUsuarios.Size = new System.Drawing.Size(80, 69);
            this.menuUsuarios.Text = "Usuarios";
            this.menuUsuarios.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText;
            // 
            // menuAdmin
            // 
            this.menuAdmin.AutoSize = false;
            this.menuAdmin.IconChar = FontAwesome.Sharp.IconChar.ScrewdriverWrench;
            this.menuAdmin.IconColor = System.Drawing.Color.Black;
            this.menuAdmin.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.menuAdmin.IconSize = 50;
            this.menuAdmin.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
            this.menuAdmin.Name = "menuAdmin";
            this.menuAdmin.Size = new System.Drawing.Size(80, 69);
            this.menuAdmin.Text = "Admin";
            this.menuAdmin.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText;
            // 
            // menuVentas
            // 
            this.menuVentas.AutoSize = false;
            this.menuVentas.IconChar = FontAwesome.Sharp.IconChar.Tags;
            this.menuVentas.IconColor = System.Drawing.Color.Black;
            this.menuVentas.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.menuVentas.IconSize = 50;
            this.menuVentas.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
            this.menuVentas.Name = "menuVentas";
            this.menuVentas.Size = new System.Drawing.Size(80, 69);
            this.menuVentas.Text = "Ventas";
            this.menuVentas.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText;
            // 
            // menuCompras
            // 
            this.menuCompras.AutoSize = false;
            this.menuCompras.IconChar = FontAwesome.Sharp.IconChar.CartFlatbed;
            this.menuCompras.IconColor = System.Drawing.Color.Black;
            this.menuCompras.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.menuCompras.IconSize = 50;
            this.menuCompras.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
            this.menuCompras.Name = "menuCompras";
            this.menuCompras.Size = new System.Drawing.Size(80, 69);
            this.menuCompras.Text = "Compras";
            this.menuCompras.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText;
            // 
            // menuClientes
            // 
            this.menuClientes.AutoSize = false;
            this.menuClientes.IconChar = FontAwesome.Sharp.IconChar.CircleUser;
            this.menuClientes.IconColor = System.Drawing.Color.Black;
            this.menuClientes.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.menuClientes.IconSize = 50;
            this.menuClientes.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
            this.menuClientes.Name = "menuClientes";
            this.menuClientes.Size = new System.Drawing.Size(80, 69);
            this.menuClientes.Text = "Clientes";
            this.menuClientes.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText;
            // 
            // menuProveedores
            // 
            this.menuProveedores.AutoSize = false;
            this.menuProveedores.IconChar = FontAwesome.Sharp.IconChar.Vcard;
            this.menuProveedores.IconColor = System.Drawing.Color.Black;
            this.menuProveedores.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.menuProveedores.IconSize = 50;
            this.menuProveedores.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
            this.menuProveedores.Name = "menuProveedores";
            this.menuProveedores.Size = new System.Drawing.Size(80, 69);
            this.menuProveedores.Text = "Proveedores";
            this.menuProveedores.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText;
            // 
            // menuInformes
            // 
            this.menuInformes.AutoSize = false;
            this.menuInformes.IconChar = FontAwesome.Sharp.IconChar.ChartColumn;
            this.menuInformes.IconColor = System.Drawing.Color.Black;
            this.menuInformes.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.menuInformes.IconSize = 50;
            this.menuInformes.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
            this.menuInformes.Name = "menuInformes";
            this.menuInformes.Size = new System.Drawing.Size(80, 69);
            this.menuInformes.Text = "Informes";
            this.menuInformes.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText;
            // 
            // acercaDe
            // 
            this.acercaDe.AutoSize = false;
            this.acercaDe.IconChar = FontAwesome.Sharp.IconChar.CircleInfo;
            this.acercaDe.IconColor = System.Drawing.Color.Black;
            this.acercaDe.IconFont = FontAwesome.Sharp.IconFont.Auto;
            this.acercaDe.IconSize = 50;
            this.acercaDe.ImageScaling = System.Windows.Forms.ToolStripItemImageScaling.None;
            this.acercaDe.Name = "acercaDe";
            this.acercaDe.Size = new System.Drawing.Size(80, 69);
            this.acercaDe.Text = "Acerca de";
            this.acercaDe.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText;
            // 
            // menuTitulo
            // 
            this.menuTitulo.AutoSize = false;
            this.menuTitulo.BackColor = System.Drawing.Color.SteelBlue;
            this.menuTitulo.Font = new System.Drawing.Font("Segoe UI", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.menuTitulo.Location = new System.Drawing.Point(0, 0);
            this.menuTitulo.Name = "menuTitulo";
            this.menuTitulo.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.menuTitulo.Size = new System.Drawing.Size(800, 33);
            this.menuTitulo.TabIndex = 1;
            this.menuTitulo.Text = "menuStrip2";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.BackColor = System.Drawing.Color.SteelBlue;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 20.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.Color.Transparent;
            this.label1.Location = new System.Drawing.Point(12, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(241, 31);
            this.label1.TabIndex = 2;
            this.label1.Text = "Sistema de Ventas";
            // 
            // Inicio
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.menu);
            this.Controls.Add(this.menuTitulo);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MainMenuStrip = this.menu;
            this.Name = "Inicio";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.menu.ResumeLayout(false);
            this.menu.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menu;
        private System.Windows.Forms.MenuStrip menuTitulo;
        private FontAwesome.Sharp.IconMenuItem menuUsuarios;
        private FontAwesome.Sharp.IconMenuItem menuAdmin;
        private FontAwesome.Sharp.IconMenuItem menuVentas;
        private FontAwesome.Sharp.IconMenuItem menuCompras;
        private FontAwesome.Sharp.IconMenuItem menuClientes;
        private FontAwesome.Sharp.IconMenuItem menuProveedores;
        private FontAwesome.Sharp.IconMenuItem menuInformes;
        private FontAwesome.Sharp.IconMenuItem acercaDe;
        private System.Windows.Forms.Label label1;
    }
}

