package com.example.TallerCuatro.service.implement;

import com.example.TallerCuatro.DTO.PacientesDto;
import com.example.TallerCuatro.entity.PacientesEntity;
import com.example.TallerCuatro.entity.UsuariosEntity;
import com.example.TallerCuatro.repository.PacientesRepository;
import com.example.TallerCuatro.repository.UsuariosRepository;
import com.example.TallerCuatro.service.MiAgendaService;
import com.example.TallerCuatro.service.MiPacientesService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacientesServiceImplement implements MiPacientesService {

    @Autowired
    private PacientesRepository pacientesRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public List<PacientesEntity> findAll() {
        return pacientesRepository.findAll();
    }

    @Override
    public PacientesEntity findByID(Long id) {
        return pacientesRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public PacientesEntity save(PacientesDto objRegistrar) {
        UsuariosEntity usuarios = usuariosRepository.
                findById(objRegistrar.getIdusuario()).orElse(null);

        PacientesEntity pacientes = new PacientesEntity();
        pacientes.setIdpaciente(objRegistrar.getIdpaciente());
        pacientes.setNombres(objRegistrar.getNombres());
        pacientes.setPrimerApellido(objRegistrar.getPrimerApellido());
        pacientes.setSegundoApellido(objRegistrar.getSegundoApellido());
        pacientes.setDocumento(objRegistrar.getDocumento());
        pacientes.setFechanacimiento(objRegistrar.getFechanacimiento());
        pacientes.setMedicamentos(objRegistrar.getMedicamentos());
        pacientes.setAlergias(objRegistrar.getAlergias());
        pacientes.setUsuario(usuarios);

        return pacientesRepository.save(pacientes);
    }

    @Override
    @Transactional
    public void eliminar(Long llavePrimaria) {
        pacientesRepository.deleteById(llavePrimaria);
    }
}
