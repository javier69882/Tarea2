package grupo.pro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoTest {

    private Departamento departamento;
    private Empleado empleado;

    @BeforeEach
    void setUp() {
        departamento = new Departamento("Informática");
        empleado = new Empleado("123", "Argomedo", "Javier", "javier@correo.com", departamento);
    }

    @Test
    void invitar() {
        assertDoesNotThrow(() -> empleado.invitar());
    }

    @Test
    void getId() {
        assertEquals("123", empleado.getId());
    }

    @Test
    void setId() {
        empleado.setId("456");
        assertEquals("456", empleado.getId());
    }

    @Test
    void getDepartamento() {
        assertEquals(departamento, empleado.getDepartamento());
    }

    @Test
    void testToString() {
        String texto = empleado.toString();
        assertTrue(texto.contains("Empleado: Javier Argomedo"));
        assertTrue(texto.contains("ID: 123"));
        assertTrue(texto.contains("Correo: javier@correo.com"));
        assertTrue(texto.contains("Departamento: "));
    }
}