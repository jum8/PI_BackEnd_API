package com.grupo6.apigestionreservas.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaPlusDTO {
    private Integer id;

    private String titulo;

    private String descripcion;

    private String urlImagen;

    private Integer cantidadProductos;

}
