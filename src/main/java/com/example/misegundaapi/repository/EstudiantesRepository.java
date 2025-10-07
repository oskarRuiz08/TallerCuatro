package com.example.misegundaapi.repository;

import com.example.misegundaapi.entity.EstudiantesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudiantesRepository extends JpaRepository<EstudiantesEntity,String> {
}
