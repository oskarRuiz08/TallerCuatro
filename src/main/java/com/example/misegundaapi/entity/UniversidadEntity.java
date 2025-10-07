package com.example.misegundaapi.entity;

import jakarta.persistence.*;


import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name="universidades")

public class UniversidadEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduniversidad")
    private Long iduniversidad;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nit", unique = true)
    private String nit;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "puntuacion")
    private Integer puntuacion;

    @Column(name = "descripcion")
    private String descripcion;


    @OneToOne(mappedBy = "universidad")
    private VehiculoEntity vehiculo;




    public Long getIduniversidad() {
        return iduniversidad;
    }

    public void setIduniversidad(Long iduniversidad) {
        this.iduniversidad = iduniversidad;
    }

    public VehiculoEntity getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoEntity vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}