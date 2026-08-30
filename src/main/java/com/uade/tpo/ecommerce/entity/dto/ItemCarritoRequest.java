package com.uade.tpo.ecommerce.entity.dto;

import lombok.Data;

@Data
public class ItemCarritoRequest {
    private Long productoId;
    private Integer cantidad;
}