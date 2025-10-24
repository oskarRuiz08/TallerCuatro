package com.example.TallerCuatro.service.implement;

import com.example.TallerCuatro.DTO.MedicosDto;
import com.example.TallerCuatro.entity.CategoriasEntity;
import com.example.TallerCuatro.entity.MedicosEntity;
import com.example.TallerCuatro.repository.CategoriaRepository;
import com.example.TallerCuatro.repository.MedicosRepository;
import com.example.TallerCuatro.service.MiMedicosService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MedicosServiceImplement implements MiMedicosService {

    @Autowired
    private MedicosRepository medicosRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<MedicosEntity> findAll() {
        return medicosRepository.findAll();
    }

    @Override
    public MedicosEntity findByID(Long id) {
        return medicosRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public MedicosEntity save(MedicosDto objRegistrar) {
        CategoriasEntity categoria = categoriaRepository
                .findById(objRegistrar.getIdcategoria()).orElse(null);


        MedicosEntity medicos = new MedicosEntity();
        medicos.setIdmedico(objRegistrar.getIdmedico());
        medicos.setNombres(objRegistrar.getNombres());
        medicos.setPrimerApellido(objRegistrar.getPrimerApellido());
        medicos.setSegundoApellido(objRegistrar.getSegundoApellido());
        medicos.setGenero(objRegistrar.getGenero());
        medicos.setEmail(objRegistrar.getEmail());
        medicos.setTelefono(objRegistrar.getTelefono());
        medicos.setCategoria(categoria);

        return medicosRepository.save(medicos);
    }


    @Override
    @Transactional
    public void eliminar(Long llavePrimaria) {
        medicosRepository.deleteById(llavePrimaria);
    }
}
