using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public class Produto
    {
        public int Id { get; set; }

        public string Nome { get; set; }

        public decimal Valor { get; set; }

        public Produto(){}

        public Produto(string nome, decimal valor)
        {
            this.Nome = nome;
            this.Valor = valor;
        }

        public Produto(int id, string nome, decimal valor):this(nome, valor)
        {
            this.Id = id;
        }
    }
}
