package grupo.pro;
import java.util.Date;
import java.time.Instant;
import java.time.Duration;


/**
 * Subclase que representa una reunión virtual que extiende la clase abstracta {@link Reunion}.
 * Incluye información adicional sobre el enlace de la reunión.
 */
public class ReunionVirtual extends Reunion{
    private String enlace;

    /**
     * Constructor que inicializa una reunión virtual con los parámetros especificados.
     *
     * @param fecha La fecha de la reunión.
     * @param horaPrevista La hora prevista para la reunión.
     * @param duracionPrevista La duración prevista de la reunión.
     * @param tipo El tipo de reunión.
     * @param enlace El enlace de la reunión.
     * @throws ValorNullException Si alguno de los parámetros es nulo o si el enlace está vacío.
     */
    public ReunionVirtual(Date fecha, Instant horaPrevista, Duration duracionPrevista, TipoReunion tipo, String enlace){
        super(fecha, horaPrevista, duracionPrevista, tipo);
        if(enlace==null||enlace.trim().isEmpty()){
            throw new ValorNullException("El enlace no puede ser nulo ni vacío");
        }
        this.enlace=enlace;
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
     * Obtiene el enlace de la reunión.
     *
     * @return El enlace de la reunión.
     */
    public String getEnlace(){
        return enlace;
    }

    /**
     * Establece el enlace de la reunión.
     *
     * @param enlace El nuevo enlace de la reunión.
     * @throws ValorNullException Si el enlace es nulo o está vacío.
     */
    public void setEnlace(String enlace){
        if(enlace==null||enlace.trim().isEmpty()){
            throw new ValorNullException("El enlace no puede ser nulo ni vacío");
        }
        this.enlace=enlace;
    }

    /**
     * Getters y Setters de Reunion.
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
     * Devuelve una cadena de la reunión virtual.
     *
     * @return Una cadena que describe la reunión virtual.
     */
    public String toString(){

        return "Reunion virtual en enlace: " + enlace + "\n" +
                "Fecha: " + fecha + "\n" +
                "Hora prevista: " + horaPrevista + "\n" +
                "Duracion prevista: " + duracionPrevista + "\n" +
                "Hora de inicio: " + horaInicio + "\n" +
                "Hora de fin: " + horaFin;
    }
}
