using Oracle.ManagedDataAccess.Client;
using System;
using System.Windows.Forms;
using System.Collections.Generic;
using static System.Windows.Forms.VisualStyles.VisualStyleElement.ProgressBar;
using System.Xml.Linq;

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

            comboBox1.SelectedIndex = 0; // 0번째 실행시키는 코드          
        }
        public string selectGoup_no()  // 정처기, sqld 중에 선택해서 선택 값 리턴하는 콤보박스1
        {
            string check = "";
            conn = new OracleConnection(strConnection);
            conn.Open();

            string c = comboBox1.SelectedItem.ToString();
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

        private void selectComboBox2() // 콤보박스1 의 값에 따라 중분류 과목이 나오는 콤보박스2
        {
            string a = selectGoup_no();
            //   Console.WriteLine(a);
            conn = new OracleConnection(strConnection);
            conn.Open();

            string sql = $"select group_detail_name from group_detail where group_detail_no like '{a}_%' and '{a}' is not null";
            cmd = new OracleCommand(sql, conn);
            OracleDataReader reader = cmd.ExecuteReader();

            try
            {
                List<string> list = new List<string>();

                while (reader.Read())
                {
                    comboBox2.Items.Clear();
                    comboBox2.Items.Add("== 선택하세요 ==");
                    
                    list.Add(reader.GetString(0));                   
                }
                
                foreach (string s in list)
                {         
                    comboBox2.Items.Add(s);
                }              
            }
            catch (Exception ex)
            {
                MessageBox.Show("오류 : " + ex.Message.ToString());
            }

            reader.Close();
            conn.Close();

            comboBox2.SelectedIndex = 0;
            
        }
        public void selectedetailName()
        {
            string word_no = ""; // 정처기, sqld 중 선택
            string word_name = ""; // word_no 에 따른 값 선택

            if (comboBox1.SelectedIndex != 0 & comboBox2.SelectedIndex != 0)
            {
                word_no = comboBox1.SelectedItem.ToString();
                word_name = comboBox2.SelectedItem.ToString();

                //button1.PerformClick();

            }
            Console.WriteLine("정처기 또는 sqld : " + word_no);
            Console.WriteLine("중분류 : " + word_name);

        }
        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)  // 선택값으로 변하는 
        {
            // 정보처리기사 가 클릭되면 카테고리가 5가지 나오고 , SQLD 면 2가지 나와야 한다.
            selectGoup_no();
            selectComboBox2();
        }

        private void comboBox2_SelectedIndexChanged(object sender, EventArgs e)
        {
            selectedetailName();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (comboBox1.SelectedIndex != 0 & comboBox2.SelectedIndex != 0)
            {
                string w_name = textBox1.Text;
                string w_content = textBox2.Text;
                Console.WriteLine("단어명 : " + w_name);
                Console.WriteLine("단어설명 : " + w_content);

            } else
                MessageBox.Show("분류를 선택하세요.");
        }
    }
}
