using System;
using DIO.Series.Classes;
using DIO.Series.Interfaces;

namespace DIO.Series
{
    class Program
    {
        private static SerieRepository repository = new SerieRepository();

        static void Main(string[] args)
        {
            string opcaoUsuario = ObterOpcaoUsuario();

            while (opcaoUsuario != "X")
            {
                switch (opcaoUsuario)
                {
                    case "1":
                        ListarSeries();
                        break;
                    case "2":
                        InserirSerie();
                        break;
                    case "3":
                        AtualizarSerie();
                        break;
                    case "4":
                        ExcluirSerie();
                        break;
                    case "5":
                        VisualizarSerie();
                        break;
                    case "C":
                        Console.Clear();
                        break;
                    default:
                        Console.WriteLine("Comando naoa coincide com os passados");
                        break;
                }

                opcaoUsuario = ObterOpcaoUsuario();
            }
        }

        private static void VisualizarSerie()
        {
            Console.WriteLine("Card Serie por ID!");

            Console.Write("Digite o id da série desejada: ");
            int entradaId = int.Parse(Console.ReadLine());

            var retorno = repository.RetornaPorId(entradaId);

            Console.WriteLine(retorno.ToString());
        }
        private static void ExcluirSerie()
        {
            Console.Write("Digite o ID a ser Excluido: ");
            int entradaId = int.Parse(Console.ReadLine());

            repository.Excluir(entradaId);
        }
        private static void InserirSerie()
        {
            Console.WriteLine("Inserir nova Série");
            ObterListaEnumerada();
            Serie serie = RoteiroInsercaoAtualizacao();
            repository.Insere(serie);
        }

        private static void ObterListaEnumerada()
        {
            foreach (int i in Enum.GetValues(typeof(Genero)))
            {
                Console.WriteLine("{0} - {1}", i, Enum.GetName(typeof(Genero), i));
            }
        }

        private static Serie RoteiroInsercaoAtualizacao(){
            Console.Write("Digite o genêro entre as opçoes acima: ");
            int entradaGenero = int.Parse(Console.ReadLine());

            Console.Write("Digite o Titulo: ");
            string entradaTitulo = Console.ReadLine();

            Console.Write("Digite o ano de lançamento: ");
            int entradaAno = int.Parse(Console.ReadLine());

            Console.Write("Digite a descrição: ");
            string entradaDescricao = Console.ReadLine();

            Serie serie = new Serie(repository.ProximoId(), (Genero)entradaGenero, entradaTitulo, entradaDescricao, entradaAno);

            return serie;
        }
        private static void AtualizarSerie()
        {
            Console.WriteLine("Parametro\ngenero\ntitulo\nano\ndesc\nall\n");
            Console.Write("Digite o id da série que deseja atualizar seguido do parametro ");

            Console.ForegroundColor = ConsoleColor.Blue;
            Console.Write("parametro id: ");
            Console.ForegroundColor = ConsoleColor.Green;

            var entrada = Console.ReadLine().Split(" ");
            var parametro = entrada[0];
            int id = int.Parse(entrada[1]);

            var entidade = repository.Lista()[id];

            switch (parametro)
            {
                case "genero":
                    Console.Write("Digite o genêro entre as opçoes acima: ");
                    entidade.Genero = Enum.Parse<Genero>(Console.ReadLine());
                    repository.Atualizar(id, entidade);
                    break;
                case "titulo":
                    Console.Write("Digite o Titulo: ");
                    entidade.Titulo = Console.ReadLine();
                    repository.Atualizar(id, entidade);
                    break;
                case "ano":
                    Console.Write("Digite o ano de lançamento: ");
                    entidade.Ano = int.Parse(Console.ReadLine());
                    repository.Atualizar(id, entidade);
                    break;
                case "desc":
                    Console.Write("Digite a descrição: ");
                    entidade.Descricao = Console.ReadLine();
                    repository.Atualizar(id, entidade);
                    break;
                case "all":
                    repository.Atualizar(id, RoteiroInsercaoAtualizacao());
                    break;
            }


        }
        private static void ListarSeries()
        {
            Console.WriteLine("Lista de Séries");

            var listaSeries = repository.Lista();

            if (listaSeries.Count == 0)
            {
                Console.WriteLine("Nenhuma Serie Cadastrada, deseja cadastrar ? (S / N)");

                var response = Console.ReadLine().ToUpper();
                if (response != "S")
                    return;
            }

            foreach (var serie in listaSeries)
            {
                Console.WriteLine("#ID - {0}: - {1}", serie.RetornaId(), serie.RetornaTitulo());
            }
        }

        private static string ObterOpcaoUsuario()
        {
            Console.WriteLine();
            Console.WriteLine("DIO Séries a seu dispor !");
            Console.WriteLine("Informe a opção desejada");

            Console.WriteLine();
            Console.WriteLine("1- Listar Séries");
            Console.WriteLine("2- Inserir nova Série");
            Console.WriteLine("3- Atualizar Série");
            Console.WriteLine("4- Excluir Série");
            Console.WriteLine("5- Visualizar Série");
            Console.WriteLine("C- Limpar console");
            Console.WriteLine("X- Sair");
            Console.WriteLine();

            string opcao = Console.ReadLine().ToUpper();
            Console.WriteLine();
            return opcao;
        }
    }
}
