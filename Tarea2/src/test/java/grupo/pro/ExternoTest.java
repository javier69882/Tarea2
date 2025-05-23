package grupo.pro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExternoTest {

    private Externo externo;

    @BeforeEach
    void setUp() {
        externo = new Externo("Vicente", "García", "vicente@correo.com");
    }

    @Test
    void invitar() {
        assertDoesNotThrow(() -> externo.invitar());
    }

    @Test
    void testToString() {
        String texto = externo.toString();
        assertTrue(texto.contains("Externo: Vicente García"));
        assertTrue(texto.contains("Correo: vicente@correo.com"));
    }
}
