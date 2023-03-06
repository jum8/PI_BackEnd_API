package com.grupo6.apigestionreservas.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo6.apigestionreservas.dto.CategoriaDTO;
import com.grupo6.apigestionreservas.model.Categoria;
import com.grupo6.apigestionreservas.repository.CategoriaRepository;
import com.grupo6.apigestionreservas.util.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ModelMapper mapper;

    public List<CategoriaDTO> findAll() {
        List<Categoria> categorias = categoriaRepository.findAll();
        List<CategoriaDTO> categoriaDTOS = new ArrayList<>();
        categorias.forEach(categoria -> categoriaDTOS.add(mapper.map(categoria, CategoriaDTO.class)));
        return categoriaDTOS;
    }

    public Integer create(CategoriaDTO categoriaDTO) {
        return  categoriaRepository.save(mapper.map(categoriaDTO,Categoria.class)).getId();
    }

    public void update(Integer id, CategoriaDTO categoriaDTO) {
        categoriaRepository.findById(id).orElseThrow(() -> new NotFoundException("Categoría no encontrada"));
        categoriaRepository.save(mapper.map(categoriaDTO, Categoria.class));
    }

    public void delete(Integer id) {
        categoriaRepository.findById(id).orElseThrow(() -> new NotFoundException("Categoría no encontrada"));
        categoriaRepository.deleteById(id);
    }

}
