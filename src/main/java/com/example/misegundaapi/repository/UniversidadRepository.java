package com.example.misegundaapi.repository;

import com.example.misegundaapi.entity.UniversidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UniversidadRepository extends JpaRepository<UniversidadEntity,Long>  {

    @Query("Select uni FROM UniversidadEntity uni WHERE uni.id = ?1")
    public UniversidadEntity findById(String id);

    @Query("SELECT uni FROM UniversidadEntity uni WHERE uni.descripcion = ?1 OR uni.puntuacion = ?2")
    public List<UniversidadEntity> findByDescripcionOrpuntuacion(String descripcion, float puntuacion);

}