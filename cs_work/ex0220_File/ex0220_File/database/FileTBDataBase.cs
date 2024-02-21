using Oracle.ManagedDataAccess.Client;
using System;
using System.Collections.Generic;
using System.Collections.Specialized;

namespace ex0220_File.database
{
 
    public class FileTBDataBase
    {
        private static string connectionString = "DATA SOURCE=localhost; User Id=hr; Password=1234;";
        private static OracleConnection con = null;
        
        public static OracleConnection connect()
        {
            if(con == null)
            {
                con = new OracleConnection(connectionString);
                con.Open();
            }
            else
            {
                con.Open();
            }
            return con;
        }
        public void insert(string text)
        {
            OracleConnection con = connect(); // DB 연결

            string sql = "insert into FILETB values (:value1)";

            using(OracleCommand command = new OracleCommand(sql, con))
            {
                command.Parameters.Add(":value1", text);
                int rowId = command.ExecuteNonQuery();
                Console.WriteLine( $"{rowId} 행을 삽입했습니다.");
            }
            con.Close();
        }

        public List<string> read()
        {
            List<string> list = new List<string>();

            OracleConnection con = connect();
            string sql = "select * from filetb";
            using (OracleCommand command = new OracleCommand(sql, con))
            {
                OracleDataReader reader = command.ExecuteReader();
                while(reader.Read())
                {
                    list.Add(reader["str"].ToString());
                }
            }
            con.Close();
            return list;
        }
        public void update(string org, string dst)
        {
            string connectionString = "DATA SOURCE=localhost; User Id=hr; Password=1234;";

            OracleConnection con = new OracleConnection(connectionString);
            con.Open(); // db 연결

            OracleCommand oracleCommand = new OracleCommand($" update filetb set str='{dst}' " +
                                                            $" where str='{org}' ", con);
            oracleCommand.ExecuteNonQuery(); // 실행하기

            con.Close(); // db 닫기
        }
        public void delete(string org)
        {
            string connectionString = "DATA SOURCE=localhost; User Id=hr; Password=1234;";

            OracleConnection con = new OracleConnection(connectionString);
            con.Open(); // db 연결

            OracleCommand oracleCommand = new OracleCommand($"delete filetb where str='{org}'", con);
            oracleCommand.ExecuteNonQuery(); // 실행하기
            con.Close(); // db 닫기
        }
    }
}
