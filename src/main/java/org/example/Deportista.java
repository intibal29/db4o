package org.example;

public class Deportista {
    private String nombre;
    private String sexo; // "M" o "F"
    private double peso; // en kilogramos
    private double altura; // en metros
    private String medalla; // "Oro", "Plata", "Bronce" o "Ninguna"

    // Constructor
    public Deportista(String nombre, String sexo, double peso, double altura, String medalla) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
        this.medalla = medalla;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getMedalla() {
        return medalla;
    }

    public void setMedalla(String medalla) {
        this.medalla = medalla;
    }

    @Override
    public String toString() {
        return String.format("Deportista: %s, Sexo: %s, Peso: %.1fkg, Altura: %.2fm, Medalla: %s",
                nombre, sexo, peso, altura, medalla);
    }
}

