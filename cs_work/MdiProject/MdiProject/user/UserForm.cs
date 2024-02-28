using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace MdiProject.user
{
    public partial class UserForm : Form
    {
        private static UserForm instance = null;
        private UserDBManager userDBManager = new UserDBManager();
        public static UserForm getInstance()
        {
            if(instance == null || instance.IsDisposed)
            {
                instance = new UserForm();
                return instance;
            }
            else
            {
                return instance;
            }
        }
        public UserForm()
        {
            InitializeComponent();
            LoadDate();
        }
        private void LoadDate()
        {
            DataTable dt = userDBManager.select();
            if(dt != null)
            {
                dataGridView1.DataSource = dt;
            }
        }

        // 삽입기능 만들어야 함
        private void insert_Click(object sender, EventArgs e)
        {
            Users users = new Users()
            {
                Name=tbName.Text,
                Addr=tbAddr.Text,
                Email=tbEmail.Text,
                Password=tbPassword.Text
            };          
            bool result = userDBManager.insert(users);
            if (result)
            {
                MessageBox.Show("등록되었습니다.");
                tbPassword.Text = "";
                tbName.Text = "";
                tbAddr.Text = "";
                tbEmail.Text = "";

                LoadDate();
            }
            else
            {
                MessageBox.Show("실패했습니다.");
            }
        }

        // 수정기능 만들어야 함
        private void update_Click(object sender, EventArgs e)
        {

        }

        // 삭제기능 만들어야 함
        private void delete_Click(object sender, EventArgs e)
        {

        }

        // 검색기능 만들어야 함
        private void select_Click(object sender, EventArgs e)
        {
            LoadDate();
        }
    }
}
