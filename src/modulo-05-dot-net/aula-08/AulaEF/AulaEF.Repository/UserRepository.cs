using AulaEF.Dominio;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AulaEF.Repository
{
    public class UserRepository : BaseRepository, IUserRepository
    {
        public User GetById(int id)
        {
            using (var connection = new SqlConnection(ConnectionString))
            {
                //...

                return null;
            }
        }
    }
}
