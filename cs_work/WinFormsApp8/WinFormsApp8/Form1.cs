using NAudio.Wave;

namespace WinFormsApp8
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            KeyPreview = true;
            timer1.Enabled = true;
        }

        private void Form1_KeyDown(object sender, KeyEventArgs e)
        {
            Console.WriteLine("����" + e.KeyCode);
            if (e.KeyCode == Keys.Q)
            {
                panel1.Visible = false;
                WaveOutEvent woe = new WaveOutEvent();
                woe.Init(new AudioFileReader(@"D:\Students\cs_work\WinFormsApp8\WinFormsApp8\do\������.mp3"));
                woe.Play();
            }
        }

        private void Form1_KeyUp(object sender, KeyEventArgs e)
        {
            Console.WriteLine("����" + e.KeyCode);
            panel1.Visible = true;
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            label1.Text = DateTime.Now.ToString();
        }
    }
}
