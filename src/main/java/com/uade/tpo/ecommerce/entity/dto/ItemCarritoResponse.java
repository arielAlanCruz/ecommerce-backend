package com.uade.tpo.ecommerce.entity.dto;

import lombok.Data;

@Data
public class ItemCarritoResponse {
    private Long id;
    private Long productoId;
    private String productoDescripcion;
    private Integer cantidad;
    private Double precioUnitario;
    private Double subtotal;
}