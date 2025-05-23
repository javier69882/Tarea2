package grupo.pro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class RetrasoTest {

    private Retraso retraso;
    private Invitacion invitacion;
    private Duration duracion;

    @BeforeEach
    void setUp() {
        invitacion = new Invitacion(Instant.parse("2025-05-22T08:00:00Z"));
        duracion = Duration.ofMinutes(10);
        retraso = new Retraso(invitacion, duracion);
    }

    @Test
    void getInvitado() {
        assertEquals(invitacion, retraso.getInvitado());
    }

    @Test
    void getDuracion() {
        assertEquals(duracion, retraso.getDuracion());
    }

    @Test
    void testToString() {
        String texto = retraso.toString();
        assertTrue(texto.contains("se retrasó 10 minutos"));
    }
}