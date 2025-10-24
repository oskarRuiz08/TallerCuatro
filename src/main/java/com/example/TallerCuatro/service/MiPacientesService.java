package com.example.TallerCuatro.service;

import com.example.TallerCuatro.DTO.PacientesDto;
import com.example.TallerCuatro.entity.PacientesEntity;

import java.util.List;

public interface MiPacientesService {
    public List<PacientesEntity> findAll();
    public PacientesEntity findByID(Long id);
    public PacientesEntity save (PacientesDto objRegistrar);
    public void eliminar (Long llavePrimaria);
}
