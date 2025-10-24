package com.example.TallerCuatro.rest;

import com.example.TallerCuatro.DTO.CitasDto;
import com.example.TallerCuatro.entity.CitasEntity;
import com.example.TallerCuatro.service.MiCitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("citas")
public class CitasController {

    @Autowired
    private MiCitasService citasService;


    @GetMapping("list")
    public ResponseEntity<List<CitasEntity>> findAll() {
        return ResponseEntity.ok(citasService.findAll());
    }


    @GetMapping("listbyid/{id}")
    public ResponseEntity<CitasEntity> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(citasService.findByID(id));
    }


    @PostMapping("crear")
    public ResponseEntity<CitasEntity> create(@RequestBody @Validated CitasDto objCrear) {
        try {
            CitasEntity cita = citasService.save(objCrear);
            return ResponseEntity.ok(cita);
        } catch (Exception e) {
            System.out.println("Error al crear cita: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        try {
            citasService.eliminar(id);
            return ResponseEntity.ok("Cita eliminada con ID: " + id);
        } catch (Exception e) {
            System.out.println("Error al eliminar cita: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<CitasEntity> update(
            @PathVariable("id") Long id,
            @RequestBody @Validated CitasEntity cita) {

        try {
            CitasEntity existingCita = citasService.findByID(id);
            if (existingCita == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            existingCita.setTitulo(cita.getTitulo());
            existingCita.setNota(cita.getNota());
            existingCita.setFecha_cita(cita.getFecha_cita() != null ? cita.getFecha_cita() : new Date());
            existingCita.setSintomas(cita.getSintomas());
            existingCita.setMedicamentos(cita.getMedicamentos());
            existingCita.setTipocita(cita.getTipocita());
            existingCita.setAntecedentes(cita.getAntecedentes());
            existingCita.setMedico(cita.getMedico());
            existingCita.setPago(cita.getPago());
            existingCita.setEstatus(cita.getEstatus());

            // Guardar los cambios
            CitasDto dto = new CitasDto();
            dto.setIdcita(existingCita.getIdcita());
            dto.setTitulo(existingCita.getTitulo());
            dto.setNota(existingCita.getNota());
            dto.setFecha_cita(existingCita.getFecha_cita());
            dto.setSintomas(existingCita.getSintomas());
            dto.setMedicamentos(existingCita.getMedicamentos());
            dto.setTipocita(existingCita.getTipocita());
            dto.setAntecedentes(existingCita.getAntecedentes());
            dto.setIdmedico(existingCita.getMedico().getIdmedico());
            dto.setIdpago(existingCita.getPago().getIdpago());
            dto.setIdestatus(existingCita.getEstatus().getIdestatus());

            citasService.save(dto);

            return ResponseEntity.ok(existingCita);

        } catch (Exception e) {
            System.out.println("Error al actualizar cita: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
