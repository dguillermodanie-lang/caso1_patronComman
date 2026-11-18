package caso1;

public class ServicioCorreo {
    public void enviar(String destinatario, String asunto) {
        System.out.println("   -> [ServicioCorreo] Enviando correo a '" + destinatario + "' con asunto: \"" + asunto + "\"");
    }
}