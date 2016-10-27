using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MarioKart.Corredores;
using MarioKart.Equipamentos;

namespace MarioKart.Kart
{
    public class Kart
    {
        public Kart(Corredor motorista)
        {
            this.Motorista = motorista;
            this.Equipamentos = new List<IEquipamento>();
        }

        private Corredor Motorista { get; set; }

        protected List<IEquipamento> Equipamentos { get; set; }

        private int Velocidade
        {
            get
            {
                return 0;
            }
        }
    }

}