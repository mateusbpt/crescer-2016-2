using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MarioKart.Corredores;

namespace MarioKart.Kart
{
   public class Sonnar : Kart
    {
        public Sonnar(Corredor motorista) : base(motorista)
        {
        }

        public override int Velocidade
        {
            get
            {
                bool temEquipamentos = Equipamentos.Count > 0;

                return temEquipamentos ? base.Velocidade + 2 : base.Velocidade;
            }
        }
    }
}
