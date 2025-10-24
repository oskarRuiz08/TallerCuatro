package com.example.TallerCuatro.service;

import com.example.TallerCuatro.entity.UsuariosEntity;

import java.util.List;

public interface MiUsuariosService {
    public List<UsuariosEntity> findAll();
    public UsuariosEntity findByID(Long idMiUniversidadService);
    public void save (UsuariosEntity objRegistrar);
    public void eliminar (Long ID);
}
