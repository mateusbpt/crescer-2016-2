using System;

namespace Loja.Dominio
{
   public class RegraNegocioException : Exception
    {
        public RegraNegocioException(string mensgagem) : base(mensgagem)
        { }
    }
}
