using Oracle.ManagedDataAccess.Client;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Mini_bono
{
    public partial class Form1 : Form
    {
        string strConnection = "DATA SOURCE = 192.168.0.110; User Id = bono; Password=bono";

        OracleConnection conn;
        OracleCommand cmd;
        int success = 0;
        public Form1()
        {
            InitializeComponent();
        }

        private void id_TextChanged(object sender, EventArgs e)
        {

        }

        private void pw_TextChanged(object sender, EventArgs e)
        {

        }

        private void name_TextChanged(object sender, EventArgs e)
        {

        }

        private void check_Click(object sender, EventArgs e)
        {
            string checkId = id.Text;

            conn = new OracleConnection(strConnection);
            conn.Open();

            string sql = "select id from member";
            cmd = new OracleCommand(sql, conn);
            OracleDataReader reader = cmd.ExecuteReader();
            try
            {
                bool check = false;
                while (reader.Read())
                {
                    if (reader["id"].ToString() == checkId)
                    {
                        check = true;
                        break;
                    }
                }
                if (check)
                {
                    MessageBox.Show("아이디 중복입니다.");
                    success = 0;
                }
                else
                {
                    MessageBox.Show("사용할 수 있는 아이디 입니다.");
                    success = 1;
                }                    
            }catch(Exception ex)
            {
                MessageBox.Show("오류 : " + ex.Message.ToString());
            }
            reader.Close();
            conn.Close();
        }

        private void signup_Click(object sender, EventArgs e)
        {
            string signId = id.Text;
            string signPw = pw.Text;
            string signName = name.Text;
            Console.WriteLine(signId);
            Console.WriteLine(signPw);
            Console.WriteLine(signName);
            conn = new OracleConnection(strConnection);
            conn.Open();

            if (success == 1)
            {
                string sql = "insert into member(id, pw, name, role, resign) " +
                               "values('" + signId + "', '" + signPw + "', '" + signName + "', 'user', 'y')";
                cmd = new OracleCommand(sql, conn);
                OracleDataReader reader = cmd.ExecuteReader();

                while(reader.Read())
                {
                    MessageBox.Show("회원가입되었습니다.");
                }
            }
            
        }
    }
}
