package grupo.pro;
/**
 *Clase que representa un empleado con información personal y su asociación a un departamento.
 */
public class Empleado implements Invitable {
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;
    private Departamento departamento;


    /**
     * Constructor que inicializa un empleado con todos sus atributos y lo agrega a su departamento.
     *
     * @param id          El identificador único del empleado.
     * @param apellidos   Los apellidos del empleado.
     * @param nombre      El nombre del empleado.
     * @param correo      El correo electrónico del empleado.
     * @param departamento El departamento al que pertenece el empleado.
     * @throws ValorNullException Si alguno de los parámetros es null o vacío.
     */
    public Empleado(String id, String apellidos, String nombre, String correo, Departamento departamento) {
        if (id == null || id.isBlank()) {
            throw new ValorNullException("El ID del empleado no puede ser null o vacío.");
        }
        if (apellidos == null || apellidos.isBlank()) {
            throw new ValorNullException("Los apellidos no pueden ser null o vacíos.");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new ValorNullException("El nombre no puede ser null o vacío.");
        }
        if (correo == null || correo.isBlank()) {
            throw new ValorNullException("El correo no puede ser null o vacío.");
        }
        if (departamento == null) {
            throw new ValorNullException("El departamento no puede ser null.");
        }

        this.id = id;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.correo = correo;
        this.departamento = departamento;

        departamento.agregarEmpleado(this); //añado altiro al empleado
    }

    /**
     * Envía una invitación al empleado.
     */
    @Override
    public void invitar() {
        System.out.println("Invitación enviada a: " + nombre + " " + apellidos + ", correo: " + correo);
    }

    /**
     * Obtiene el identificador único del empleado.
     *
     * @return El ID del empleado.
     */
    public String getId() {
        return id;
    }

    /**
     * Obtiene los apellidos del empleado.
     *
     * @return Los apellidos del empleado.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Obtiene el nombre del empleado.
     *
     * @return El nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el correo electrónico del empleado.
     *
     * @return El correo del empleado.
     */
    public String getCorreo() {
        return correo;
    }


    /**
     * Establece el ID único del empleado.
     *
     * @param id El nuevo ID del empleado.
     * @throws ValorNullException Si el ID es null o está vacío.
     */
    public void setId(String id) {
        if (id == null || id.isBlank()) {
            throw new ValorNullException("El ID no puede ser null o vacío.");
        }
        this.id = id;
    }

    /**
     * Establece los apellidos del empleado.
     *
     * @param apellidos Los nuevos apellidos del empleado.
     * @throws ValorNullException Si los apellidos son null o están vacíos.
     */
    public void setApellidos(String apellidos) {
        if (apellidos == null || apellidos.isBlank()) {
            throw new ValorNullException("Los apellidos no pueden ser null o vacíos.");
        }
        this.apellidos = apellidos;
    }

    /**
     * Establece el nombre del empleado.
     *
     * @param nombre El nuevo nombre del empleado.
     * @throws ValorNullException Si el nombre es null o está vacío.
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new ValorNullException("El nombre no puede ser null o vacío.");
        }
        this.nombre = nombre;
    }
    /**
     * Establece el correo electrónico del empleado.
     *
     * @param correo El nuevo correo del empleado.
     * @throws ValorNullException Si el correo es null o está vacío.
     */
    public void setCorreo(String correo) {
        if (correo == null || correo.isBlank()) {
            throw new ValorNullException("El correo no puede ser null o vacío.");
        }
        this.correo = correo;
    }
    /**
     * Obtiene el departamento al que pertenece el empleado.
     *
     * @return El departamento del empleado.
     */
    public Departamento getDepartamento() {
        return departamento;
    }

    /**
     * Devuelve una representación en cadena del empleado.
     *
     * @return Una cadena que describe al empleado.
     */
    public String toString() {
        return "Empleado: " + nombre + " " + apellidos + ", ID: " + id + ", Correo: " + correo + ", Departamento: " + getDepartamento();
    }
}
