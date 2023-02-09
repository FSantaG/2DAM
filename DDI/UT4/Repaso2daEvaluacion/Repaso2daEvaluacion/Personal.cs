using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repaso2daEvaluacion
{
    class Personal
    {
        public int IdPersonal { get; set; }
        public int Numero { get; set; }

        public string Nombre { get; set; }
        public Servicio oServicio { get; set; }
        public string fechaAlta { get; set; }
        public string fechaBaja { get; set; }
        public bool Estado { get; set; }
        public string fechaCreacion { get; set; }
    }
}
