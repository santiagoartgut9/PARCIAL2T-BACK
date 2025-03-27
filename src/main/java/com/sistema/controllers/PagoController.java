package com.sistema.controllers;

import com.sistema.models.Pago;
import com.sistema.models.Articulo;
import com.sistema.services.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    // Endpoint para realizar un pago
    @PostMapping("/realizar")
    public Pago realizarPago(@RequestParam String usuarioId, 
                             @RequestBody List<Articulo> articulos, 
                             @RequestParam double total, 
                             @RequestParam String fecha) {
        try {
            // Convertir la fecha de String a Date
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date fechaCompra = formatter.parse(fecha);
            return pagoService.procesarPago(usuarioId, articulos, total, fechaCompra);
        } catch (ParseException e) {
            return new Pago(usuarioId, articulos, total, null, "Declinado", "Formato de fecha incorrecto", null);
        }
    }

    // Endpoint para consultar pagos por usuario
    @GetMapping("/consultar/{usuarioId}")
    public List<Pago> consultarPagos(@PathVariable String usuarioId) {
        return pagoService.consultarPagosPorUsuario(usuarioId);
    }
}
