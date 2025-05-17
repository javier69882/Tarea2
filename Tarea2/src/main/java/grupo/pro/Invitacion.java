package grupo.pro;

import java.time.Instant;

public class Invitacion implements Invitable {
    private Instant hora;

    public Invitacion(Instant hora) {
        if (hora == null) {
            throw new ValorNullException("La hora de la invitación no puede ser null.");
        }
        this.hora = hora;
    }

    @Override
    public void invitar() {
        System.out.println("Invitación enviada a las: " + getHora());
    }

    public Instant getHora() {
        if (hora == null) {
            throw new ValorNullException("La hora de invitación no ha sido inicializada.");
        }
        return hora;
    }

    public void setHora(Instant hora) {
        if (hora == null) {
            throw new ValorNullException("No se puede asignar una hora null a la invitación.");
        }
        this.hora = hora;
    }

    public String toString() {
        return "Hora de invitación: " + getHora();
    }
}
