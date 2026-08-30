package com.uade.tpo.ecommerce.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uade.tpo.ecommerce.entity.dto.CarritoResponse;
import com.uade.tpo.ecommerce.entity.dto.ItemCarritoRequest;
import com.uade.tpo.ecommerce.entity.dto.ItemCarritoResponse;
import com.uade.tpo.ecommerce.entity.dto.ItemCarritoUpdateRequest;
import com.uade.tpo.ecommerce.exceptions.CantidadInvalidaException;
import com.uade.tpo.ecommerce.exceptions.ItemCarritoNoEncontradoException;
import com.uade.tpo.ecommerce.exceptions.ProductoNoEncontradoException;
import com.uade.tpo.ecommerce.exceptions.StockInvalidoException;
import com.uade.tpo.ecommerce.exceptions.UsuarioNoEncontradoException;
import com.uade.tpo.ecommerce.service.CarritoService;

@RestController
@RequestMapping("api/carrito")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @GetMapping
    public ResponseEntity<CarritoResponse> getCarrito() throws UsuarioNoEncontradoException {
        Long usuarioId = 1L;
        return ResponseEntity.ok(carritoService.getCarrito(usuarioId));
    }

    @PostMapping("/items")
    public ResponseEntity<ItemCarritoResponse> agregarItem(@RequestBody ItemCarritoRequest request)
            throws CantidadInvalidaException, UsuarioNoEncontradoException,
            ProductoNoEncontradoException, StockInvalidoException {

        Long usuarioId = 1L;
        ItemCarritoResponse result = carritoService.agregarItem(usuarioId, request);
        return ResponseEntity.created(URI.create("/api/carrito/items/" + result.getId())).body(result);
    }

    @PutMapping("/items/{itemId}")
    public ResponseEntity<ItemCarritoResponse> actualizarItem(@PathVariable Long itemId,
            @RequestBody ItemCarritoUpdateRequest request)
            throws CantidadInvalidaException, UsuarioNoEncontradoException,
            ItemCarritoNoEncontradoException, StockInvalidoException {

        Long usuarioId = 1L;
        return ResponseEntity.ok(carritoService.actualizarItem(usuarioId, itemId, request));
    }

    @DeleteMapping("/items/{itemId}")
    public ResponseEntity<Void> eliminarItem(@PathVariable Long itemId)
            throws UsuarioNoEncontradoException, ItemCarritoNoEncontradoException {

        Long usuarioId = 1L;
        carritoService.eliminarItem(usuarioId, itemId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> vaciarCarrito() throws UsuarioNoEncontradoException {
        Long usuarioId = 1L;
        carritoService.vaciarCarrito(usuarioId);
        return ResponseEntity.noContent().build();
    }
}