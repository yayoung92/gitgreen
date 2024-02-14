using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WinFormsApp6
{
    // Object 생략되어있음.
    public class Friend : Object
    {
        private String name;
        public Friend(String name)
        {
            this.name = name;
        }

        public String getName()
        {
            return name;
        }
        public override string ToString()
        {
            //return "Friend { name = " + name;
            return $"Friend name = {name}";
        }
    }
}
