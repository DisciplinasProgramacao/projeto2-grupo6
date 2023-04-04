public class GrafoCompleto extends Grafo {

    public GrafoCompleto(String nome) {
        super(nome);
        GrafoCompleto(this.ordem());
    }

    public void GrafoCompleto(int ordem) {

        if (!this.completo()) {
            for (Vertice verticeOrigem : this.vertices.allElements(null)) {
                for (Vertice verticeDestino : this.vertices.allElements(null)) {
                        //Para vada vértice de destino, se não houver a aresta origem - destino. Eu crio o vértice.
                }
            }
        }
    }

}
