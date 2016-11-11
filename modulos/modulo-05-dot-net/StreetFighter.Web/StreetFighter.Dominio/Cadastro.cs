using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public class Cadastro
    {
        public int Id { get; set; }

        public string Login { get; set; }

        public string Senha { get; set; }

        public Cadastro(int id, string login, string senha): this(login, senha)
        {
            this.Id = id;
        }

        public Cadastro(string login, string senha)
        {
            this.Login = login;
            this.Senha = senha;
        }

        public Cadastro() { }
    }
}
