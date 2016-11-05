using StreetFighter.Aplicativo;
using StreetFighter.Dominio;
using StreetFighter.Web.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace StreetFighter.Web.Controllers
{
    public class StreetFighterController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Cadastro()
        {
            return View();
        }

        [Route("BLABLABLA/Nunes/HelloWorld")]
        [Route("RotaOpcional2")]
        public ActionResult ExemploRedirecionamento(bool redirecionar)
        {
            if (redirecionar)
            {
                TempData["Mensagem"] = "Ocorreu um redirecionamento.";

                return RedirectToAction("Index");
            }
            else
            {
                return View("Index");
            }
        }

        public ActionResult FichaTecnica()
        {
            var model = new FichaTecnicaModel();
            model.Nome = "Blanka";
            model.Id = 2;

            return View(model);
        }

        public ActionResult Salvar(FichaTecnicaModel model)
        {
            if (ModelState.IsValid)
            {
                try
                {
                    var aplicativo = new PersonagemAplicativo();
                    var personagem = new Personagem(model.Nome, model.Origem);

                    aplicativo.Salvar(personagem);
                }
                catch (RegraNegocioException ex)
                {
                    ModelState.AddModelError("", ex.Message);
                }
                catch
                {
                    ModelState.AddModelError("", "Ocorreu um erro inesperado. Contate o administrador do sistema.");
                }
            }

            return View("Cadastro", model);
        }
    }
}