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
        this.invitado = invitado;
        this.horaLlegada = horaLlegada;
    }

    public Invitable getInvitado() {
        return invitado;
    }
    public Instant getHoraLlegada() {
        return horaLlegada;
    }
    public String toString(){
        return invitado.toString() + " llegó a las " + horaLlegada;
    }
}
