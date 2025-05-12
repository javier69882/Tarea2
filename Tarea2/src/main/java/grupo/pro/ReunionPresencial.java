package grupo.pro;

public class ReunionPresencial extends Reunion {
    private String sala;

    @Override
    public void iniciar() {

    }

    @Override
    public void finalizar() {

    }

    public ReunionPresencial(Date fecha, Instant horaPrevista, Duration duracionPrevista, Instant horaInicio, Instant horaFin, String sala){
        super(fecha, horaPrevista, duracionPrevista, horaInicio, horaFin);
        this.sala = sala;
    }
}
