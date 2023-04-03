public class App {

	public static void main(String[] args) throws Exception {
		Grafo g = new Grafo("Grafo Main");
		System.out.println((g.nome));

		g.carregar(null);
	}
}
