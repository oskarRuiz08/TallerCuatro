package com.example.misegundaapi.service;

import com.example.misegundaapi.DTO.EstudianteDTO;
import com.example.misegundaapi.entity.EstudiantesEntity;
import com.example.misegundaapi.entity.UniversidadEntity;

import java.util.List;

public interface MiEstudianteService {
    public List<EstudiantesEntity> findAll();
    public EstudiantesEntity findByID(String idMiEstudianteService);


    public EstudiantesEntity registrar (EstudianteDTO objRegistrar);
    public Boolean actualizar(UniversidadEntity objActualizar);
    public void eliminar (Long llavePrimaria);
}
