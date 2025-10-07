package com.example.misegundaapi.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name="vehiculo")

public class VehiculoEntity implements Serializable {


    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVhiculo")
    private Long idVehiculo;

    @Column(name = "placa", unique = true)
    private String placa;

    @Column(name = "color")
    private String color;


    @OneToOne
    @JoinColumn(name = "fkuniversidad")
    private UniversidadEntity universidad;



    public Long getIdVehiculo() {return idVehiculo;
    }

    public void setIdVehiculo(Long idVehiculo) {this.idVehiculo = idVehiculo;
    }

    public String getPlaca() {return placa;
    }

    public void setPlaca(String placa) {this.placa = placa;
    }

    public String getColor() {return color;
    }

    public void setColor(String color) {this.color = color;
    }

    public UniversidadEntity getUniversidad() {
        return universidad;
    }

    public void setUniversidad(UniversidadEntity universidad) {
        this.universidad = universidad;
    }
}
