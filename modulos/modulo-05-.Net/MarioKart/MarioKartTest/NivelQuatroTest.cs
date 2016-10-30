using MarioKart.Corredores;
using MarioKart.Equipamentos;
using MarioKart.Kart;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static MarioKart.Corredores.Habilidade;

namespace MarioKartTest
{
    [TestClass]
    public class NivelQuatroTest
    {
        [TestMethod]
        public void VerificarHabilidadeCorredorNoob()
        {
            var kart = new SkyFusion(new Corredor("Mario", Nivel.Noob));
            var nivel = kart.habilidadeCorredor();

            Assert.AreEqual(1, nivel);
        }

        [TestMethod]
        public void VerificarHabilidadeCorredorMediano()
        {
            var kart = new SkyFusion(new Corredor("Mario", Nivel.Mediano));
            var nivel = kart.habilidadeCorredor();

            Assert.AreEqual(2, nivel);
        }

        [TestMethod]
        public void VerificarHabilidadeCorredorProfissional()
        {
            var kart = new SkyFusion(new Corredor("Mario", Nivel.Profissional));
            var nivel = kart.habilidadeCorredor();

            Assert.AreEqual(3, nivel);
        }

        [TestMethod]
        public void VerificarVelocidadeCorredorNoobComSkyFusionSemItens()
        {
            var kart = new SkyFusion(new Corredor("Mario", Nivel.Noob));
            Assert.AreEqual(6, kart.Velocidade);
        }

        [TestMethod]
        public void VerificarVelocidadeCorredorNoobComSkyFusionComItens()
        {
            var kart = new SkyFusion(new Corredor("Mario", Nivel.Noob));
            kart.adicionarEquipamento(new PneuDeCouroDeDragao());
            Assert.AreEqual(8, kart.Velocidade);
        }

        [TestMethod]
        public void VerificarVelocidadeCorredorNoobComSkyFusionDeItem()
        {
            var kart = new SkyFusion(new Corredor("Mario", Nivel.Noob));
            kart.adicionarEquipamento(new SkyFusion(new Corredor("Luigi", Nivel.Noob)));
            Assert.AreEqual(7, kart.Velocidade);
        }

        [TestMethod]
        public void VerificarVelocidadeCorredorMedianoComSkyFusionDeItem()
        {
            var kart = new SkyFusion(new Corredor("Mario", Nivel.Mediano));//8
            kart.adicionarEquipamento(new SkyFusion(new Corredor("Luigi", Nivel.Noob)));//1
            Assert.AreEqual(9, kart.Velocidade);
        }

        [TestMethod]
        public void VerificarVelocidadeCorredorProfissionalComSkyFusionDeItem()
        {
            var kart = new SkyFusion(new Corredor("Mario", Nivel.Profissional)); //10
            kart.adicionarEquipamento(new SkyFusion(new Corredor("Luigi", Nivel.Noob))); //1
            Assert.AreEqual(11, kart.Velocidade);
        }

        [TestMethod]
        public void VerificarVelocidadeCorredorProfissionalComSkyFusionDeItemESonnar()
        {
            var kart = new Sonnar(new Corredor("Mario", Nivel.Profissional)); //14
            kart.adicionarEquipamento(new PneuDeCouroDeDragao()); //2
            kart.adicionarEquipamento(new FogueteDePlutonio(5)); //5
            kart.adicionarEquipamento(new SkyFusion(new Corredor("Luigi", Nivel.Noob))); //1
            Assert.AreEqual(22, kart.Velocidade);
        }

        [TestMethod]
        public void VerificarVelocidadeCorredorComSkyFusionDeItemVelocidadeAcimaDeDozeESonnar()
        {
            var kart = new SkyFusion(new Corredor("Mario", Nivel.Profissional)); //11
            var kartReserva = new Sonnar(new Corredor("Mario", Nivel.Profissional));//12
            kart.adicionarEquipamento(new PneuDeCouroDeDragao()); //2
            kart.adicionarEquipamento(new FogueteDePlutonio(5)); //5
            kartReserva.adicionarEquipamento(kart); //10

            Assert.AreEqual(18, kart.Velocidade);
            Assert.AreEqual(22, kartReserva.Velocidade);
        }

    }
}
