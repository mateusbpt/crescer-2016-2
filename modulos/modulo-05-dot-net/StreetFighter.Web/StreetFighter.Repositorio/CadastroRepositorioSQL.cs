using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Repositorio
{
    public class CadastroRepositorioSQL : ICadastroRepositorio
    {
        public List<Cadastro> UsuariosCadastrados()
        {
            //Ajustar para um número maior de cadastros
            string conexao = ConfigurationManager.ConnectionStrings["StreetFighter"].ConnectionString;
            List<Cadastro> usuarios = new List<Cadastro>();

            using (var connection = new SqlConnection(conexao))
            {
                connection.Open();

                string sql = $"SELECT Nome, Senha FROM Login";

                var comando = new SqlCommand(sql, connection);

                SqlDataReader leitura = comando.ExecuteReader();

                while (leitura.Read())
                {
                    Cadastro usuario = ConverteParaCadastro(leitura);
                    usuarios.Add(usuario);
                }

                connection.Close();
            }
            return usuarios;
        }

        private Cadastro ConverteParaCadastro(SqlDataReader leitura)
        {
            Cadastro retorno = new Cadastro
                (
                login: leitura["Nome"].ToString(),
                senha: leitura["Senha"].ToString()
                );

            return retorno;
        }

    }
}
