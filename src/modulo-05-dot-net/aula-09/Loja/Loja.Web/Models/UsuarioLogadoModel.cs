using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Loja.Web.Models
{
    public class UsuarioLogadoModel
    {
        [Required]
        public string Email{ get; set; }

        public UsuarioLogadoModel(string email)
        {
            this.Email = email;
        }
    }
}