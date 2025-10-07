package com.example.misegundaapi.service;

import com.example.misegundaapi.entity.UniversidadEntity;

import java.util.List;

public interface MiUniversidadService {
    public List<UniversidadEntity> findAll();
    public UniversidadEntity findByID(Long idMiUniversidadService);
    public UniversidadEntity findByNit(String nit);
    public List <UniversidadEntity> findBydescripcioOrpuntuacion(String descripcion, float puntuacion);
    public void save (UniversidadEntity objRegistrar);
    public void eliminar (Long ID);
}
