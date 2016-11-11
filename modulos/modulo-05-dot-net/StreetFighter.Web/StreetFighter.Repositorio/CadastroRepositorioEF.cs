using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Repositorio
{
   public class CadastroRepositorioEF : ICadastroRepositorio
    {
        public List<Cadastro> UsuariosCadastrados()
        {
            using (var context = new DatabaseContext())
            {
                var cadastros = context.Cadastro;

                return cadastros.ToList();
            }
        }
    }
}
