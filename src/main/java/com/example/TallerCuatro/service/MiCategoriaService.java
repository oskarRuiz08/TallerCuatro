package com.example.TallerCuatro.service;

import com.example.TallerCuatro.entity.CategoriasEntity;

import java.util.List;

public interface MiCategoriaService {
    public List<CategoriasEntity> findAll();
    public CategoriasEntity findByID(Long idMiUniversidadService);
    public void save (CategoriasEntity objRegistrar);
    public void eliminar (Long ID);
}
