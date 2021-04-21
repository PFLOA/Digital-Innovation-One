using System;

namespace DIO.Bank
{
    public class Conta
    {
        #region Propriedades    

        ///<summary>
        /// Define se a conta é de pessoa física ou pessoa jurídica.
        ///</summary>
        private TipoConta TipoConta { get; set; }
        
        ///<summary>
        /// Saldo atual da conta.
        ///</summary>
        private double Saldo { get; set; }

        ///<summary>
        /// Valor do crédito atual da conta.
        ///</summary>
        private double Credito { get; set; }

        ///<summary>
        /// Nome do cliente.
        ///</summary>
        private string Nome { get; set; }

        #endregion

        #region Construtores

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

        #endregion

        #region Métodos Publicos

        /// <summary>
        ///	 Saca valor do saldo.
        /// </summary>
        /// <param name="valorSaque">Valor a ser debitado da conta.</param>
        /// <return>Retorna um boolean: True se o saque foi realizado com sucesso, False caso o saldo seja insuficiente.</return>
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

            return true;
        }

        /// <summary>
        ///	 Deposita valor no saldo.
        /// </summary>
        /// <param name="valorDeposito">Valor a ser creditado da conta.</param>
        public void Depositar(double valorDeposito)
        {
            this.Saldo += valorDeposito;

            Console.WriteLine("Saldo atual da conta de {0} é {1}", this.Nome, this.Saldo);
        }

        /// <summary>
        ///	 Transfere saldo entre contas.
        /// </summary>
        /// <param name="valorTransferencia">Valor a ser debitado da conta.</param>
        /// <param name="contaDestino">Conta de destino.</param>
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
            return string.Format(header, contagem.ToString(), this.TipoConta, this.Nome, this.Saldo.ToString("C2"), this.Credito.ToString("C2"));
        }

        #endregion
    }
}