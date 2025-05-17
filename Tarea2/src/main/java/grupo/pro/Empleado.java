package grupo.pro;

public class Empleado implements Invitable {
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;
    private Departamento departamento;

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

    @Override
    public void invitar() {
        System.out.println("Invitación enviada a: " + nombre + " " + apellidos + ", correo: " + correo);
    }

    public String getId() {
        return id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setId(String id) {
        if (id == null || id.isBlank()) {
            throw new ValorNullException("El ID no puede ser null o vacío.");
        }
        this.id = id;
    }

    public void setApellidos(String apellidos) {
        if (apellidos == null || apellidos.isBlank()) {
            throw new ValorNullException("Los apellidos no pueden ser null o vacíos.");
        }
        this.apellidos = apellidos;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new ValorNullException("El nombre no puede ser null o vacío.");
        }
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        if (correo == null || correo.isBlank()) {
            throw new ValorNullException("El correo no puede ser null o vacío.");
        }
        this.correo = correo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public String toString() {
        return "Empleado: " + nombre + " " + apellidos + ", ID: " + id + ", Correo: " + correo + ", Departamento: " + getDepartamento();
    }
}
