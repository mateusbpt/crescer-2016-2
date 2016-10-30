using MarioKart.Equipamentos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MarioKart.Corredores;

namespace MarioKart.Kart
{
    public class SkyFusion : Kart, IEquipamento
    {
        public SkyFusion(Corredor motorista) : base(motorista)
        {
        }

        public int BonusEquipamento
        {
            get
            {
                var bonus = Equipamentos.Count + habilidadeCorredor();

                var velocidadeMaiorQueDoze = Velocidade > 12;

                return velocidadeMaiorQueDoze ? bonus + 5 : bonus;
            }
        }

        public int habilidadeCorredor()
        {
            var nivelCorredor = (int)Math.Floor((decimal)Motorista.HabilidadeCorredor / 2);

            return nivelCorredor;
        }
    }

}


