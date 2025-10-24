package com.example.TallerCuatro.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "agendas")
public class AgendasEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // 🔹 Relación con la tabla Citas
    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fkcita", referencedColumnName = "idcita")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CitasEntity cita;


    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fkpaciente", referencedColumnName = "idpaciente")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PacientesEntity paciente;

    // 🔹 Getters y Setters

    public CitasEntity getCita() {
        return cita;
    }

    public void setCita(CitasEntity cita) {
        this.cita = cita;
    }

    public PacientesEntity getPaciente() {
        return paciente;
    }

    public void setPaciente(PacientesEntity paciente) {
        this.paciente = paciente;
    }
}

