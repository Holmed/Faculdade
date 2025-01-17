﻿using System.Collections.Generic;
using System.Linq;
using SimuladorSGBD.Core.GerenciamentoBuffer.Buffer.LogicaSubstituicao.PinCount;

namespace SimuladorSGBD.Core.GerenciamentoBuffer.Buffer.LogicaSubstituicao
{
    public class LeastRecentlyUsed : ILogicaSubstituicao, IPinCountChangeObserver
    {
        private readonly Queue<int> quadrosDisponiveisSubstituicao = new Queue<int>(); 
        
        public int Selecionar()
        {
            if (quadrosDisponiveisSubstituicao.Any())
                return quadrosDisponiveisSubstituicao.Dequeue();
            return -1;
        }

        public void NotificarIncrementoPinCount(int indice, int novoPinCount)
        {
        }

        public void NotificarDecrementoPinCount(int indice, int novoPinCount)
        {
            if(novoPinCount == 0)
                quadrosDisponiveisSubstituicao.Enqueue(indice);
        }

        public void NotificarNovoQuadroComPinCountZero(int indice)
        {
            quadrosDisponiveisSubstituicao.Enqueue(indice);
        }
    }
}