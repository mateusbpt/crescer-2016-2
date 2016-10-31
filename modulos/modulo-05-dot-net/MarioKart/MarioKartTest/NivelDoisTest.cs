using System;
using MarioKart.Corredores;
using MarioKart.Kart;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using static MarioKart.Corredores.Habilidade;
using MarioKart.Equipamentos;

namespace MarioKartTest
{
    [TestClass]
    public class NivelDoisTest
    {

        [TestMethod]
        public void VerificarVelocidadeSonnarComMotoristaNoobSemItens()
        {
            var kart = new Sonnar(new Corredor("Yoshi", Nivel.Noob));
            Assert.AreEqual(6, kart.Velocidade);
        }

        [TestMethod]
        public void VerificarVelocidadeLightComMotoristaNoobSemItens()
        {
            var kart = new Light(new Corredor("Yoshi", Nivel.Noob));
            Assert.AreEqual(9, kart.Velocidade);
        }

        [TestMethod]
        public void VerificarVelocidadeDinamComMotoristaNoobSemItens()
        {
            var kart = new Light(new Corredor("Yoshi", Nivel.Noob));
            Assert.AreEqual(9, kart.Velocidade);
        }

        [TestMethod]
        public void VerificarVelocidadeSonnarComMotoristaNoobComItens()
        {
            var kart = new Sonnar(new Corredor("Yoshi", Nivel.Noob));
            kart.adicionarEquipamento(new MotorABaseDeLava());
            Assert.AreEqual(11, kart.Velocidade);
        }

        [TestMethod]
        public void VerificarVelocidadeLightComMotoristaNoobComItens()
        {
            var kart = new Light(new Corredor("Yoshi", Nivel.Noob));
            kart.adicionarEquipamento(new MotorABaseDeLava());
            Assert.AreEqual(12, kart.Velocidade);
        }

        [TestMethod]
        public void VerificarVelocidadeDinamComMotoristaNoobComItens()
        {
            var kart = new Dinam(new Corredor("Yoshi", Nivel.Noob));
            kart.adicionarEquipamento(new MotorABaseDeLava());
            Assert.AreEqual(12, kart.Velocidade);
        }
    }


}
