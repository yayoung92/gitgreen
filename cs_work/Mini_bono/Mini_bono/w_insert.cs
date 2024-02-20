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
    public partial class w_insert : Form
    {
        string strConnection = "DATA SOURCE = 192.168.0.110; User Id = bono; Password=bono";

        OracleConnection conn;
        OracleCommand cmd;

        public w_insert()
        {
            InitializeComponent();
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            // 정보처리기사 가 클릭되면 카테고리가 5가지 나오고 , SQLD 면 2가지 나와야 한다.
            conn = new OracleConnection(strConnection);
            conn.Open();

            string c = comboBox1.SelectedItem.ToString();
            Console.WriteLine(c);

            if (c.Equals("정보처리기사"))
            {

            }
        }
    }
}
