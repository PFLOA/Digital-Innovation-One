using System;

namespace DIO.Bank
{
    public class Conta
    {
        // Atributos
        private TipoConta TipoConta { get; set; }
        private double Saldo { get; set; }
        private double Credito { get; set; }
        private string Nome { get; set; }

        /// <summary>
        ///	 Construtor com parâmetros de construção.
        /// </summary>
        /// <param name="tipoConta">Tipo de conta: Fisica ou Juridica.</param>
        /// <param name="saldo">Saldo da conta.</param>
        /// <param name="credito">Credito da conta.</param>
        /// <param name="nome">Nome do cliente.</param>
        public Conta(TipoConta tipoConta, double saldo, double credito, string nome)
        {
            this.TipoConta = tipoConta;
            this.Saldo = saldo;
            this.Credito = credito;
            this.Nome = nome;
        }

		/// <summary>
        ///	 Construtor com parâmetros de construção.
        /// </summary>
        /// <param name="valorSaque">Valor a ser debitado da conta.</param>
        /// <return>Retorna um boolean: True ou False</return>
        public bool Sacar(double valorSaque)
        {
            // Validação de saldo suficiente
            if (this.Saldo - valorSaque < (this.Credito * -1))
            {
                Console.WriteLine("Saldo insuficiente!");
                return false;
            }
            this.Saldo -= valorSaque;

            Console.WriteLine("Saldo atual da conta de {0} é {1}", this.Nome, this.Saldo);
            // https://docs.microsoft.com/pt-br/dotnet/standard/base-types/composite-formatting

            return true;
        }

        /// <summary>
        ///	 Construtor com parâmetros de construção.
        /// </summary>
        /// <param name="valorSaque">Valor a ser debitado da conta.</param>
        public void Depositar(double valorDeposito)
        {
            this.Saldo += valorDeposito;

            Console.WriteLine("Saldo atual da conta de {0} é {1}", this.Nome, this.Saldo);
        }

        /// <summary>
        ///	 Construtor com parâmetros de construção.
        /// </summary>
        /// <param name="valorSaque">Valor a ser debitado da conta.</param>
        public void Transferir(double valorTransferencia, Conta contaDestino)
        {
            if (this.Sacar(valorTransferencia))
            {
                contaDestino.Depositar(valorTransferencia);
            }
        }

		/// <summary>
        ///	 Método ToString para construir a tabela no console.
        /// </summary>
		/// <param name="header">Valor a ser debitado da conta.</param>
		/// <param name="contagem">Valor a ser debitado da conta.</param>
        /// <return>string</return>
        public string ToString(string header, int contagem)
        {
            return string.Format(header, contagem.ToString(),this.TipoConta, this.Nome, this.Saldo.ToString("C2"), this.Credito.ToString("C2"));
        }
    }
}