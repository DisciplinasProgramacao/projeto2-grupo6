import java.io.FileNotFoundException;

public abstract class GrafoMutavel extends Grafo {

	public GrafoMutavel(String nome) {
		super(nome);
		// TODO Auto-generated constructor stub
	}

	public abstract void carregar(String nomeArquivo) throws FileNotFoundException;
	public boolean addVertice(int id) {
		Vertice verticeNovo = new Vertice(id);
		return this.vertices.add(id, verticeNovo);
	}

	public Vertice removeVertice(int id) {

		Vertice[] vertices1 = new Vertice[vertices.size()];
		Vertice[] percorreVertice = vertices.allElements(vertices1);
		Aresta aux;

		for(int i = 1; i <= percorreVertice.length; i++) {
			aux = percorreVertice[i].existeAresta(id);

			if(aux != null) {
				percorreVertice[i].removeAresta(id);
			}
		}

		return vertices.remove(id);
	}



	public boolean addAresta(int origem, int destino) {
		return false;
	}

	public Aresta removAresta(int origem, int destino) {
		return null;
	}
}
