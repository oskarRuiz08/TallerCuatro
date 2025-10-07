package com.example.misegundaapi.service.implement;

import com.example.misegundaapi.DTO.EstudianteDTO;
import com.example.misegundaapi.entity.EstudiantesEntity;
import com.example.misegundaapi.entity.UniversidadEntity;
import com.example.misegundaapi.repository.EstudiantesRepository;
import com.example.misegundaapi.repository.UniversidadRepository;
import com.example.misegundaapi.service.MiEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstudianteServiceImplement implements MiEstudianteService {

    @Autowired
    private EstudiantesRepository estudiantesRepository;
    @Autowired
    private UniversidadRepository universidadRepository;


    @Override
    public List<EstudiantesEntity> findAll() {
        return estudiantesRepository.findAll();
    }

    @Override
    public EstudiantesEntity findByID(String idMiUniversidadService) {
        return estudiantesRepository.findById(idMiUniversidadService).orElse(null);
    }

    @Override
    @Transactional
    public EstudiantesEntity registrar(EstudianteDTO objRegistrar) {
        UniversidadEntity unifk = universidadRepository.
                findById(objRegistrar.getFkUniversidad()).orElse(null);

        EstudiantesEntity estudiante = new EstudiantesEntity();
        estudiante.setDocumento(objRegistrar.getDocumento());
        estudiante.setNombre(objRegistrar.getNombre());
        estudiante.setTipoDocumento(objRegistrar.getTipoDocumento());
        estudiante.setTelefono(objRegistrar.getTelefono());
        estudiante.setExtensionnumero(objRegistrar.getExtensionnumero());
        estudiante.setUniversidad(unifk);
        return estudiantesRepository.save(estudiante);
    }

    @Override
    public Boolean actualizar(UniversidadEntity objActualizar) {
        return null;
    }

    @Override
    public void eliminar(Long llavePrimaria) {

    }
}
