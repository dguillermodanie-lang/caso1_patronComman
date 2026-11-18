package caso2;

/*
 * Patrón elegido: State (Comportamiento).
 * Justificación: Permite que el objeto Cuenta altere su comportamiento ante el inicio de sesión, desbloqueo
 * o suspensión cuando cambia su estado interno (Activa, Bloqueada, Suspendida). Evita condicionales complejos
 * en la clase Cuenta delegando cada regla de negocio y transición a clases de estado independientes.
 */
public class Main {
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta("Delgado", "ClaveSegura123");

        System.out.println("=== 1. INGRESO CORRECTO ===");
        cuenta.iniciarSesion("ClaveSegura123");

        System.out.println("\n=== 2. TRES INGRESOS INCORRECTOS ===");
        cuenta.iniciarSesion("mal1");
        cuenta.iniciarSesion("mal2");
        cuenta.iniciarSesion("mal3");

        System.out.println("\n=== 3. INGRESO CON CONTRASEÑA CORRECTA ESTANDO BLOQUEADA ===");
        cuenta.iniciarSesion("ClaveSegura123");

        System.out.println("\n=== 4. DESBLOQUEAR E INGRESAR DE NUEVO ===");
        cuenta.desbloquear();
        cuenta.iniciarSesion("ClaveSegura123");

        System.out.println("\n=== 5. SUSPENDER CUENTA E INTENTAR INGRESAR ===");
        cuenta.suspender();
        cuenta.iniciarSesion("ClaveSegura123");
    }
}