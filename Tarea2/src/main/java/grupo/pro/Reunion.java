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
    private TipoReunion tipo;
    private List<Invitable> invitados=new ArrayList<>();
    private List<Asistencia> presentes = new ArrayList<>();
    private List<Invitable> ausentes = new ArrayList<>();
    private List<Nota> notas=new ArrayList<>();

    public Reunion(java.util.Date fecha, Instant horaPrevista, Duration duracionPrevista, TipoReunion tipo){
        if(fecha==null){
            throw new ValorNullException("La fecha no puede ser nula");
        }
        if(horaPrevista==null){
            throw new ValorNullException("La hora prevista no puede ser nula");
        }
        if(duracionPrevista==null || duracionPrevista.isNegative() || duracionPrevista.isZero()){
            throw new ValorNullException("La duración prevista debe ser mayor a cero");
        }
        if(tipo==null){
            throw new ValorNullException("El tipo de reunión no puede ser nulo");
        }
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.tipo = tipo;
    }

    public void agregarInvitado(Invitable invitable){
        if(invitable==null){
            throw new ValorNullException("No se puede agregar un invitado nulo");
        }
        invitados.add(invitable);
        ausentes.add(invitable);
    }

    public abstract void iniciar();
    public abstract void finalizar();

    public void registrarAsistencia(Invitable invitable){
        if(invitable == null){
            throw new ValorNullException("No se puede registrar asistencia de un invitado nulo");
        }
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

    public void agregarNota(String contenido){
        if(contenido==null || contenido.trim().isEmpty()){
            throw new ValorNullException("La nota no puede estar vacía");
        }
        notas.add(new Nota(contenido));
    }
    public void agregarNota(Nota nota){
        if(nota==null){
            throw new ValorNullException("No se puede agregar una nota nula");
        }
        notas.add(nota);
    }
    public List<Nota> obtenerNotas() {
        return notas;
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
        if(fecha==null){
            throw new ValorNullException("La fecha no puede ser nula");
        }
        this.fecha=fecha;
    }
    public void setHoraPrevista(Instant horaPrevista){
        if(horaPrevista==null){
            throw new ValorNullException("La hora prevista no puede ser nula");
        }
        this.horaPrevista=horaPrevista;
    }
    public void setDuracionPrevista(Duration duracionPrevista){
        if(duracionPrevista==null || duracionPrevista.isNegative() || duracionPrevista.isZero()){
            throw new ValorNullException("La duración prevista debe ser mayor a cero");
        }
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
    public TipoReunion getTipo() {
        return tipo;
    }
    public void setTipo(TipoReunion tipo){
        if(tipo==null){
            throw new ValorNullException("El tipo no puede ser nulo");
        }
        try{
            TipoReunion.valueOf(tipo.name());
        }
        catch(IllegalArgumentException e){
            throw new TipoReunionNoPermitidoException("Tipo de reunión no permitido: " + tipo);
        }
        this.tipo = tipo;
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
