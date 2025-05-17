package grupo.pro;

public class TipoReunionNoPermitidoException extends RuntimeException{
  public TipoReunionNoPermitidoException(String mensaje){
    super(mensaje);
  }
}