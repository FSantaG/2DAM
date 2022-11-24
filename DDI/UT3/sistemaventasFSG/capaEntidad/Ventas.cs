using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace capaEntidad
{
    public class Ventas
    {
        public int IdVenta { get; set; }
        public Usuario oUsuario { get; set; }
        public string TipoDocumento { get; set; }
        public string NumeroDocumento { get; set; }
        public string DocumentoCliente { get; set; }
        public string NombreCliente { get; set; }
        public double MontoPago { get; set; }
        public double MontoCambio { get; set; }
        public double MontoTotal { get; set; }
        public List<Detalle_Venta> oDetalle_Venta { get; set; }
        public string FechaRegistro { get; set; }
    }
}
