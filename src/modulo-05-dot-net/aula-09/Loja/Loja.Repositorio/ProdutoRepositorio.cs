using Loja.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Repositorio
{
    public class ProdutoRepositorio : IProdutoRepositorio
    {
        public void EditarProduto(Produto produto)
        {
            throw new NotImplementedException();
        }

        public void ExcluirProduto(Produto produto)
        {
            throw new NotImplementedException();
        }

        public void IncluirProduto(Produto produto)
        {
            throw new NotImplementedException();
        }

        public List<Produto> ListarProdutos(string filtro = null)
        {
            using (var contexto = new ContextoDeDados())
            {
                var produto = contexto.Produto;

                if (filtro != null)
                {
                    return produto.Where(prod => prod.Nome.Contains(filtro)).ToList();
                }
                else
                {
                    return produto.ToList();
                }

            }
        }

        public Produto PesquisarPeloId(int id)
        {
            using (var context = new ContextoDeDados())
            {
                Produto produto = context.Produto.FirstOrDefault(prod => prod.Id == id);

                return produto;
            }
        }
    }
}
