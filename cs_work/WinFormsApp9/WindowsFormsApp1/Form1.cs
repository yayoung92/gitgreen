﻿using Oracle.ManagedDataAccess.Client;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Net.Mime.MediaTypeNames;

namespace WindowsFormsApp1
{
    class AA
    {
        public string Name { get; set; }
        public double Cnt { get; set; }
    }

    public partial class Form1 : Form
    {
        List<AA> AAList = new List<AA>();
        string strConnection = "DATA SOURCE=localhost; User Id=hr; Password=1234";
        public Form1()
        {
            InitializeComponent(); // 화면 그리는 함수
            select();
            MakeLabels();
        }
        public void MakeLabels()
        {
            int y = 10;
            foreach (AA aa in AAList)
            {
                Label label1 = new Label();
                label1.AutoSize = true;
                label1.Location = new Point(10, y);
                label1.TabIndex = 0;
                label1.Text = aa.Name;
                label1.Font = new Font("한컴 말랑말랑 Bold", 15.2499962F, FontStyle.Bold, GraphicsUnit.Point, 129);
                Controls.Add(label1);

                Label label2 = new Label();
                label2.AutoSize = true;
                label2.Location = new Point(100, y);
                label2.TabIndex = 0;
                label2.Text = aa.Cnt + "";
                label2.Font = new Font("한컴 말랑말랑 Bold", 15.2499962F, FontStyle.Bold, GraphicsUnit.Point, 129);
                Controls.Add(label2);
                y += 40;

            }
        }
        public void select()
        {
            AAList.Clear(); // list 안에 있는 거 비우기
            OracleConnection conn = new OracleConnection(strConnection);
            conn.Open();
            string sql = "select * from AA";
            OracleCommand cmd = new OracleCommand(sql, conn);
            OracleDataReader rdr = cmd.ExecuteReader();

            while (rdr.Read())
            {
                AAList.Add(new AA() { Name = rdr.GetString(0), Cnt = rdr.GetDouble(1) });
            }
            rdr.Close();
            conn.Close();
        }
    }
}
