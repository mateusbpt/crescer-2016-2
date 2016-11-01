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
        // GET: StreetFighter
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult FichaTecnica()
        {
            var blanka = new FichaTecnicaModel()
            {
                PrimeiraAparicao = "Street Fighter II The World Warrior(1991).",
                DataNascimento = new DateTime(1966, 2, 12),
                Altura = 192,
                Peso = 96,
                Medidas = "B198, C120, Q172.",
                TipoSanguineo = 'B',
                HabilidadeEspeciais = "Caçar, Eletricidade.",
                Gosta = "Frutas tropicais, Pirarucu, Sua mãe.",
                Desgosta = " Army ants (espécie de formiga).",
                EstiloDeLuta = "Luta Selvagem autodidata (Army Ants) / Capoeira.",
                Origem = "Brasil (lugar de nascença é provável como sendo Tailândia).",
                FalaDeVitoria = "Ver você em ação é uma piada!.",
                SSF2Nickname = "A selvagem criança da natureza.",
                SSF3Nickname = "A animal pessoa amazônica.",
                SF4Nickname = "Guerreiro da selva.",
                SFA3Stage = "Ramificação do Rio Madeira - pantano, Brasil (ramificação do rio Madeira: talvez possa ser Mato Grosso, ou Tocantins?).",
                SF2Stage = "Bacia do rio Amazonas (Brasil).",
                GolpesFamosos = "Electric Thunder, Rolling Attack."
            };


            return View(blanka);
        }
    }
}