import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		
		Cofrinho cofrinho = new Cofrinho();
		
		//Scanner = pega o que o usuário vai digitar
		Scanner scanner = new Scanner(System.in);
		int opcao = 0;//opção do menu
		
		//Aqui é simples, enquanto o while for diferente da opção 6(sair), o programa segue executando.
		while (opcao != 6) {
            ExibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha após a leitura do número

            //1: Lista moedas no cofrinho, 2: Adiciona uma moeda, 3: Remover moeda, 4: Converter em real, 5: Informações da moeda, 6: Sair
            switch (opcao) {
                case 1:
                    System.out.println("Moedas no cofrinho:");
                    cofrinho.ListarMoedas();
                    break;
                case 2:
                    System.out.println("Digite o nome da moeda a ser adicionada:");
                    String nomeMoeda = scanner.nextLine();
                    double valorMoeda = 0.0;
                    if (nomeMoeda.equalsIgnoreCase("Euro")) {
                        valorMoeda = 6.0;
                    } else if (nomeMoeda.equalsIgnoreCase("Dólar")) {
                        valorMoeda = 4.5;
                    } else if (nomeMoeda.equalsIgnoreCase("Real")) {
                        valorMoeda = 1.0;
                    }
                    cofrinho.AdicionarMoeda(CriarMoeda(nomeMoeda, valorMoeda));
                    System.out.println("Moeda adicionada com sucesso!");
                    break;
                case 3:
                    System.out.println("Digite o nome da moeda a ser removida:");
                    nomeMoeda = scanner.nextLine();
                    cofrinho.RemoverMoeda(nomeMoeda);
                    System.out.println("Moeda removida com sucesso!");
                    break;
                case 4:
                    double valorTotalEmReal = cofrinho.CalcularValorTotalEmReal();
                    System.out.println("Valor total em Real: R$" + valorTotalEmReal);
                    break;
                case 5:
                    System.out.println("Digite o nome da moeda para exibir informações:");
                    nomeMoeda = scanner.nextLine();
                    ExibirInformacoesMoeda(cofrinho, nomeMoeda); // Função atualizada para exibir informações da moeda
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Digite um número válido.");
                    break;
            }

            System.out.println(); // Linha vazia para separar as interações com o menu
        }
		
		scanner.close();
	
	}

		
	//Função que cria o menu
	private static void ExibirMenu() {
        System.out.println("---- MENU ----");
        System.out.println("1 - Listar Moedas");
        System.out.println("2 - Adicionar Moeda");
        System.out.println("3 - Remover Moeda");
        System.out.println("4 - Converter para Real");
        System.out.println("5 - Informações da Moeda");
        System.out.println("6 - Sair");
        System.out.println("Digite o número da opção desejada:");
        // Posicionar o cursor na linha abaixo
        System.out.print("\n> ");
    }
	
	private static void ExibirInformacoesMoeda(Cofrinho cofrinho, String nomeMoeda) {
	    boolean encontrada = false;

	    for (Moeda moeda : cofrinho.getMoedas()) {
	        if (moeda.getNome().equals(nomeMoeda)) {
	            encontrada = true;
	            moeda.info();
	            // Adicione aqui a lógica para exibir a cotação da moeda, se aplicável
	            System.out.println("Cotação: ..."); // Substitua ... pelo valor da cotação
	            break;
	        }
	    }

	    if (!encontrada) {
	        System.out.println("Moeda não encontrada.");
	    }
	}
	
	private static Moeda CriarMoeda(String nome, double valor) {
	    if (nome.equalsIgnoreCase("Euro")) {
	        return new Filha1(nome, valor);
	    } else if (nome.equalsIgnoreCase("Dólar")) {
	        return new Filha2(nome, valor);
	    } else if (nome.equalsIgnoreCase("Real")) {
	        return new Filha3(nome, valor);
	    } else {
	        return null; // Moeda não reconhecida
	    }
	}
	

}