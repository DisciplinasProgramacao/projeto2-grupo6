<<<<<<< HEAD
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
=======

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
>>>>>>> fff88e3c70e68fa4be15f2ecb2da32fabbc9ff24

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GrafoDirecionadoTest {
    private static final Object Aresta = null;
    private static final Object Vertice = new Vertice(10);
    private static final Object ArestaAddAresta = new Aresta(9, 10);

    GrafoMutavel g;

    /**
     * teste para o método carregar
     *
     * @throws IOException
     */
    @BeforeEach
    public void init() {
        g = new GrafoDirecionado("teste da classe GRAFO DIRECIONADO");
    }

    @Test
    public void testarCarregarArquivo() throws FileNotFoundException {
        assertDoesNotThrow(
                () -> g.carregar("/Users/ericdiniz/Documents/GitHub/projeto2-grupo6/codigo/Grafos/src/teste.csv"));

    }

    /**
     * Teste para verificar se o grafo está sendo salvo
     *
     * @throws IOException
     */
    @Test
    public void testarSalvarGrafo() throws IOException {
        g.addVertice(1);
        g.addVertice(2);
        g.salvar("arquivoParaSalvar");
        System.out.println(g.ordem());
        assertDoesNotThrow(() -> g.salvar("arquivoParaSalvar"));
    }

    @Test
    public void testarAddAresta() {
        g.addVertice(7);
        g.addVertice(8);
        assertEquals(true, g.addAresta(8, 7, 50));
    }

    /**
     * Teste para verificar se ARESTA foi removida
     */
    @Test
    public void testarRemoverAresta() {
        g.addVertice(9);
        g.addVertice(10);
        g.addAresta(9, 10, 5);
        g.removeAresta(9, 10);

        assertSame(Aresta, g.removeAresta(9, 10));
    }

    /**
     * Teste para verificar se VERTICE existe.
     */
    @Test
    public void testarSeExisteVertice() {
        Vertice vertex = new Vertice(88);
        g.addVertice(vertex.getId());
        assertEquals(88, g.existeVertice(88).getId());
    }

    /**
     * Teste para verificar se ARESTA existe.
     */
    @Test
    public void testarSeExisteAresta() {
        Vertice v = new Vertice(1);
        Vertice v2 = new Vertice(2);

        g.addVertice(v.getId());
        g.addVertice(v2.getId());
        v.addAresta(2, 10);
        v2.addAresta(1, 10);
        g.addAresta(v.getId(), v2.getId(), 10);
        assertEquals(2, g.existeAresta(1, 2).destino());
    }

    /**
     * Teste para verificar o nome do GRAFO
     */
    @Test
    public void testarSeGrafoPossuiNomeCorreto() {
        assertEquals("teste da classe GRAFO DIRECIONADO", g.nome());
    }
}
