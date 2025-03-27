package com.sistema.services;

import com.sistema.models.Pago;
import com.sistema.models.Articulo;
import com.sistema.repositories.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    // Método para realizar un pago
    public Pago procesarPago(String usuarioId, List<Articulo> articulos, double total, Date fechaCompra) {
        // Calcular el total real de los artículos
        double totalCalculado = articulos.stream().mapToDouble(a -> a.getCantidad() * a.getPrecioUnitario()).sum();

        if (total != totalCalculado) {
            return new Pago(usuarioId, articulos, total, fechaCompra, "Declinado", "El total no coincide con la suma de los artículos", null);
        }

        // Generar número de transacción único
        String numeroTransaccion = UUID.randomUUID().toString().substring(0, 8);

        // Guardar pago en la base de datos
        Pago pago = new Pago(usuarioId, articulos, total, fechaCompra, "Aprobado", "Pago realizado con éxito", numeroTransaccion);
        return pagoRepository.save(pago);
    }

    // Método para consultar pagos por usuario
    public List<Pago> consultarPagosPorUsuario(String usuarioId) {
        return pagoRepository.findByUsuarioId(usuarioId);
    }
}
