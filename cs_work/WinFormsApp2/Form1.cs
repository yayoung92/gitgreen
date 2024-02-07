using Oracle.ManagedDataAccess.Client;
using System.Data;

namespace WinFormsApp2
{
    public partial class Form1 : Form
    {
       // string strConnection = "Data Source=(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=localhost)(PORT=1521))(CONNECT_DATA=(SERVICE_NAME=xe)));User Id=hr;Password=1234;";
        string strConnection = "DATA SOURCE=127.0.0.1; User Id=hr; Password=1234";

        OracleConnection conn;
        OracleCommand cmd;

        public Form1()
        {
            InitializeComponent();

            // ctrl + k + c -> 주석처리
            MessageBox.Show(strConnection);

        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            conn = new OracleConnection(strConnection);
            //cmd = new OracleCommand();
            //cmd.Connection = conn;
            conn.Open(); // database 열기

            DataSet dataSet = new DataSet();
            String sql = "select * from emp";

            OracleDataAdapter adapter = new OracleDataAdapter();
            adapter.SelectCommand = new OracleCommand(sql, conn);
            adapter.Fill(dataSet);

            //MessageBox.Show(dataSet.Tables[0].ToString());

            dataGridView1.DataSource = dataSet.Tables[0];
            conn.Close(); // database 닫기
            //MessageBox.Show("Test"+ strConnection);
            
        }

        private void button2_Click(object sender, EventArgs e)
        {

        }
    }
}
