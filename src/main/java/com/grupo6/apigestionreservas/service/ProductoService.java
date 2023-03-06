package com.grupo6.apigestionreservas.service;

import com.grupo6.apigestionreservas.dto.ProductoDTO;
import com.grupo6.apigestionreservas.model.Producto;
import com.grupo6.apigestionreservas.repository.ProductoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {
    @Autowired
    ProductoRepository productoRepository;
    @Autowired
    private ModelMapper mapper;

    public List<ProductoDTO> findAll() {
        List<Producto> productos = productoRepository.findAll();
        List<ProductoDTO> productoDTOS = new ArrayList<>();
        productos.forEach(producto -> productoDTOS.add(mapper.map(producto, ProductoDTO.class)));
        return productoDTOS;
    }
}
