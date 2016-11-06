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

        public DateTime DataNascimento { get; private set; }

        public int Altura { get; private set; }

        public decimal Peso { get; private set; }

        public string GolpesEspeciais { get; private set; }

        public bool PersonagemOculto { get; private set; }

        public string Imagem { get; private set; }

        public Personagem
            (
            int id,
            string nome,
            string origem,
            DateTime dataNascimento,
            int altura,
            decimal peso,
            string golpesEspeciais,
            bool personagemOculto = false,
            string imagem = "default"
            )
            : this(
                  nome,
                  origem,
                  dataNascimento,
                  altura,
                  peso,
                  golpesEspeciais,
                  personagemOculto,
                  imagem
                  )
        {
            this.Id = id;
        }

        public Personagem
            (
            string nome,
            string origem,
            DateTime dataNascimento,
            int altura,
            decimal peso,
            string golpesEspeciais,
            bool personagemOculto = false,
            string imagem = "default"
            )
        {
            this.Nome = nome;
            this.Origem = origem;
            this.DataNascimento = dataNascimento;
            this.Altura = altura;
            this.Peso = peso;
            this.GolpesEspeciais = golpesEspeciais;
            this.PersonagemOculto = personagemOculto;
            this.Imagem = imagem;
        }
    }
}
