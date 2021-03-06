﻿using Loja.Dominio;
using System.Security.Cryptography;
using System.Text;

namespace Loja.Infraestrutura
{
    public class ServicoDeCriptografia : IServicoDeCriptografia
    {
        public string Criptografar(string texto)
        {
            var salto = $"_{texto}_crescer-2016";
            return ConverterParaMD5(salto);
        }

        private string ConverterParaMD5(string texto)
        {
            using (MD5 md5Hash = MD5.Create())
            {
                // Convert the input string to a byte array and compute the hash.
                byte[] data = md5Hash.ComputeHash(Encoding.UTF8.GetBytes(texto));

                // Create a new Stringbuilder to collect the bytes
                // and create a string.
                StringBuilder sBuilder = new StringBuilder();

                // Loop through each byte of the hashed data 
                // and format each one as a hexadecimal string.
                for (int i = 0; i < data.Length; i++)
                {
                    sBuilder.Append(data[i].ToString("x2"));
                }

                // Return the hexadecimal string.
                return sBuilder.ToString();
            }
        }
    }
}
