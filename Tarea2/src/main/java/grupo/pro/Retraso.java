package grupo.pro;

import java.time.Duration;

public class Retraso {
    private Invitable invitado;
    private Duration duracion;

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

    public Invitable getInvitado() {
        if (invitado == null) {
            throw new ValorNullException("El invitado no ha sido inicializado.");
        }
        return invitado;
    }

    public Duration getDuracion() {
        if (duracion == null) {
            throw new ValorNullException("La duración no ha sido inicializada.");
        }
        return duracion;
    }

    @Override
    public String toString() {
        return getInvitado().toString() + " se retrasó " + getDuracion().toMinutes() + " minutos.";
    }
}
