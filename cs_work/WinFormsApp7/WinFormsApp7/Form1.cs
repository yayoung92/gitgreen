using WinFormsApp7.aaa;

namespace WinFormsApp7
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Hide();
            MessageBox.Show("form2");
            Form2 frm2 = new Form2();
            frm2.Show();
       //     new Form2().Show();
            Show();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Hide();
            MessageBox.Show("form3");
            new Form3().ShowDialog();
            Show();
        }
    }
}
