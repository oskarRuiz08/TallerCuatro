package com.example.TallerCuatro.service.implement;


import com.example.TallerCuatro.entity.EstatusEntity;
import com.example.TallerCuatro.repository.EstatusRepository;
import com.example.TallerCuatro.service.MiEstatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstatusServiceImplement implements MiEstatusService {

    @Autowired
    private EstatusRepository estatusRepository;

    @Override
    public List<EstatusEntity> findAll() {
        return estatusRepository.findAll();
    }

    @Override
    public EstatusEntity findByID(Long idMiUniversidadService) {
        return estatusRepository.findById(idMiUniversidadService).orElse(null);
    }

    @Override
    public void save(EstatusEntity objRegistrar) {
        estatusRepository.save(objRegistrar);
    }

    @Override
    public void eliminar(Long ID) {
        estatusRepository.deleteById(ID);
    }
}
