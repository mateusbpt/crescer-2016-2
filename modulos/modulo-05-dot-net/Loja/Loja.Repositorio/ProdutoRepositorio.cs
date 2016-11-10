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
            using (var contexto = new ContextoDeDados())
            {
                var produtoEditado = contexto.Produto.Where(prod => prod.Id == produto.Id).FirstOrDefault();

                if (produtoEditado != null)
                {
                    contexto.Entry(produtoEditado).CurrentValues.SetValues(produto);
                    contexto.SaveChanges();
                }
            }
        }

        public void ExcluirProduto(Produto produto)
        {
            using (var contexto = new ContextoDeDados())
            {
                var personagemRemovido = contexto.Produto.Where(prod => prod.Id == produto.Id).FirstOrDefault();

                if (personagemRemovido != null)
                {
                    contexto.Produto.Remove(personagemRemovido);
                    contexto.SaveChanges();
                }
            }
        }

        public void IncluirProduto(Produto produto)
        {
            using (var contexto = new ContextoDeDados())
            {
                contexto.Produto.Add(produto);
                contexto.SaveChanges();
            }
        }

        public List<Produto> ListarProdutos()
        {
            using (var contexto = new ContextoDeDados())
            {
                var produto = contexto.Produto;

                return produto.OrderBy(prod => prod.Nome).ToList();
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

