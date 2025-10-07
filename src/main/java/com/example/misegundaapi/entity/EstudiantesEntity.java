package com.example.misegundaapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name="estudiantes")

public class EstudiantesEntity implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "documento")
    private String documento;

    @Column(name = "nombres")
    private String nombre;

    @Column(name = "tipo_documento")
    private Integer tipoDocumento;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "extensionnumero")
    private String extensionnumero;



    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fkuniversidad",
            referencedColumnName = "iduniversidad")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UniversidadEntity universidad;


    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(Integer tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getExtensionnumero() {
        return extensionnumero;
    }

    public void setExtensionnumero(String extensionnumero) {
        this.extensionnumero = extensionnumero;
    }

    public UniversidadEntity getUniversidad() {
        return universidad;
    }

    public void setUniversidad(UniversidadEntity universidad) {
        this.universidad = universidad;
    }
}
