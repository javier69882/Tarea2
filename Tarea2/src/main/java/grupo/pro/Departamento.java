package grupo.pro;

import java.util.ArrayList;
import java.util.List;

public class Departamento implements Invitable {

    private String nombre;
    private List<Empleado> empleados; // Empleados del departamento

    public Departamento(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new ValorNullException("El nombre del departamento no puede ser null o vacío.");
        }
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        if (empleado == null) {
            throw new ValorNullException("No se puede agregar un empleado null al departamento.");
        }
        empleados.add(empleado);
    }

    public int obtenerCantidadEmpleados() {
        return empleados.size();
    }

    @Override
    public void invitar() {
        for (Empleado e : empleados) {
            if (e == null) {
                throw new ValorNullException("Se encontró un empleado null al intentar invitar.");
            }
            e.invitar();
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new ValorNullException("El nombre del departamento no puede ser null o vacío.");
        }
        this.nombre = nombre;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        if (empleados == null) {
            throw new ValorNullException("La lista de empleados no puede ser null.");
        }
        this.empleados = empleados;
    }

    public String toString() {
        return "Departamento: " + nombre + ", Empleados: " + empleados.size();
    }
}
