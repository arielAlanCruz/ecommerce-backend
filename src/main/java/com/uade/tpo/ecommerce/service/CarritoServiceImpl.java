package com.uade.tpo.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uade.tpo.ecommerce.entity.Carrito;
import com.uade.tpo.ecommerce.entity.ItemCarrito;
import com.uade.tpo.ecommerce.entity.Producto;
import com.uade.tpo.ecommerce.entity.Usuario;
import com.uade.tpo.ecommerce.entity.dto.CarritoResponse;
import com.uade.tpo.ecommerce.entity.dto.ItemCarritoRequest;
import com.uade.tpo.ecommerce.entity.dto.ItemCarritoResponse;
import com.uade.tpo.ecommerce.entity.dto.ItemCarritoUpdateRequest;
import com.uade.tpo.ecommerce.exceptions.CantidadInvalidaException;
import com.uade.tpo.ecommerce.exceptions.ItemCarritoNoEncontradoException;
import com.uade.tpo.ecommerce.exceptions.ProductoNoEncontradoException;
import com.uade.tpo.ecommerce.exceptions.StockInvalidoException;
import com.uade.tpo.ecommerce.exceptions.UsuarioNoEncontradoException;
import com.uade.tpo.ecommerce.repository.CarritoRepository;
import com.uade.tpo.ecommerce.repository.ItemCarritoRepository;
import com.uade.tpo.ecommerce.repository.ProductoRepository;
import com.uade.tpo.ecommerce.repository.UsuarioRepository;

@Service
public class CarritoServiceImpl implements CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private ItemCarritoRepository itemCarritoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public CarritoResponse getCarrito(Long usuarioId) throws UsuarioNoEncontradoException {
        Carrito carrito = obtenerOCrearCarrito(usuarioId);
        return convertirCarrito(carrito);
    }

    public ItemCarritoResponse agregarItem(Long usuarioId, ItemCarritoRequest request)
            throws CantidadInvalidaException, UsuarioNoEncontradoException,
            ProductoNoEncontradoException, StockInvalidoException {

        validarCantidad(request.getCantidad());
        Carrito carrito = obtenerOCrearCarrito(usuarioId);

        Optional<Producto> productoOptional = productoRepository.findById(request.getProductoId());
        if (productoOptional.isEmpty())
            throw new ProductoNoEncontradoException();

        Producto producto = productoOptional.get();
        ItemCarrito itemExistente = null;

        for (ItemCarrito item : carrito.getItems()) {
            if (item.getProducto().getId().equals(producto.getId())) {
                itemExistente = item;
                break;
            }
        }

        Integer cantidadFinal = request.getCantidad();
        if (itemExistente != null)
            cantidadFinal = cantidadFinal + itemExistente.getCantidad();

        validarStock(producto, cantidadFinal);

        if (itemExistente != null) {
            itemExistente.setCantidad(cantidadFinal);
            itemCarritoRepository.save(itemExistente);
            return convertirItem(itemExistente);
        }

        ItemCarrito item = new ItemCarrito();
        item.setCarrito(carrito);
        item.setProducto(producto);
        item.setCantidad(request.getCantidad());
        carrito.getItems().add(item);
        itemCarritoRepository.save(item);
        return convertirItem(item);
    }

    public ItemCarritoResponse actualizarItem(Long usuarioId, Long itemId, ItemCarritoUpdateRequest request)
            throws CantidadInvalidaException, UsuarioNoEncontradoException,
            ItemCarritoNoEncontradoException, StockInvalidoException {

        validarCantidad(request.getCantidad());
        Carrito carrito = obtenerOCrearCarrito(usuarioId);

        Optional<ItemCarrito> itemOptional = itemCarritoRepository.findById(itemId);
        if (itemOptional.isEmpty())
            throw new ItemCarritoNoEncontradoException();

        ItemCarrito item = itemOptional.get();
        if (!item.getCarrito().getId().equals(carrito.getId()))
            throw new ItemCarritoNoEncontradoException();

        validarStock(item.getProducto(), request.getCantidad());
        item.setCantidad(request.getCantidad());
        itemCarritoRepository.save(item);
        return convertirItem(item);
    }

    public void eliminarItem(Long usuarioId, Long itemId)
            throws UsuarioNoEncontradoException, ItemCarritoNoEncontradoException {

        Carrito carrito = obtenerOCrearCarrito(usuarioId);
        Optional<ItemCarrito> itemOptional = itemCarritoRepository.findById(itemId);

        if (itemOptional.isEmpty())
            throw new ItemCarritoNoEncontradoException();

        ItemCarrito item = itemOptional.get();
        if (!item.getCarrito().getId().equals(carrito.getId()))
            throw new ItemCarritoNoEncontradoException();

        itemCarritoRepository.delete(item);
    }

    public void vaciarCarrito(Long usuarioId) throws UsuarioNoEncontradoException {
        Carrito carrito = obtenerOCrearCarrito(usuarioId);
        carrito.getItems().clear();
        carritoRepository.save(carrito);
    }

    private Carrito obtenerOCrearCarrito(Long usuarioId) throws UsuarioNoEncontradoException {
        Optional<Carrito> carritoOptional = carritoRepository.findByUsuarioId(usuarioId);

        if (carritoOptional.isPresent())
            return carritoOptional.get();

        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuarioId);
        if (usuarioOptional.isEmpty())
            throw new UsuarioNoEncontradoException();

        Carrito carrito = new Carrito();
        carrito.setUsuario(usuarioOptional.get());
        return carritoRepository.save(carrito);
    }

    private void validarCantidad(Integer cantidad) throws CantidadInvalidaException {
        if (cantidad == null || cantidad <= 0)
            throw new CantidadInvalidaException();
    }

    private void validarStock(Producto producto, Integer cantidad) throws StockInvalidoException {
        if (producto.getStock() == null || cantidad > producto.getStock())
            throw new StockInvalidoException();
    }

    private CarritoResponse convertirCarrito(Carrito carrito) {
        CarritoResponse response = new CarritoResponse();
        response.setId(carrito.getId());

        List<ItemCarritoResponse> items = new ArrayList<>();
        Double total = 0.0;

        for (ItemCarrito item : carrito.getItems()) {
            ItemCarritoResponse itemResponse = convertirItem(item);
            items.add(itemResponse);
            total = total + itemResponse.getSubtotal();
        }

        response.setItems(items);
        response.setTotal(total);
        return response;
    }

    private ItemCarritoResponse convertirItem(ItemCarrito item) {
        ItemCarritoResponse response = new ItemCarritoResponse();
        Double precio = item.getProducto().getPrecio();

        response.setId(item.getId());
        response.setProductoId(item.getProducto().getId());
        response.setProductoDescripcion(item.getProducto().getDescripcion());
        response.setCantidad(item.getCantidad());
        response.setPrecioUnitario(precio);
        response.setSubtotal(precio * item.getCantidad());
        return response;
    }
}