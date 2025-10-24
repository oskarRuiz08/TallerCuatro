package com.example.TallerCuatro.service.implement;


import com.example.TallerCuatro.entity.CategoriasEntity;
import com.example.TallerCuatro.repository.CategoriaRepository;
import com.example.TallerCuatro.service.MiCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImplement implements MiCategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriasEntity> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public CategoriasEntity findByID(Long idMiUniversidadService) {
        return categoriaRepository.findById(idMiUniversidadService).orElse(null);
    }

    @Override
    public void save(CategoriasEntity objRegistrar) {
        categoriaRepository.save(objRegistrar);
    }

    @Override
    public void eliminar(Long ID) {
        categoriaRepository.deleteById(ID);
    }
}
