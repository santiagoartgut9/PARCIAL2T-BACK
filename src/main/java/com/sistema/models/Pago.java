package com.sistema.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.List;

@Document(collection = "pagos") // Indica que esta entidad se almacena en MongoDB
public class Pago {
    
    @Id
    private String id;
    private String usuarioId;
    private List<Articulo> articulos;
    private double total;
    private Date fechaCompra;
    private String estado;
    private String mensaje;
    private String numeroTransaccion;

    // Constructor vacío para MongoDB
    public Pago() {}

    // Constructor con parámetros
    public Pago(String usuarioId, List<Articulo> articulos, double total, Date fechaCompra, String estado, String mensaje, String numeroTransaccion) {
        this.usuarioId = usuarioId;
        this.articulos = articulos;
        this.total = total;
        this.fechaCompra = fechaCompra;
        this.estado = estado;
        this.mensaje = mensaje;
        this.numeroTransaccion = numeroTransaccion;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUsuarioId() { return usuarioId; }
    public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }

    public List<Articulo> getArticulos() { return articulos; }
    public void setArticulos(List<Articulo> articulos) { this.articulos = articulos; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public Date getFechaCompra() { return fechaCompra; }
    public void setFechaCompra(Date fechaCompra) { this.fechaCompra = fechaCompra; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public String getNumeroTransaccion() { return numeroTransaccion; }
    public void setNumeroTransaccion(String numeroTransaccion) { this.numeroTransaccion = numeroTransaccion; }
}
