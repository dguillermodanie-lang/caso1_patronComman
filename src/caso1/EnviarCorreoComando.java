package caso1;

public class EnviarCorreoComando implements Comando {
    private final ServicioCorreo servicio;
    private final String destinatario;
    private final String asunto;

    public EnviarCorreoComando(ServicioCorreo servicio, String destinatario, String asunto) {
        this.servicio = servicio;
        this.destinatario = destinatario;
        this.asunto = asunto;
    }

    @Override
    public void ejecutar() {
        servicio.enviar(destinatario, asunto);
    }

    @Override
    public String getDescripcion() {
        return "Enviar correo a " + destinatario + " (" + asunto + ")";
    }
}