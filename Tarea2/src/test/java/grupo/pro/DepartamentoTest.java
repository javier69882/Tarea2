package grupo.pro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepartamentoTest{

    private Departamento departamento;
    private Empleado empleado1;
    private Empleado empleado2;

    @BeforeEach
    void setUp() {
        departamento = new Departamento("Informática");
        empleado1 = new Empleado("001", "Argomedo", "Javier", "javier@correo.com", departamento);
        empleado2 = new Empleado("002", "García", "Vicente", "vicente@correo.com", departamento);
    }

    @Test
    void agregarEmpleado() {
        Departamento d = new Departamento("Finanzas");
        Empleado emp = new Empleado("003", "López", "Carlos", "carlos@correo.com", d);
        assertTrue(d.getEmpleados().contains(emp));
    }

    @Test
    void obtenerCantidadEmpleados() {
        assertEquals(2, departamento.obtenerCantidadEmpleados());
    }

    @Test
    void invitar() {
        assertDoesNotThrow(() -> departamento.invitar());
    }

    @Test
    void getNombre() {
        assertEquals("Informática", departamento.getNombre());
    }

    @Test
    void setNombre() {
        departamento.setNombre("Recursos Humanos");
        assertEquals("Recursos Humanos", departamento.getNombre());
    }

    @Test
    void getEmpleados() {
        List<Empleado> empleados = departamento.getEmpleados();
        assertEquals(2, empleados.size());
        assertTrue(empleados.contains(empleado1));
        assertTrue(empleados.contains(empleado2));
    }

    @Test
    void setEmpleados() {
        List<Empleado> nuevos = new ArrayList<>();
        Empleado nuevoEmp = new Empleado("004", "Rojas", "Luis", "luis@correo.com", departamento);
        nuevos.add(nuevoEmp);
        departamento.setEmpleados(nuevos);
        assertEquals(1, departamento.obtenerCantidadEmpleados());
        assertTrue(departamento.getEmpleados().contains(nuevoEmp));
    }

    @Test
    void testToString() {
        String resultado = departamento.toString();
        assertTrue(resultado.contains("Departamento: Informática"));
        assertTrue(resultado.contains("Empleados: 2"));
    }
}