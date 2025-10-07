package com.example.misegundaapi.rest;


import com.example.misegundaapi.entity.UniversidadEntity;
import com.example.misegundaapi.repository.UniversidadRepository;
import com.example.misegundaapi.service.MiUniversidadService;
import jakarta.persistence.Id;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("universidad")
public class UniversidadController {

    @Autowired
    private MiUniversidadService universidadService;
    @Autowired
    private UniversidadRepository universidadRepository;

    @GetMapping("list")
    public ResponseEntity<List<UniversidadEntity>> findAll() {
    return ResponseEntity.ok(universidadService.findAll());
    }

    @GetMapping("listbyid/{id}")
    public ResponseEntity<UniversidadEntity> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(universidadService.findByID(id));
    }

    @GetMapping("listbyidParam/{id}")
    public ResponseEntity<UniversidadEntity> findByIdParam(@PathVariable("id") Long id) {
        return ResponseEntity.ok(universidadService.findByID(id));
    }

    @GetMapping("listbyNit/{nit}")
    public ResponseEntity<UniversidadEntity> findByNit(@PathVariable("nit") String nit) {
        return ResponseEntity.ok(universidadService.findByNit(nit));
    }


    @GetMapping("listbyDescOrPunt/{descripcion}/{puntuacion}")
    public ResponseEntity<List<UniversidadEntity>> findBydescripcioOrpuntuacion(@PathVariable("descripcion") String descripcion, @PathVariable("puntuacion") float puntuacion) {
        return ResponseEntity.ok(universidadService.findBydescripcioOrpuntuacion(descripcion, puntuacion));
    }

    @PostMapping("crear")
    public ResponseEntity<UniversidadEntity> create(@RequestBody
                                                    @Validated UniversidadEntity objCrear) {
        try {
            universidadService.save(objCrear);
            ResponseEntity.status(200);
            return ResponseEntity.ok(objCrear);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {

        try {
            universidadService.eliminar(id);
            ResponseEntity.status(200);
            return ResponseEntity.ok("Eliminado " + id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }


    }

    @PutMapping("edit/{id}")
    public ResponseEntity<UniversidadEntity> update(
            @PathVariable("id") Long id,
            @RequestBody @Validated UniversidadEntity universidad) {
        try {
            UniversidadEntity uniExist = universidadService.findByID(id);
            uniExist.setNit(universidad.getNit());
            uniExist.setNombre(universidad.getNombre());
            uniExist.setDescripcion(universidad.getDescripcion());
            uniExist.setPuntuacion(universidad.getPuntuacion());
            universidadService.save(uniExist);
            ResponseEntity.status(200);
            return ResponseEntity.ok(uniExist);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
