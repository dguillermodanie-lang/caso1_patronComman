package caso2;

public class Cuenta {
    private final String usuario;
    private final String password;
    private int intentosFallidos;
    private EstadoCuenta estadoActual;

    public Cuenta(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
        this.intentosFallidos = 0;
        this.estadoActual = new EstadoActiva();
    }

    public void iniciarSesion(String password) {
        estadoActual.iniciarSesion(this, password);
    }

    public void desbloquear() {
        estadoActual.desbloquear(this);
    }

    public void suspender() {
        estadoActual.suspender(this);
    }

    public void setEstado(EstadoCuenta nuevoEstado) {
        String estadoAnterior = this.estadoActual.getNombre();
        this.estadoActual = nuevoEstado;
        System.out.println("[CUENTA " + usuario + "] Estado: " + estadoAnterior + " -> " + nuevoEstado.getNombre());
    }

    public boolean validarPassword(String passwordIngresado) {
        return this.password.equals(passwordIngresado);
    }

    public void incrementarIntentos() {
        this.intentosFallidos++;
    }

    public void reiniciarIntentos() {
        this.intentosFallidos = 0;
    }

    public int getIntentosFallidos() {
        return intentosFallidos;
    }

    public String getUsuario() {
        return usuario;
    }
}