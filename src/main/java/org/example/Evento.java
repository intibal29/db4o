package org.example;

import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String nombre;
    private List<Deportista> participantes;

    // Constructor
    public Evento(String nombre) {
        this.nombre = nombre;
        this.participantes = new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Deportista> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Deportista> participantes) {
        this.participantes = participantes;
    }

    // Método para añadir un deportista al evento
    public void añadirParticipante(Deportista deportista) {
        this.participantes.add(deportista);
    }

    // Método para eliminar un participante
    public boolean eliminarParticipante(Deportista deportista) {
        return this.participantes.remove(deportista);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Evento: ").append(nombre).append("\nParticipantes:\n");
        for (Deportista deportista : participantes) {
            sb.append("- ").append(deportista.getNombre()).append("\n");
        }
        return sb.toString();
    }
}

