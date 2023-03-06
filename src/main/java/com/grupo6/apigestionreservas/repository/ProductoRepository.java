package com.grupo6.apigestionreservas.repository;

import com.grupo6.apigestionreservas.model.Ciudad;
import com.grupo6.apigestionreservas.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByCiudadId(Integer ciudadId);
    List<Producto> findByCategoriaId(Integer categoriaId);
}
