using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinFormsApp_Class
{
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
            Label label1 = new Label();
            label1.AutoSize = true;
            label1.Location = new Point(10, 20);
            label1.TabIndex = 0;
            label1.Text = "집 가자";
            label1.Font = new Font("한컴 말랑말랑 Bold", 15.2499962F, FontStyle.Bold, GraphicsUnit.Point, 129);
            Controls.Add(label1);
        }
    }
}
