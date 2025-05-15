package grupo.pro;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Informe {
    public static void generarInforme(Reunion reunion, String nombreArchivo) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo));

        writer.write("------- INFORME DE REUNIÓN -------\n\n");
        writer.write("Fecha: " + reunion.getFecha() + "\n");
        writer.write("Hora prevista: " + reunion.getHoraPrevista() + "\n");
        writer.write("Hora de inicio real: " + reunion.getHoraInicio() + "\n");
        writer.write("Hora de fin: " + reunion.getHoraFin() + "\n");
        writer.write("Duración real (minutos): " + reunion.calcularTiempoReal() + "\n\n");

        if (reunion instanceof ReunionVirtual) {
            writer.write("Tipo: Virtual\n");
            writer.write("Enlace: " + ((ReunionVirtual) reunion).getEnlace() + "\n\n");
        } else if (reunion instanceof ReunionPresencial) {
            writer.write("Tipo: Presencial\n");
            writer.write("Sala: " + ((ReunionPresencial) reunion).getSala() + "\n\n");
        }

        writer.write("Participantes y asistencia:\n");
        int totalInvitados = reunion.getInvitados().size();
        int totalPresentes = reunion.obtenerAsistencia().size();
        int totalAusentes = reunion.obtenerAusencias().size();
        float porcentaje = reunion.obtenerPorcentajeAsistencia();
        writer.write("Total invitados: " + totalInvitados + "\n");
        writer.write("Presentes: " + totalPresentes + "\n");
        writer.write("Ausentes: " + totalAusentes + "\n");
        writer.write("Porcentaje de asistencia: " + porcentaje + "%\n\n");

        for (Invitable inv : reunion.getInvitados()) {
            String estado = "Ausente";
            for (Asistencia a : reunion.obtenerAsistencia()) {
                if (a.getInvitado().equals(inv)) {
                    estado = "Presente";
                    if (a.getHoraLlegada().isAfter(reunion.getHoraPrevista())) {
                        Duration retraso = Duration.between(reunion.getHoraPrevista(), a.getHoraLlegada());
                        estado = "Tarde (" + retraso.toMinutes() + " min)";
                    }
                }
            }
            if (inv instanceof Empleado) {
                Empleado emp = (Empleado) inv;
                writer.write("- Empleado: " + emp.getNombre() + " " + emp.getApellidos() + ", ID: " + emp.getId() + ", Correo: " + emp.getCorreo()
                        + ", Departamento: " + emp.getDepartamento().getNombre() + ", Asistencia: " + estado + "\n");
            } else {
                writer.write("- Invitado: " + inv.toString() + " * Asistencia: " + estado + "\n");
            }
        }

        writer.write("\nNotas registradas:\n");
        List<Nota> notas = reunion.obtenerNotas();
        if (notas.isEmpty()) {
            writer.write(" (No se registraron notas)\n");
        } else {
            for (Nota nota : notas) {
                writer.write(" * " + nota.getContenido() + "\n");
            }
        }

        writer.write("\n------- FIN DEL INFORME -------\n");

        writer.close();
    }
}
