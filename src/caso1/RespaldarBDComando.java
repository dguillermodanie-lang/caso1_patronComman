package caso1;

public class RespaldarBDComando implements Comando {
    private final ServicioRespaldo servicio;
    private final String baseDatos;

    public RespaldarBDComando(ServicioRespaldo servicio, String baseDatos) {
        this.servicio = servicio;
        this.baseDatos = baseDatos;
    }

    @Override
    public void ejecutar() {
        servicio.respaldar(baseDatos);
    }

    @Override
    public String getDescripcion() {
        return "Respaldar base de datos '" + baseDatos + "'";
    }
}