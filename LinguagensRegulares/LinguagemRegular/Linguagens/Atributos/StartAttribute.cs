﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Analisador.Linguagens.Atributos
{
    [AttributeUsage(AttributeTargets.Method, Inherited = false, AllowMultiple = true)]
    public sealed class StartAttribute : Attribute
    {
        public StartAttribute() { }
    }
}
