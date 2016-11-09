using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public interface IProdutoRepositorio
    {
        List<Produto> ListarProdutos(string filtro = null);
        void IncluirProduto(Produto produto);
        void ExcluirProduto(Produto produto);
        void EditarProduto(Produto produto);
        Produto PesquisarPeloId(int id);
    }
}


