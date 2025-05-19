package grupo.pro;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.ArrayList;

/**
 * Clase abstracta que representa una reunión con detalles como fecha, hora prevista, duración, tipo, invitados,
 * asistencia, ausencias y notas.
 */
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

    /**
     * Clase abstracta que representa una reunión con detalles como fecha, hora prevista, duración, tipo, invitados,
     * asistencia, ausencias y notas.
     */
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

    /**
     * Agrega un invitado a la reunión.
     *
     * @param invitable El invitado a agregar.
     * @throws ValorNullException Si el invitado es nulo.
     */
    public void agregarInvitado(Invitable invitable){
        if(invitable==null){
            throw new ValorNullException("No se puede agregar un invitado nulo");
        }
        invitados.add(invitable);
        ausentes.add(invitable);
    }

    /**
     * Método abstracto para iniciar la reunión.
     */
    public abstract void iniciar();

    /**
     * Método abstracto para finalizar la reunión.
     */
    public abstract void finalizar();

    /**
     * Registra la asistencia de un invitado.
     *
     * @param invitable El invitado que asiste.
     * @throws ValorNullException Si el invitado es nulo.
     */
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

    /**
     * Obtiene la lista de asistentes presentes.
     *
     * @return Una lista de objetos de tipo Asistencia.
     */
    public List<Asistencia> obtenerAsistencia() {
        return presentes;
    }

    /**
     * Obtiene la lista de invitados ausentes.
     *
     * @return Una lista de objetos de tipo Invitable.
     */
    public List<Invitable> obtenerAusencias() {
        return ausentes;
    }


    /**
     * Obtiene el total de asistentes presentes.
     *
     * @return El número total de asistentes presentes.
     */
    public int obtenerTotalAsistencia(){
        return presentes.size();
    }

    /**
     * Calcula el porcentaje de asistencia.
     *
     * @return El porcentaje de asistencia como un valor flotante.
     */
    public float obtenerPorcentajeAsistencia(){
        if(invitados.size()==0){
            return 0;
        }
        else{
            return (float) presentes.size()/invitados.size()*100;
        }
    }


    /**
     * Obtiene la lista de retrasos de los asistentes.
     *
     * @return Una lista de objetos de tipo Retraso.
     */
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


    /**
     * Calcula el tiempo real de duración de la reunión.
     *
     * @return La duración real en minutos.
     */
    public float calcularTiempoReal() {
        if(horaInicio==null||horaFin==null){
            return 0;
        }
        Duration duracionReal=Duration.between(horaInicio, horaFin);
        return duracionReal.toMinutes();
    }

    /**
     * Agrega una nota a la reunión.
     *
     * @param contenido El contenido de la nota.
     * @throws ValorNullException Si el contenido es nulo o vacío.
     */
    public void agregarNota(String contenido){
        if(contenido==null || contenido.trim().isEmpty()){
            throw new ValorNullException("La nota no puede estar vacía");
        }
        notas.add(new Nota(contenido));
    }

    /**
     * Agrega una nota a la reunión.
     *
     * @param nota La nota a agregar.
     * @throws ValorNullException Si la nota es nula.
     */
    public void agregarNota(Nota nota){
        if(nota==null){
            throw new ValorNullException("No se puede agregar una nota nula");
        }
        notas.add(nota);
    }

    /**
     * Obtiene la lista de notas de la reunión.
     *
     * @return Una lista de objetos de tipo Nota.
     */
    public List<Nota> obtenerNotas() {
        return notas;
    }






    /**
     * Obtiene la fecha de la reunión.
     *
     * @return La fecha de la reunión.
     */
    public java.util.Date getFecha(){
        return fecha;
    }

    /**
     * Obtiene la hora prevista de la reunión.
     *
     * @return La hora prevista de la reunión.
     */
    public Instant getHoraPrevista(){
        return horaPrevista;
    }

    /**
     * Obtiene la duración prevista de la reunión.
     *
     * @return La duración prevista de la reunión.
     */
    public Duration getDuracionPrevista(){
        return duracionPrevista;
    }

    /**
     * Obtiene la hora de inicio de la reunión.
     *
     * @return La hora de inicio de la reunión.
     */
    public Instant getHoraInicio(){
        return horaInicio;
    }

    /**
     * Obtiene la hora de fin de la reunión.
     *
     * @return La hora de fin de la reunión.
     */
    public Instant getHoraFin(){
        return horaFin;
    }

    /**
     * Establece la fecha de la reunión.
     *
     * @param fecha La nueva fecha de la reunión.
     * @throws ValorNullException Si la fecha es nula.
     */
    public void setFecha(java.util.Date fecha){
        if(fecha==null){
            throw new ValorNullException("La fecha no puede ser nula");
        }
        this.fecha=fecha;
    }

    /**
     * Establece la hora prevista de la reunión.
     *
     * @param horaPrevista La nueva hora prevista de la reunión.
     * @throws ValorNullException Si la hora prevista es nula.
     */
    public void setHoraPrevista(Instant horaPrevista){
        if(horaPrevista==null){
            throw new ValorNullException("La hora prevista no puede ser nula");
        }
        this.horaPrevista=horaPrevista;
    }

    /**
     * Establece la duración prevista de la reunión.
     *
     * @param duracionPrevista La nueva duración prevista de la reunión.
     * @throws ValorNullException Si la duración prevista es nula o menor o igual a cero.
     */
    public void setDuracionPrevista(Duration duracionPrevista){
        if(duracionPrevista==null || duracionPrevista.isNegative() || duracionPrevista.isZero()){
            throw new ValorNullException("La duración prevista debe ser mayor a cero");
        }
        this.duracionPrevista=duracionPrevista;
    }

    /**
     * Establece la hora de inicio de la reunión.
     *
     * @param horaInicio La nueva hora de inicio de la reunión.
     * @throws ValorNullException Si la hora de inicio es nula.
     */
    public void setHoraInicio(Instant horaInicio){
        this.horaInicio=horaInicio;
    }

    /**
     * Establece la hora de fin de la reunión.
     *
     * @param horaFin La nueva hora de fin de la reunión.
     * @throws ValorNullException Si la hora de fin es nula.
     */
    public void setHoraFin(Instant horaFin){
        this.horaFin=horaFin;
    }

    /**
     * Obtiene la lista de invitados a la reunión.
     *
     * @return Una lista de objetos de tipo Invitable.
     */
    public List<Invitable> getInvitados(){
        return invitados;
    }

    /**
     * Obtiene el tipo de reunión.
     *
     * @return El tipo de reunión.
     */
    public TipoReunion getTipo() {
        return tipo;
    }
    /**
     * Establece el tipo de reunión.
     *
     * @param tipo El nuevo tipo de reunión.
     * @throws ValorNullException Si el tipo es nulo.
     * @throws TipoReunionNoPermitidoException Si el tipo no es permitido.
     */
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

    /**
     * Devuelve una cadena de la reunión.
     *
     * @return Una cadena que describe la reunión.
     */
    public String toString(){
        return "Reunion: " + "\n" +
                "Fecha: " + fecha + "\n" +
                "Hora prevista: " + horaPrevista + "\n" +
                "Duracion prevista: " + duracionPrevista + "\n" +
                "Hora inicio: " + horaInicio + "\n" +
                "Hora fin: " + horaFin;
    }

}
