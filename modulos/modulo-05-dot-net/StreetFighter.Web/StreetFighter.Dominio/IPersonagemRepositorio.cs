using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public interface IPersonagemRepositorio
    {
        List<Personagem> ListarPersonagens(string filtro = null);
        void IncluirPersonagem(Personagem personagem);
        void ExcluirPersonagem(Personagem personagem);
        void EditarPersonagem(Personagem personagem);
        Personagem PesquisarPeloId(int id);
    }
}
