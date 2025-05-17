package grupo.pro;

import java.time.Instant;

public class Asistencia {
    private Invitable invitado;
    private Instant horaLlegada;


    public Asistencia() {
        this.invitado = null;
        this.horaLlegada = null;
    }

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

    public Invitable getInvitado() {
        if (invitado == null) {
            throw new ValorNullException("Invitado no ha sido inicializado.");
        }
        return invitado;
    }

    public Instant getHoraLlegada() {
        if (horaLlegada == null) {
            throw new ValorNullException("Hora de llegada no ha sido inicializada.");
        }
        return horaLlegada;
    }

    public String toString() {
        return getInvitado().toString() + " llegó a las " + getHoraLlegada();
    }
}
