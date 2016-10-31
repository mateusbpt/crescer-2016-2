using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Equipamentos
{
    public class FogueteDePlutonio : IEquipamento
    {
        public FogueteDePlutonio() : this(2)
        {
        }

        public FogueteDePlutonio(int nivelFoguete)
        {
            var nivelCorreto = nivelFoguete > 0 && nivelFoguete <= 5; 
            this.Nivel = nivelCorreto ? nivelFoguete : 2;
        }

        public int Nivel { get; private set; }

        public int BonusEquipamento
        {
            get
            {
                return Nivel;
            }
        }
    }
}
