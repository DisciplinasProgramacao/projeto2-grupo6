public class GrafoCompleto extends Grafo {

	/**
	 * Construtor de um grafo completo
	 *
	 * @param ordem
	 */
	public GrafoCompleto(int ordem) {
		super("Grafo Completo");

		for (int i = 0; i < ordem; i++)
			this.vertices.add(i, new Vertice(i));

		for (int i = 0; i < ordem; i++)
			for (int j = i + 1; j < ordem; j++)
				addAresta(i, j);
	}
}
