package org.example;

import org.example.Deportista;
import org.example.Evento;
import org.example.Olimpiada;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OlimpiadasDB4o {

    // Lista principal de Olimpiadas
    private static List<Olimpiada> olimpiadas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarDatos(); // Poblar datos iniciales
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1 -> listarDeportistas();
                case 2 -> modificarMedalla();
                case 3 -> añadirParticipacion();
                case 4 -> eliminarParticipacion();
                case 0 -> salir = true;
                default -> System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }

        System.out.println("Programa terminado.");
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Listado de deportistas participantes");
        System.out.println("2. Modificar medalla deportista");
        System.out.println("3. Añadir deportista/participación");
        System.out.println("4. Eliminar participación");
        System.out.println("0. Salir del programa");
        System.out.print("Seleccione una opción: ");
    }

    private static void listarDeportistas() {
        System.out.print("Ingrese la temporada (Summer/Winter): ");
        String temporada = scanner.nextLine();

        // Filtrar Olimpiadas por temporada
        List<Olimpiada> opcionesOlimpiadas = olimpiadas.stream()
                .filter(o -> o.getTemporada().equalsIgnoreCase(temporada))
                .toList();

        if (opcionesOlimpiadas.isEmpty()) {
            System.out.println("No se encontraron olimpiadas para la temporada seleccionada.");
            return;
        }

        for (int i = 0; i < opcionesOlimpiadas.size(); i++) {
            Olimpiada olimpiada = opcionesOlimpiadas.get(i);
            System.out.printf("%d. %s (%d, %s)\n", i + 1, olimpiada.getNombre(), olimpiada.getAño(), olimpiada.getCiudad());
        }

        System.out.print("Seleccione una olimpiada: ");
        int indiceOlimpiada = scanner.nextInt() - 1;
        scanner.nextLine();

        if (indiceOlimpiada < 0 || indiceOlimpiada >= opcionesOlimpiadas.size()) {
            System.out.println("Selección inválida.");
            return;
        }

        Olimpiada seleccionada = opcionesOlimpiadas.get(indiceOlimpiada);
        mostrarDeportesYEventos(seleccionada);
    }

    private static void mostrarDeportesYEventos(Olimpiada olimpiada) {
        List<Deporte> deportes = olimpiada.getDeportes();

        for (int i = 0; i < deportes.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, deportes.get(i).getNombre());
        }

        System.out.print("Seleccione un deporte: ");
        int indiceDeporte = scanner.nextInt() - 1;
        scanner.nextLine();

        if (indiceDeporte < 0 || indiceDeporte >= deportes.size()) {
            System.out.println("Selección inválida.");
            return;
        }

        Deporte deporteSeleccionado = deportes.get(indiceDeporte);
        List<Evento> eventos = deporteSeleccionado.getEventos();

        for (int i = 0; i < eventos.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, eventos.get(i).getNombre());
        }

        System.out.print("Seleccione un evento: ");
        int indiceEvento = scanner.nextInt() - 1;
        scanner.nextLine();

        if (indiceEvento < 0 || indiceEvento >= eventos.size()) {
            System.out.println("Selección inválida.");
            return;
        }

        Evento eventoSeleccionado = eventos.get(indiceEvento);
        listarParticipantes(eventoSeleccionado);
    }

    private static void listarParticipantes(Evento evento) {
        List<Deportista> participantes = evento.getParticipantes();

        if (participantes.isEmpty()) {
            System.out.println("No hay deportistas registrados para este evento.");
            return;
        }

        System.out.println("\n--- Deportistas Participantes ---");
        for (Deportista deportista : participantes) {
            System.out.printf("Nombre: %s, Sexo: %s, Peso: %.1fkg, Altura: %.2fm, Medalla: %s\n",
                    deportista.getNombre(), deportista.getSexo(), deportista.getPeso(),
                    deportista.getAltura(), deportista.getMedalla());
        }
    }

    private static void modificarMedalla() {
        System.out.print("Ingrese el nombre del deportista a buscar: ");
        String nombre = scanner.nextLine();

        for (Olimpiada olimpiada : olimpiadas) {
            for (Deporte deporte : olimpiada.getDeportes()) {
                for (Evento evento : deporte.getEventos()) {
                    for (Deportista deportista : evento.getParticipantes()) {
                        if (deportista.getNombre().equalsIgnoreCase(nombre)) {
                            System.out.printf("Deportista encontrado: %s (Medalla actual: %s)\n",
                                    deportista.getNombre(), deportista.getMedalla());
                            System.out.print("Ingrese la nueva medalla (Oro/Plata/Bronce/Ninguna): ");
                            deportista.setMedalla(scanner.nextLine());
                            System.out.println("Medalla actualizada correctamente.");
                            return;
                        }
                    }
                }
            }
        }

        System.out.println("No se encontró un deportista con ese nombre.");
    }

    private static void añadirParticipacion() {
        // Similar a listarDeportistas pero con opción de añadir un nuevo participante
        System.out.println("Función de añadir participación en desarrollo...");
    }

    private static void eliminarParticipacion() {
        // Similar a listarDeportistas pero con opción de eliminar un participante
        System.out.println("Función de eliminar participación en desarrollo...");
    }

    private static void inicializarDatos() {
        // Inicializar algunos datos ficticios
        Deportista d1 = new Deportista("Michael Phelps", "M", 88, 1.93, "Oro");
        Deportista d2 = new Deportista("Usain Bolt", "M", 94, 1.95, "Oro");
        Deportista d3 = new Deportista("Simone Biles", "F", 47, 1.42, "Oro");

        Evento natacion = new Evento("Natación 100m libre");
        natacion.getParticipantes().add(d1);

        Evento atletismo = new Evento("Atletismo 100m");
        atletismo.getParticipantes().add(d2);

        Evento gimnasia = new Evento("Gimnasia artística");
        gimnasia.getParticipantes().add(d3);

        Deporte natacionDeporte = new Deporte("Natación");
        natacionDeporte.getEventos().add(natacion);

        Deporte atletismoDeporte = new Deporte("Atletismo");
        atletismoDeporte.getEventos().add(atletismo);

        Deporte gimnasiaDeporte = new Deporte("Gimnasia");
        gimnasiaDeporte.getEventos().add(gimnasia);

        Olimpiada tokio2020 = new Olimpiada("Tokio 2020", 2021, "Summer", "Tokio");
        tokio2020.getDeportes().add(natacionDeporte);
        tokio2020.getDeportes().add(atletismoDeporte);
        tokio2020.getDeportes().add(gimnasiaDeporte);

        olimpiadas.add(tokio2020);
    }
}
