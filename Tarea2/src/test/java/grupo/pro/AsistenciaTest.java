package grupo.pro;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class AsistenciaTest {

    @Test
    void getInvitado() {
        Invitacion invitacion = new Invitacion(Instant.parse("2025-06-01T08:00:00Z"));
        Instant llegada = Instant.parse("2025-06-01T08:10:00Z");

        Asistencia asistencia = new Asistencia(invitacion, llegada);

        assertEquals(invitacion, asistencia.getInvitado());
    }

    @Test
    void getHoraLlegada() {
        Invitacion invitacion = new Invitacion(Instant.parse("2025-06-01T08:00:00Z"));
        Instant llegada = Instant.parse("2025-06-01T08:10:00Z");

        Asistencia asistencia = new Asistencia(invitacion, llegada);

        assertEquals(llegada, asistencia.getHoraLlegada());
    }

    @Test
    void testToString() {
        Invitacion invitacion = new Invitacion(Instant.parse("2025-06-01T08:00:00Z"));
        Instant llegada = Instant.parse("2025-06-01T08:10:00Z");

        Asistencia asistencia = new Asistencia(invitacion, llegada);

        String esperado = "Hora de invitación: 2025-06-01T08:00:00Z llegó a las 2025-06-01T08:10:00Z";
        assertEquals(esperado, asistencia.toString());
    }

    @Test
    void constructorConInvitadoNulo() {
        final Instant llegada = Instant.parse("2025-06-01T08:10:00Z");

        assertThrows(ValorNullException.class, new Executable() {
            @Override
            public void execute() {
                new Asistencia(null, llegada);
            }
        });
    }

    @Test
    void constructorConHoraLlegadaNula() {
        final Invitacion invitacion = new Invitacion(Instant.parse("2025-06-01T08:00:00Z"));

        assertThrows(ValorNullException.class, new Executable(){
            @Override
            public void execute() {
                new Asistencia(invitacion, null);
            }
        });
    }
}