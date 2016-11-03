using StreetFighter.Web.Models;
using System;
using System.Collections.Generic;
using System.Web.Mvc;

namespace StreetFighter.Web.Controllers
{
    public class StreetFighterController : Controller
    {

        public ActionResult Index()
        {
            return View();
        }

        public ActionResult FichaTecnica()
        {
            var blanka = new FichaTecnicaModel()
            {
                Nome = "Blanka",
                Imagem = "http://www.streetfighter.com.br/upload/editor/20120823194105_127.png",
                DataNascimento = new DateTime(1966, 2, 12),
                Altura = 192,
                Peso = 96,
                Origem = "Brasil",
                GolpesEspeciais = "Electric Thunder, Rolling Attack"
            };

            return View(blanka);
        }

        public ActionResult Cadastro()
        {
            PopularPaises();

            return View();
        }

        public ActionResult Salvar(FichaTecnicaModel model)
        {
            PopularPaises();
            if (ModelState.IsValid)
            {
                ViewBag.Mensagem = "Cadastro concluído com sucesso.";
                return View("FichaTecnica", model);
            }
            else
            {
                ModelState.AddModelError("", "Ocorreu um erro no cadastro, tente novamente.");
                return View("Cadastro");
            }
        }

        public ActionResult Sobre()
        {
            var sobre = new SobreModel()
            {
                Frase = "Em construção!",
                Imagem = "http://i1.kym-cdn.com/photos/images/newsfeed/000/096/044/trollface.jpg"
            };

            return View(sobre);
        }

        private void PopularPaises()
        {
            ViewData["ListaPaises"] = new List<SelectListItem>()
            {
                new SelectListItem() { Value = "BR", Text = "Brasil" },
                new SelectListItem() { Value = "US", Text = "Estados Unidos" },
                new SelectListItem() { Value = "JP", Text = "Japão" },
                new SelectListItem() { Value = "CN", Text = "China" },
                new SelectListItem() { Value = "EN", Text = "Inglaterra" },
                new SelectListItem() { Value = "KR", Text = "Coréia do Sul" },
            };

        }

    }
}




