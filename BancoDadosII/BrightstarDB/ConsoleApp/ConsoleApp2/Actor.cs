﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApp2
{
    public partial class Actor
    {
        public void GetOlder(int years)
        {
            DateOfBirth = DateOfBirth.AddYears(-years);
        }
    }
}
