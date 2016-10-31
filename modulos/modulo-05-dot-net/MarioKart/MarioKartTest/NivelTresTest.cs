using MarioKart.Equipamentos;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKartTest
{
    [TestClass]
    public class NivelTresTest
    {
        [TestMethod]
        public void VerificarNivelEquipamentoFogueteDePlutonioSemNivel()
        {
            var equipamento = new FogueteDePlutonio();
            Assert.AreEqual(2, equipamento.BonusEquipamento);
        }

        [TestMethod]
        public void VerificarNivelEquipamentoFogueteDePlutonioNivelCinco()
        {
            var equipamento = new FogueteDePlutonio(5);
            Assert.AreEqual(5, equipamento.BonusEquipamento);
        }

        [TestMethod]
        public void VerificarNivelEquipamentoFogueteDePlutonioNivelZero()
        {
            var equipamento = new FogueteDePlutonio(0);
            Assert.AreEqual(2, equipamento.BonusEquipamento);
        }

        [TestMethod]
        public void VerificarNivelEquipamentoFogueteDePlutonioNivelInvalido()
        {
            var equipamento = new FogueteDePlutonio(9999);
            Assert.AreEqual(2, equipamento.BonusEquipamento);
        }

        [TestMethod]
        public void VerificarNivelEquipamentoUltraPackComMotor()
        {
            var equipamento = new UltraPack(new MotorABaseDeLava());
            Assert.AreEqual(4, equipamento.BonusEquipamento);
        }

        [TestMethod]
        public void VerificarNivelEquipamentoUltraPackComPneu()
        {
            var equipamento = new UltraPack(new PneuDeCouroDeDragao());
            Assert.AreEqual(3, equipamento.BonusEquipamento);
        }

        [TestMethod]
        public void VerificarNivelEquipamentoUltraPackComFogueteNivelCinco()
        {
            var equipamento = new UltraPack(new FogueteDePlutonio(5));
            Assert.AreEqual(6, equipamento.BonusEquipamento);
        }
    }
}
