namespace StreetFighter.Web.Models
{
    public class UsuarioLogadoModel
    {
        public string Login { get; set; }

        public UsuarioLogadoModel(string login)
        {
            this.Login = login;
        }
    }
}