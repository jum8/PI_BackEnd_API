package com.grupo6.apigestionreservas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Categoria {
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String titulo;

    @Column
    private String descripcion;

    @Column(nullable = false)
    private String urlImagen;

    @JsonIgnore
    @OneToMany(mappedBy = "categoria")
    private Set<Producto> productos;
}

