using StreetFighter.Dominio;
using StreetFighter.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Aplicativo
{
    public class PersonagemAplicativo
    {
        private readonly PersonagemRepositorio repositorio = new PersonagemRepositorio();

        public List<Personagem> ListarPersonagens(string filtroNome = null)
        {
            return repositorio.ListarPersonagens(filtroNome);
        }

        public List<Personagem> ListarPersonagensSql(string filtroNome = null)
        {
            return repositorio.ListarPersonagensSql(filtroNome);
        }

        public Personagem BuscarPeloId(int id)
        {
            return repositorio.ListarPersonagens().Find(personagem => personagem.Id == id);
        }

        public Personagem BuscarPeloIdSql(int id)
        {
            return repositorio.PesquisarPorIDSql(id);
        }

        public void Salvar(Personagem personagem)
        {
            if (personagem.Id == 0)
            {
                repositorio.IncluirPersonagem(personagem);
            }
            else
            {
                repositorio.EditarPersonagem(personagem);
            }
        }

        public void Excluir(Personagem personagem)
        {
            repositorio.ExcluirPersonagem(personagem);
        }
    }
}
