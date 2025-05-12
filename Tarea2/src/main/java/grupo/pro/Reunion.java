package grupo.pro;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

public abstract class Reunion {
    protected java.util.Date fecha;
    protected Instant horaPrevista;
    protected Duration duracionPrevista;
    protected Instant horaInicio;
    protected Instant horaFin;

    public Reunion(java.util.Date fecha, Instant horaPrevista, Duration duracionPrevista, Instant horaInicio, Instant horaFin) {
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public abstract void iniciar();
    public abstract void finalizar();

    public List<Asistencia> obtenerAsistencia() {
        return null;
    }

    public List<Asistencia> obtenerAusencias() {
        return null;
    }

    public List<Retraso> obtenerRetrasos() {
        return null;
    }

    public int obtenerTotalAsistencia() {
        return 0;
    }

    public float obtenerPorcentajeAsistencia() {
        return 0;
    }

    public float calcularTiempoReal() {
        return 0;
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
