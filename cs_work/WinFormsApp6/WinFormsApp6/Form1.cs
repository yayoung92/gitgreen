namespace WinFormsApp6
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            Friend friend = new Friend("ȫ�浿");
        // ����ϴ� ���
            Console.WriteLine(friend);

            label1.Text = friend.ToString();

        }
    }
}
