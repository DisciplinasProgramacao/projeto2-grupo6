import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GrafoDirecionado extends GrafoMutavel {

	/**
	 * construtor com super
	 */
	public GrafoDirecionado(String nome) {
		super(nome);
	}

	/**
	 * metodo para adicionar aresta a um vertice
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
			result = (v_origin.addAresta(destiny, weight) && v_destiny.addAresta(origin, weight));
		}

		return result;
	}

	/**
	 * metodo para remocao de aresta
	 * 
	 * @param origin
	 * @param destiny
	 *
	 * @return aresta
	 */
	@Override
	public Aresta removAresta(int origem, int destino) {
		return null;
	}
}