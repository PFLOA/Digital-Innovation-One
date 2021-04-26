using System;

namespace DesafiosAritméticosEmCsharp.Desafios
{
    public class crescimento_populacional
    {
        public static void Executar()
        {
            int t = Convert.ToInt32(Console.ReadLine());
            double cpa, cpb, pa, pb;
            int anos ;

            for (int i = 0; i < t; i++)
            {
                string[] dados = Console.ReadLine().Split(" ");

                pa = Convert.ToDouble(dados[0]);
                pb = Convert.ToDouble(dados[1]);
                cpa = Convert.ToDouble(dados[2].Replace(".",","))/100;
                cpb = Convert.ToDouble(dados[3].Replace(".",","))/100;

                anos = 0;

                while(pa <= pb){
                    pa += Convert.ToInt32(pa * cpa);
                    pb += Convert.ToInt32(pb * cpb);

                    Console.WriteLine($"anos {anos} :{pa}   {pb}");
                    anos++;

                    if(anos > 100){
                        Console.WriteLine("Mais de 1 seculo.");
                        break;
                    }
                }

                Console.WriteLine($"{pa}   {pb}");
                
                if(anos <= 100){
                    Console.WriteLine($"{anos} anos.");
                }

            }
        }
    }
}