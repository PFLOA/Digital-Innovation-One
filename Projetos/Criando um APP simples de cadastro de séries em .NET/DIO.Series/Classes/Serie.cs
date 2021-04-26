using DIO.Series.Interfaces;

namespace DIO.Series.Classes
{
    public class Serie : EntidadeBase
    {
        #region Propriedades Privadas

        ///<summary>
        /// Genero da Série.
        ///</summary>
        public Genero Genero { get; set; }

        ///<summary>
        /// Título da Série.
        ///</summary>
        public string Titulo { get; set; }

        ///<summary>
        /// Descrição da Série
        ///</summary>
        public string Descricao { get; set; }

        ///<summary>
        /// Ano de lançamento
        ///</summary>
        public int Ano { get; set; }

        public bool Excluido { get; set; }

        #endregion

        #region Construtores

        ///<summary>
        /// Constrói um objeto Serie.
        ///</summary>
        public Serie(int id, Genero genero, string titulo, string descricao, int ano)
        {
            this.Id = id;
            this.Genero = genero;
            this.Titulo = titulo;
            this.Descricao = descricao;
            this.Ano = ano;
            this.Excluido = false;
        }

        #endregion

        #region Métodos Privados

        private string formatacao = "\nGenero: {0}\nTitulo: {1}\nDescrição: {2}\nAno: {3}";
        private string formatacaoToFile = "{0};{1};{2};{3};{4}";

        #endregion

        #region Métodos Publicos

        public override string ToString()
        {
            return string.Format(formatacao, this.Genero, this.Titulo, this.Descricao, this.Ano);
        }

        public string ToSaveFile()
        {
            return string.Format(formatacaoToFile, base.Id ,this.Genero, this.Titulo, this.Descricao, this.Ano);
        }

        public string RetornaTitulo()
        {
            return this.Titulo;
        }

        public int RetornaId()
        {
            return base.Id;
        }

        public void Excluir()
        {
            this.Excluido = true;
        }

        #endregion
    }
}