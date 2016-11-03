using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public class Personagem
    {
        public int Id { get; private set; }

        public string Nome { get; private set; }

        public string Origem { get; private set; }

        public Personagem(int id, string nome, string origem) : this(nome, origem)
        {
            this.Id = id;
        }

        public Personagem(string nome, string origem)
        {
            this.Nome = nome;
            this.Origem = origem;
        }
    }
}
