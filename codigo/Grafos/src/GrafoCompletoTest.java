import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GrafoCompletoTest {

    /**
     * Teste realizado para verificar se grafo é completo
     */
    @Test
    public void testarGrafoCompleto() {
        GrafoCompleto g = new GrafoCompleto(5);
        assertEquals(4, g.ordem());
    }

}