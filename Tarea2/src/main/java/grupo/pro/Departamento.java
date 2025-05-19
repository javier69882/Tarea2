package grupo.pro;

import java.util.ArrayList;
import java.util.List;
/**
 * Clase que representa un departamento dentro de una organización, que contiene empleados y permite gestionar su información.
 */

public class Departamento implements Invitable {

    private String nombre;
    private List<Empleado> empleados; // Empleados del departamento
    /**
     * Constructor que inicializa un departamento con un nombre.
     *
     * @param nombre El nombre del departamento.
     * @throws ValorNullException Si el nombre es null o está vacío.
     */

    public Departamento(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new ValorNullException("El nombre del departamento no puede ser null o vacío.");
        }
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    /**
     * Agrega un empleado al departamento.
     *
     * @param empleado El empleado a agregar.
     * @throws ValorNullException Si el empleado es null.
     */

    public void agregarEmpleado(Empleado empleado) {
        if (empleado == null) {
            throw new ValorNullException("No se puede agregar un empleado null al departamento.");
        }
        empleados.add(empleado);
    }
    /**
     * Obtiene la cantidad de empleados en el departamento.
     *
     * @return El número de empleados en el departamento.
     */

    public int obtenerCantidadEmpleados() {
        return empleados.size();
    }
    /**
     * Envía una invitación a todos los empleados del departamento.
     *
     * @throws ValorNullException Si algún empleado en la lista es null.
     */

    @Override
    public void invitar() {
        for (Empleado e : empleados) {
            if (e == null) {
                throw new ValorNullException("Se encontró un empleado null al intentar invitar.");
            }
            e.invitar();
        }
    }


    /**
     * Obtiene el nombre del departamento.
     *
     * @return El nombre del departamento.
     */

    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del departamento.
     *
     * @param nombre El nuevo nombre del departamento.
     * @throws ValorNullException Si el nombre es null o está vacío.
     */

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new ValorNullException("El nombre del departamento no puede ser null o vacío.");
        }
        this.nombre = nombre;
    }


    /**
     * Obtiene la lista de empleados del departamento.
     *
     * @return La lista de empleados.
     */

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    /**
     * Establece la lista de empleados del departamento.
     *
     * @param empleados La nueva lista de empleados.
     * @throws ValorNullException Si la lista de empleados es null.
     */

    public void setEmpleados(List<Empleado> empleados) {
        if (empleados == null) {
            throw new ValorNullException("La lista de empleados no puede ser null.");
        }
        this.empleados = empleados;
    }
    /**
     * @return Una cadena que describe el departamento y la cantidad de empleados.
     */
    public String toString() {
        return "Departamento: " + nombre + ", Empleados: " + empleados.size();
    }
}
