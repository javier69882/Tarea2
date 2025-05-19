package grupo.pro;

import java.time.Duration;

/**
 * Clase que representa un retraso asociado a un invitado y su duración.
 */
public class Retraso {
    private Invitable invitado;
    private Duration duracion;

    /**
     * Constructor que inicializa un retraso con un invitado y su duración.
     *
     * @param invitado El invitado asociado al retraso.
     * @param duracion La duración del retraso.
     * @throws ValorNullException Si el invitado o la duración son null.
     */
    public Retraso(Invitable invitado, Duration duracion) {
        if (invitado == null) {
            throw new ValorNullException("El invitado no puede ser null.");
        }
        if (duracion == null) {
            throw new ValorNullException("La duración del retraso no puede ser null.");
        }
        this.invitado = invitado;
        this.duracion = duracion;
    }

    /**
     * Obtiene el invitado asociado al retraso.
     *
     * @return El invitado asociado al retraso.
     * @throws ValorNullException Si el invitado no ha sido inicializado.
     */
    public Invitable getInvitado() {
        if (invitado == null) {
            throw new ValorNullException("El invitado no ha sido inicializado.");
        }
        return invitado;
    }

    /**
     * Obtiene la duración del retraso.
     *
     * @return La duración del retraso.
     * @throws ValorNullException Si la duración no ha sido inicializada.
     */
    public Duration getDuracion() {
        if (duracion == null) {
            throw new ValorNullException("La duración no ha sido inicializada.");
        }
        return duracion;
    }

    /**
     * Devuelve cadena del retraso.
     *
     * @return Una cadena que describe al invitado y la duración del retraso.
     */
    @Override
    public String toString() {
        return getInvitado().toString() + " se retrasó " + getDuracion().toMinutes() + " minutos.";
    }
}
