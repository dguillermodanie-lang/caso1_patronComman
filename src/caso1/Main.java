package caso1;

/*
 * Patrón elegido: Command (Comportamiento).
 * Justificación: Encapsula cada tarea (envío de correo, reporte, respaldo) como un objeto independiente
 * con los datos y el receptor necesarios para ejecutarse diferidamente. Esto desacopla completamente
 * la cola de ejecución (invocador) de los servicios reales, permitiendo agregar nuevas tareas sin modificar la cola.
 */
public class Main {
    public static void main(String[] args) {
        // 1. Instanciar los receptores (servicios)
        ServicioCorreo servicioCorreo = new ServicioCorreo();
        ServicioReportes servicioReportes = new ServicioReportes();
        ServicioRespaldo servicioRespaldo = new ServicioRespaldo();

        // 2. Instanciar el invocador (cola de tareas)
        ColaTareas cola = new ColaTareas();

        // 3. Crear y encolar al menos 4 tareas (no se ejecutan todavía)
        cola.agregar(new EnviarCorreoComando(servicioCorreo, "ana.gomez@correo.com", "Confirmación de compra #1024"));
        cola.agregar(new EnviarCorreoComando(servicioCorreo, "carlos.ruiz@correo.com", "Factura electrónica #1025"));
        cola.agregar(new GenerarReporteComando(servicioReportes, "Ventas Diarias Consolidado"));
        cola.agregar(new RespaldarBDComando(servicioRespaldo, "BD_Ventas_Prod"));

        // 4. Procesar la cola
        System.out.println("=== INICIANDO PROCESAMIENTO DE TAREAS DE CIERRE ===");
        cola.ejecutarTodas();

        // 5. Mostrar historial de tareas ejecutadas
        cola.mostrarHistorial();

        // 6. Intentar ejecutar nuevamente con la cola vacía
        System.out.println("=== VERIFICANDO COLA NUEVAMENTE ===");
        cola.ejecutarTodas();
    }
}