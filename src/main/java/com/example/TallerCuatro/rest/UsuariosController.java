package com.example.TallerCuatro.rest;

import com.example.TallerCuatro.entity.UsuariosEntity;
import com.example.TallerCuatro.service.MiUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuariosController {

    @Autowired
    public MiUsuariosService usuariosService;

    @GetMapping("list")
    public ResponseEntity<List<UsuariosEntity>> findAll() {
        return ResponseEntity.ok(usuariosService.findAll());
    }

    @GetMapping("listbyid/{id}")
    public ResponseEntity<UsuariosEntity> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(usuariosService.findByID(id));
    }

    @PostMapping("crear")
    public ResponseEntity<UsuariosEntity> create(@RequestBody @Validated UsuariosEntity objRegistrar) {
        try {
            usuariosService.save(objRegistrar);
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
            usuariosService.eliminar(id);
            ResponseEntity.status(200);
            return ResponseEntity.ok("Usuario eliminado con ID: " + id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<UsuariosEntity> update(
            @PathVariable("id") Long id,
            @RequestBody @Validated UsuariosEntity usuario) {
        try {
            UsuariosEntity usuarioExistente = usuariosService.findByID(id);
            usuarioExistente.setUsername(usuario.getUsername());
            usuarioExistente.setPassword(usuario.getPassword());
            usuarioExistente.setEstado(usuario.getEstado());

            usuariosService.save(usuarioExistente);
            ResponseEntity.status(200);
            return ResponseEntity.ok(usuarioExistente);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
