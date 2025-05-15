package grupo.pro;

import java.time.Instant;

public class Nota {
    private String contenido;
    private Instant fechaHora;

    public Nota(String contenido) {
        this.contenido = contenido;
        this.fechaHora = Instant.now(); // Guarda la fecha y hora actual automáticamente
    }

    public String getContenido() {
        return contenido;
    }

    public Instant getFechaHora() {
        return fechaHora;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setFechaHora(Instant fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "[" + fechaHora + "] Nota: " + contenido;
    }
}