﻿using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Repositorio
{
    public class PersonagemRepositorio
    {
        const string CaminhoDoArquivo = @"C:\Users\GJK\Desktop\Mateus\CWI\crescer-2016-2\modulos\modulo-05-dot-net\CadastroPersonagens.txt";

        public List<Personagem> ListarPersonagens(string filtro = null)
        {
            List<Personagem> listaPersonagens = new List<Personagem>();
            string[] linhas = File.ReadAllLines(CaminhoDoArquivo);
            bool listaDePersonagensVazia = linhas == null || linhas.Length == 0;

            if (!listaDePersonagensVazia)
            {
                for (int i = 0; i < linhas.Length; i++)
                {
                    string[] auxiliar = linhas[i].Split(';');

                    listaPersonagens.Add(new Personagem
                        (
                        Convert.ToInt32(auxiliar[0]),
                        auxiliar[1],
                        auxiliar[2],
                        Convert.ToDateTime(auxiliar[3]),
                        Convert.ToInt32(auxiliar[4]),
                        Convert.ToDecimal(auxiliar[5]),
                        auxiliar[6],
                        Convert.ToBoolean(auxiliar[7]),
                        auxiliar[8]
                        ));
                }
            }

            return filtro != null ?
                listaPersonagens.Where(personagem => personagem.Nome.ToUpperInvariant()
                .Contains(filtro.ToUpperInvariant())).ToList()
                : listaPersonagens;
        }

        public void IncluirPersonagem(Personagem personagem)
        {
            string novoPersonagem = String.Format("{0};{1};{2};{3};{4};{5};{6};{7};{8};",
                VerificaUltimoIdUtilizado() + 1,
                personagem.Nome,
                personagem.Origem,
                personagem.DataNascimento,
                personagem.Altura,
                personagem.Peso,
                personagem.GolpesEspeciais,
                personagem.PersonagemOculto,
                personagem.Imagem
                );
            if (ListarPersonagens().Count == 0)
            {
                File.AppendAllText(CaminhoDoArquivo, novoPersonagem);
            }
            else
            {
                File.AppendAllText(CaminhoDoArquivo, Environment.NewLine + novoPersonagem);
            }

        }


        public void EditarPersonagem(Personagem personagem)
        {
            throw new NotImplementedException();
        }

        public void ExcluirPersonagem(Personagem personagem)
        {
            throw new NotImplementedException();
        }

        public int VerificaUltimoIdUtilizado()
        {
            var retorno = 0;

            if (ListarPersonagens().Count != 0)
            {
                var ultimoPersonagem = ListarPersonagens().OrderBy(id => id.Id).Last();
                retorno = ultimoPersonagem.Id;
            }

            return retorno;
        }

    }

}
