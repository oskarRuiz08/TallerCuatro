package com.example.TallerCuatro.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "medicos")

public class MedicosEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmedico")
    private Long idmedico;

    @Column(name = "nombres", length = 50)
    private String nombres;

    @Column(name = "primerApellido", length = 15)
    private String primerApellido;

    @Column(name = "segundoApellido", length = 15)
    private String segundoApellido;

    @Column(name = "genero")
    private Integer genero;

    @Column(name = "email", length = 15)
    private String email;

    @Column(name = "telefono", length = 15)
    private String telefono;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idcategoria", referencedColumnName = "idcategoria")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CategoriasEntity categoria;

    public Long getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(Long idmedico) {
        this.idmedico = idmedico;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Integer getGenero() {
        return genero;
    }

    public void setGenero(Integer genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public CategoriasEntity getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriasEntity categoria) {
        this.categoria = categoria;
    }
}
