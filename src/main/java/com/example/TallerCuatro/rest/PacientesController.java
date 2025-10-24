package com.example.TallerCuatro.rest;

import com.example.TallerCuatro.DTO.PacientesDto;
import com.example.TallerCuatro.entity.PacientesEntity;
import com.example.TallerCuatro.service.MiPacientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pacientes")
public class PacientesController {

    @Autowired
    public MiPacientesService pacientesService;

    @GetMapping("list")
    public ResponseEntity<List<PacientesEntity>> findAll() {
        return ResponseEntity.ok(pacientesService.findAll());
    }


    @GetMapping("listbyid/{id}")
    public ResponseEntity<PacientesEntity> findById(@PathVariable("id") Long id) {
        PacientesEntity paciente = pacientesService.findByID(id);
        if (paciente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(paciente);
    }

    @PostMapping("crear")
    public ResponseEntity<PacientesEntity> create(@RequestBody @Validated PacientesDto objCrear) {
        try {
            PacientesEntity nuevo = pacientesService.save(objCrear);
            return ResponseEntity.ok(nuevo);
        } catch (Exception e) {
            System.out.println("Error al crear paciente: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        try {
            pacientesService.eliminar(id);
            return ResponseEntity.ok("Paciente eliminado con ID: " + id);
        } catch (Exception e) {
            System.out.println("Error al eliminar paciente: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<PacientesEntity> update(
            @PathVariable("id") Long id,
            @RequestBody @Validated PacientesEntity paciente) {
        try {
            PacientesEntity existente = pacientesService.findByID(id);
            if (existente == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            // Actualizar campos
            existente.setNombres(paciente.getNombres());
            existente.setPrimerApellido(paciente.getPrimerApellido());
            existente.setSegundoApellido(paciente.getSegundoApellido());
            existente.setDocumento(paciente.getDocumento());
            existente.setFechanacimiento(paciente.getFechanacimiento());
            existente.setMedicamentos(paciente.getMedicamentos());
            existente.setAlergias(paciente.getAlergias());

            if (paciente.getUsuario() != null) {
                existente.setUsuario(paciente.getUsuario());
            }

            // Crear DTO y guardar
            PacientesDto dto = new PacientesDto();
            dto.setIdpaciente(existente.getIdpaciente());
            dto.setNombres(existente.getNombres());
            dto.setPrimerApellido(existente.getPrimerApellido());
            dto.setSegundoApellido(existente.getSegundoApellido());
            dto.setDocumento(existente.getDocumento());
            dto.setFechanacimiento(existente.getFechanacimiento());
            dto.setMedicamentos(existente.getMedicamentos());
            dto.setAlergias(existente.getAlergias());
            dto.setIdusuario(existente.getUsuario().getIdusuario());

            pacientesService.save(dto);
            return ResponseEntity.ok(existente);

        } catch (Exception e) {
            System.out.println("Error al actualizar paciente: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
