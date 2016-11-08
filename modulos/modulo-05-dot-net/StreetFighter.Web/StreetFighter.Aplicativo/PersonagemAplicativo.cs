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
        //Ajustar aqui para Cadastro de Personagem no BD ou no arquivo txt
        private readonly IPersonagemRepositorio repositorio = new PersonagemRepositorioEF();

        public List<Personagem> ListarPersonagens(string filtroNome = null)
        {
            return repositorio.ListarPersonagens(filtroNome);
        }

        public Personagem BuscarPeloId(int id)
        {
            return repositorio.PesquisarPeloId(id);
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
