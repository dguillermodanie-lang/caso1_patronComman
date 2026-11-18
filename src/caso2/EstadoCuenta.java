package caso2;

public interface EstadoCuenta {
    void iniciarSesion(Cuenta cuenta, String password);
    void desbloquear(Cuenta cuenta);
    void suspender(Cuenta cuenta);
    String getNombre();
}