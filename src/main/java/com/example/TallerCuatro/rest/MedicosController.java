package com.example.TallerCuatro.rest;

import com.example.TallerCuatro.DTO.MedicosDto;
import com.example.TallerCuatro.entity.MedicosEntity;
import com.example.TallerCuatro.service.MiMedicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicosController {

    @Autowired
    private MiMedicosService medicosService;

    @GetMapping("list")
    public ResponseEntity<List<MedicosEntity>> findAll() {
        return ResponseEntity.ok(medicosService.findAll());
    }


    @GetMapping("listbyid/{id}")
    public ResponseEntity<MedicosEntity> findById(@PathVariable("id") Long id) {
        MedicosEntity medico = medicosService.findByID(id);
        if (medico == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(medico);
    }


    @PostMapping("crear")
    public ResponseEntity<MedicosEntity> create(@RequestBody @Validated MedicosDto objCrear) {
        try {
            MedicosEntity nuevo = medicosService.save(objCrear);
            return ResponseEntity.ok(nuevo);
        } catch (Exception e) {
            System.out.println("Error al crear médico: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        try {
            medicosService.eliminar(id);
            return ResponseEntity.ok("Médico eliminado con ID: " + id);
        } catch (Exception e) {
            System.out.println("Error al eliminar médico: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<MedicosEntity> update(
            @PathVariable("id") Long id,
            @RequestBody @Validated MedicosEntity medico) {
        try {
            MedicosEntity existingMedico = medicosService.findByID(id);
            if (existingMedico == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            existingMedico.setNombres(medico.getNombres());
            existingMedico.setPrimerApellido(medico.getPrimerApellido());
            existingMedico.setSegundoApellido(medico.getSegundoApellido());
            existingMedico.setGenero(medico.getGenero());
            existingMedico.setEmail(medico.getEmail());
            existingMedico.setTelefono(medico.getTelefono());
            if (medico.getCategoria() != null) {
                existingMedico.setCategoria(medico.getCategoria());
            }
            MedicosDto dto = new MedicosDto();
            dto.setIdmedico(existingMedico.getIdmedico());
            dto.setNombres(existingMedico.getNombres());
            dto.setPrimerApellido(existingMedico.getPrimerApellido());
            dto.setSegundoApellido(existingMedico.getSegundoApellido());
            dto.setGenero(existingMedico.getGenero());
            dto.setEmail(existingMedico.getEmail());
            dto.setTelefono(existingMedico.getTelefono());
            dto.setIdcategoria(existingMedico.getCategoria().getIdcategoria());


            medicosService.save(dto);
            return ResponseEntity.ok(existingMedico);


        } catch (Exception e) {
            System.out.println("Error al actualizar médico: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}


