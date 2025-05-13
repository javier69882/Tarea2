package grupo.pro;
import java.util.Date;
import java.time.Instant;
import java.time.Duration;

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







    public String getSala(){
        return sala;
    }
    public void setSala(String sala){
        this.sala=sala;
    }
    public java.util.Date getFecha(){
        return fecha;
    }
    public Instant getHoraPrevista(){
        return horaPrevista;
    }
    public Duration getDuracionPrevista(){
        return duracionPrevista;
    }
    public Instant getHoraInicio(){
        return horaInicio;
    }
    public Instant getHoraFin(){
        return horaFin;
    }
    public void setFecha(java.util.Date fecha){
        this.fecha=fecha;
    }
    public void setHoraPrevista(Instant horaPrevista){
        this.horaPrevista=horaPrevista;
    }
    public void setDuracionPrevista(Duration duracionPrevista){
        this.duracionPrevista=duracionPrevista;
    }
    public void setHoraInicio(Instant horaInicio){
        this.horaInicio=horaInicio;
    }
    public void setHoraFin(Instant horaFin){
        this.horaFin=horaFin;
    }
    public String toString(){
        return "Reunion presencial en sala: " + sala + "\n" +
                "Fecha: " + fecha + "\n" +
                "Hora prevista: " + horaPrevista + "\n" +
                "Duracion prevista: " + duracionPrevista + "\n" +
                "Hora inicio: " + horaInicio + "\n" +
                "Hora fin: " + horaFin;
    }
}
