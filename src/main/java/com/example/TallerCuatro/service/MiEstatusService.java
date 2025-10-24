package com.example.TallerCuatro.service;

import com.example.TallerCuatro.entity.EstatusEntity;

import java.util.List;

public interface MiEstatusService {
    public List<EstatusEntity> findAll();
    public EstatusEntity findByID(Long idMiUniversidadService);
    public void save (EstatusEntity objRegistrar);
    public void eliminar (Long ID);
}
