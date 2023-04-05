import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class App {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		Grafo g = null;
		menu();
		int opcao = entrada.nextInt();
		while (opcao != 0) {
			switch (opcao) {
				case 1:
					carregarGrafo(g);
					menu();
					break;
				case 2:
					salvarGrafo(g);
					menu();
					break;
				case 3:
					gerarGrafoCompleto(g);
					menu();
					break;
				case 4:
					gerarGrafoDirecionado(g);
					menu();
					break;
				case 5:
					gerarGrafoNaoDirecionado(g);
					menu();
					break;
				case 6:
					gerarSubGrafo(g);
					menu();
					break;
				default:
					System.err.println("Escolha entre 0 e 7");
					break;
			}
		}
		System.out.println("obrigado por usar nosso aplicativo, até a próxima");
	}

	/**
	 * Gerar sub-grafo
	 */
	private static void gerarSubGrafo(Grafo g) {
		System.out.println();
		System.out.println("6 - Gerar Sub Grafo");
		g.subGrafo(null);
	}

	/**
	 * Gerar Grafo Não Direcionado
	 */
	private static void gerarGrafoNaoDirecionado(Grafo g) {
		System.out.println();
		System.out.println("5 - Gerar grafo não-direcionado");
		g = new GrafoNaoDirecionado("Grafo");

	}

	/**
	 * Gerar Grafo Direcionado
	 */
	private static void gerarGrafoDirecionado(Grafo g) {
		System.out.println();
		System.out.println("4 - Gerar grafo direcionado");
		g = new GrafoDirecionado("Grafo");
	}

	/**
	 * Gerar grafo completo
	 */
	private static void gerarGrafoCompleto(Grafo g) {
		System.out.println();
		System.out.println("3 - Gerar grafo completo - digite o valor da ordem");
		g = new GrafoCompleto(entrada.nextInt());
	}

	/**
	 * Chamada do metodo salvar
	 */
	public static void salvarGrafo(Grafo g) throws IOException {
		System.out.println();
		System.out.println("2 - Salvar o grafo feito");
		String nome = entrada.nextLine();
		g.salvar(nome);
	}

	/**
	 * Chamada do metodo carregar
	 */
	public static void carregarGrafo(Grafo g) throws FileNotFoundException {
		System.out.println();
		System.out.println("1 - Carregar um grafo");
		System.out.println("Digite o nome do arquivo");
		g.carregar("codigo/Grafos/docs/grafo.csv");
	}

	/**
	 * Menu de opções para a aplicação
	 */
	private static void menu() {
		System.out.println("Escolha uma opção:");
		System.out.println("0 - Sair do app");
		System.out.println("1 - Carregar um grafo");
		System.out.println("2 - Salvar o grafo feito");
		System.out.println("3 - Gerar grafo completo");
		System.out.println("4 - Gerar grafo direcionado");
		System.out.println("5 - Gerar grafo não-direcionado");
		System.out.println("6 - Alterar um vertice");
		System.out.println("7 - Alterar uma aresta");

	}

}
