using Marvelflix.Dominio;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;

namespace Marvelflix.Repositorio
{
    public class HeroisRepositorio : IHeroisRepositorio
    {
        public IEnumerable<Heroi> Todos()
        {
            using (var contexto = new ContextoDeDados())
            {
                return contexto.Heroi.ToList();
            }
        }

        public Heroi PorId(int id)
        {
            using (var contexto = new ContextoDeDados())
            {
                return contexto.Heroi.Find(id);
            }
        }
    }
}
