package com.grupo6.apigestionreservas.controller;

import com.grupo6.apigestionreservas.dto.ProductoDTO;
import com.grupo6.apigestionreservas.model.Producto;
import com.grupo6.apigestionreservas.repository.ProductoRepository;
import com.grupo6.apigestionreservas.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/productos")
public class ProductoController {
    @Autowired
    ProductoService productoService;


    @GetMapping
    public List<ProductoDTO> getAllProductos() {
        return productoService.findAll();
    }
}
