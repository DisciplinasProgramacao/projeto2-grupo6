public class GrafoCompleto extends Grafo {

	/**
	 * Construtor de um grafo completo
	 *
	 * @param ordem
	 */
	public GrafoCompleto(int ordem) {
		super("Grafo Completo");

		for (int i = 0; i < ordem; i++) {
			Vertice vertice = new Vertice(i);
			if (this.existeVertice(i) == null) {
				vertices.add(i, vertice);
			}
		}

		Vertice[] allVertices = this.listaVertices();

		for (Vertice verticeOrigem : allVertices) {
			for (Vertice verticeDestino : allVertices) {
				if (verticeOrigem.existeAresta(verticeDestino.getId()) == null
						&& verticeDestino.getId() != verticeOrigem.getId()) {
					verticeOrigem.addAresta(verticeDestino.getId());
				}
			}
		}
	}
}
