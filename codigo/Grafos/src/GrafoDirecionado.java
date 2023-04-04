import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
			result = (v_origin.addAresta(destiny, weight) && v_destiny.addAresta(origin, weight));
		}

		return result;
	}

	@Override
	public Aresta removAresta(int origem, int destino) {
		return null;
	}
}