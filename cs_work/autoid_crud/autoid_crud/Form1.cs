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
        public Form1()
        {
            InitializeComponent();
            this.comboBox1.Items.AddRange(new object[] {"조금 다른 사람"}); // 콤보박스 추가
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
            CRUD.cmd.Parameters.Add(":FirstName", OracleDbType.Varchar2).Value = FirstNameTextBox.Text;
            CRUD.cmd.Parameters.Add(":LastName", OracleDbType.Varchar2).Value = LastNameTextBox.Text;
            CRUD.cmd.Parameters.Add(":Gender", OracleDbType.Varchar2).Value = gender;
            CRUD.cmd.ExecuteNonQuery();

            MessageBox.Show("저장되었습니다.");

            CRUD.con.Close();
        }
    }
}
