using ex0220_File.database;
using ex0220_File.file;
using System;
using System.Collections.Generic;
using System.Windows.Forms;

namespace ex0220_File
{
    public partial class Form1 : Form
    {
        FileControl fc = new FileControl();
        FileTBDataBase fted = new FileTBDataBase();

        List<string> list = new List<string>();

        public Form1()
        {
            InitializeComponent();

            //List<string> list = fc.read();
            List<string> list = fted.read();
            listBox1.DataSource = null;
            listBox1.DataSource = list;
        }

        private void 파일쓰기(object sender, EventArgs e)
        {
            if (textBox1.Text == "")
            {
                MessageBox.Show("글자를 입력하세요");
                return;
            }
            
            // 파일에 list 저장
            //fc.write(textBox1.Text, list);

            // list 객체 안에 글자 담기
            //list.Add(textBox1.Text);

            // db 에 저장하기
            fted.insert(textBox1.Text);
            List<string> list = fted.read();

            listBox1.DataSource = null;
            listBox1.DataSource = list;
            textBox1.Text = ""; // 값 넣고 빈 공백으로 바꿔라.
        }

        private void 불러오기(object sender, EventArgs e)
        {
            List<string> list = fc.read();
            listBox1.DataSource = null;
            listBox1.DataSource = list;
        }
    }
}
