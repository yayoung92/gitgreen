namespace WinFormsApp1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            foreach (Control control in this.Controls) 
            { 
                Console.WriteLine(control);

                if(control is Panel)
                {
                    // 예외 상황이 발생하더라도 종료 안됨.
                    Panel panel = control as Panel;
                    foreach(Control subcontrol in panel.Controls)
                    {
                        subcontrol.Text = "글자바꾸기";
                    }
                }
                control.Text = "글자바꾸기";
                control.Font = new Font("한컴 말랑말랑 Bold", 15.2499962F, FontStyle.Bold, GraphicsUnit.Point, 129);
               if(control is Button)
                {
                    Button button = control as Button;
                    control.AutoSize = true;
                }
            }
        }
    }
}
