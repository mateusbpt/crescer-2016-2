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
                    Imagem = personagemSelecionado.Imagem
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

        public ActionResult Retorno()
        {
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

        [HttpPost]
        public ActionResult Salvar(FichaTecnicaModel model)
        {
            PopularPaises();

            if (ModelState.IsValid)
            {
                try
                {

                    Personagem personagem = new Personagem
                    (
                    model.Id == null ? 0 : (int)model.Id,
                    model.Nome,
                    model.Origem,
                    model.DataNascimento,
                    model.Altura,
                    model.Peso,
                    model.GolpesEspeciais,
                    model.PersonagemOculto,
                    model.Imagem == null ? "default" : model.Imagem
                    );
                    if (personagem.Id == 0)
                    {
                        ViewBag.Mensagem = "Cadastro concluído com sucesso!";
                    }
                    else
                    {
                        ViewBag.Mensagem = "Cadastro editado com sucesso!";
                    }

                    aplicativo.Salvar(personagem);
                }
                catch (RegraNegocioException ex)
                {
                    ModelState.AddModelError("", ex.Message);
                    return View("Cadastro");
                }
                catch
                {
                    ModelState.AddModelError("", "Ocorreu um erro inesperado. Contate o administrador do sistema.");
                    return View("Cadastro");
                }
            }
            return View("Retorno");
        }

        public ActionResult Excluir(int id)
        {
            var personagem = aplicativo.ListarPersonagens().Where(per => per.Id == id).ToList().ElementAt(0);
            aplicativo.Excluir(personagem);
            ViewBag.Mensagem = "Cadastro excluído com sucesso!";
            return View("Retorno");
        }

        public ActionResult Editar(int id)
        {
            PopularPaises();

            var personagemSelecionado = aplicativo.BuscarPeloId(id);

            if (personagemSelecionado != null)
            {
                var model = new FichaTecnicaModel()
                {
                    Id = personagemSelecionado.Id,
                    Nome = personagemSelecionado.Nome,
                    Origem = personagemSelecionado.Origem,
                    DataNascimento = personagemSelecionado.DataNascimento,
                    GolpesEspeciais = personagemSelecionado.GolpesEspeciais,
                    Peso = personagemSelecionado.Peso,
                    Altura = personagemSelecionado.Altura,
                    PersonagemOculto = personagemSelecionado.PersonagemOculto,
                    Imagem = personagemSelecionado.Imagem
                };

                return View("Cadastro", model);
            }

            return new HttpNotFoundResult();
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
                new SelectListItem() { Value = "MDP", Text = "Morro da Pedra"}
            };

        }

    }
}




