package grupo.pro;
import java.util.Date;
import java.time.Instant;
import java.time.Duration;

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
    public String getEnlace(){
        return enlace;
    }
    public void setEnlace(String enlace){
        this.enlace=enlace;
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
}
