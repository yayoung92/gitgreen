using Oracle.ManagedDataAccess.Client;

namespace WinFormsApp4
{
    public partial class Form1 : Form
    {
        string strConnection = "DATA SOURCE=localhost; User Id=hr; Password=1234";
        OracleConnection conn;
        OracleCommand cmd;

        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            listBox1.Items.Clear();
            conn = new OracleConnection(strConnection);
            conn.Open();
            cmd = new OracleCommand("select * from �л�", conn);
            OracleDataReader reader = cmd.ExecuteReader();
            while (reader.Read())
            {
                listBox1.Items.Add(
                    reader.GetString(0) + "\t" +
                    reader.GetString(1) + "\t" +
                    reader.GetString(2) + "\t" +
                    reader.GetString(3) + "\t" +
                    reader.GetString(4)
                );
                //listBox1.Items.Add(reader.GetString(0));
                //MessageBox.Show(reader["�й�"].ToString());

            }
            reader.Close();
            conn.Close();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            listBox1.Items.Add("���ڿ��Դϴ�.");
        }

        private void button3_Click(object sender, EventArgs e)
        {
            listBox1.Items.Insert(0, "���ڿ��߰�");
        }
    }
}
