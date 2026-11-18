package caso2;

public class EstadoActiva implements EstadoCuenta {

    @Override
    public void iniciarSesion(Cuenta cuenta, String password) {
        if (cuenta.validarPassword(password)) {
            cuenta.reiniciarIntentos();
            System.out.println("[LOGIN] Bienvenido, " + cuenta.getUsuario());
        } else {
            cuenta.incrementarIntentos();
            int intentos = cuenta.getIntentosFallidos();
            System.out.println("[LOGIN] Contraseña incorrecta (intento " + intentos + " de 3)");
            if (intentos >= 3) {
                cuenta.setEstado(new EstadoBloqueada());
            }
        }
    }

    @Override
    public void desbloquear(Cuenta cuenta) {
        System.out.println("La cuenta ya está activa");
    }

    @Override
    public void suspender(Cuenta cuenta) {
        cuenta.setEstado(new EstadoSuspendida());
    }

    @Override
    public String getNombre() {
        return "Activa";
    }
}