package com.example.TallerCuatro.entity;

import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "estatus")
public class EstatusEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idestatus")
    private Long idestatus;

    @Column(name = "nombreEstatus", length = 200)
    private String nombreEstatus;

    public Long getIdestatus() {
        return idestatus;
    }

    public void setIdestatus(Long idestatus) {
        this.idestatus = idestatus;
    }

    public String getNombreEstatus() {
        return nombreEstatus;
    }

    public void setNombreEstatus(String nombreEstatus) {
        this.nombreEstatus = nombreEstatus;
    }
}
