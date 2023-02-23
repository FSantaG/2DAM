using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RegistroAlumnos
{
    class Registro
    {
        public int Idregistro { get; set; }
        public Alumno oAlumno { get; set; }
        public string regfechahora { get; set; }
        public bool regtipomov { get; set; }
    }
}
