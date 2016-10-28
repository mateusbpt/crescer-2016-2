using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MarioKart.Corredores;
using MarioKart.Equipamentos;
using static MarioKart.Corredores.Habilidade;

namespace MarioKart.Kart
{
    public abstract class Kart
    {
        public Kart(Corredor motorista)
        {
            this.Motorista = motorista;
            this.Equipamentos = new List<IEquipamento>();
        }

        public Corredor Motorista { get; set; }

        protected List<IEquipamento> Equipamentos { get; set; }

        public virtual int Velocidade
        {
            get
            {
                int somaVelocidade = 3 + (int)Motorista.HabilidadeCorredor + bonusEquipamento();

                bool profissional = Motorista.HabilidadeCorredor == Nivel.Profissional;

                return profissional ? somaVelocidade + Equipamentos.Count : somaVelocidade;
            }
        }

        public int bonusEquipamento()
        {
            int totalBonus = 0;

            foreach (IEquipamento bonus in Equipamentos)
            {
                totalBonus += bonus.BonusEquipamento;
            }

            return totalBonus;
        }

        public void adicionarEquipamento(IEquipamento equipamento)
        {
            Equipamentos.Add(equipamento);
        }
    }

}