package com.example.TallerCuatro.service;

import com.example.TallerCuatro.DTO.CitasDto;
import com.example.TallerCuatro.entity.CitasEntity;

import java.util.List;

public interface MiCitasService {
    public List<CitasEntity> findAll();
    public CitasEntity findByID(Long id);
    public CitasEntity save (CitasDto objRegistrar);
    public void eliminar (Long llavePrimaria);
}
