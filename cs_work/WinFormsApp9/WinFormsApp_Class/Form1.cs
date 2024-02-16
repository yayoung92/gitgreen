using System.Windows.Forms;

namespace WinFormsApp_Class
{
    public partial class Form1 : Form
    {
        int y = 10;

        List<Car> list = new List<Car>();

        public Form1()
        {
            InitializeComponent();

            MakeLable(10, y, "�ȳ��ϼ���");
            MakeLable(10, y += 40, "������ ������");
            //  MakeLable(10, 90, "�߰���");

            Car car1 = new Car() { Name = "�����ڵ���" };
            Car car2 = new Car() { Name = "�����ڵ���" };

            list.Add(car1);
            list.Add(car2);
        }
        public void MakeLable(int x, int y, string text)
        {
            Label label1 = new Label();
            label1.AutoSize = true;
            label1.Location = new Point(x, y);
            label1.TabIndex = 0;
            label1.Text = text;
            label1.Font = new Font("���� �������� Bold", 15.2499962F, FontStyle.Bold, GraphicsUnit.Point, 129);
            Controls.Add(label1);
        }

        private void button1_Click(object sender, EventArgs e)
        {
            MakeLable(10, y = y + 40, textBox1.Text);
            Console.WriteLine(textBox1.Text);
            textBox1.Text = "";
        }

        private void textBox1_KeyUp(object sender, KeyEventArgs e)
        {
            if(e.KeyCode == Keys.Enter) 
            {
                button1_Click(null, null);
            }
        }
    }
    class Car
    {
        // �̷��� �ϸ� Name �� ���� getter, setter �ڵ����� �������
        public string Name { get; set; }
    }
}
