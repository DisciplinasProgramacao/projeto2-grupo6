import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public abstract class GrafoMutavel extends Grafo {

	/**
	 * Construtor com chamada do super
	 */
	public GrafoMutavel(String nome) {
		super(nome);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo para adicionar um novo vertice ao grafo
	 *
	 * @param id
	 * @return booleano com true ou false para adição do vértice
	 */
	public boolean addVertice(int id) {
		Vertice verticeNovo = new Vertice(id);
		return this.vertices.add(id, verticeNovo);
	}

	/**
	 * Metodo de remoção do vertice
	 *
	 * @param id
	 * @return id do vertice removido
	 */
	public Vertice removeVertice(int id) {

		Vertice[] vertices1 = new Vertice[vertices.size()];
		Vertice[] percorreVertice = vertices.allElements(vertices1);
		Aresta aux;

		for (int i = 1; i <= percorreVertice.length; i++) {
			aux = percorreVertice[i].existeAresta(id);

			if (aux != null) {
				percorreVertice[i].removeAresta(id);
			}
		}

		return vertices.remove(id);
	}

	/**
	 * metodo abstrato booleano de adição de aresta
	 */
	public abstract boolean addAresta(int origem, int destino, int peso);

	/**
	 * metodo abstrato booleano de remoção de aresta
	 */
	public abstract Aresta removAresta(int origem, int destino);

	/**
	 * metodo carregar grafo
	 * 
	 * @param nomeArquivo
	 */
	public void carregar(String nomeArquivo) throws FileNotFoundException {

		try {
			Scanner sc = new Scanner(new File(nomeArquivo));
			String linha = "";
			String[] item;

			while (sc.hasNextLine()) {
				linha = sc.nextLine();
				item = linha.split(",");

				Vertice origem = new Vertice(Integer.parseInt(item[0]));
				vertices.add(Integer.parseInt(item[0]), origem);
				origem.addAresta(Integer.parseInt(item[1]));

				Vertice destino = new Vertice(Integer.parseInt(item[1]));
				vertices.add(Integer.parseInt(item[1]), destino);

			}

			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado");
		}
	}

	/**
	 * metodo para salvar o grafo
	 * 
	 * @param nomeArquivo
	 */
	public void salvar(String nomeArquivo) throws IOException {
		FileWriter novoArquivo = new FileWriter(nomeArquivo);
		novoArquivo.write("origem,destino,peso\\n");

		TreeMap<Integer, Vertice> treeMap = this.vertices.getTreeMap();

		treeMap.forEach((key, vertices) -> {
			Aresta[] listaArestas = vertices.listaArestas();
			for (Aresta aresta : listaArestas) {
				String aux = String.valueOf(vertices.getId()) + "," + String.valueOf(aresta.destino()) + ","
						+ String.valueOf(aresta.peso()) + "\n";
				try {
					novoArquivo.append(aux);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		});

		novoArquivo.close();
	}
}
