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

namespace MdiProject.todo
{
    public partial class TodoForm : Form
    {
        private static TodoDBManager todoDBManager = new TodoDBManager();
        private static TodoForm instance = null;
        public static TodoForm getInstance()
        {
            if (instance == null || instance.IsDisposed)
            {
                instance = new TodoForm();
                return instance;
            }
            else
            {
                return instance;
            }
        }
        public TodoForm()
        {
            InitializeComponent();
            useridx_comboBox.DataSource = new List<string>()
            {
                "1","2","3","4","5"
            };
            useridx_comboBox.SelectedText = "1";

            Label title_lb = new Label();
            title_lb.Text = "title";
            title_lb.AutoSize = true;
            title_lb.Font = new Font("함초롬돋움", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));

            Panel resevPanel = new Panel();
            resevPanel.BackColor = Color.White;
            resevPanel.Size = new Size(200, 100);
            resevPanel.Location = new Point(20, 70);

            resevPanel.Controls.Add(title_lb);

            panel1.Controls.Add(resevPanel);


        }

        private void button1_Click(object sender, EventArgs e)
        {
            bool result = todoDBManager.insert(new Todo()
            {
                user_idx = int.Parse(useridx_comboBox.Text),
                title = title_tb.Text,
                content = content_tb.Text,
                finishdate = DateTime.Now,
            });
            if (result)
            {
                MessageBox.Show("입력하였습니다.");
                title_tb.Text = "";
                content_tb.Text = "";
            }
             
        }
    }
}
