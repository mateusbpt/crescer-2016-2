﻿using Loja.Dominio;
using Loja.Infraestrutura;
using Loja.Repositorio;
using Loja.Web.Models;
using Loja.Web.Servicos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Loja.Web.Controllers
{
    public class LoginController : Controller
    {
        // GET: Login
        public ActionResult Index()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Entrar(string email, string senha)
        {
            UsuarioServico usuarioServico = ServicoDeDependencias.MontarUsuarioServico();

            Usuario usuario = usuarioServico.BuscarPorAutenticacao(email, senha);

            if (usuario != null)
            {
                ServicoDeAutenticacao.Autenticar(new UsuarioLogadoModel(usuario.Email));
                return RedirectToAction("Index", "Cadastro");
            }

            ViewBag.Mensagem = "E-mail ou senha incorreta, tente novamente.";
            return View("Index");
        }
    }
}