package caso2;

public class EstadoSuspendida implements EstadoCuenta {

    @Override
    public void iniciarSesion(Cuenta cuenta, String password) {
        System.out.println("Cuenta suspendida, comuníquese con el administrador");
    }

    @Override
    public void desbloquear(Cuenta cuenta) {
        cuenta.reiniciarIntentos();
        cuenta.setEstado(new EstadoActiva());
    }

    @Override
    public void suspender(Cuenta cuenta) {
        System.out.println("La cuenta ya está suspendida");
    }

    @Override
    public String getNombre() {
        return "Suspendida";
    }
}