package caso1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ColaTareas {
    private final Queue<Comando> pendientes = new LinkedList<>();
    private final List<String> historial = new ArrayList<>();

    public void agregar(Comando c) {
        pendientes.offer(c);
    }

    public void ejecutarTodas() {
        if (pendientes.isEmpty()) {
            System.out.println("[AVISO] No hay tareas pendientes");
            return;
        }

        int total = pendientes.size();
        int indice = 1;

        while (!pendientes.isEmpty()) {
            Comando comando = pendientes.poll();
            System.out.println("[TAREA " + indice + "/" + total + "] " + comando.getDescripcion());
            comando.ejecutar();
            historial.add(comando.getDescripcion());
            indice++;
        }
    }

    public void mostrarHistorial() {
        System.out.println("\n--- HISTORIAL DE TAREAS PROCESADAS ---");
        if (historial.isEmpty()) {
            System.out.println("No se han ejecutado tareas aún.");
        } else {
            for (int i = 0; i < historial.size(); i++) {
                System.out.println((i + 1) + ". " + historial.get(i));
            }
        }
        System.out.println("--------------------------------------\n");
    }
}