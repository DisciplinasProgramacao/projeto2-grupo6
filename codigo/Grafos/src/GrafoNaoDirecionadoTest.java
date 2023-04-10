
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GrafoNaoDirecionadoTest {

    GrafoNaoDirecionado grafoNaoDirecionado;

    @BeforeEach
    public void init() {
        grafoNaoDirecionado = new GrafoNaoDirecionado("test");
    }

    @Test
    public void adicionarAresta(){
        
    }

    @Test
    public void testarNomeGrafo() {
        assertEquals("test", grafoNaoDirecionado.nome());
    }

    @Test
    public void adicionarNovoVertice() {
        assertTrue(grafoNaoDirecionado.addVertice(1));
    }

    @Test
    public void adicionarVerticeRepetido() {
        grafoNaoDirecionado.addVertice(5);
        assertFalse(grafoNaoDirecionado.addVertice(5));
    }

    @Test
    public void removerVertice() {

        grafoNaoDirecionado.addVertice(1);
        grafoNaoDirecionado.addVertice(2);
        assertEquals(2, grafoNaoDirecionado.ordem());
        assertNotNull(grafoNaoDirecionado.removeVertice(2));
        assertEquals(1, grafoNaoDirecionado.ordem());

    }

    @Test
    public void tamanhoDoGrafo() {
        grafoNaoDirecionado.addVertice(1);
        grafoNaoDirecionado.addVertice(2);
        grafoNaoDirecionado.addVertice(4);
        grafoNaoDirecionado.addVertice(5);

        grafoNaoDirecionado.addAresta(1, 2, 0);

        assertEquals(5, grafoNaoDirecionado.tamanho());
    }

    // @Test
    // public void testarSalvarGrafo() throws IOException {

    // grafoNaoDirecionado.addVertice(2);

    // grafoNaoDirecionado.salvar("tete");
    // assertDoesNotThrow(() -> grafoNaoDirecionado.salvar("teste"));
    // }

}
