package grupo.pro;

import java.time.Instant;
import java.time.Duration;

public class Retraso{
    private Invitable invitado;
    private Duration duracion;

    public Retraso(Invitable invitado, Duration duracion) {
        this.invitado = invitado;
        this.duracion = duracion;
    }

    public Invitable getInvitado() {
        return invitado;
    }

    public Duration getDuracion() {
        return duracion;
    }

    @Override
    public String toString() {
        return invitado.toString() + " se retrasó " + duracion.toMinutes() + " minutos.";
    }
}
