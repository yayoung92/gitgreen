﻿namespace WinFormsApp7.member
{
    partial class MainForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
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
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            label1 = new Label();
            label2 = new Label();
            userControl11 = new UserControl1();
            userControl21 = new UserControl2();
            button1 = new Button();
            button2 = new Button();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("맑은 고딕", 24F, FontStyle.Bold);
            label1.Location = new Point(30, 9);
            label1.Name = "label1";
            label1.Size = new Size(112, 45);
            label1.TabIndex = 0;
            label1.Text = "label1";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Font = new Font("맑은 고딕", 24F, FontStyle.Bold);
            label2.Location = new Point(30, 67);
            label2.Name = "label2";
            label2.Size = new Size(112, 45);
            label2.TabIndex = 1;
            label2.Text = "label2";
            // 
            // userControl11
            // 
            userControl11.Location = new Point(384, 88);
            userControl11.Name = "userControl11";
            userControl11.Size = new Size(348, 287);
            userControl11.TabIndex = 2;
            // 
            // userControl21
            // 
            userControl21.Location = new Point(384, 77);
            userControl21.Name = "userControl21";
            userControl21.Size = new Size(366, 298);
            userControl21.TabIndex = 3;
            // 
            // button1
            // 
            button1.Location = new Point(113, 182);
            button1.Name = "button1";
            button1.Size = new Size(98, 47);
            button1.TabIndex = 4;
            button1.Text = "button1";
            button1.UseVisualStyleBackColor = true;
            button1.Click += button1_Click;
            // 
            // button2
            // 
            button2.Location = new Point(113, 235);
            button2.Name = "button2";
            button2.Size = new Size(98, 45);
            button2.TabIndex = 5;
            button2.Text = "button2";
            button2.UseVisualStyleBackColor = true;
            button2.Click += button2_Click;
            // 
            // MainForm
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(button2);
            Controls.Add(button1);
            Controls.Add(userControl21);
            Controls.Add(userControl11);
            Controls.Add(label2);
            Controls.Add(label1);
            Name = "MainForm";
            Text = "MainForm";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private Label label2;
        private UserControl1 userControl11;
        private UserControl2 userControl21;
        private Button button1;
        private Button button2;
    }
}