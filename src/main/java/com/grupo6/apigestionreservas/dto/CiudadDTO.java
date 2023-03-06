package com.grupo6.apigestionreservas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CiudadDTO {
    private Long id;
    @NotNull
    @Size(max = 255)
    private String nombre;
    @NotNull
    private Integer paisId;

}
