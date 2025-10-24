package com.example.TallerCuatro.service;

import com.example.TallerCuatro.entity.PagosEntity;

import java.util.List;

public interface MiPagosService {
    public List<PagosEntity> findAll();
    public PagosEntity findByID(Long idMiUniversidadService);
    public void save (PagosEntity objRegistrar);
    public void eliminar (Long ID);
}
