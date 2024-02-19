using Oracle.ManagedDataAccess.Client;
using System;
using System.Windows.Forms;

namespace Mini_bono
{
    public partial class insert : Form
    {
        string strConnection = "DATA SOURCE = 192.168.0.110; User Id = bono; Password=bono";

        OracleConnection conn;
        OracleCommand cmd;
        public insert()
        {
            InitializeComponent();
            listView1.SelectedIndexChanged += listView1_SelectedIndexChanged;
        }

        private void listView1_SelectedIndexChanged(object sender, EventArgs e)
        {
            listView1.Items.Clear();

            conn = new OracleConnection(strConnection);
            conn.Open();

            string sql = "select word_no, word, word_mean, insert_date from word;";
            cmd = new OracleCommand(sql, conn);
            OracleDataReader reader = cmd.ExecuteReader();
            try
            {
                while (reader.Read())
                {
                    ListViewItem item = new ListViewItem(reader["word_no"].ToString());
                    item.SubItems.Add(reader["word"].ToString());
                    item.SubItems.Add(reader["word_mean"].ToString());
                    item.SubItems.Add(reader["insert_date"].ToString());

                    listView1.Items.Add(item);
                   // Console.WriteLine(item.ToString());
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("오류 : " + ex.Message.ToString());
            }
            reader.Close();
            conn.Close();
        }
    }
}
