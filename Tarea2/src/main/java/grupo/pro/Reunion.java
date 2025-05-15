package grupo.pro;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.ArrayList;

public abstract class Reunion {
    protected java.util.Date fecha;
    protected Instant horaPrevista;
    protected Duration duracionPrevista;
    protected Instant horaInicio;
    protected Instant horaFin;
    private List<Invitable> invitados=new ArrayList<>();
    private List<Asistencia> presentes = new ArrayList<>();
    private List<Invitable> ausentes = new ArrayList<>();

    public Reunion(java.util.Date fecha, Instant horaPrevista, Duration duracionPrevista) {
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
    }
    public void agregarInvitado(Invitable invitable) {
        invitados.add(invitable);
        ausentes.add(invitable);
    }

    public abstract void iniciar();
    public abstract void finalizar();

    public void registrarAsistencia(Invitable invitable) {
        if (ausentes.contains(invitable)) {
            presentes.add(new Asistencia(invitable, Instant.now()));
            ausentes.remove(invitable);
        } else {
            System.out.println("El invitado ya ha sido registrado o no fue invitado.");
        }
    }


    public List<Asistencia> obtenerAsistencia() {
        return presentes;
    }

    public List<Invitable> obtenerAusencias() {
        return ausentes;
    }

    public int obtenerTotalAsistencia(){
        return presentes.size();
    }

    public float obtenerPorcentajeAsistencia(){
        if(invitados.size()==0){
            return 0;
        }
        else{
            return (float) presentes.size()/invitados.size()*100;
        }
    }



    public List<Retraso> obtenerRetrasos() {
        List<Retraso> retrasos = new ArrayList<>();
        for (Asistencia asistencia : presentes) {
            Instant llegada = asistencia.getHoraLlegada();
            if (llegada.isAfter(horaPrevista)) {
                Duration retraso = Duration.between(horaPrevista, llegada);
                retrasos.add(new Retraso(asistencia.getInvitado(), retraso));
            }
        }
        return retrasos;
    }



    public float calcularTiempoReal() {
        if(horaInicio==null||horaFin==null){
            return 0;
        }
        Duration duracionReal=Duration.between(horaInicio, horaFin);
        return duracionReal.toMinutes();
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
    public List<Invitable> getInvitados(){
        return invitados;
    }
    public String toString(){
        return "Reunion: " + "\n" +
                "Fecha: " + fecha + "\n" +
                "Hora prevista: " + horaPrevista + "\n" +
                "Duracion prevista: " + duracionPrevista + "\n" +
                "Hora inicio: " + horaInicio + "\n" +
                "Hora fin: " + horaFin;
    }
}
