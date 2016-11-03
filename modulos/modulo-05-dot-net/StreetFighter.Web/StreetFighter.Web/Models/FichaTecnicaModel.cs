using System;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;

namespace StreetFighter.Web.Models
{
    public class FichaTecnicaModel
    {
        [Required]
        public string Nome { get; set; }

        public string Imagem { get; set; }
        
        [Required]
        [DisplayName("Data de Nascimento")]
        public DateTime DataNascimento { get; set; }

        [Required]
        public int? Altura { get; set; }

        [Required]
        public decimal? Peso { get; set; }
        
        [Required]
        public string Origem { get; set; }

        [Required]
        [DisplayName("Golpes Especiais")]
        public string GolpesEspeciais { get; set; }

        [DisplayName("Personagem Oculto")]
        public bool PersonagemOculto { get; set; }

    }
}