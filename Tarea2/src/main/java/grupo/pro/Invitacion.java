package grupo.pro;

import java.time.Instant;

/**
 * Clase que epresenta una invitación con una hora específica y permite enviar la invitación.
 */
public class Invitacion implements Invitable {
    private Instant hora;

    /**
     * Constructor que inicializa una invitación con una hora específica.
     *
     * @param hora La hora de la invitación.
     * @throws ValorNullException Si la hora es null.
     */
    public Invitacion(Instant hora) {
        if (hora == null) {
            throw new ValorNullException("La hora de la invitación no puede ser null.");
        }
        this.hora = hora;
    }

    /**
     * Envía la invitación mostrando la hora en la que se envió.
     */
    @Override
    public void invitar() {
        System.out.println("Invitación enviada a las: " + getHora());
    }


    /**
     * Obtiene la hora de la invitación.
     *
     * @return La hora de la invitación.
     * @throws ValorNullException Si la hora no ha sido inicializada.
     */
    public Instant getHora() {
        if (hora == null) {
            throw new ValorNullException("La hora de invitación no ha sido inicializada.");
        }
        return hora;
    }

    /**
     * Establece la hora de la invitación.
     *
     * @param hora La nueva hora de la invitación.
     * @throws ValorNullException Si la hora es null.
     */
    public void setHora(Instant hora) {
        if (hora == null) {
            throw new ValorNullException("No se puede asignar una hora null a la invitación.");
        }
        this.hora = hora;
    }
    /**
     * Devuelve una representación en cadena de la invitación.
     *
     * @return Una cadena que describe la hora de la invitación.
     */
    public String toString() {
        return "Hora de invitación: " + getHora();
    }
}
