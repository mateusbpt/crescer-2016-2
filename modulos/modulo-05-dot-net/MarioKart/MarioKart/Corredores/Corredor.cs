using System;

namespace MarioKart.Corredores
{
    public class Corredor
    {
        public Corredor(string nome, Habilidade.Nivel nivel)
        {
            this.NomeCorredor = nome;
            this.HabilidadeCorredor = nivel;
        }

        public string NomeCorredor { get; private set; }

        public Habilidade.Nivel HabilidadeCorredor { get; private set; }

    }

}

