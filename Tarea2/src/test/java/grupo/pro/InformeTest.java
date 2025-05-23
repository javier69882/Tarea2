package grupo.pro;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class InformeTest {

    @Test
    void generarInforme() {
        Date fecha = new Date();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofHours(2);
        TipoReunion tipo = TipoReunion.TECNICA;
        String sala = "Sala A";

        ReunionPresencial reunionPresencial = new ReunionPresencial(fecha, horaPrevista, duracionPrevista, tipo, sala);

        Departamento Informatica = new Departamento("Informática");
        Empleado empleado1 = new Empleado("123", "Pérez", "Juan", "juan.perez@empresa.com", Informatica);
        Empleado empleado2 = new Empleado("1234", "Argomedo", "Javier", "javier.argomedo@empresa.com", Informatica);
        Externo externo1 = new Externo("Vicente", "Garcia", "vicho173@gmail.com");

        reunionPresencial.agregarInvitado(empleado1);
        reunionPresencial.agregarInvitado(empleado2);
        reunionPresencial.agregarInvitado(externo1);

        reunionPresencial.iniciar();
        reunionPresencial.registrarAsistencia(empleado1);
        reunionPresencial.registrarAsistencia(externo1);
        reunionPresencial.agregarNota("Se tuvo una reunion amigable");
        reunionPresencial.agregarNota("Se discutieron todos los temas previstos");
        reunionPresencial.finalizar();

        try {
            String nombreArchivo = "informe_reunion_test.txt";
            Informe.generarInforme(reunionPresencial, nombreArchivo);
            File archivo = new File(nombreArchivo);
            assertTrue(archivo.exists());
            assertTrue(archivo.length() > 0);
            archivo.delete();
        } catch (IOException e) {
            fail("No se pudo generar el informe: " + e.getMessage());
        }
    }
}