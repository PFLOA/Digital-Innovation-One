using System;

namespace DesafiosAritméticosEmCsharp.Desafios
{
    public class crescimento_populacional
    {
        public static void Executar(){

            int t = Convert.ToInt32(Console.ReadLine());
            double[] arrayList = new double[4];
            int pa, pb;
            double cpa, cpb;
            int anos;

            for (int i = 0; i < t; i++)
            {
                anos = 0;
                string[] valores = Console.ReadLine().Split();
                pa = int.Parse(valores[0]);
                pb = int.Parse(valores[1]);

                cpa = double.Parse(valores[2]);
                cpb = double.Parse(valores[3]);

                while (pa <= pb)
                {
                    int taxaA = Convert.ToInt32(pa * cpa);
                    int taxaB = Convert.ToInt32(pb * cpb);
                    
                    pa += taxaA;
                    pb += taxaB;
                    
                    if (anos > 100)
                    {
                       Console.WriteLine("Mais de 1 seculo.");
                       break;
                    }
                    anos++;
                  
                }

                if (anos <= 100)
                {
                  Console.WriteLine($"{anos} anos.");
                }
            }
        }
    }
}