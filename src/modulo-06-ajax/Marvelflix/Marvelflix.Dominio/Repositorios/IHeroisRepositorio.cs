using System.Collections.Generic;
using System.Linq;

namespace Marvelflix.Dominio
{
    public interface IHeroisRepositorio
    {
        IEnumerable<Heroi> Todos();
        Heroi PorId(int id);
    }
}
