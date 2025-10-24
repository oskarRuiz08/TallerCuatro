package com.example.TallerCuatro.service.implement;

import com.example.TallerCuatro.entity.UsuariosEntity;
import com.example.TallerCuatro.repository.UsuariosRepository;
import com.example.TallerCuatro.service.MiAgendaService;
import com.example.TallerCuatro.service.MiUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosServiceImplement implements MiUsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public List<UsuariosEntity> findAll() {
        return usuariosRepository.findAll();
    }

    @Override
    public UsuariosEntity findByID(Long idMiUniversidadService) {
        return usuariosRepository.findById(idMiUniversidadService).orElse(null);
    }

    @Override
    public void save(UsuariosEntity objRegistrar) {
        usuariosRepository.save(objRegistrar);
    }

    @Override
    public void eliminar(Long ID) {
        usuariosRepository.deleteById(ID);
    }
}
