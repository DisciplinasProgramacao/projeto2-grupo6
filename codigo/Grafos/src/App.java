public class App {

	public static void main(String[] args) throws Exception {
		Grafo g = new Grafo("");
		g.carregar("grafo.txt");
		g.salvar("teste.txt");
	}
}
