package caso1;

public class GenerarReporteComando implements Comando {
    private final ServicioReportes servicio;
    private final String tipo;

    public GenerarReporteComando(ServicioReportes servicio, String tipo) {
        this.servicio = servicio;
        this.tipo = tipo;
    }

    @Override
    public void ejecutar() {
        servicio.generar(tipo);
    }

    @Override
    public String getDescripcion() {
        return "Generar reporte de " + tipo;
    }
}
