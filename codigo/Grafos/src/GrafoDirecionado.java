import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GrafoDirecionado extends GrafoMutavel {

	public GrafoDirecionado(String nome) {
		super(nome);
	}

	public void carregar(String nomeArquivo) throws FileNotFoundException {
		try{

			Scanner sc = new Scanner(new File(nomeArquivo));
			String linha = "";
			String[] item;

			while (sc.hasNextLine()){
				linha = sc.nextLine();
				item = linha.split(",");

				Vertice origem = new Vertice(Integer.parseInt(item[0]));
				vertices.add(Integer.parseInt(item[0]), origem);

				Vertice destino = new Vertice(Integer.parseInt(item[1]));
				vertices.add(Integer.parseInt(item[1]), destino);

				origem.addAresta(Integer.parseInt(item[1]));

				sc.close();
			}

		} catch (FileNotFoundException e) {

			System.out.println("Arquivo não encontrado");
		}
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
	public Aresta removeAresta(int origin, int destiny) {
		return null;
	}

}