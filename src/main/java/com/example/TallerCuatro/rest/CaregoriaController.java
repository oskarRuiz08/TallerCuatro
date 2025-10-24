package com.example.TallerCuatro.rest;

import com.example.TallerCuatro.entity.CategoriasEntity;
import com.example.TallerCuatro.service.MiCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categoria")
public class CaregoriaController {

    @Autowired
    public MiCategoriaService categoriasService;

    @GetMapping("list")
    public ResponseEntity<List<CategoriasEntity>> findAll() {
        return ResponseEntity.ok(categoriasService.findAll());
    }

    @GetMapping("listbyid/{id}")
    public ResponseEntity<CategoriasEntity> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(categoriasService.findByID(id));
    }

    @PostMapping("crear")
    public ResponseEntity<CategoriasEntity> create(@RequestBody @Validated CategoriasEntity objRegistrar) {
        try {
            categoriasService.save(objRegistrar);
            ResponseEntity.status(200);
            return ResponseEntity.ok(objRegistrar);
        } catch (Exception e) {
            System.out.println("Error al crear categoría: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        try {
            categoriasService.eliminar(id);
            ResponseEntity.status(200);
            return ResponseEntity.ok("Categoría eliminada con ID: " + id);
        } catch (Exception e) {
            System.out.println("Error al eliminar categoría: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @PutMapping("edit/{id}")
    public ResponseEntity<CategoriasEntity> update(
            @PathVariable("id") Long id,
            @RequestBody @Validated CategoriasEntity categoria) {
        try {
            CategoriasEntity categoriaExistente = categoriasService.findByID(id);
            if (categoriaExistente == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            categoriaExistente.setNombrecategoria(categoria.getNombrecategoria());
            categoriasService.save(categoriaExistente);

            ResponseEntity.status(200);
            return ResponseEntity.ok(categoriaExistente);

        } catch (Exception e) {
            System.out.println("Error al actualizar categoría: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
