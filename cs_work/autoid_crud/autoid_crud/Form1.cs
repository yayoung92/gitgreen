using autoid_crud.db;
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

namespace autoid_crud
{
    public partial class Form1 : Form
    {
        private int autoid = 0;
        public Form1()
        {
            InitializeComponent();
            this.comboBox1.Items.AddRange(new object[] {"조금 다른 사람"}); // 콤보박스 추가
            comboBox1.SelectedIndex = 0;
            dataGridView1.ReadOnly = true;
            dataGridView1.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;
            dataGridView1.AllowUserToAddRows = false; // 새로운 행 넣지 않겠다

            select();           

        }

        private void cleanControl()
        {
            FirstNameTextBox.Text = string.Empty;
            LastNameTextBox.Text = string.Empty;
            button2.Text = "UPDATE";
            button3.Text = "DELETE";
        }

        private void select(string searchText="")  // 안보내면 빈공백이다., 보내면 보내는 값이다.
        {
            CRUD.con.Open();

            OracleDataAdapter oracleDataAdapter = new OracleDataAdapter();
            /*            string sql = $"select * from tb_smart_crud where firstname like '%{searchText.Text}%' or " +
                            $"lastname like '%{searchText.Text}%' or " +
                            $"gender like '%{searchText.Text}%'" +
                            $"order by autoid desc";*/

            string sql = "select * from tb_smart_crud where concat(firstname, lastname) like :searchText order by autoid desc";
            string search = $"%{searchText}%";

            OracleCommand oracleCommand = new OracleCommand(sql, CRUD.con);
            oracleCommand.Parameters.Add(":searchText", search);
            oracleDataAdapter.SelectCommand = oracleCommand;

            DataSet dataSet = new DataSet();
            oracleDataAdapter.Fill(dataSet);

            dataGridView1.DataSource = dataSet.Tables[0];

            CRUD.con.Close();
            cleanControl();

            // 없으면 행 선택 한것처럼 보여도 선택 된 것이 아님.
            if (dataGridView1.Rows.Count > 0)
            {
                this.autoid = int.Parse(dataGridView1.Rows[0].Cells[0].Value.ToString());
            }
        }

        private void insert(object sender, EventArgs e)  // insert 버튼을 누르면 텍스트박스 trim(값의 양쪽의 빈공백 없애기) 한다
        {
            if(string.IsNullOrEmpty(FirstNameTextBox.Text.Trim())
                || string.IsNullOrEmpty(LastNameTextBox.Text.Trim()))
            {
                MessageBox.Show("이름을 입력하세요","경고", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
            string gender = "";
            if(comboBox1.SelectedItem != null )
            {
                gender = comboBox1.SelectedItem.ToString();
            }

            CRUD.con.Open();
            CRUD.sql = "INSERT INTO TB_SMART_CRUD (AUTOID, FIRSTNAME, LASTNAME, GENDER) " +
                "VALUES(TB_SMART_SEQ.NEXTVAL, :FirstName, :LastName, :Gender)";

/*            CRUD.sql = $"INSERT INTO TB_SMART_CRUD " +
                $"VALUES(TB_SMART_SEQ.NEXTVAL, " +
                $"'{FirstNameTextBox.Text}', " +
                $"'{LastNameTextBox.Text}', " +
                $"'{gender}')";*/
            CRUD.cmd = new OracleCommand(CRUD.sql, CRUD.con);
            CRUD.cmd.Parameters.Add(":FirstName", FirstNameTextBox.Text);
            CRUD.cmd.Parameters.Add(":LastName", LastNameTextBox.Text);
            CRUD.cmd.Parameters.Add(":Gender", gender);
            CRUD.cmd.ExecuteNonQuery();
            CRUD.con.Close();

            MessageBox.Show("저장되었습니다.");
            select();            
        }

        private void button4_Click(object sender, EventArgs e)
        {
            if(searchText.Text.Equals(""))
                select();
            else
                select(searchText.Text);
        }

        private void dataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            this.autoid = int.Parse(dataGridView1.CurrentRow.Cells[0].Value.ToString());

            string firstName = dataGridView1.CurrentRow.Cells[1].Value.ToString();
            string lastName = dataGridView1.CurrentRow.Cells[2].Value.ToString();
            string gender = dataGridView1.CurrentRow.Cells[3].Value.ToString();

            FirstNameTextBox.Text = firstName;
            LastNameTextBox.Text = lastName;
            comboBox1.SelectedItem = gender;

            button2.Text = $"update ({autoid})";
            button3.Text = $"delete ({autoid})";

        }
        #region update 버튼 누름
        private void button2_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(FirstNameTextBox.Text.Trim())
                || string.IsNullOrEmpty(LastNameTextBox.Text.Trim()))
            {
                MessageBox.Show("이름을 입력하세요", "경고", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
            string gender = "";
            if (comboBox1.SelectedItem != null)
            {
                gender = comboBox1.SelectedItem.ToString();
            }

            CRUD.con.Open();
            CRUD.sql = $"update tb_smart_crud"+
                            " set firstname = :FirstName, " +
                            "lastname = :LastName, " +
                            "gender = :Gender" +
                            " where autoid = :Autoid";

            CRUD.cmd = new OracleCommand(CRUD.sql, CRUD.con);
            CRUD.cmd.Parameters.Add(":FirstName", FirstNameTextBox.Text);
            CRUD.cmd.Parameters.Add(":LastName", LastNameTextBox.Text);
            CRUD.cmd.Parameters.Add(":Gender", gender);
            CRUD.cmd.Parameters.Add(":Autoid", this.autoid);

            CRUD.cmd.ExecuteNonQuery();
            CRUD.con.Close();

            MessageBox.Show("수정되었습니다.");
            select();
        }
        #endregion

        #region delete 버튼 누름
        private void button3_Click(object sender, EventArgs e)
        {
            if (autoid == 0)
            {
                MessageBox.Show("삭제하는 행을 선택해주세요");
                return;
            }

            CRUD.sql = $"delete tb_smart_crud where autoid = :Autoid";

            CRUD.con.Open();
            CRUD.cmd = new OracleCommand(CRUD.sql, CRUD.con);
            CRUD.cmd.Parameters.Clear();
            CRUD.cmd.Parameters.Add(":Autoid", this.autoid);

            CRUD.cmd.ExecuteNonQuery();
            CRUD.con.Close();

            MessageBox.Show("삭제되었습니다.");
            select();
        }
        #endregion
    }
}
