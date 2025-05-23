package grupo.pro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ReunionPresencialTest {

    private ReunionPresencial reunion;
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private TipoReunion tipo;

    @BeforeEach
    void setUp() {
        fecha = new Date();
        horaPrevista = Instant.parse("2025-05-20T08:00:00Z");
        duracionPrevista = Duration.ofMinutes(90);
        tipo = TipoReunion.TECNICA;
        reunion = new ReunionPresencial(fecha, horaPrevista, duracionPrevista, tipo, "Sala A");
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
    void getSala() {
        assertEquals("Sala A", reunion.getSala());
    }

    @Test
    void setSala() {
        reunion.setSala("Sala B");
        assertEquals("Sala B", reunion.getSala());
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
        Instant nuevaHora = Instant.parse("2025-05-20T10:00:00Z");
        reunion.setHoraPrevista(nuevaHora);
        assertEquals(nuevaHora, reunion.getHoraPrevista());
    }

    @Test
    void setDuracionPrevista() {
        Duration nuevaDuracion = Duration.ofMinutes(120);
        reunion.setDuracionPrevista(nuevaDuracion);
        assertEquals(nuevaDuracion, reunion.getDuracionPrevista());
    }

    @Test
    void setHoraInicio() {
        Instant nuevaHoraInicio = Instant.parse("2025-05-20T08:30:00Z");
        reunion.setHoraInicio(nuevaHoraInicio);
        assertEquals(nuevaHoraInicio, reunion.getHoraInicio());
    }

    @Test
    void setHoraFin() {
        Instant nuevaHoraFin = Instant.parse("2025-05-20T10:00:00Z");
        reunion.setHoraFin(nuevaHoraFin);
        assertEquals(nuevaHoraFin, reunion.getHoraFin());
    }

    @Test
    void testToString() {
        String texto = reunion.toString();
        assertTrue(texto.contains("Reunion presencial en sala: Sala A"));
        assertTrue(texto.contains("Fecha:"));
        assertTrue(texto.contains("Hora prevista:"));
        assertTrue(texto.contains("Duracion prevista:"));
    }

    @Test
    void constructorConParametrosNull() {
        assertThrows(ValorNullException.class, () -> new ReunionPresencial(null, horaPrevista, duracionPrevista, tipo, "Sala A"));
        assertThrows(ValorNullException.class, () -> new ReunionPresencial(fecha, null, duracionPrevista, tipo, "Sala A"));
        assertThrows(ValorNullException.class, () -> new ReunionPresencial(fecha, horaPrevista, null, tipo, "Sala A"));
        assertThrows(ValorNullException.class, () -> new ReunionPresencial(fecha, horaPrevista, duracionPrevista, null, "Sala A"));
        assertThrows(ValorNullException.class, () -> new ReunionPresencial(fecha, horaPrevista, duracionPrevista, tipo, null));
    }
}