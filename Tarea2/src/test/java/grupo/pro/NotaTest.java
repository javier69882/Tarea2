package grupo.pro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class NotaTest {

    private Nota nota;
    private String contenidoInicial = "Primera nota";

    @BeforeEach
    void setUp() {
        nota = new Nota(contenidoInicial);
    }

    @Test
    void getContenido() {
        assertEquals(contenidoInicial, nota.getContenido());
    }

    @Test
    void getFechaHora() {
        assertNotNull(nota.getFechaHora());
    }

    @Test
    void setContenido() {
        String nuevoContenido = "Actualización importante";
        nota.setContenido(nuevoContenido);
        assertEquals(nuevoContenido, nota.getContenido());
    }

    @Test
    void setFechaHora() {
        Instant nuevaFecha = Instant.parse("2025-05-16T09:00:00Z");
        nota.setFechaHora(nuevaFecha);
        assertEquals(nuevaFecha, nota.getFechaHora());
    }

    @Test
    void testToString() {
        String texto = nota.toString();
        assertTrue(texto.contains("Nota: " + contenidoInicial));
    }
}