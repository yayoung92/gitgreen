using WinFormsApp7.member;

namespace WinFormsApp7
{
    public partial class Login : Form
    {
        public Login()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Console.WriteLine(textBox1.Text);
            Console.WriteLine(textBox2.Text);

            if(
                textBox1.Text == "admin" && textBox2.Text == "1234"
               )
            {
                MessageBox.Show("로그인성공");
                Hide();
                MainForm mf = new MainForm(textBox1.Text, textBox2.Text);
                mf.ShowDialog();
                Show();
            }
            else
            {
                MessageBox.Show("아이디와 비밀번호 확인하세요.");
            }
        }
    }
}
