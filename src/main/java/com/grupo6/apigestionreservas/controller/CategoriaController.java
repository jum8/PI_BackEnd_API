package com.grupo6.apigestionreservas.controller;

import com.grupo6.apigestionreservas.dto.CategoriaDTO;
import com.grupo6.apigestionreservas.model.Categoria;
import com.grupo6.apigestionreservas.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<CategoriaDTO> getAllCategorias() {
        return categoriaService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer createCategoria(@RequestBody @Valid CategoriaDTO categoriaDTO) {
        return categoriaService.create(categoriaDTO);
    }

    @PutMapping("/{id}")
    public void updateCategoria(@PathVariable Integer id, @RequestBody @Valid CategoriaDTO categoriaDTO) {
        categoriaService.update(id, categoriaDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategoria(@PathVariable Integer id) {
        categoriaService.delete(id);
    }

}