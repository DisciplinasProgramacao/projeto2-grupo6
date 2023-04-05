import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GrafoNaoDirecionado extends GrafoMutavel {

	/**
	 * construtor com super
	 */
	public GrafoNaoDirecionado(String nome) {
		super(nome);
		// TODO Auto-generated constructor stub
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
	public boolean addAresta(int origem, int destino, int peso) {
		boolean result = false;
		Vertice v_origin = this.existeVertice(origem);
		Vertice v_destiny = this.existeVertice(destino);

		if (v_origin != null && v_destiny != null) {
			result = (v_origin.addAresta(destino, peso) && v_destiny.addAresta(origem, peso)
					&& v_destiny.addAresta(origem, peso)
					&& v_destiny.addAresta(destino, peso));
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
	public Aresta removAresta(int origem, int destino) {
		return null;
	}
}
