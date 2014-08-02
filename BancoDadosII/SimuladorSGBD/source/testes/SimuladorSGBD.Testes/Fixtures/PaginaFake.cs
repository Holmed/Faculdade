﻿using SimuladorSGBD.Core;

namespace SimuladorSGBD.Testes.Fixtures
{
    public class PaginaFake : IPagina
    {
        public char[] Dados { get; set; }
        public bool Sujo { get; set; }
        public int PinCount { get; set; }
        public int UltimoAcesso { get; set; }
    }
}