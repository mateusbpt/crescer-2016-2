using Loja.Dominio;
using Loja.Web.Models;
using Loja.Web.Servicos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Loja.Web.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index(string filtro)
        {
            ProdutoServico usuarioServico = ServicoDeDependencias.MontarProdutoServico();
            List<Produto> produtos = usuarioServico.ListarProdutos(filtro);

            if (produtos.Count != 0)
            {
                return View(produtos);
            }

            ViewBag.ListaVazia = "Não há produtos cadastrados...";

            return View();
        }



        public ActionResult About()
        {
            ViewBag.Message = "Your application description page.";

            return View();
        }
        
     
        public ActionResult Contact()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }
    }
}