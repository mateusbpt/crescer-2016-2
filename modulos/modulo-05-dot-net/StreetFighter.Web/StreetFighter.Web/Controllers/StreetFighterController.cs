using StreetFighter.Aplicativo;
using StreetFighter.Dominio;
using StreetFighter.Web.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web.Mvc;

namespace StreetFighter.Web.Controllers
{
    public class StreetFighterController : Controller
    {
        PersonagemAplicativo aplicativo = new PersonagemAplicativo();

        public ActionResult Index()
        {
            return View();
        }

        public ActionResult FichaTecnica(int id)
        {
            var personagemSelecionado = aplicativo.BuscarPeloId(id);

            if (personagemSelecionado != null)
            {
                var model = new FichaTecnicaModel()
                {
                    Nome = personagemSelecionado.Nome,
                    Origem = personagemSelecionado.Origem,
                    DataNascimento = personagemSelecionado.DataNascimento,
                    GolpesEspeciais = personagemSelecionado.GolpesEspeciais,
                    Peso = personagemSelecionado.Peso,
                    Altura = personagemSelecionado.Altura,
                    Imagem = personagemSelecionado.Imagem,
                };
                return View(model);
            }

            ModelState.AddModelError("", "Personagem não cadastrado");
            return new HttpNotFoundResult();

        }

        public ActionResult Cadastro()
        {
            PopularPaises();

            return View();
        }

        public ActionResult ListaPersonagem(string filtro)
        {
            List<Personagem> personagens = aplicativo.ListarPersonagens(filtro);

            if (personagens.Count != 0)
            {
                return View(personagens);
            }

            ViewBag.ListaVazia = "Não há personagens cadastrados...";
            return View();

        }

        public ActionResult Pesquisar(string filtro)
        { 
            return View("ListaPersonagem");
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




