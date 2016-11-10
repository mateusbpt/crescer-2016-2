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

        public List<Produto> ListarProdutos()
        {
            return produtoServico.ListarProdutos();
        }

        public void Salvar(Produto produto)
        {
            if (produto.Valor <= 0)
                throw new RegraNegocioException("O valor deve ser maior que 0.");

            if (produto.Nome.Length <= 2)
                throw new RegraNegocioException("O nome do produto deve ter no mínimo 3 caracteres.");

            foreach (var prod in ListarProdutos())
            {
                if (produto.Nome.ToUpperInvariant().Equals(prod.Nome.ToUpperInvariant()))
                {
                    throw new RegraNegocioException("Não se pode cadastrar dois produtos com o mesmo nome.");
                }
            }


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
