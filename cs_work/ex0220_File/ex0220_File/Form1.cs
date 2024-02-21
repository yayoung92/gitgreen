using ex0220_File.database;
using ex0220_File.file;
using Oracle.ManagedDataAccess.Client;
using System;
using System.Collections.Generic;
using System.Windows.Forms;

namespace ex0220_File
{
    public partial class Form1 : Form
    {
        FileControl fc = new FileControl();
        FileTBDataBase fted = new FileTBDataBase();

        private string selectstring = "";

        public Form1()
        {
            InitializeComponent();

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
            fted.insert(textBox1.Text); // insert 하는거
            List<string> list = fted.read(); // select 하는거

            listBox1.DataSource = null;
            listBox1.DataSource = list; // 화면내용 다시 보여주기
            textBox1.Text = ""; // 값 넣고 빈 공백으로 바꿔라.
        }

        private void 불러오기(object sender, EventArgs e)
        {
            List<string> list = fted.read();
            listBox1.DataSource = null;
            listBox1.DataSource = list;
        }

        private void 수정하기(object sender, EventArgs e)
        {
            MessageBox.Show("수정");

            if(textBox1.Text == "")
            {
                MessageBox.Show("글자를 입력하세요...");
                return;
            }

            string updateStr = textBox1.Text;

            fted.update(selectstring, updateStr);

            button1.PerformClick();
            textBox1.Text = "";
        }

        private void 삭제하기(object sender, EventArgs e)
        {
            string deleteStr = textBox1.Text;
            fted.delete(deleteStr);

            button1.PerformClick();
            textBox1.Text = "";

            MessageBox.Show("삭제");

        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            Console.WriteLine(listBox1.SelectedIndex);
            Console.WriteLine(listBox1.SelectedItem);

            if(listBox1.SelectedItem != null) 
            { 
                textBox1.Text = listBox1.SelectedItem.ToString();
                selectstring = listBox1.SelectedItem.ToString();
               // MessageBox.Show("글자 수정하고 싶은거 바꿨네 : " + selectstring);
            }
        }
    }
}
