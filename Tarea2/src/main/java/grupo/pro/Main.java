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
        String sala = "Sala A";

        ReunionPresencial reunionPresencial = new ReunionPresencial(fecha, horaPrevista, duracionPrevista, sala);
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


        //AGREGA INVITADOS
        reunionPresencial.agregarInvitado(empleado1);
        reunionPresencial.agregarInvitado(empleado2);

        // Invitar a todos los invitados
        for(Invitable invitado : reunionPresencial.getInvitados()){
            invitado.invitar();
        }

        reunionPresencial.iniciar();
        System.out.println("Reunión iniciada a las: " + reunionPresencial.getHoraInicio());
        reunionPresencial.registrarAsistencia(empleado1);

        reunionPresencial.finalizar();
        System.out.println("Reunión finalizada a las: " + reunionPresencial.getHoraFin());

        System.out.println("Presentes:");
        for (Asistencia asistencia : reunionPresencial.obtenerAsistencia()) {
            System.out.println(asistencia);
        }

        System.out.println("\nAusentes:");
        for (Invitable ausente : reunionPresencial.obtenerAusencias()) {
            System.out.println(ausente);
        }



    }
}