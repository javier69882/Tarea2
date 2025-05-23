package grupo.pro;

import java.time.Instant;

/**
 *Clase que representa la asistencia de un invitado a una reunión.
 */



public class Asistencia {
    private Invitable invitado;
    private Instant horaLlegada;

    /**
     * Constructor por defecto que inicializa los valores a null.
     */
    public Asistencia() {
        this.invitado = null;
        this.horaLlegada = null;
    }
    /**
     * Constructor que inicializa la asistencia con un invitado y la hora de llegada.
     * @param invitado El invitado que asiste.
     * @param horaLlegada La hora de llegada del invitado.
     * @throws ValorNullException Si el invitado o la hora de llegada son null.
     */

    public Asistencia(Invitable invitado, Instant horaLlegada) {
        if (invitado == null) {
            throw new ValorNullException("El invitado no puede ser null.");
        }
        if (horaLlegada == null) {
            throw new ValorNullException("La hora de llegada no puede ser null.");
        }
        this.invitado = invitado;
        this.horaLlegada = horaLlegada;
    }


    /**
     * Obtiene el invitado asociado a esta asistencia.
     *
     * @return El invitado.
     * @throws ValorNullException Si el invitado no ha sido inicializado.
     */
    public Invitable getInvitado() {
        if (invitado == null) {
            throw new ValorNullException("Invitado no ha sido inicializado.");
        }
        return invitado;
    }
    /**
     * Obtiene la hora de llegada del invitado.
     *
     * @return La hora de llegada.
     * @throws ValorNullException Si la hora de llegada no ha sido inicializada.
     */
    public Instant getHoraLlegada() {
        if (horaLlegada == null) {
            throw new ValorNullException("Hora de llegada no ha sido inicializada.");
        }
        return horaLlegada;
    }
    /**
     * Devuelve una representación en cadena de la asistencia.
     *
     * @return Una cadena que describe al invitado y su hora de llegada.
     */
    @Override
    public String toString(){
        return getInvitado().toString() + " llegó a las " + getHoraLlegada();
    }
}
