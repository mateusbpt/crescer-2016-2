using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Equipamentos
{
    public class UltraPack : IEquipamento
    {
        public UltraPack(IEquipamento equipado)
        {
            Equipamento = equipado;
        }

        public IEquipamento Equipamento { get; private set; }

        public int BonusEquipamento
        {
            get
            {
                var pontuacaoExtra = (int)Math.Ceiling(Equipamento.BonusEquipamento * 0.2);
                var bonus = Equipamento.BonusEquipamento + pontuacaoExtra;
                
                return bonus;
            }
        }
    }
}
