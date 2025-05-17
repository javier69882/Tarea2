package grupo.pro;

import java.time.Instant;

public class Nota {
    private String contenido;
    private Instant fechaHora;

    public Nota(String contenido) {
        if (contenido == null || contenido.isBlank()) {
            throw new ValorNullException("El contenido de la nota no puede ser null o vacío.");
        }
        this.contenido = contenido;
        this.fechaHora = Instant.now(); // Guarda la fecha y hora actual automáticamente
    }

    public String getContenido() {
        if (contenido == null) {
            throw new ValorNullException("El contenido no ha sido inicializado.");
        }
        return contenido;
    }

    public Instant getFechaHora() {
        if (fechaHora == null) {
            throw new ValorNullException("La fecha y hora no han sido inicializadas.");
        }
        return fechaHora;
    }

    public void setContenido(String contenido) {
        if (contenido == null || contenido.isBlank()) {
            throw new ValorNullException("El contenido no puede ser null o vacío.");
        }
        this.contenido = contenido;
    }

    public void setFechaHora(Instant fechaHora) {
        if (fechaHora == null) {
            throw new ValorNullException("La fechaHora no puede ser null.");
        }
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "[" + getFechaHora() + "] Nota: " + getContenido();
    }
}
