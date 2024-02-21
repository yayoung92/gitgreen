using Oracle.ManagedDataAccess.Client;
using System;
using System.Windows.Forms;
using System.Collections.Generic;
using static System.Windows.Forms.VisualStyles.VisualStyleElement.ProgressBar;

namespace Mini_bono
{
    public partial class w_insert : Form
    {
        string strConnection = "DATA SOURCE = 192.168.0.110; User Id = bono; Password=bono";

        OracleConnection conn;
        OracleCommand cmd;

        public w_insert()
        {
            InitializeComponent();

            IndexComboBox(); // 0번째 실행시키는 코드
        }

        // comboBox1 0번째 값으로 보여줘라는 코드
        private void IndexComboBox()
        {
            comboBox1.SelectedIndex = 0; 
        }
        public string selectGoup_no()
        {
            string check = "";
            conn = new OracleConnection(strConnection);
            conn.Open();

            string c = comboBox1.SelectedItem.ToString();
          //  Console.WriteLine(c);

            string sql = $"select group_detail_no from group_detail where group_detail_name='{c}'";
            cmd = new OracleCommand(sql, conn);
            OracleDataReader reader = cmd.ExecuteReader();

            try
            {
                while (reader.Read())
                {
                    check = reader.GetString(0);
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("오류 : " + ex.Message.ToString());
            }

            reader.Close();
            conn.Close();

            return check;
        }

        private void IndexComboBox2()
        {
            string a = selectGoup_no();
            Console.WriteLine(a);
            conn = new OracleConnection(strConnection);
            conn.Open();

            string sql = $"select group_detail_name from group_detail where group_detail_no like '{a}_%' and '{a}' is not null";
            cmd = new OracleCommand(sql, conn);
            OracleDataReader reader = cmd.ExecuteReader();

            try
            {
             //      if (!a.Equals("null")) {
                        List<string> list = new List<string>();

                        while (reader.Read())
                        {
                    
                            list.Add(reader.GetString(0));
                        }
                        //Console.WriteLine(reader["group_detail_name"]);
                        foreach (string s in list)
                            {
                                // Console.WriteLine(s);
       
                                comboBox2.Items.Add(s);
                            } 
            //        }

            }
            catch (Exception ex)
            {
                MessageBox.Show("오류 : " + ex.Message.ToString());
            }

            reader.Close();
            conn.Close();


            //    comboBox2.Items.Add("0");
            //    comboBox2.SelectedIndex = 0;
        }
        public void selectdetailName()
        {

        }
        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            // 정보처리기사 가 클릭되면 카테고리가 5가지 나오고 , SQLD 면 2가지 나와야 한다.
            selectGoup_no();
            IndexComboBox2();
            
        }

        private void comboBox2_SelectedIndexChanged(object sender, EventArgs e)
        {
           // IndexComboBox2();
        }
    }
}
