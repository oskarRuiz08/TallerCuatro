package com.example.TallerCuatro.service;

import com.example.TallerCuatro.DTO.MedicosDto;
import com.example.TallerCuatro.entity.MedicosEntity;

import java.util.List;

public interface MiMedicosService {
    public List<MedicosEntity> findAll();
    public MedicosEntity findByID(Long id);
    public MedicosEntity save (MedicosDto objRegistrar);
    public void eliminar (Long llavePrimaria);
}
