using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public interface IPersonagemRepositorio
    {
        List<Personagem> ListarPersonagens(string filtroNome);
        void IncluirPersonagem(Personagem personagem);
        void EditarPersonagem(Personagem personagem);
        void ExcluirPersonagem(Personagem personagem);
    }
}
