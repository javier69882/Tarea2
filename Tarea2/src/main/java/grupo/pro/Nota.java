package grupo.pro;

import java.time.Instant;
/**
 * Representa una nota con contenido y una marca de tiempo.
 */
public class Nota {
    private String contenido;
    private Instant fechaHora;

    /**
     * Constructor que inicializa una nota con el contenido especificado.
     * La fecha y hora se asignan automáticamente al momento de la creación.
     *
     * @param contenido El contenido de la nota.
     * @throws ValorNullException Si el contenido es null o está vacío.
     */
    public Nota(String contenido) {
        if (contenido == null || contenido.isBlank()) {
            throw new ValorNullException("El contenido de la nota no puede ser null o vacío.");
        }
        this.contenido = contenido;
        this.fechaHora = Instant.now(); // Guarda la fecha y hora actual automáticamente
    }

    /**
     * Obtiene el contenido de la nota.
     *
     * @return El contenido de la nota.
     * @throws ValorNullException Si el contenido no ha sido inicializado.
     */
    public String getContenido() {
        if (contenido == null) {
            throw new ValorNullException("El contenido no ha sido inicializado.");
        }
        return contenido;
    }

    /**
     * Obtiene la fecha y hora de la nota.
     *
     * @return La fecha y hora de la nota.
     * @throws ValorNullException Si la fecha y hora no han sido inicializadas.
     */
    public Instant getFechaHora() {
        if (fechaHora == null) {
            throw new ValorNullException("La fecha y hora no han sido inicializadas.");
        }
        return fechaHora;
    }


    /**
     * Establece el contenido de la nota.
     *
     * @param contenido El nuevo contenido de la nota.
     * @throws ValorNullException Si el contenido es null o está vacío.
     */
    public void setContenido(String contenido) {
        if (contenido == null || contenido.isBlank()) {
            throw new ValorNullException("El contenido no puede ser null o vacío.");
        }
        this.contenido = contenido;
    }

    /**
     * Establece la fecha y hora de la nota.
     *
     * @param fechaHora La nueva fecha y hora de la nota.
     * @throws ValorNullException Si la fecha y hora son null.
     */
    public void setFechaHora(Instant fechaHora) {
        if (fechaHora == null) {
            throw new ValorNullException("La fechaHora no puede ser null.");
        }
        this.fechaHora = fechaHora;
    }
    /**
     * Devuelve una cadena de la nota.
     *
     * @return Una cadena que describe la nota con su fecha y hora.
     */
    @Override
    public String toString() {
        return "[" + getFechaHora() + "] Nota: " + getContenido();
    }
}
