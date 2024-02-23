using Oracle.ManagedDataAccess.Client;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace autoid_crud.db
{
    public class CRUD
    {
        public static string getConnection() // db 연결하는 메서드
        {
            string dbstr = "DATA SOURCE=localhost; User Id=hr; Password=1234";
            return dbstr;
        }
        public static OracleConnection con = new OracleConnection(getConnection());
        public static OracleCommand cmd = new OracleCommand();
        public static string sql = "";
    }
}
