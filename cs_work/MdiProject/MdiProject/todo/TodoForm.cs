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

            /*            Label title_lb = new Label();
                        title_lb.Text = "title";
                        title_lb.AutoSize = true;
                        title_lb.Font = new Font("함초롬돋움", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));

                        Panel resevPanel = new Panel();
                        resevPanel.BackColor = Color.White;
                        resevPanel.Size = new Size(200, 100);
                        resevPanel.Location = new Point(20, 70);

                        resevPanel.Controls.Add(title_lb);

                        panel1.Controls.Add(resevPanel);*/

            DataTable dataTable = todoDBManager.select();

            int y = 66;
            int evenOdd = 1;

            foreach (DataRow row in dataTable.Rows)
            {

                int idx = int.Parse(row["idx"].ToString());
                string title = row["title"].ToString();
                string content = row["content"].ToString();
                DateTime finishdate = new DateTime(
                        int.Parse(row["finishdate"].ToString().Split('-', ' ')[0]),
                        int.Parse(row["finishdate"].ToString().Split('-', ' ')[1]),
                        int.Parse(row["finishdate"].ToString().Split('-', ' ')[2]));

                Todo todo = new Todo();
                todo.idx = idx;
                todo.title = title;
                todo.content = content;
                todo.finishdate = finishdate;

                makeTodoPanel(12, y, todo, evenOdd%2);
                evenOdd += 1;
                y += 200;
            }
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
        private void makeTodoPanel(int x, int y, Todo todo, int evenOdd)
        {
            #region Panel 화면 구현

            Label finish_lb = new Label();
            Label content_lb = new Label();
            Label title_lb = new Label();
            Label finish_lb_value = new Label();
            Label title_lb_value = new Label();
            CheckBox check_lb = new CheckBox();
            Label content_lb_value = new Label();

            // check_lb
            check_lb.AutoSize = true;
            check_lb.Location = new Point(137, 135);
            check_lb.Name = "check_lb";
            check_lb.Size = new Size(48, 16);
            check_lb.TabIndex = 6;
            check_lb.Text = "완료";
            check_lb.UseVisualStyleBackColor = true;

            // finish_lb_value
            finish_lb_value.AutoSize = true;
            finish_lb_value.Font = new Font("함초롬돋움", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            finish_lb_value.Location = new Point(12, 117);
            finish_lb_value.Name = "finish_lb_value";
            finish_lb_value.Size = new Size(91, 21);
            finish_lb_value.TabIndex = 5;
            finish_lb_value.Text = todo.finishdate.ToString("yyyy/MM/dd");

            // content_lb_value
            content_lb_value.AutoSize = true;
            content_lb_value.Font = new Font("함초롬돋움", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            content_lb_value.Location = new Point(12, 59);
            content_lb_value.Name = "content_lb_value";
            content_lb_value.Size = new Size(70, 21);
            content_lb_value.TabIndex = 4;
            content_lb_value.Text = todo.content;

            // title_lb_value
            title_lb_value.AutoSize = true;
            title_lb_value.Font = new Font("함초롬돋움", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            title_lb_value.Location = new Point(65, 6);
            title_lb_value.Name = "title_lb_value";
            title_lb_value.Size = new Size(42, 21);
            title_lb_value.TabIndex = 3;
            title_lb_value.Text = todo.title;

            // finish_lb
            finish_lb.AutoSize = true;
            finish_lb.Font = new Font("함초롬돋움", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            finish_lb.Location = new Point(12, 96);
            finish_lb.Name = "finish_lb";
            finish_lb.Size = new Size(91, 21);
            finish_lb.TabIndex = 2;
            finish_lb.Text = "FinishDate";

            // content_lb
            content_lb.AutoSize = true;
            content_lb.Font = new Font("함초롬돋움", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            content_lb.Location = new Point(12, 38);
            content_lb.Name = "content_lb";
            content_lb.Size = new Size(70, 21);
            content_lb.TabIndex = 1;
            content_lb.Text = "Content";

            // title_lb
            title_lb.AutoSize = true;
            title_lb.Font = new Font("함초롬돋움", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            title_lb.Location = new Point(12, 6);
            title_lb.Name = "title_lb";
            title_lb.Size = new Size(42, 21);
            title_lb.TabIndex = 0;
            title_lb.Text = "Title";

            // panel4
            Panel panel4 = new Panel();
            if(evenOdd%2 ==0)
                panel4.BackColor = Color.FromArgb(((int)(((byte)(192)))), ((int)(((byte)(192)))), ((int)(((byte)(255)))));
            else
                panel4.BackColor = Color.FromArgb(((int)(((byte)(152)))), ((int)(((byte)(192)))), ((int)(((byte)(255)))));
            panel4.Controls.Add(check_lb);
            panel4.Controls.Add(finish_lb_value);
            panel4.Controls.Add(content_lb_value);
            panel4.Controls.Add(title_lb_value);
            panel4.Controls.Add(finish_lb);
            panel4.Controls.Add(content_lb);
            panel4.Controls.Add(title_lb);
            panel4.Location = new Point(x, y);
            panel4.Name = "panel4";
            panel4.Size = new Size(218, 165);
            panel4.TabIndex = 1;
            panel4.ResumeLayout(false);
            panel4.PerformLayout();

            this.panel1.Controls.Add(panel4);
            #endregion
        }
    }
}
