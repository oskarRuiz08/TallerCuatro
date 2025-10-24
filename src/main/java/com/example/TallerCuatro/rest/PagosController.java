package com.example.TallerCuatro.rest;

import com.example.TallerCuatro.entity.PagosEntity;
import com.example.TallerCuatro.service.MiPagosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pagos")
public class PagosController {

    @Autowired
    public MiPagosService pagosService;

    @GetMapping("list")
    public ResponseEntity<List<PagosEntity>> findAll() {
        return ResponseEntity.ok(pagosService.findAll());
    }

    @GetMapping("listbyid/{id}")
    public ResponseEntity<PagosEntity> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(pagosService.findByID(id));
    }

    @PostMapping("crear")
    public ResponseEntity<PagosEntity> create(@RequestBody @Validated PagosEntity objRegistrar) {
        try {
            pagosService.save(objRegistrar);
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
            pagosService.eliminar(id);
            ResponseEntity.status(200);
            return ResponseEntity.ok("Pago eliminado con ID: " + id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<PagosEntity> update(
            @PathVariable("id") Long id,
            @RequestBody @Validated PagosEntity pago) {
        try {
            PagosEntity pagoExistente = pagosService.findByID(id);
            pagoExistente.setTipoPago(pago.getTipoPago());

            pagosService.save(pagoExistente);
            ResponseEntity.status(200);
            return ResponseEntity.ok(pagoExistente);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
