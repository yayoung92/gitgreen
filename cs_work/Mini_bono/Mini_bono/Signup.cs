using Oracle.ManagedDataAccess.Client;
using System;
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

        //회원가입 시 아이디 중복 체크
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

        //회원가입 누르는 버튼
        private void signup_Click(object sender, EventArgs e)
        {
            string signId = id.Text;
            string signPw = pw.Text;
            string signName = name.Text;

            conn = new OracleConnection(strConnection);
            conn.Open();
            string sql = "insert into member(id, pw, name, role, resign) " +
               "values('" + signId + "', '" + signPw + "', '" + signName + "', 'USER', 'N')";
            cmd = new OracleCommand(sql, conn);

            try
            {
                if (cmd.ExecuteNonQuery() == 1)
                {
                    MessageBox.Show("환영합니다. " + signId + " 님 회원가입 되었습니다.");

                    Wordlist wordlist = new Wordlist();
                    // Close 하면 프로그램 종료하는 것처럼 되는 듯?
                    this.Hide();   // 회원가입 성공이면 원래 폼 숨기기
                    wordlist.Show();
                }
                else
                    MessageBox.Show("비정상 입력 정보, 재확인바랍니다.");
            }catch(Exception ex)
            {
                
                MessageBox.Show("아이디 중복입니다. 재확인바랍니다.");
            }
            conn.Close();
        }
    }
}
