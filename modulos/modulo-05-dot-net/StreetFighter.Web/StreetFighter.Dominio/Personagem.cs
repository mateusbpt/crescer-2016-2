﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public class Personagem
    {
        public int Id { get; set; }

        public string Nome { get; set; }

        public string Origem { get; set; }

        public DateTime DataNascimento { get; set; }

        public int Altura { get; set; }

        public decimal Peso { get; set; }

        public string GolpesEspeciais { get; set; }

        public bool PersonagemOculto { get; set; }

        public string Imagem { get; set; }

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
            if (nome.ToUpperInvariant().Contains("NUNES"))
                throw new RegraNegocioException("Não é permitido cadastrar um personagem overpowered.");
            if (origem.ToUpperInvariant().Contains("MDP"))
                throw new RegraNegocioException($"Somente um personagem pode ser dessa região e esse personagem não é o { nome }.");
            if (dataNascimento.CompareTo(DataMinima) < 0)
                throw new RegraNegocioException($"Não é permitido adicionar uma data menor que {DataMinima.ToShortDateString()}");
            this.Nome = nome;
            this.Origem = origem;
            this.DataNascimento = dataNascimento;
            this.Altura = altura;
            this.Peso = peso;
            this.GolpesEspeciais = golpesEspeciais;
            this.PersonagemOculto = personagemOculto;
            this.Imagem = imagem;
        }

        public DateTime DataMinima { get; } = new DateTime(1800, 01, 01);

        public Personagem() { }
    }
}
