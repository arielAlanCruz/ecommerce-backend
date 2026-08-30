package com.uade.tpo.ecommerce.service;

import com.uade.tpo.ecommerce.entity.dto.CarritoResponse;
import com.uade.tpo.ecommerce.entity.dto.ItemCarritoRequest;
import com.uade.tpo.ecommerce.entity.dto.ItemCarritoResponse;
import com.uade.tpo.ecommerce.entity.dto.ItemCarritoUpdateRequest;
import com.uade.tpo.ecommerce.exceptions.CantidadInvalidaException;
import com.uade.tpo.ecommerce.exceptions.ItemCarritoNoEncontradoException;
import com.uade.tpo.ecommerce.exceptions.ProductoNoEncontradoException;
import com.uade.tpo.ecommerce.exceptions.StockInvalidoException;
import com.uade.tpo.ecommerce.exceptions.UsuarioNoEncontradoException;

public interface CarritoService {

    public CarritoResponse getCarrito(Long usuarioId) throws UsuarioNoEncontradoException;

    public ItemCarritoResponse agregarItem(Long usuarioId, ItemCarritoRequest request)
            throws CantidadInvalidaException, UsuarioNoEncontradoException,
            ProductoNoEncontradoException, StockInvalidoException;

    public ItemCarritoResponse actualizarItem(Long usuarioId, Long itemId, ItemCarritoUpdateRequest request)
            throws CantidadInvalidaException, UsuarioNoEncontradoException,
            ItemCarritoNoEncontradoException, StockInvalidoException;

    public void eliminarItem(Long usuarioId, Long itemId)
            throws UsuarioNoEncontradoException, ItemCarritoNoEncontradoException;

    public void vaciarCarrito(Long usuarioId) throws UsuarioNoEncontradoException;
}