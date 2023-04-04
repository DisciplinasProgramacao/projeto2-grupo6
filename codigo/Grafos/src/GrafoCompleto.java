public class GrafoCompleto extends Grafo {

    public GrafoCompleto(String nome) {
        super(nome);
    }

    public void GrafoCompleto(int ordem) {

        int peso = -1;
        if (!this.completo()) {
            for (Vertice verticeOrigem : this.vertices.allElements(null)) {
                for (Vertice verticeDestino : this.vertices.allElements(null)) {
                    if (verticeOrigem.existeAresta(verticeDestino.getId()) == null) {
                        this.addAresta(verticeOrigem.getId(), verticeDestino.getId(), peso);
                    }
                }
            }
        }
    }
}

