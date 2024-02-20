using Oracle.ManagedDataAccess.Client;
using System;
using System.Windows.Forms;

namespace Mini_bono
{
    public partial class Wordlist : Form
    {
        string strConnection = "DATA SOURCE = 192.168.0.110; User Id = bono; Password=bono";

        OracleConnection conn;
        OracleCommand cmd;
        public Wordlist()
        {
            InitializeComponent();
            wordlist();
            listView1.SelectedIndexChanged += listView1_SelectedIndexChanged;
        }
        public void wordlist()
        {
            listView1.Items.Clear();

            conn = new OracleConnection(strConnection);
            conn.Open();

            string sql = "select word_no, word, word_mean, insert_date from word";
            cmd = new OracleCommand(sql, conn);
            OracleDataReader reader = cmd.ExecuteReader();
            try
            {
                listView1.View = View.Details;
                listView1.Columns.Add("단어번호", 50, HorizontalAlignment.Left);
                listView1.Columns.Add("단어", 200, HorizontalAlignment.Left);
                listView1.Columns.Add("단어 뜻", 500, HorizontalAlignment.Left);
                listView1.Columns.Add("등록일", 100, HorizontalAlignment.Left);

                while (reader.Read())
                {
                    ListViewItem item = new ListViewItem(reader["word_no"].ToString());
                    item.SubItems.Add(reader["word"].ToString());
                    item.SubItems.Add(reader["word_mean"].ToString());
                    item.SubItems.Add(reader["insert_date"].ToString());

                    listView1.Items.Add(item);
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("오류 : " + ex.Message.ToString());
            }
            reader.Close();
            conn.Close();
        }
        private void listView1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void button4_Click(object sender, EventArgs e)
        {
            Hide();
            new w_insert().Show();
        }
    }
}
