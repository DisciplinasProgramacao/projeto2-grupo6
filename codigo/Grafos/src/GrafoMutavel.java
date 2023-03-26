import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class GrafoMutavel extends Grafo{

    public GrafoMutavel(String nome){
        super(nome);
    }

    public void carregaGrafoCsv(String nomeArquivo) throws FileNotFoundException {

        FileReader fr = new FileReader(nomeArquivo);
        BufferedReader br = new BufferedReader(fr);

        try {

            String linha = br.readLine();
            String[] verticesLidos = linha.split(",");

            int qtdeArestas = Integer.parseInt(verticesLidos[1]);

            linha = br.readLine();
            String[] vetVertLidos = linha.split(",");
            int[] vetVertLidosToInt = Arrays.stream(vetVertLidos).mapToInt(Integer::parseInt).toArray();

            for (int v : vetVertLidosToInt) {
                this.addVertice(v);
            }

            System.out.println("Arestas lidas : ");
            for (int i = 0; i < qtdeArestas; i++) {
                linha = br.readLine();
                String[] arestasLidas = linha.split(",");
                int[] arestasLidasToInt = Arrays.stream(arestasLidas).mapToInt(Integer::parseInt).toArray();
                this.addAresta(arestasLidasToInt[0], arestasLidasToInt[1]);
            }
            br.close();
            fr.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public boolean addAresta(int origem, int destino) {
        boolean adicionou = false;
        Vertice saida = this.existeVertice(origem);
        Vertice chegada = this.existeVertice(destino);
        if (saida != null && chegada != null) {
            adicionou = (saida.addAresta(destino) && chegada.addAresta(origem));
        }
        return adicionou;

    }
}
