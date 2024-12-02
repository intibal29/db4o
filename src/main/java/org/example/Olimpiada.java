package org.example;

import java.util.ArrayList;
import java.util.List;

public class Olimpiada {
    private String nombre;
    private int año;
    private String temporada; // "Summer" o "Winter"
    private String ciudad;
    private List<Deporte> deportes;

    // Constructor
    public Olimpiada(String nombre, int año, String temporada, String ciudad) {
        this.nombre = nombre;
        this.año = año;
        this.temporada = temporada;
        this.ciudad = ciudad;
        this.deportes = new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Deporte> getDeportes() {
        return deportes;
    }

    public void setDeportes(List<Deporte> deportes) {
        this.deportes = deportes;
    }

    // Método para añadir un deporte a la lista
    public void añadirDeporte(Deporte deporte) {
        this.deportes.add(deporte);
    }

    @Override
    public String toString() {
        return String.format("Olimpiada: %s (%d), Temporada: %s, Ciudad: %s",
                nombre, año, temporada, ciudad);
    }
}
