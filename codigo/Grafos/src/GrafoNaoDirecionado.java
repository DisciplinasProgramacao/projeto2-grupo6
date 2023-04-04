import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GrafoNaoDirecionado extends GrafoMutavel {

	public GrafoNaoDirecionado(String nome) {
		super(nome);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addAresta(int origem, int destino, int peso) {
		boolean result = false;
		Vertice v_origin = this.existeVertice(origem);
		Vertice v_destiny = this.existeVertice(destino);

		if (v_origin != null && v_destiny != null) {
			result = (v_origin.addAresta(destino, peso) && v_destiny.addAresta(origem, peso) && v_destiny.addAresta(origem, peso)
					&& v_destiny.addAresta(destino, peso));
		}

		return result;
	}

	public Aresta removAresta(int origem, int destino) {
		return null;
	}
}
