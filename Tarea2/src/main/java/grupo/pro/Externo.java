
package grupo.pro;

/**
 * Clase que representa a una persona externa invitada a una reunión.
 */
public class Externo extends Persona {

    /**
     * Constructor que inicializa un invitado externo con su información personal.
     *
     * @param nombre    Nombre del invitado externo.
     * @param apellidos Apellidos del invitado externo.
     * @param correo    Correo electrónico del invitado externo.
     * @throws ValorNullException Si algún campo es null o vacío.
     */
    public Externo(String nombre, String apellidos, String correo) {
        super(nombre, apellidos, correo);
    }

    /**
     * Envía una invitación al invitado externo.
     */
    @Override
    public void invitar() {
        System.out.println("Invitación enviada a externo: " + nombre + " " + apellidos + ", correo: " + correo);
    }
    /**
     * Devuelve una cadena de la persona.
     *
     * @return Una cadena que describe a la persona con su nombre, apellidos y correo.
     */
    @Override
    public String toString() {
        return "Externo: " + nombre + " " + apellidos + ", Correo: " + correo;
    }
}
