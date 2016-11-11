using System.Collections.Generic;
using System.Linq;

namespace Marvelflix.Dominio
{
    public interface IHeroisRepositorio
    {
        IEnumerable<Heroi> Todos(int pagina, int tamanhoPagina);
        Heroi PorId(int id);
        void Adicionar(Heroi heroi);
    }
}
