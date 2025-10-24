package com.example.TallerCuatro.service.implement;


import com.example.TallerCuatro.entity.PagosEntity;
import com.example.TallerCuatro.repository.PagosRepository;
import com.example.TallerCuatro.service.MiPagosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagosServiceImplement implements MiPagosService {

    @Autowired
    private PagosRepository pagosRepository;

    @Override
    public List<PagosEntity> findAll() {
        return pagosRepository.findAll();
    }

    @Override
    public PagosEntity findByID(Long idMiUniversidadService) {
        return pagosRepository.findById(idMiUniversidadService).orElse(null);
    }

    @Override
    public void save(PagosEntity objRegistrar) {
        pagosRepository.save(objRegistrar);
    }

    @Override
    public void eliminar(Long ID) {
        pagosRepository.deleteById(ID);
    }
}
