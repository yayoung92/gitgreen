namespace WinFormsApp3
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            button1 = new Button();
            label1 = new Label();
            tv = new TextBox();
            button2 = new Button();
            button3 = new Button();
            button4 = new Button();
            button5 = new Button();
            tv_num1 = new TextBox();
            tv_num2 = new TextBox();
            label2 = new Label();
            label3 = new Label();
            label4 = new Label();
            lb_result = new Label();
            SuspendLayout();
            // 
            // button1
            // 
            button1.Location = new Point(311, 113);
            button1.Name = "button1";
            button1.Size = new Size(102, 30);
            button1.TabIndex = 0;
            button1.Text = "button1";
            button1.UseVisualStyleBackColor = true;
            button1.Click += button1_Click;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(96, 128);
            label1.Name = "label1";
            label1.Size = new Size(39, 15);
            label1.TabIndex = 1;
            label1.Text = "label1";
            // 
            // tv
            // 
            tv.Location = new Point(153, 120);
            tv.Name = "tv";
            tv.Size = new Size(100, 23);
            tv.TabIndex = 2;
            // 
            // button2
            // 
            button2.Font = new Font("한컴 말랑말랑 Bold", 11.2499981F, FontStyle.Bold);
            button2.Location = new Point(606, 210);
            button2.Name = "button2";
            button2.Size = new Size(102, 30);
            button2.TabIndex = 3;
            button2.Text = "더하기";
            button2.UseVisualStyleBackColor = true;
            button2.Click += button2_Click;
            // 
            // button3
            // 
            button3.Font = new Font("한컴 말랑말랑 Bold", 11.2499981F, FontStyle.Bold);
            button3.Location = new Point(606, 246);
            button3.Name = "button3";
            button3.Size = new Size(102, 30);
            button3.TabIndex = 4;
            button3.Text = "빼기";
            button3.UseVisualStyleBackColor = true;
            button3.Click += button3_Click;
            // 
            // button4
            // 
            button4.Font = new Font("한컴 말랑말랑 Bold", 11.2499981F, FontStyle.Bold);
            button4.Location = new Point(606, 287);
            button4.Name = "button4";
            button4.Size = new Size(102, 30);
            button4.TabIndex = 5;
            button4.Text = "나누기";
            button4.UseVisualStyleBackColor = true;
            button4.Click += button4_Click;
            // 
            // button5
            // 
            button5.Font = new Font("한컴 말랑말랑 Bold", 11.2499981F, FontStyle.Bold);
            button5.Location = new Point(606, 323);
            button5.Name = "button5";
            button5.Size = new Size(102, 30);
            button5.TabIndex = 6;
            button5.Text = "곱하기";
            button5.UseVisualStyleBackColor = true;
            button5.Click += button5_Click;
            // 
            // tv_num1
            // 
            tv_num1.Font = new Font("한컴 말랑말랑 Regular", 12F);
            tv_num1.Location = new Point(447, 246);
            tv_num1.Name = "tv_num1";
            tv_num1.Size = new Size(100, 28);
            tv_num1.TabIndex = 7;
            // 
            // tv_num2
            // 
            tv_num2.Font = new Font("한컴 말랑말랑 Regular", 12F);
            tv_num2.Location = new Point(447, 275);
            tv_num2.Name = "tv_num2";
            tv_num2.Size = new Size(100, 28);
            tv_num2.TabIndex = 8;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Font = new Font("한컴 말랑말랑 Bold", 12F, FontStyle.Bold);
            label2.Location = new Point(374, 243);
            label2.Name = "label2";
            label2.Size = new Size(67, 21);
            label2.TabIndex = 9;
            label2.Text = "첫번째수";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Font = new Font("한컴 말랑말랑 Bold", 12F, FontStyle.Bold);
            label3.Location = new Point(374, 280);
            label3.Name = "label3";
            label3.Size = new Size(65, 21);
            label3.TabIndex = 10;
            label3.Text = "두번째수";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Font = new Font("한컴 말랑말랑 Bold", 12F, FontStyle.Bold);
            label4.Location = new Point(376, 332);
            label4.Name = "label4";
            label4.Size = new Size(39, 21);
            label4.TabIndex = 11;
            label4.Text = "결과";
            // 
            // lb_result
            // 
            lb_result.AutoSize = true;
            lb_result.Font = new Font("한컴 말랑말랑 Bold", 12F, FontStyle.Bold);
            lb_result.Location = new Point(447, 332);
            lb_result.Name = "lb_result";
            lb_result.Size = new Size(39, 21);
            lb_result.TabIndex = 12;
            lb_result.Text = "결과";
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(lb_result);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(tv_num2);
            Controls.Add(tv_num1);
            Controls.Add(button5);
            Controls.Add(button4);
            Controls.Add(button3);
            Controls.Add(button2);
            Controls.Add(tv);
            Controls.Add(label1);
            Controls.Add(button1);
            Name = "Form1";
            Text = "Form1";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Button button1;
        private Label label1;
        private TextBox tv;
        private Button button2;
        private Button button3;
        private Button button4;
        private Button button5;
        private TextBox tv_num1;
        private TextBox tv_num2;
        private Label label2;
        private Label label3;
        private Label label4;
        private Label lb_result;
    }
}
