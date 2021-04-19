import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LectorTest {

    @Test
    void lector_Asociaciones() {
    }

    @Test
    void lector_Asociaciones2() {
    }

    @Test
    void lector_Expresion() {
        Lector lector = new Lector();
        String prueba = lector.Lector_Expresion();
        assertEquals("Este es un ejemplo",prueba);
    }
}