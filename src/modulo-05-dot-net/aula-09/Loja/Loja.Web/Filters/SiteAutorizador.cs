using Loja.Web.Models;
using Loja.Web.Servicos;
using System.Web;
using System.Web.Mvc;

namespace Loja.Web.Filters
{
    public class SiteAutorizador : AuthorizeAttribute
    {
        protected override bool AuthorizeCore(HttpContextBase httpContext)
        {
            UsuarioLogadoModel usuario = ServicoDeAutenticacao.UsuarioLogado;

            if (usuario == null)
            {
                return false;
            }

            return true;
        }

        //  protected override void HandleUnauthorizedRequest(AuthorizationContext filterContext)
        //{
        //     filterContext.Result = new RedirectResult("Index");
        //  }
    }
}