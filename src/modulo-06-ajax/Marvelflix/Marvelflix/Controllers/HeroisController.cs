using Marvelflix.Dominio;
using Marvelflix.Servicos;
using System.Collections.Generic;
using System.Linq;
using System.Web.Http;
using System.Web.Http.Description;

namespace Marvelflix.Controllers
{
    public class HeroisController : ApiController
    {
        private IHeroisRepositorio herois = ServicoDeDependencias.MontarHeroisRepositorio();

        // GET: api/Herois
        public IEnumerable<Heroi> GetHeroi()
        {
            return herois.Todos();
        }

        // GET: api/Herois/5
        [ResponseType(typeof(Heroi))]
        public IHttpActionResult GetHeroi(int id)
        {
            Heroi heroi = herois.PorId(id);
            if (heroi == null)
            {
                return NotFound();
            }

            return Ok(heroi);
        }

        // POST: api/Herois
        //[ResponseType(typeof(Heroi))]
        //public IHttpActionResult PostHeroi(Heroi heroi)
        //{
        //    if (!ModelState.IsValid)
        //    {
        //        return BadRequest(ModelState);
        //    }

        //    db.Heroi.Add(heroi);
        //    db.SaveChanges();

        //    return CreatedAtRoute("DefaultApi", new { id = heroi.Id }, heroi);
        //}
    }
}