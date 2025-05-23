package grupo.pro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class InvitacionTest {

    private Invitacion invitacion;
    private Instant horaInicial;

    @BeforeEach
    void setUp() {
        horaInicial = Instant.parse("2025-05-01T08:00:00Z");
        invitacion = new Invitacion(horaInicial);
    }

    @Test
    void invitar() {
        assertDoesNotThrow(() -> invitacion.invitar());
    }

    @Test
    void getHora() {
        assertEquals(horaInicial, invitacion.getHora());
    }

    @Test
    void setHora() {
        Instant nuevaHora = Instant.parse("2025-05-01T09:00:00Z");
        invitacion.setHora(nuevaHora);
        assertEquals(nuevaHora, invitacion.getHora());
    }

    @Test
    void testToString() {
        String texto = invitacion.toString();
        assertTrue(texto.contains("Hora de invitación: 2025-05-01T08:00:00Z"));
    }
}