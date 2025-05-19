package grupo.pro;
import java.util.Date;
import java.time.Instant;
import java.time.Duration;

/**
 * Subclase que epresenta una reunión presencial que extiende la clase abstracta {@link Reunion}.
 * Incluye información adicional sobre la sala donde se llevará a cabo la reunión.
 */
public class ReunionPresencial extends Reunion {
    private String sala;


    /**
     * Constructor que inicializa una reunión presencial con los parámetros especificados.
     *
     * @param fecha La fecha de la reunión.
     * @param horaPrevista La hora prevista para la reunión.
     * @param duracionPrevista La duración prevista de la reunión.
     * @param tipo El tipo de reunión.
     * @param sala La sala donde se llevará a cabo la reunión.
     * @throws ValorNullException Si alguno de los parámetros es nulo o si la sala está vacía.
     */
    public ReunionPresencial(Date fecha, Instant horaPrevista, Duration duracionPrevista, TipoReunion tipo, String sala){
        super(fecha, horaPrevista, duracionPrevista, tipo);
        if (sala==null||sala.trim().isEmpty()){
            throw new ValorNullException("La sala no puede ser nula ni vacía.");
        }
        this.sala = sala;
    }


    /**
     * Inicia la reunión estableciendo la hora de inicio al momento actual.
     */
    @Override
    public void iniciar() {
        this.horaInicio=Instant.now();
    }


    /**
     * Finaliza la reunión estableciendo la hora de fin al momento actual.
     */
    @Override
    public void finalizar() {
        this.horaFin=Instant.now();
    }







    /**
     * Obtiene la sala donde se llevará a cabo la reunión.
     *
     * @return La sala de la reunión.
     */
    public String getSala(){
        return sala;
    }

    /**
     * Establece la sala donde se llevará a cabo la reunión.
     *
     * @param sala La nueva sala de la reunión.
     * @throws ValorNullException Si la sala es nula o está vacía.
     */
    public void setSala(String sala){
        if (sala==null||sala.trim().isEmpty()){
            throw new ValorNullException("La sala no puede ser nula ni vacía.");
        }
        this.sala=sala;
    }
    /**
     * Getters y Setters ya vistos en Reunion.
     *
     */
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


    /**
     * Devuelve una cadena de la reunión presencial.
     *
     * @return Una cadena que describe la reunión presencial.
     */
    public String toString(){
        return "Reunion presencial en sala: " + sala + "\n" +
                "Fecha: " + fecha + "\n" +
                "Hora prevista: " + horaPrevista + "\n" +
                "Duracion prevista: " + duracionPrevista + "\n" +
                "Hora inicio: " + horaInicio + "\n" +
                "Hora fin: " + horaFin;
    }
}
