package grupo.pro;

public class ReunionVirtual extends Reunion {
    private String enlace;

    @Override
    public void iniciar() {

    }

    @Override
    public void finalizar() {

    }
    public ReunionVirtual(Date fecha, Instant horaPrevista, Duration duracionPrevista, Instant horaInicio, Instant horaFin, String enlace){
        super(fecha, horaPrevista, duracionPrevista, horaInicio, horaFin);
        this.enlace = enlace;
    }
}
