package com.example.TallerCuatro.service.implement;

import com.example.TallerCuatro.DTO.CitasDto;
import com.example.TallerCuatro.entity.CitasEntity;
import com.example.TallerCuatro.entity.EstatusEntity;
import com.example.TallerCuatro.entity.MedicosEntity;
import com.example.TallerCuatro.entity.PagosEntity;
import com.example.TallerCuatro.repository.CitasRepository;
import com.example.TallerCuatro.repository.EstatusRepository;
import com.example.TallerCuatro.repository.MedicosRepository;
import com.example.TallerCuatro.repository.PagosRepository;
import com.example.TallerCuatro.service.MiCitasService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitasServiceImplement implements MiCitasService {

    @Autowired
    private CitasRepository citasRepository;

    @Autowired
    private MedicosRepository medicosRepository;

    @Autowired
    private PagosRepository pagosRepository;

    @Autowired
    private EstatusRepository estatusRepository;

    @Override
    public List<CitasEntity> findAll() {
        return citasRepository.findAll();
    }

    @Override
    public CitasEntity findByID(Long id) {
        return citasRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public CitasEntity save(CitasDto objRegistrar) {
        MedicosEntity medico = medicosRepository.findById(objRegistrar.getIdmedico())
                .orElseThrow(() -> new RuntimeException("Medico no encontrado"));
        PagosEntity pago = pagosRepository.findById(objRegistrar.getIdpago())
                .orElseThrow(() -> new RuntimeException("Pago no encontrado"));
        EstatusEntity estatus = estatusRepository.findById(objRegistrar.getIdestatus())
                .orElseThrow(() -> new RuntimeException("Estatus no encontrado"));


        CitasEntity citas = new CitasEntity();
        citas.setIdcita(objRegistrar.getIdcita());
        citas.setTitulo(objRegistrar.getTitulo());
        citas.setNota(objRegistrar.getNota());
        citas.setFecha_cita(objRegistrar.getFecha_cita());
        citas.setSintomas(objRegistrar.getSintomas());
        citas.setMedicamentos(objRegistrar.getMedicamentos());
        citas.setTipocita(objRegistrar.getTipocita());
        citas.setTipocita(objRegistrar.getTipocita());
        citas.setMedico(medico);
        citas.setPago(pago);
        citas.setEstatus(estatus);


        return citasRepository.save(citas);
    }

    @Override
    @Transactional
    public void eliminar(Long llavePrimaria) {
        citasRepository.deleteById(llavePrimaria);
    }
}
