using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MarioKart.Corredores;
using static MarioKart.Corredores.Habilidade;

namespace MarioKart.Kart
{
    public class Light : Kart
    {
        public Light(Corredor motorista) : base(motorista)
        {
        }

        public override int Velocidade
        {
            get
            {
                int retorno = base.Velocidade;
              
                if (Motorista.HabilidadeCorredor == Nivel.Noob)
                {
                    retorno += 3;
                }

                if (Motorista.HabilidadeCorredor == Nivel.Profissional)
                {
                    retorno -= 1;
                }
                    return retorno;
            }
        }
    }
}
