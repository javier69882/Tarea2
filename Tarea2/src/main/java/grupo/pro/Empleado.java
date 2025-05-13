package grupo.pro;

public class Empleado {
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;
    private Departamento departamento;

    public Empleado(String id, String apellidos, String nombre, String correo,Departamento departamento) {
        this.id = id;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.correo = correo;
        this.departamento = departamento;

        departamento.agregarEmpleado(this); //añado altiro al empleado
    }



    public String getId(){
        return id;
    }
    public String getApellidos(){
        return apellidos;
    }
    public String getNombre(){
        return nombre;
    }
    public String getCorreo(){
        return correo;
    }
    public void setId(String id){
        this.id=id;
    }
    public void setApellidos(String apellidos){
        this.apellidos=apellidos;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setCorreo(String correo){
        this.correo=correo;
    }
    public Departamento getDepartamento(){
        return departamento;
    }
    public String toString(){
        return "Empleado: " + nombre + " " + apellidos + ", ID: " + id + ", Correo: " + correo + ", Departamento: " + getDepartamento();
    }
}
