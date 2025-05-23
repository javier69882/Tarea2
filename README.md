# Tarea2
Vicente Garcia
Javier van Rysselberghe

Principales cambios del proyecto a partir del UML ya dado
se creo el toString de cada clase, los getter y setter, ademas se manejo exepciones de valores null y IOException
-Asistencia
Estaba vacio en el UML se agrego lo siguiente
 private Invitable invitado;
 private Instant horaLlegada;
 Constructor por defecto
 Constructor con (invitado,horallegada)
 Con lo que agregamos podemos registrar al empleado y su hora de llegada

 -Departamento
  private List<Empleado> empleados; Se agrego para usarlo como contenedor de emepleados
  Constructor(nombre) para crearlo

  -Persona 
  Para poder invitar externos y empleados a las reuniones
  variables protegidas para que erede

  -Externos
  personas que se pueden invitar pero que no son de los departamentos, hijo de Persona

  -Empleados 
  empleados que se pueden invitar hijo de persona

  -Informe 
  crea un archivo de texto nuevo con el nombre que uno quiera
  y lo rellena con toda la informacion de la reunion
  Lo creamos porque lo pedia la pauta

  -Invitacion 
  Cambios minimos
  Se creo su constructor que recibe la hora en que se envio
  Sirve para mostrar la hora de invitacion y manda la invitacion con un mensaje

 -Nota
 Se le agrego fecha y hora y un metodo para asignar la fecha y hora, no lo hemos usado, porque sin tener fecha y hora, ya estan ordenadas cronologicamente porque se guardan en una lista en reunion

 -Retraso 
 cambiamos hora instant por duracion, para guardar la durcacion del retrado
 Se guardan en una lista en reunion que usa obtener retraso

 -Reunion
 Todas las variables private del UML dado las cambiamos por protected para que se herede
 agregamos Tipo de reunion para saber el tipo de reunion
 List<Invitable> invitados, para guardar a los invitados
 private List<Asistencia> presentes, guarda a los presentes
 private List<Invitable> ausentes, guarda a los ausentes
  private List<Nota> notas, guarda las notas cronologicamente
  Metodo agregar invitado, para llenar la lista de ausente y invitados con los invitados y luego calcular asistencia
Metodo registrarAsistencia, registra la asistencia viendo la lista de ausentes, y si esta los quita de la lista de ausentes y los añade a presentes como objeto de asistencia 
Metodo obtenerRetrasos, revisa que si allguien llego tarde y si llego tarde crea objeto de retraso, para calcular su retraso y lo añade a la lista de eretrasos
Metodo agregarNota crea un objeto de nota y lo mete a la lista de notas

-Reunion presencial
SE MANTUVO

-Reunion virtual 
SE MANTUVO

Enlace UML https://miro.com/welcomeonboard/KzNKbjRoS25WdXYwTE90eE9vbmd3aC9UN3BYcENBS2NIcTRjVURkSTcxdnR2em9Lb2V5dXdwS0ZVbWVKdkZnNVB0MnpIa09DelVRQ2ZFS1B5ZXB6T0ZNUTBVUkk1bFJmT1owV0dXL3NrYW9sZHU4ai9DbkhNMm9IZkcxRzNsdUdhWWluRVAxeXRuUUgwWDl3Mk1qRGVRPT0hdjE=?share_link_id=468272383375
 
