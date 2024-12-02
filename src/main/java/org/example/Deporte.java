package org.example;

import java.util.ArrayList;
import java.util.List;

public class Deporte {
    private String nombre;
    private List<Evento> eventos;

    // Constructor
    public Deporte(String nombre) {
        this.nombre = nombre;
        this.eventos = new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    // Método para añadir un evento
    public void añadirEvento(Evento evento) {
        this.eventos.add(evento);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Deporte: ").append(nombre).append("\nEventos:\n");
        for (Evento evento : eventos) {
            sb.append("- ").append(evento.getNombre()).append("\n");
        }
        return sb.toString();
    }
}

