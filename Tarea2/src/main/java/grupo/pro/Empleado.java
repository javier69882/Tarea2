package grupo.pro;

/**
 * Clase que representa un empleado con información personal y su asociación a un departamento.
 */
public class Empleado extends Persona {
    private String id;
    private Departamento departamento;

    /**
     * Constructor que inicializa un empleado con todos sus atributos y lo agrega a su departamento.
     *
     * @param id                  El identificador unico del empleado.
     * @param apellidos           Los apellidos del empleado.
     * @param nombre              El nombre del empleado.
     * @param correo              El correo electronico del empleado.
     * @param departamento        El departamento al que pertenece el empleado.
     * @throws ValorNullException Si alguno de los parametros es null o vacio.
     */
    public Empleado(String id, String apellidos, String nombre, String correo, Departamento departamento) {
        super(nombre, apellidos, correo);
        if (id == null || id.isBlank()) {
            throw new ValorNullException("El ID del empleado no puede ser null o vacio.");
        }
        if (departamento == null) {
            throw new ValorNullException("El departamento no puede ser null.");
        }
        this.id = id;
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
     * Obtiene el departamento al que pertenece el empleado.
     *
     * @return El departamento del empleado.
     */
    public Departamento getDepartamento() {
        return departamento;
    }

    /**
     * Devuelve una cadena del empleado.
     *
     * @return Una cadena que describe al empleado.
     */
    public String toString() {
        return "Empleado: " + nombre + " " + apellidos + ", ID: " + id + ", Correo: " + correo + ", Departamento: " + getDepartamento();
    }
}