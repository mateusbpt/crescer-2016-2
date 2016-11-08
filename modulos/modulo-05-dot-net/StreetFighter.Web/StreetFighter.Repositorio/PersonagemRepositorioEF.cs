using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Repositorio
{
    public class PersonagemRepositorioEF : IPersonagemRepositorio
    {
        public void EditarPersonagem(Personagem personagem)
        {
            using (var context = new DatabaseContext())
            {
                var personagemEditado = context.Personagem.Where(per => per.Id == personagem.Id).FirstOrDefault();

                if (personagemEditado != null)
                {
                    context.Entry(personagemEditado).CurrentValues.SetValues(personagem);
                    context.SaveChanges();
                }
            }
        }

        public void ExcluirPersonagem(Personagem personagem)
        {
            using (var context = new DatabaseContext())
            {
                var personagemRemovido = context.Personagem.Where(per => per.Id == personagem.Id).FirstOrDefault();

                if (personagemRemovido != null)
                {
                    context.Personagem.Remove(personagemRemovido);
                    context.SaveChanges();
                }
            }
        }

        public void IncluirPersonagem(Personagem personagem)
        {
            using (var context = new DatabaseContext())
            {
                context.Personagem.Add(personagem);
                context.SaveChanges();
            }
        }

        public List<Personagem> ListarPersonagens(string filtro = null)
        {
            using (var context = new DatabaseContext())
            {
                var personagens = context.Personagem;

                if (!String.IsNullOrEmpty(filtro))
                {
                    personagens.Where(per => per.Nome.ToUpperInvariant().Contains(filtro.ToUpperInvariant()));
                }

                return personagens.ToList();
            }
        }

        public Personagem PesquisarPeloId(int id)
        {
            using (var context = new DatabaseContext())
            {
                Personagem personagem = context.Personagem.FirstOrDefault(per => per.Id == id);

                return personagem;
            }
        }
    }
}
