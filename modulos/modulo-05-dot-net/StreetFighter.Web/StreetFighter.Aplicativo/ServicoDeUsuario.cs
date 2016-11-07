using StreetFighter.Infra;
using StreetFighter.Dominio;
using StreetFighter.Repositorio;
using System.Linq;
using System.Collections.Generic;

namespace StreetFighter.Aplicativo
{
    public class ServicoDeUsuario
    {
        private readonly CadastroRepositorio usuariosCadastrados = new CadastroRepositorio();

        public List<Cadastro> ListarUsuarios()
        {
            return usuariosCadastrados.UsuariosCadastrados();
        }

        public Cadastro BuscarUsuarioAutenticado(string login, string senha)
        {
            var usuarioEncontrado = ListarUsuarios().FirstOrDefault(cadastro =>
            cadastro.Login.Equals(login));

            string senhaDeComparacao =
                ServicoDeCriptografia.ConverterParaMD5($"{login}_crescer2016_{senha}");

            if (usuarioEncontrado != null && usuarioEncontrado.Senha.Equals(senhaDeComparacao))
            {
                return usuarioEncontrado;
            }

            return null;
        }
    }
}
