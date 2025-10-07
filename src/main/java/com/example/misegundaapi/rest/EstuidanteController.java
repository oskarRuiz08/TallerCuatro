package com.example.misegundaapi.rest;


import com.example.misegundaapi.DTO.EstudianteDTO;
import com.example.misegundaapi.entity.EstudiantesEntity;
import com.example.misegundaapi.entity.UniversidadEntity;
import com.example.misegundaapi.service.MiEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("estuidante")
public class EstuidanteController {

    @Autowired
    private MiEstudianteService estudianteService;

    @GetMapping("list")
    public ResponseEntity<List<EstudiantesEntity>> findAll() {
        return ResponseEntity.ok(estudianteService.findAll());
    }

    @GetMapping("listbyid/{id}")
    public ResponseEntity<EstudiantesEntity> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(estudianteService.findByID(id));
    }

    @PostMapping("crear")
    public ResponseEntity<EstudiantesEntity> create(@RequestBody
                                                    @Validated EstudianteDTO objCrear) {
        try {
            EstudiantesEntity estudiantes = estudianteService.registrar(objCrear);
            ResponseEntity.status(200);
            return ResponseEntity.ok(estudiantes);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }





}
