using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Corredores
{
    public class Corredor
    {
        public Corredor(String nome, NivelHabilidade nivel)
        {
            this.NomeCorredor = nome;
            this.HabilidadeCorredor = nivel;
        }

        protected String NomeCorredor { get; set; }

        public NivelHabilidade HabilidadeCorredor { get; set; }

    }

    public enum NivelHabilidade
    {
        Noob, Mediano, Profissional
    }
}

