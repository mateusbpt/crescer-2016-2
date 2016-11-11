using Loja.Dominio;
using Loja.Web.Filters;
using Loja.Web.Models;
using Loja.Web.Servicos;
using System.Linq;
using System.Web.Mvc;

namespace Loja.Web.Controllers
{
    [SiteAutorizador]
    public class CadastroController : Controller
    {
        public ActionResult Index()
        {
            ProdutoServico usuarioServico = ServicoDeDependencias.MontarProdutoServico();
            var produtos = usuarioServico.ListarProdutos();

            if (produtos.Count != 0)
            {
                return View(produtos);
            }

            ViewBag.ListaVazia = "Não há produtos cadastrados...";
            return View();
      
        }

        public ActionResult Cadastro()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Salvar(ProdutoModel model)
        {
            ProdutoServico usuarioServico = ServicoDeDependencias.MontarProdutoServico();

            if (ModelState.IsValid)
            {
                try
                {
                    Produto produto = new Produto
                    (
                    model.Id == null ? 0 : (int)model.Id,
                    model.Nome,
                    model.Valor
                    );
                    if (produto.Id == 0)
                    {
                        ViewBag.Mensagem = "Cadastro concluído com sucesso!";
                    }
                    else
                    {
                        ViewBag.Mensagem = "Cadastro editado com sucesso!";
                    }

                    usuarioServico.Salvar(produto);
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
            ProdutoServico usuarioServico = ServicoDeDependencias.MontarProdutoServico();
            var produto = usuarioServico.ListarProdutos().Where(per => per.Id == id).ToList().FirstOrDefault();
            usuarioServico.Excluir(produto);
            ViewBag.Mensagem = "Cadastro excluído com sucesso!";
            return View("Retorno");
        }

        public ActionResult Editar(int id)
        {
            ProdutoServico usuarioServico = ServicoDeDependencias.MontarProdutoServico();
            var produtoSelecionado = usuarioServico.BuscarPeloId(id);

            if (produtoSelecionado != null)
            {
                var model = new ProdutoModel()
                {
                    Id = produtoSelecionado.Id,
                    Nome = produtoSelecionado.Nome,
                    Valor = produtoSelecionado.Valor
                };

                return View("Cadastro", model);
            }

            return new HttpNotFoundResult();
        }

        public ActionResult Retorno()
        {
            return View();
        }

    }
}