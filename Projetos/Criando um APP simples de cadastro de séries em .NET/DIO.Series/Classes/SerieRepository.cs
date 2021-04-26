using System;
using System.Collections.Generic;
using DIO.Series.Interfaces;

namespace DIO.Series.Classes
{
    public class SerieRepository : IRepositorio<Serie>
    {
        private List<Serie> ListaSeries = new List<Serie>();

        public SerieRepository()
        {
            ListaSeries = Arquivo.RetornarListaDeSeries();
        }

        public List<Serie> Lista()
        {
            return this.ListaSeries;
        }

        public Serie RetornaPorId(int id)
        {
            return this.ListaSeries[id];
        }
    
        ///<summary>
        /// Adiciona uma nova serie.
        ///</summary>
        ///<param name="entidade">Entidade Serie a ser inserida.</param>
        public void Insere(Serie entidade)
        {
            this.ListaSeries.Add(entidade);
            Arquivo.SalvarObjetoArquivoCsv(entidade);
        }

        public void Excluir(int id)
        {
            try
            {
                this.ListaSeries[id].Excluir();
                Arquivo.ExluirLinhaArquivo(id, this.ListaSeries);        
            }
            catch (System.ArgumentOutOfRangeException)
            {
                 Console.ForegroundColor = ConsoleColor.Red;
                 Console.WriteLine("ID {0} Inexistente", id);

                 Console.ForegroundColor = ConsoleColor.Green;
            }
        }

        public void Atualizar(int id, Serie entidade)
        {
            this.ListaSeries[id] = entidade;
        }

        public int ProximoId()
        {
            return this.ListaSeries[ListaSeries.Count - 1].RetornaId() + 1;
        }
    }
}