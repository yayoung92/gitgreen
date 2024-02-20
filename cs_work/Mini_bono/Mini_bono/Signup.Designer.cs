using System.Data;

namespace Mini_bono
{
    partial class Form1
    {
        /// <summary>
        /// 필수 디자이너 변수입니다.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 사용 중인 모든 리소스를 정리합니다.
        /// </summary>
        /// <param name="disposing">관리되는 리소스를 삭제해야 하면 true이고, 그렇지 않으면 false입니다.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form 디자이너에서 생성한 코드

        /// <summary>
        /// 디자이너 지원에 필요한 메서드입니다. 
        /// 이 메서드의 내용을 코드 편집기로 수정하지 마세요.
        /// </summary>
        private void InitializeComponent()
        {
            this.id = new System.Windows.Forms.TextBox();
            this.pw = new System.Windows.Forms.TextBox();
            this.name = new System.Windows.Forms.TextBox();
            this.signup = new System.Windows.Forms.Button();
            this.check = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // id
            // 
            this.id.Location = new System.Drawing.Point(312, 156);
            this.id.Name = "id";
            this.id.Size = new System.Drawing.Size(164, 21);
            this.id.TabIndex = 0;
            this.id.TextChanged += new System.EventHandler(this.id_TextChanged);
            // 
            // pw
            // 
            this.pw.Location = new System.Drawing.Point(312, 204);
            this.pw.Name = "pw";
            this.pw.Size = new System.Drawing.Size(164, 21);
            this.pw.TabIndex = 1;
            this.pw.TextChanged += new System.EventHandler(this.pw_TextChanged);
            // 
            // name
            // 
            this.name.Location = new System.Drawing.Point(312, 244);
            this.name.Name = "name";
            this.name.Size = new System.Drawing.Size(164, 21);
            this.name.TabIndex = 2;
            this.name.TextChanged += new System.EventHandler(this.name_TextChanged);
            // 
            // signup
            // 
            this.signup.Location = new System.Drawing.Point(348, 280);
            this.signup.Name = "signup";
            this.signup.Size = new System.Drawing.Size(96, 28);
            this.signup.TabIndex = 3;
            this.signup.Text = "회원가입";
            this.signup.UseVisualStyleBackColor = true;
            this.signup.Click += new System.EventHandler(this.signup_Click);
            // 
            // check
            // 
            this.check.Location = new System.Drawing.Point(500, 156);
            this.check.Name = "check";
            this.check.Size = new System.Drawing.Size(102, 23);
            this.check.TabIndex = 4;
            this.check.Text = "아이디중복확인";
            this.check.UseVisualStyleBackColor = true;
            this.check.Click += new System.EventHandler(this.check_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("굴림", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.label1.Location = new System.Drawing.Point(223, 156);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(69, 19);
            this.label1.TabIndex = 5;
            this.label1.Text = "아이디";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("굴림", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.label2.Location = new System.Drawing.Point(223, 204);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(89, 19);
            this.label2.TabIndex = 6;
            this.label2.Text = "비밀번호";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("굴림", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.label3.Location = new System.Drawing.Point(223, 244);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(49, 19);
            this.label3.TabIndex = 7;
            this.label3.Text = "이름";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.check);
            this.Controls.Add(this.signup);
            this.Controls.Add(this.name);
            this.Controls.Add(this.pw);
            this.Controls.Add(this.id);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox id;
        private System.Windows.Forms.TextBox pw;
        private System.Windows.Forms.TextBox name;
        private System.Windows.Forms.Button signup;
        private System.Windows.Forms.Button check;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;

    }
}

