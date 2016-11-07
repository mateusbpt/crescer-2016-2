using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Repositorio
{
   public class CadastroRepositorio
    {
        const string CaminhoDoArquivo = @"C:\Users\GJK\Desktop\Mateus\CWI\crescer-2016-2\modulos\modulo-05-dot-net\Logins.txt";

        public List<Cadastro> UsuariosCadastrados()
        {
            List<Cadastro> usuarios = new List<Cadastro>();
            string[] linhas = File.ReadAllLines(CaminhoDoArquivo);
            bool listaDeCadastroVazia = linhas == null || linhas.Length == 0;

            if (!listaDeCadastroVazia)
            {
                for (int i = 0; i < linhas.Length; i++)
                {
                    string[] auxiliar = linhas[i].Split(';');

                    usuarios.Add(new Cadastro
                        (
                        auxiliar[0],
                        auxiliar[1]
                        ));
                }
            }
            return usuarios;
        }
    }
}
