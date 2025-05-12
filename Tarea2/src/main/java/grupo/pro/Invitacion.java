package grupo.pro;

import java.time.Instant;

public class Invitacion implements Invitable {
    private Instant hora;

    public Invitacion(Instant hora) {
        this.hora = hora;
    }
    @Override
    public void invitar() {

    }
    public Instant getHora(){
        return hora;
    }
    public void setHora(Instant hora){
        this.hora=hora;
    }
}
