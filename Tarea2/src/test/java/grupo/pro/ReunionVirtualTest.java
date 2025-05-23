package grupo.pro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ReunionVirtualTest {

    private ReunionVirtual reunion;
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private TipoReunion tipo;

    @BeforeEach
    void setUp() {
        fecha = new Date();
        horaPrevista = Instant.parse("2025-05-01T08:00:00Z");
        duracionPrevista = Duration.ofMinutes(60);
        tipo = TipoReunion.TECNICA;
        reunion = new ReunionVirtual(fecha, horaPrevista, duracionPrevista, tipo, "https://meet.example.com/reunion1");
    }

    @Test
    void iniciar() {
        reunion.iniciar();
        assertNotNull(reunion.getHoraInicio());
    }

    @Test
    void finalizar() {
        reunion.iniciar();
        reunion.finalizar();
        assertNotNull(reunion.getHoraFin());
    }

    @Test
    void getEnlace() {
        assertEquals("https://meet.example.com/reunion1", reunion.getEnlace());
    }

    @Test
    void setEnlace() {
        reunion.setEnlace("https://zoom.us/reunion2");
        assertEquals("https://zoom.us/reunion2", reunion.getEnlace());
    }

    @Test
    void getFecha() {
        assertEquals(fecha, reunion.getFecha());
    }

    @Test
    void getHoraPrevista() {
        assertEquals(horaPrevista, reunion.getHoraPrevista());
    }

    @Test
    void getDuracionPrevista() {
        assertEquals(duracionPrevista, reunion.getDuracionPrevista());
    }

    @Test
    void getHoraInicio() {
        reunion.iniciar();
        assertNotNull(reunion.getHoraInicio());
    }

    @Test
    void getHoraFin() {
        reunion.iniciar();
        reunion.finalizar();
        assertNotNull(reunion.getHoraFin());
    }

    @Test
    void setFecha() {
        Date nuevaFecha = new Date();
        reunion.setFecha(nuevaFecha);
        assertEquals(nuevaFecha, reunion.getFecha());
    }

    @Test
    void setHoraPrevista() {
        Instant nuevaHora = Instant.parse("2025-05-01T10:00:00Z");
        reunion.setHoraPrevista(nuevaHora);
        assertEquals(nuevaHora, reunion.getHoraPrevista());
    }

    @Test
    void setDuracionPrevista() {
        Duration nuevaDuracion = Duration.ofMinutes(90);
        reunion.setDuracionPrevista(nuevaDuracion);
        assertEquals(nuevaDuracion, reunion.getDuracionPrevista());
    }

    @Test
    void setHoraInicio() {
        Instant nuevaHoraInicio = Instant.parse("2025-05-01T08:30:00Z");
        reunion.setHoraInicio(nuevaHoraInicio);
        assertEquals(nuevaHoraInicio, reunion.getHoraInicio());
    }

    @Test
    void setHoraFin() {
        Instant nuevaHoraFin = Instant.parse("2025-05-01T09:30:00Z");
        reunion.setHoraFin(nuevaHoraFin);
        assertEquals(nuevaHoraFin, reunion.getHoraFin());
    }

    @Test
    void testToString() {
        String texto = reunion.toString();
        assertTrue(texto.contains("Reunion virtual en enlace: https://meet.example.com/reunion1"));
        assertTrue(texto.contains("Fecha:"));
        assertTrue(texto.contains("Hora prevista:"));
        assertTrue(texto.contains("Duracion prevista:"));
    }

    @Test
    void constructorConParametrosNull() {
        assertThrows(ValorNullException.class, () -> new ReunionVirtual(null, horaPrevista, duracionPrevista, tipo, "https://meet.example.com/reunion1"));
        assertThrows(ValorNullException.class, () -> new ReunionVirtual(fecha, null, duracionPrevista, tipo, "https://meet.example.com/reunion1"));
        assertThrows(ValorNullException.class, () -> new ReunionVirtual(fecha, horaPrevista, null, tipo, "https://meet.example.com/reunion1"));
        assertThrows(ValorNullException.class, () -> new ReunionVirtual(fecha, horaPrevista, duracionPrevista, null, "https://meet.example.com/reunion1"));
        assertThrows(ValorNullException.class, () -> new ReunionVirtual(fecha, horaPrevista, duracionPrevista, tipo, null));
    }
}
