package grupo.pro;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        // Crear una reunión presencial
        Date fecha = new Date();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofHours(2);
        Instant horaInicio = Instant.now();
        Instant horaFin = horaInicio.plus(duracionPrevista);
        String sala = "Sala A";

        ReunionPresencial reunionPresencial = new ReunionPresencial(fecha, horaPrevista, duracionPrevista, horaInicio, horaFin, sala);
        System.out.println(reunionPresencial);

        //creo departamento
        Departamento Informatica = new Departamento("Informática");
        System.out.println(Informatica);


        Empleado empleado1 = new Empleado("123", "Pérez", "Juan", "juan.perez@empresa.com", Informatica);
        System.out.println(empleado1);

        Empleado empleado2 = new Empleado("1234", "Argomedo", "Javier", "javier.argomedo@empresa.com", Informatica);
        System.out.println(empleado2);

        // to string de departamento
        System.out.println(Informatica);




    }
}