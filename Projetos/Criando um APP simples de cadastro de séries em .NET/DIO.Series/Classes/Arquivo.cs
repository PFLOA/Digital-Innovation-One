using System;
using System.Collections.Generic;
using System.IO;
using DIO.Series.Interfaces;

namespace DIO.Series.Classes
{
    ///<summary>
    /// Métodos para guardar os dados das séries em um arquivo txt.
    ///</summary>
    public class Arquivo
    {
        public static void SalvarObjetoArquivoCsv(Serie serie)
        {
            using (StreamWriter writer = new StreamWriter("series.csv"))
            {
                writer.WriteLine(serie.ToSaveFile());
            }
        }

        public static List<Serie> RetornarListaDeSeries()
        {
            List<Serie> listaSerie = new List<Serie>();
            string line = "";
            int id = 0;

            using (StreamReader reader = new StreamReader("series.csv"))
            {
                while ((line = reader.ReadLine()) != null)
                {
                    var serie = line.Split(";");
                    listaSerie.Add(new Serie(id, (Genero)Enum.Parse(typeof(Genero), serie[0]), serie[1], serie[2], int.Parse(serie[3])));
                }
            }

            return listaSerie;
        }

        public static void ExluirLinhaArquivo(int id, List<Serie> listaSerie)
        {
            string tempFile = Path.GetTempFileName();
            using (StreamWriter writer = new StreamWriter(tempFile))
            {
                for (int i = 0;i < listaSerie.Count;i++)
                {
                    if (listaSerie[i].RetornaId() != id)
                        writer.WriteLine(listaSerie[i].ToSaveFile());
                }
            }

            File.Delete("series.csv");
            File.Move(tempFile, "series.csv");
        }
    }
}