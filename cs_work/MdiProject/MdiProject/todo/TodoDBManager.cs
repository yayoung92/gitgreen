using MdiProject.database;
using Oracle.ManagedDataAccess.Client;
using System;
using System.Data;
using System.Windows.Forms;

namespace MdiProject.todo
{
    public class TodoDBManager
    {
        public TodoDBManager() { }
        public bool insert(Todo todo)
        {

            try
            {
                OracleConnection conn = DBINFO.openConnect();

                string sql = "INSERT INTO TODO " +
                    "(IDX, USERS_IDX, TITLE, CONTENT, FINISHDATE) " +
                    "VALUES " +
                    "(todoIdx.nextval, :userIdx, :title, :content, :finishdate)";

                OracleCommand cmd = new OracleCommand(sql, conn);
                cmd.Parameters.Add(":userIdx", todo.user_idx);
                cmd.Parameters.Add(":title", todo.title);
                cmd.Parameters.Add(":content", todo.content);
                cmd.Parameters.Add(":finishdate", todo.finishdate);
                cmd.ExecuteNonQuery();

                DBINFO.closeConnect();
                return true;

            } catch(Exception e)
            {
                Console.WriteLine(e.StackTrace);
                Console.WriteLine(e.Message);
                return false;
            }

        }
        public void update(Todo todo)
        {

        }
        public void delete(Todo todo) 
        { 

        }
        public DataTable select()
        {
            try
            {
                OracleConnection con = DBINFO.openConnect();

                string sql = "select a.idx, a.title, a.content, a.finishdate, b.name " +
                             "from todo a, users b " +
                             "where a.users_idx = b.idx and a.status is null " +
                             "order by a.idx desc";

                OracleDataAdapter adapter = new OracleDataAdapter();
                DataSet ds = new DataSet();

                OracleCommand oracleCommand = new OracleCommand(sql, con);
                adapter.SelectCommand = oracleCommand;

                adapter.Fill(ds);

                DBINFO.closeConnect();
                return ds.Tables[0];
            }catch(Exception e)
            {
                MessageBox.Show(e.StackTrace);
                MessageBox.Show(e.Message);
                return null;
            }            
        }
    }
}
