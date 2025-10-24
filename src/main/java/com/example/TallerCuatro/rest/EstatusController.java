package com.example.TallerCuatro.rest;

import com.example.TallerCuatro.entity.EstatusEntity;
import com.example.TallerCuatro.service.MiEstatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("estatus")
public class EstatusController {

    @Autowired
    public MiEstatusService estatusService;

    @GetMapping("list")
    public ResponseEntity<List<EstatusEntity>> findAll() {
        return ResponseEntity.ok(estatusService.findAll());
    }

    @GetMapping("listbyid/{id}")
    public ResponseEntity<EstatusEntity> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(estatusService.findByID(id));
    }

    @PostMapping("crear")
    public ResponseEntity<EstatusEntity> create(@RequestBody @Validated EstatusEntity objRegistrar) {
        try {
            estatusService.save(objRegistrar);
            ResponseEntity.status(200);
            return ResponseEntity.ok(objRegistrar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        try {
            estatusService.eliminar(id);
            ResponseEntity.status(200);
            return ResponseEntity.ok("Estatus eliminado con ID: " + id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<EstatusEntity> update(
            @PathVariable("id") Long id,
            @RequestBody @Validated EstatusEntity estatus) {
        try {
            EstatusEntity estatusExistente = estatusService.findByID(id);
            estatusExistente.setNombreEstatus(estatus.getNombreEstatus());

            estatusService.save(estatusExistente);
            ResponseEntity.status(200);
            return ResponseEntity.ok(estatusExistente);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
