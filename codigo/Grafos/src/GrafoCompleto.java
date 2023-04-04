public class GrafoCompleto extends Grafo {

    public GrafoCompleto(String nome) {
        super(nome);
    }

    public GrafoCompleto(int ordem) {
        super("Grafo Completo");

        int peso = -1;

        for (int i = 0; i < ordem; i++) {
            this.vertices.add(i, new Vertice(i));
        }

        Vertice[] listaVertices = new Vertice[vertices.size()];

        for (int i = 0; i < ordem; i++)
            for (int j = i + 1; j < ordem; j++)
                addAresta(i, j);

        // for (Vertice verticeOrigem : this.vertices.allElements(listaVertices)) {
        // for (Vertice verticeDestino : this.vertices.allElements(listaVertices)) {
        // if (verticeOrigem.existeAresta(verticeDestino.getId()) == null) {
        // this.addAresta(verticeOrigem.getId(), verticeDestino.getId(), peso);
        // }
        // }
        // }

    }
}
