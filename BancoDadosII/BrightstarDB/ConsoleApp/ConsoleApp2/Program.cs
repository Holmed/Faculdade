﻿using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp2
{
    class Program
    {
        static void Main(string[] args)
        {
            const string connectionString = "type=embedded;storesdirectory=.\\;storename=Films";
            var context = new MyEntityContext(connectionString);

            LimparABase(context);
                        
            var bladeRunner = context.Films.Create();
            bladeRunner.Name = "Blade Runner";

            var starWars = context.Films.Create();
            starWars.Name = "StarWars";

            context.Films.Add(new Film
            { 
                Name = "Jurassic Park" 
            });

            var ford = context.Actors.Create();
            ford.Name = "Harrison Ford";
            ford.DateOfBirth = new DateTime(1942, 7, 13);
            ford.Films.Add(starWars);
            ford.Films.Add(bladeRunner);

            var hamill = context.Actors.Create();
            hamill.Name = "Mark Hamill";
            hamill.DateOfBirth = new DateTime(1951, 9, 25);
            hamill.Films.Add(starWars);

            context.SaveChanges();

            //não é obrigatório criar um novo contexto
            context = new MyEntityContext(connectionString);

            TesteDesempenhoQuery(context);

            var atorEncontrado = context.Actors.First(ator => ator.Name.Contains("Ford"));
            Console.WriteLine(atorEncontrado.Name);
            Console.WriteLine(atorEncontrado.DateOfBirth);
            atorEncontrado.GetOlder(years: 10);
            context.SaveChanges();

            atorEncontrado = context.Actors.First(ator => ator.Name.Contains("Ford"));
            Console.WriteLine(atorEncontrado.Name);
            Console.WriteLine(atorEncontrado.DateOfBirth);

            var filmeEncontrado = context.Films.First(filme => filme.Name.Contains("Star"));
            Console.WriteLine(filmeEncontrado.Name);
            
            foreach (var filme in context.Films)
            {
                Console.WriteLine();
                Console.WriteLine("Atores em {0}", filme.Name);
                ImprimirAtoresDoFilme(filme);
            }

            Console.ReadLine();
        }

        private static void ImprimirAtoresDoFilme(IFilm filme)
        {
            foreach (var ator in filme.Actors)
            {
                Console.WriteLine("Ator: {0} ({1})", ator.Name, ator.Id);
            }
        }

        private static void LimparABase(MyEntityContext context)
        {
            foreach(var ator in context.Actors)
                context.DeleteObject(ator);

            foreach (var filme in context.Films)
                context.DeleteObject(filme);
        }

        private static void TesteDesempenhoQuery(MyEntityContext context)
        {
            for (int i = 0; i < 30; i++)
            {
                var watch = Stopwatch.StartNew();
                var atorEncontrado = context.Actors.First(ator => ator.Name.Contains("Ford"));
                watch.Stop();

                Console.WriteLine("{0}ms", watch.ElapsedMilliseconds);
            }

            //var query = "SELECT ?category WHERE { " +
            //"<http://www.brightstardb.com/products/brightstar> <http://brightstardb.com/namespaces/default/name> ?category " +
            //"}";

            ////var query = "SELECT ?category WHERE { " +
            ////"<http://www.brightstardb.com/products/brightstar> <http://www.brightstardb.com/schemas/product/category> ?category " +
            ////"}";

            //<http://brightstardb.com/namespaces/default/name>
            //for (int i = 0; i < 30; i++)
            //{
                
            //}
        }
    }
}
