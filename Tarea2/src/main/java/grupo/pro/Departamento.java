package grupo.pro;
import java.util.ArrayList;
import java.util.List;

public class Departamento implements Invitable{

    private String nombre;
    private List<Empleado> empleados; // Empleados del departamento

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public int obtenerCantidadEmpleados() {
        return empleados.size();
    }

    @Override
    public void invitar(){
        for(Empleado e : empleados){
            e.invitar();
        }
    }








    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public List<Empleado> getEmpleados(){
        return empleados;
    }
    public void setEmpleados(List<Empleado> empleados){
        this.empleados=empleados;
    }
    public String toString() {
       return  "Departamento: " + nombre + ", Empleados: " + empleados.size();

    }
}
