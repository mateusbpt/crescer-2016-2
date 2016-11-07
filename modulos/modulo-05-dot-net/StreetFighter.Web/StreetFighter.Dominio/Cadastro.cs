using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public class Cadastro
    {
        public string Login { get; set; }

        public string Senha { get; set; }

        public Cadastro(string login, string senha)
        {
            this.Login = login;
            this.Senha = senha;
        }

    }
}
