using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart.Corredores;
using static MarioKart.Corredores.Habilidade;
using MarioKart.Kart;
using MarioKart.Equipamentos;

namespace MarioKartTest
{
    [TestClass]
    public class NivelUmTest
    {
        [TestMethod]
        public void VerificarNomeCorredor()
        {
            var corredor = new Corredor("Yoshi", Nivel.Noob);

            Assert.AreEqual("Yoshi", corredor.NomeCorredor);
            Assert.AreEqual(Nivel.Noob, corredor.HabilidadeCorredor);
        }

        [TestMethod]
        public void VerificarVelocidadeNoobSemItens()
        {
            var kart = new Sonnar(new Corredor("Yoshi", Nivel.Noob));
            Assert.AreEqual(6, kart.Velocidade);

        }

        [TestMethod]
        public void VerificarVelocidadeNoobComItens()
        {
            var kart = new Sonnar(new Corredor("Yoshi", Nivel.Noob));
            kart.adicionarEquipamento(new PneuDeCouroDeDragao());
            Assert.AreEqual(10, kart.Velocidade);

        }

        [TestMethod]
        public void VerificarVelocidadeMedianoSemItens()
        {
            var kart = new Sonnar(new Corredor("Luigi", Nivel.Mediano));
            Assert.AreEqual(8, kart.Velocidade);

        }

        [TestMethod]
        public void VerificarVelocidadeMedianoComItens()
        {
            var kart = new Sonnar(new Corredor("Luigi", Nivel.Mediano));
            kart.adicionarEquipamento(new PneuDeCouroDeDragao());
            kart.adicionarEquipamento(new MotorABaseDeLava());
            Assert.AreEqual(15, kart.Velocidade);

        }

        [TestMethod]
        public void VerificarVelocidadeProfissionalSemItens()
        {
            var kart = new Sonnar(new Corredor("Mario", Nivel.Profissional));
            Assert.AreEqual(9, kart.Velocidade);

        }

        [TestMethod]
        public void VerificarVelocidadeProfissionalComUmItem()
        {
            var kart = new Sonnar(new Corredor("Mario", Nivel.Profissional));
            kart.adicionarEquipamento(new PneuDeCouroDeDragao());
            Assert.AreEqual(14, kart.Velocidade);

        }

        [TestMethod]
        public void VerificarVelocidadeProfissionalComDoisItens()
        {
            var kart = new Sonnar(new Corredor("Mario", Nivel.Profissional));
            kart.adicionarEquipamento(new PneuDeCouroDeDragao());
            kart.adicionarEquipamento(new MotorABaseDeLava());
            Assert.AreEqual(18, kart.Velocidade);

        }
    }
}
