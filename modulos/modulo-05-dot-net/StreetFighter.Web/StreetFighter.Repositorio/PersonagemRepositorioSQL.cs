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
    public class PersonagemRepositorioSQL : IPersonagemRepositorio
    {
        public void EditarPersonagem(Personagem personagem)
        {
            string conexao = ConfigurationManager.ConnectionStrings["StreetFighterTeste"].ConnectionString;
            var parametros = new List<SqlParameter>();

            using (var connection = new SqlConnection(conexao))
            {
                connection.Open();

                string sql = $"UPDATE Personagem SET Nome = @param_nome, Origem = @param_origem, DataNascimento = @param_data, Altura = @param_altura, Peso = @param_peso, GolpesEspeciais = @param_golpes, PersonagemOculto = @param_oculto, Imagem = @param_imagem WHERE Id = @param_id";
                parametros.Add(new SqlParameter("param_id", personagem.Id));
                parametros.Add(new SqlParameter("param_nome", personagem.Nome));
                parametros.Add(new SqlParameter("param_origem", personagem.Origem));
                parametros.Add(new SqlParameter("param_data", personagem.DataNascimento));
                parametros.Add(new SqlParameter("param_altura", personagem.Altura));
                parametros.Add(new SqlParameter("param_peso", personagem.Peso));
                parametros.Add(new SqlParameter("param_golpes", personagem.GolpesEspeciais));
                parametros.Add(new SqlParameter("param_oculto", personagem.PersonagemOculto));
                parametros.Add(new SqlParameter("param_imagem", personagem.Imagem));

                var comando = new SqlCommand(sql, connection);

                foreach (SqlParameter param in parametros)
                {
                    comando.Parameters.Add(param);
                }
                comando.ExecuteNonQuery();
                connection.Close();
            }
        }
    
        public void ExcluirPersonagem(Personagem personagem)
        {
            string conexao = ConfigurationManager.ConnectionStrings["StreetFighterTeste"].ConnectionString;

            using (var connection = new SqlConnection(conexao))
            {
                connection.Open();

                string sql = $"DELETE FROM Personagem WHERE Id = @param_Id";

                var comando = new SqlCommand(sql, connection);

                comando.Parameters.Add(new SqlParameter("param_id", personagem.Id));

                comando.ExecuteNonQuery();
                connection.Close();
            }
        }

        public void IncluirPersonagem(Personagem personagem)
        {
            string conexao = ConfigurationManager.ConnectionStrings["StreetFighterTeste"].ConnectionString;
            var parametros = new List<SqlParameter>();

            using (var connection = new SqlConnection(conexao))
            {
                connection.Open();

                 string sql = $"INSERT INTO Personagem (Nome, Origem, DataNascimento, Altura, Peso, GolpesEspeciais, PersonagemOculto, Imagem) values (@param_nome, @param_origem, @param_data, @param_altura, @param_peso, @param_golpes, @param_oculto, @param_imagem)";

                parametros.Add(new SqlParameter("param_nome", personagem.Nome));
                parametros.Add(new SqlParameter("param_origem", personagem.Origem));
                parametros.Add(new SqlParameter("param_data", personagem.DataNascimento));
                parametros.Add(new SqlParameter("param_altura", personagem.Altura));
                parametros.Add(new SqlParameter("param_peso", personagem.Peso));
                parametros.Add(new SqlParameter("param_golpes", personagem.GolpesEspeciais));
                parametros.Add(new SqlParameter("param_oculto", personagem.PersonagemOculto));
                parametros.Add(new SqlParameter("param_imagem", personagem.Imagem));

                var comando = new SqlCommand(sql, connection);

                foreach (SqlParameter param in parametros)
                {
                    comando.Parameters.Add(param);
                }
                comando.ExecuteNonQuery();
                connection.Close();
            }
        }

        public List<Personagem> ListarPersonagens(string filtro = null)
        {
            string conexao = ConfigurationManager.ConnectionStrings["StreetFighterTeste"].ConnectionString;
            List<Personagem> retorno = new List<Personagem>();

            using (var connection = new SqlConnection(conexao))
            {
                connection.Open();

                string sql = $"SELECT * FROM Personagem WHERE Nome LIKE @param_nome";

                var comando = new SqlCommand(sql, connection);

                comando.Parameters.Add(new SqlParameter("param_nome", $"%{filtro}%"));

                SqlDataReader leitura = comando.ExecuteReader();

                while (leitura.Read())
                {
                    Personagem personagem = ConverteParaPersonagem(leitura);
                    retorno.Add(personagem);
                }

                connection.Close();
            }

            return retorno;
        }

        public Personagem PesquisarPeloId(int id)
        {
            string conexao = ConfigurationManager.ConnectionStrings["StreetFighterTeste"].ConnectionString;
            Personagem personagem = null;

            using (var connection = new SqlConnection(conexao))
            {
                connection.Open();

                string sql = $"SELECT * FROM Personagem WHERE Id = @param_id";

                var comando = new SqlCommand(sql, connection);

                comando.Parameters.Add(new SqlParameter("param_id", id));

                SqlDataReader leitura = comando.ExecuteReader();

                if (leitura.Read())
                {
                    personagem = ConverteParaPersonagem(leitura);

                }

                connection.Close();
            }

            return personagem;
        }

        private Personagem ConverteParaPersonagem(SqlDataReader leitura)
        {
            Personagem retorno = new Personagem
                (
                id: Convert.ToInt32(leitura["id"]),
                nome: leitura["nome"].ToString(),
                origem: leitura["origem"].ToString(),
                dataNascimento: Convert.ToDateTime(leitura["dataNascimento"]),
                altura: Convert.ToInt32(leitura["altura"]),
                peso: Convert.ToDecimal(leitura["peso"]),
                golpesEspeciais: leitura["golpesEspeciais"].ToString(),
                personagemOculto: Convert.ToBoolean(leitura["personagemOculto"]),
                imagem: leitura["imagem"].ToString()
                );

            return retorno;
        }
    }
}
