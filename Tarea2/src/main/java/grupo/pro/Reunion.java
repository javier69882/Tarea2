package grupo.pro;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

public abstract class Reunion {
    private java.util.Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;

    public abstract void iniciar();
    public abstract void finalizar();

    public List<Asistencia> obtenerAsistencia() {
        return null;
    }

    public List<Asistencia> obtenerAusencias() {
        return null;
    }

    public List<Retraso> obtenerRetrasos() {
        return null;
    }

    public int obtenerTotalAsistencia() {
        return 0;
    }

    public float obtenerPorcentajeAsistencia() {
        return 0;
    }

    public float calcularTiempoReal() {
        return 0;
    }
}
