package com.grupo6.apigestionreservas.config;
import com.grupo6.apigestionreservas.dto.CategoriaSimpleDTO;
import com.grupo6.apigestionreservas.dto.ProductoDTO;
import com.grupo6.apigestionreservas.model.Categoria;
import com.grupo6.apigestionreservas.model.Producto;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();


        modelMapper.createTypeMap(Producto.class, ProductoDTO.class)
                .addMapping(Producto::getId, ProductoDTO::setId)
                .addMapping(Producto::getTitulo, ProductoDTO::setTitulo)
                .addMapping(Producto::getDescripcion, ProductoDTO::setDescripcion)
                .addMapping(Producto::getLatitud, ProductoDTO::setLatitud)
                .addMapping(Producto::getLongitud, ProductoDTO::setLongitud)
                .addMapping(Producto::getCategoria, ProductoDTO::setCategoria);

        modelMapper.createTypeMap(Categoria.class, CategoriaSimpleDTO.class)
                .addMapping(categoria -> categoria.getId(), CategoriaSimpleDTO::setId)
                .addMapping(categoria -> categoria.getTitulo(), CategoriaSimpleDTO::setTitulo);

        return modelMapper;
    }
}
