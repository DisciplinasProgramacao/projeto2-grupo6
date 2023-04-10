import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public abstract class GrafoMutavel extends Grafo {

	/**
	 * Construtor com chamada do super
	 */
	public GrafoMutavel(String nome) {
		super(nome);
	}

	/**
	 * Adiciona um vértice com o id especificado. Ignora a ação e retorna false se
	 * já existir um vértice com este id
	 *
	 * @param id O identificador do vértice a ser criado/adicionado
	 * @return TRUE se houve a inclusão do vértice, FALSE se já existia vértice com
	 *         este id
	 */
	public boolean addVertice(int id) {
		Vertice novo = new Vertice(id);
		return vertices.add(id, novo);
	}

	/**
	 * Remove um vértice com o id especificado. Ignora a ação se não houver o
	 * vértice e retorsa false. caso positivo retorna o vértice removido.
	 * 
	 * @param id O identificador do vértice a ser removido
	 * @return vértice removido
	 */
	public Vertice removeVertice(int id) {
		return vertices.remove(id);
	}

	/**
	 * Adiciona uma aresta entre dois vértices do grafo, caso os dois vértices
	 * existam no grafo.
	 * Caso a aresta já exista, ou algum dos vértices não existir, o comando é
	 * ignorado e retorna FALSE.
	 *
	 * @param origem  Vértice de origem
	 * @param destino Vértice de destino
	 * @param peso    Peso da aresta
	 * @return TRUE se foi inserida, FALSE caso contrário
	 */
	public boolean addAresta(int origem, int destino, int peso) {
		boolean adicionou = false;
		Vertice saida = this.existeVertice(origem);
		Vertice chegada = this.existeVertice(destino);
		if (saida != null && chegada != null) {
			adicionou = (saida.addAresta(destino, peso) && chegada.addAresta(origem, peso));
		}
		return adicionou;
	}

	public Aresta removeAresta(int origem, int destino) {
		return vertices.find(origem).removeAresta(destino);
	}

	/**
	 * metodo carregar grafo
	 * 
	 * @param nomeArquivo
	 */
	public void carregar(String nomeArquivo) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(nomeArquivo));
		String linha;
		String[] itens;

		linha = sc.nextLine(); // ignorar cabeçalho
		while (sc.hasNextLine()) {
			linha = sc.nextLine();
			itens = linha.split(",");

			int origem = Integer.parseInt(itens[0]);
			int destino = Integer.parseInt(itens[1]);
			int peso = Integer.parseInt(itens[2]);

			addAresta(origem, destino, peso);
		}
		sc.close();
	}

	public void salvar(String nomeArquivo) throws IOException {
		FileWriter novoArquivo = new FileWriter(nomeArquivo);
		novoArquivo.write("origem,destino,peso\n");

		Vertice[] listaVertices = listaVertices();
		for (Vertice vertice : listaVertices) {
			Aresta[] listaArestas = vertice.listaArestas();
			for (Aresta aresta : listaArestas) {
				String aux = String.valueOf(vertice.getId()) + "," + String.valueOf(aresta.destino()) + ","
						+ String.valueOf(aresta.peso()) + "\n";
				novoArquivo.append(aux);
			}
		}
		novoArquivo.close();
	}
}
