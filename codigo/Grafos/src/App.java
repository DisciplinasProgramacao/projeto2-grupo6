public class App {

	public static void main(String[] args) throws Exception {
		Grafo g = new Grafo("Grafo Main");
		// System.out.println((g.nome));

		String caminhoGrafoNaoPonderado = "codigo/Grafos/docs/grafo.csv";
		// String caminhoGrafoPonderado = "codigo/Grafos/docs/grafoPonderado.csv";
		g.carregar(caminhoGrafoNaoPonderado);
		g.salvar("teste");
	}
}
