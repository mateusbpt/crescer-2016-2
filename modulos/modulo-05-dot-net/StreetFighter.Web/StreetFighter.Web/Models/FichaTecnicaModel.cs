using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace StreetFighter.Web.Models
{
    public class FichaTecnicaModel
    {
        public string PrimeiraAparicao { get; set; }
        public DateTime DataNascimento { get; set; }
        public int Altura { get; set; }
        public int Peso { get; set; }
        public string Medidas { get; set; }
        public char TipoSanguineo { get; set; }
        public string HabilidadeEspeciais { get; set; }
        public string Gosta { get; set; }
        public string Desgosta { get; set; }
        public string EstiloDeLuta { get; set; }
        public string Origem { get; set; }
        public string FalaDeVitoria { get; set; }
        public string SSF2Nickname { get; set; }
        public string SSF3Nickname { get; set; }
        public string SF4Nickname { get; set; }
        public string SFA3Stage { get; set; }
        public string SF2Stage { get; set; }
        public string GolpesFamosos { get; set; }

    }
}