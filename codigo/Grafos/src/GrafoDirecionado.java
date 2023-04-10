public class GrafoDirecionado extends GrafoMutavel {

	/**
	 * construtor com super
	 */
	public GrafoDirecionado(String nome) {
		super(nome);
	}

	/**
	 * método para adicionar aresta a um vértice
	 *
	 * @param origin
	 * @param destiny
	 * @param weight
	 *
	 * @return booleano
	 */
	@Override
	public boolean addAresta(int origin, int destiny, int weight) {

		boolean result = false;
		Vertice v_origin = this.existeVertice(origin);
		Vertice v_destiny = this.existeVertice(destiny);

		if (v_origin != null && v_destiny != null) {
			result = (v_origin.addAresta(destiny, weight));
		}

		return result;
	}

	/**
	 * método para remoção de aresta
	 *
	 * @param origin
	 * @param destiny
	 *
	 * @return aresta removida
	 */
	@Override
	public Aresta removeAresta(int origin, int destiny) {
		return vertices.find(origin).removeAresta(destiny);
	}
}