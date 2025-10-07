package com.example.misegundaapi.DTO;

public class EstudianteDTO {
    private String documento;
    private String nombre;
    private Integer tipoDocumento;
    private String telefono;
    private String extensionnumero;
    private Long fkUniversidad;

    public EstudianteDTO() {
    }

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

    public Long getFkUniversidad() {
        return fkUniversidad;
    }

    public void setFkUniversidad(Long fkUniversidad) {
        this.fkUniversidad = fkUniversidad;
    }
}
