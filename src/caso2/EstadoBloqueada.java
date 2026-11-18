package caso2;

public class EstadoBloqueada implements EstadoCuenta {

    @Override
    public void iniciarSesion(Cuenta cuenta, String password) {
        System.out.println("Cuenta bloqueada por intentos fallidos");
    }

    @Override
    public void desbloquear(Cuenta cuenta) {
        cuenta.reiniciarIntentos();
        cuenta.setEstado(new EstadoActiva());
    }

    @Override
    public void suspender(Cuenta cuenta) {
        cuenta.setEstado(new EstadoSuspendida());
    }

    @Override
    public String getNombre() {
        return "Bloqueada";
    }
}