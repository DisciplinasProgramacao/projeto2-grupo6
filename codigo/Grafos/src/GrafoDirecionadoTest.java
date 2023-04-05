import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class GrafoDirecionadoTest {

    /**
     * Teste para verificar se o grafo está sendo salvo
     */
    @Test
    public void testarSalvarGrafo() {
        GrafoNaoDirecionado g = new GrafoNaoDirecionado("test");
        g.addVertice(1);
        g.addVertice(2);
        assertDoesNotThrow(() -> g.salvar("teste"));
    }

}
