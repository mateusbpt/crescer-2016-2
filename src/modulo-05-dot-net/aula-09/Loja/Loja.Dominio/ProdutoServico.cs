using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public class ProdutoServico
    {
        private IProdutoRepositorio produtoServico;

        public ProdutoServico(IProdutoRepositorio produtoServico)
        {
            this.produtoServico = produtoServico;
        }

        public List<Produto> ListarProdutos(string filtro = null)
        {
            return produtoServico.ListarProdutos(filtro);
        }

        public void Salvar(Produto produto)
        {
            if (produto.Id == 0)
            {
                produtoServico.IncluirProduto(produto);
            }
            else
            {
                produtoServico.EditarProduto(produto);
            }
        }

        public void Excluir(Produto produto)
        {
            produtoServico.ExcluirProduto(produto);
        }

        public Produto BuscarPeloId(int id)
        {
            return produtoServico.PesquisarPeloId(id);
        }

    }
}
