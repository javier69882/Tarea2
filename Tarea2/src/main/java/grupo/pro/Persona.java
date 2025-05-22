package grupo.pro;


/**
 * Clase abstracta que representa una persona con nombre, apellidos y correo electrónico.
 * Implementa la interfaz {@link Invitable}.
 */

public abstract class Persona implements Invitable {
    protected String nombre;
    protected String apellidos;
    protected String correo;



    /**
     * Constructor que inicializa una persona con los datos especificados.
     *
     * @param nombre              El nombre de la persona.
     * @param apellidos           Los apellidos de la persona.
     * @param correo              El correo electrónico de la persona.
     * @throws ValorNullException Si alguno de los parámetros es null o está vacío.
     */

    public Persona(String nombre, String apellidos, String correo) {
        if (nombre == null || nombre.isBlank()) {
            throw new ValorNullException("El nombre no puede ser null o vacío.");
        }
        if (apellidos == null || apellidos.isBlank()) {
            throw new ValorNullException("Los apellidos no pueden ser null o vacíos.");
        }
        if (correo == null || correo.isBlank()) {
            throw new ValorNullException("El correo no puede ser null o vacío.");
        }
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
    }




    /**
     * Obtiene el nombre de la persona.
     *
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }



    /**
     * Obtiene los apellidos de la persona.
     *
     * @return Los apellidos de la persona.
     */
    public String getApellidos() {
        return apellidos;
    }



    /**
     * Obtiene el correo electrónico de la persona.
     *
     * @return El correo electrónico de la persona.
     */
    public String getCorreo() {
        return correo;
    }



    /**
     * Establece el nombre de la persona.
     *
     * @param nombre El nuevo nombre de la persona.
     * @throws ValorNullException Si el nombre es null o está vacío.
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new ValorNullException("El nombre no puede ser null o vacío.");
        }
        this.nombre = nombre;
    }



    /**
     * Establece los apellidos de la persona.
     *
     * @param apellidos Los nuevos apellidos de la persona.
     * @throws ValorNullException Si los apellidos son null o están vacíos.
     */
    public void setApellidos(String apellidos) {
        if (apellidos == null || apellidos.isBlank()) {
            throw new ValorNullException("Los apellidos no pueden ser null o vacíos.");
        }
        this.apellidos = apellidos;
    }



    /**
     * Establece el correo electrónico de la persona.
     *
     * @param correo El nuevo correo electrónico de la persona.
     * @throws ValorNullException Si el correo es null o está vacío.
     */
    public void setCorreo(String correo) {
        if (correo == null || correo.isBlank()) {
            throw new ValorNullException("El correo no puede ser null o vacío.");
        }
        this.correo = correo;
    }



    /**
     * Devuelve una cadena de la persona.
     *
     * @return Una cadena que describe a la persona con su nombre, apellidos y correo.
     */
    @Override
    public String toString() {
        return nombre + " " + apellidos + ", Correo: " + correo;
    }
}
