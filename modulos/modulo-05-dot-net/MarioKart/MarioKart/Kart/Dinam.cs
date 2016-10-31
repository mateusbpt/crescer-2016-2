using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MarioKart.Corredores;

namespace MarioKart.Kart
{
    public class Dinam : Kart
    {
        public Dinam(Corredor motorista) : base(motorista)
        {
        }

        public override int Velocidade
        {
            get
            {
                return base.Velocidade + (int)Motorista.HabilidadeCorredor;
            }
        }

    }
}
