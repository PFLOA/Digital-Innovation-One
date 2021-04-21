using System;
using System.Collections.Generic;

namespace DIO.Bank
{
    public class ContaService
    {
        #region Atributos Privados

        /// <summary>
        ///  Cabeçalho da tabela de clientes.
        /// </summary>
        private static string Header = "# {0, -5} {1, -15} {2, -40}{3, -20}  {4, -20}";

        #endregion

        #region Métodos Publicos

        /// <summary>
        ///  Construtor do cabeçalho
        /// </summary>
        public static void WriteHeader()
        {
            Console.WriteLine(string.Format(Header, "Nr", "Tipo de Conta", "Nome do Cliente", "Saldo da Conta", "Crédito"));
        }

        /// <summary>
        ///  Cabeçalho da tabela de clientes.
        /// </summary>
        /// <param name="conta">Conta</param>
        /// <param name="contagem">Contagem das linhas.</param>
        public static void WriteLine(Conta conta, int contagem)
        {
            Console.WriteLine(conta.ToString(Header, contagem));
        }

        #endregion
    }
}