package com.uade.tpo.ecommerce.entity.dto;

import java.util.List;

import lombok.Data;

@Data
public class CarritoResponse {
    private Long id;
    private List<ItemCarritoResponse> items;
    private Double total;
}