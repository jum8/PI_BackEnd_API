package com.grupo6.apigestionreservas.repository;

import com.grupo6.apigestionreservas.model.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
class ProductoRepositoryTest {

    @Autowired
    ProductoRepository productoRepository;

    @Test
    void testFindProductosByCategoriaId() {
        Categoria categoria1 = new Categoria();
        categoria1.setTitulo("Hoteles");
        categoria1.setDescripcion("");
        categoria1.setUrlImagen("url");

        Categoria categoria2 = new Categoria();
        categoria2.setTitulo("Departamentos");
        categoria2.setDescripcion("");
        categoria2.setUrlImagen("url");

        DescripcionProducto descripcion = new DescripcionProducto();
        descripcion.setTitulo("Alojate en el corazón de Buenos Aires");
        descripcion.setDescripcion("Una descripción");

        TipoPolitica tipoPolitica1 = new TipoPolitica();
        tipoPolitica1.setTitulo("Normas");

        TipoPolitica tipoPolitica2 = new TipoPolitica();
        tipoPolitica2.setTitulo("Seguridad");

        TipoPolitica tipoPolitica3 = new TipoPolitica();
        tipoPolitica3.setTitulo("Cancelación");

        Politica politica1 = new Politica();
        politica1.setTipoPolitica(tipoPolitica1);
        politica1.setTitulo("Normas de la casa");
        politica1.setDescripcion("Check out: 10:00");

        Politica politica2 = new Politica();
        politica2.setTipoPolitica(tipoPolitica2);
        politica2.setTitulo("Salud y seguridad");
        politica2.setDescripcion("Detector de humo");

        Politica politica3 = new Politica();
        politica3.setTipoPolitica(tipoPolitica3);
        politica3.setTitulo("Politica de Cancelación");
        politica3.setDescripcion("Agregá las fechas de tu viaje para obtener los detalles de cancelación de tu estadía");

        Pais pais = new Pais();
        pais.setNombre("Argentina");

        Ciudad ciudad = new Ciudad();
        ciudad.setNombre("Buenos Aires");
        ciudad.setPais(pais);

        Caracteristica caracteristica1 = new Caracteristica();
        caracteristica1.setDescripcion("Cocina");

        Caracteristica caracteristica2 = new Caracteristica();
        caracteristica2.setDescripcion("Estacionamiento gratuito");

        Caracteristica caracteristica3 = new Caracteristica();
        caracteristica3.setDescripcion("Aire aconcicionado");

        Imagen imagen1 = new Imagen();
        imagen1.setTitulo("una imagen");
        imagen1.setUrl("url");

        Producto producto1 = new Producto();
        producto1.setTitulo("Hotel1");
        producto1.setTitulo("Grand Hotel");
        producto1.setCategoria(categoria1);
        producto1.setCiudad(ciudad);
        producto1.setDescripcion(descripcion);
        producto1.setCaracteristicas(Set.of(caracteristica1, caracteristica2, caracteristica3));
        producto1.setImagenes(Set.of(imagen1));
        producto1.setPoliticas(Set.of(politica1, politica2, politica3));

        Producto producto2 = new Producto();
        producto2.setTitulo("Dpto");
        producto2.setCategoria(categoria2);
        producto2.setCiudad(ciudad);
        producto2.setDescripcion(descripcion);
        producto2.setTitulo("Grand Dpto");
        producto2.setCaracteristicas(Set.of(caracteristica1, caracteristica2, caracteristica3));
        producto2.setImagenes(Set.of(imagen1));
        producto2.setPoliticas(Set.of(politica1, politica2, politica3));

        productoRepository.saveAll(Arrays.asList(producto1, producto2));

        List<Producto> productos = productoRepository.findByCategoriaId(1);
        assertThat(productos.size()).isEqualTo(1);
        assertThat(productos).containsExactly(producto1);

    }
}