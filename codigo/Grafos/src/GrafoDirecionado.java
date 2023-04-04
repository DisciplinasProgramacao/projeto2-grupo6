public class GrafoDirecionado extends GrafoMutavel {

	public GrafoDirecionado(String nome) {
		super(nome);
	}

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

	@Override
	public Aresta removeAresta(int origin, int destiny) {
		return null;
	}

}