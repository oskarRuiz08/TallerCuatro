package com.example.misegundaapi.service.implement;


import com.example.misegundaapi.entity.UniversidadEntity;
import com.example.misegundaapi.repository.UniversidadRepository;
import com.example.misegundaapi.service.MiUniversidadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UniversidadServiceImplement implements MiUniversidadService {


    @Autowired
    private UniversidadRepository universidadRepository;

    @Override
    public List<UniversidadEntity> findAll() {

        return universidadRepository.findAll();
    }

    @Override
    public UniversidadEntity findByID(Long id) {

        return universidadRepository.findById(id).orElse(null);
    }

    @Override
    public UniversidadEntity findByNit(String nit) {
        return universidadRepository.findById(nit);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UniversidadEntity> findBydescripcioOrpuntuacion(String descripcion, float puntuacion) {
        return universidadRepository.findByDescripcionOrpuntuacion(descripcion, puntuacion);
    }

    @Override
    @Transactional
    public void save(UniversidadEntity objRegistrar) {
        universidadRepository.save(objRegistrar);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        universidadRepository.deleteById(id);
    }
}
