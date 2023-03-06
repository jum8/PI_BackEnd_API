package com.grupo6.apigestionreservas.dto;

import com.grupo6.apigestionreservas.model.Categoria;
import com.grupo6.apigestionreservas.model.DescripcionProducto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductoDTO {

    private Long id;

    @NotNull
    @Size(max = 50)
    private String titulo;

    @NotNull
    private DescripcionProducto descripcion;

//    @NotNull
//    private Set<Politica> politicas;

    private Double latitud;

    private Double longitud;

    @NotNull
    private Categoria categoria;
//
//    @NotNull
//    private CiudadDTO ciudad;
//
//    @NotNull
//    private Set<Caracteristica> caracteristicas;
//
//    @NotNull
//    private Set<Imagen> imagenes;


}