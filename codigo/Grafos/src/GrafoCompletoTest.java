import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GrafoCompletoTest {

    @Test
    public void testarGrafoCompleto() {
        GrafoCompleto g = new GrafoCompleto("TesteGrafoCompleto");
        g.addVertice(1);
        g.addVertice(2);
        g.addVertice(3);
        int ordem = g.ordem();
        g.GrafoCompletoBuild(ordem);
        assertEquals(2, g.ordem());
    }

}