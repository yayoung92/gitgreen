using System.Drawing.Text;

namespace WinFormsApp9
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            foreach (var con in Controls)
            {
                if (con is Panel)
                {
                    Panel temp = con as Panel;
                    foreach (var subcon in temp.Controls)
                    {
                        if (subcon is Label)
                        {
                            Label temp1 = subcon as Label;
                            temp1.Font = new Font(FontLibrary.Families[0], 15);
                        }
                    }
                }
                Console.WriteLine(con);
                if (con is Label)
                {
                    Label temp = con as Label;
                    temp.Font = new Font(FontLibrary.Families[0], 15);
                }
            }
        }
    }
}
