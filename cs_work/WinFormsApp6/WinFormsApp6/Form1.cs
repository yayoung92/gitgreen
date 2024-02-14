namespace WinFormsApp6
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            Friend friend = new Friend("홍길동");
        // 출력하는 방식
            Console.WriteLine(friend);

            label1.Text = friend.ToString();

        }
    }
}
