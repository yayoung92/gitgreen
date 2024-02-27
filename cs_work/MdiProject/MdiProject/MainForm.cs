using MdiProject.todo;
using MdiProject.user;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace MdiProject
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
            this.IsMdiContainer = true;
        }
        private void 사용자관리ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            UserForm userForm = UserForm.getInstance();
            userForm.MdiParent = this;
            userForm.Show();
        }
        private void 할일관리ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            TodoForm todoForm = TodoForm.getInstance();
            todoForm.MdiParent = this;
            todoForm.Show();
        }

        private void 종료ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Dispose(); // 창 닫기 = 종료
        }

    }
}
