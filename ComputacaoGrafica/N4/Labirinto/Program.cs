﻿
namespace JogoLabirinto
{
    /// <summary>
    /// Instruções para fazer o freeglut funcioncar: http://choorucode.com/2013/04/28/how-to-install-freeglut-for-visual-studio-2012/
    /// </summary>
    class Program
    {
        public static void Main(string[] args)
        {
            var n4 = new Jogo();
            n4.Run(120, 60);
        }
    }
}
