import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class GrafoCompletoTest {

    @Test
    public void testarGrafoCompleto() {
        GrafoCompleto g = new GrafoCompleto(5);
<<<<<<< HEAD
        assertEquals(4, g.ordem());
=======
        assertEquals(4, g.existeVertice(4).grau());
>>>>>>> fff88e3c70e68fa4be15f2ecb2da32fabbc9ff24
    }

    @Test
    public void testarOutroGrafoCompleto() {

        Grafo completo = Grafo.grafoCompleto(2);

        assertEquals(3, completo.tamanho());
    }

    @Test
    public void testarBooleanoGrafoCompletoVerdadeiro() {

        GrafoCompleto g = new GrafoCompleto(5);

        assertTrue(g.completo());
    }

} 