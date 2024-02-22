using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace labeladdelbutton
{
    public partial class Form1 : Form
    {
        List<int> ints = new List<int>() {};

        int size = 3;
        public Form1()
        {
            InitializeComponent();

            //this.label2.Font = new System.Drawing.Font("한컴 말랑말랑 Bold", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            Console.WriteLine();

            addButtons();
            setLabelList();
        }

        private void Button_Click1(object sender, EventArgs e)
        {
            MessageBox.Show("함수 연결 또 되나 ?");
        }

        private void Button_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            //MessageBox.Show("Test" + btn.Text);
            int temp = int.Parse(btn.Text);
            ints.Add(temp);

            setLabelList() ;
        }
        #region 버튼 추가하는 함수
        private void addButtons()
        {
            Random ran = new Random();

            for (int i = 0; i < 5; i++)
            {
                string randomstr = ran.Next(100).ToString();
                // 추가 하는 버튼
                Button button = new Button();
                button.Text = randomstr;
                button.Font = new System.Drawing.Font("한컴 말랑말랑 Bold", 14F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
                button.Location = new Point(80 + (i * 100), 230);
                button.AutoSize = true;
                button.Click += Button_Click;
                Controls.Add(button);

                //삭제하는 버튼
                Button button1 = new Button();
                button1.Text = randomstr;
                button1.Font = new System.Drawing.Font("한컴 말랑말랑 Bold", 14F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
                button1.Location = new Point(80 + (i * 100), 330);
                button1.AutoSize = true;
                button1.Click += Button1_Click;
/*                button1.Click += (sender, e) =>
                {
                    Button tmp = sender as Button;
                    int itmp = int.Parse(tmp.Text);
                    ints.Remove(itmp);
                    // ints.RemoveAt(0);   / 0번째 요소를 삭제해라. 뭘 누르던 0번째가 삭제되는데 0번째 값이 없어지면 에러 뜬다.
                    setLabelList();
                };*/
                Controls.Add(button1);
            }
        }
        private void Button1_Click(object sender, EventArgs e)
        {
            Button tmp = sender as Button;
            int itmp = int.Parse(tmp.Text);
            ints.Remove(itmp);
            // ints.RemoveAt(0);   / 0번째 요소를 삭제해라. 뭘 누르던 0번째가 삭제되는데 0번째 값이 없어지면 에러 뜬다.
            setLabelList();
        }
        #endregion list 설정하는 함수
        private void setLabelList()
        {
            string result = "";
            for (int i = 0; i < ints.Count; i++)
            {
                if (ints.Count != (i + 1)) // 카운트는 안 들어간 갯숫가 나오는거라 3 이 나오게 된다.
                    result += ints[i] + ", ";
                else
                    result += ints[i];
            }
            label2.Text = result;
        }

        // 폼이 나오는 순간 실행되는 함수
        private void Form1_Load(object sender, EventArgs e)
        {
            //MessageBox.Show("Test");
        }

        private void button1_Click(object sender, EventArgs e)
        {
            MessageBox.Show("추가 버튼 누름");
        }
    }
}
