package com.sistema.models;

public class Articulo {
    private String nombre;
    private int cantidad;
    private double precioUnitario;

    // Constructor vacío (obligatorio para Spring Boot y MongoDB)
    public Articulo() {}

    // Constructor con parámetros
    public Articulo(String nombre, int cantidad, double precioUnitario) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(double precioUnitario) { this.precioUnitario = precioUnitario; }
}
