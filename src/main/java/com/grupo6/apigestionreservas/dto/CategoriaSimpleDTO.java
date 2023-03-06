package com.grupo6.apigestionreservas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaSimpleDTO {
    private Integer id;

    private String titulo;

}
