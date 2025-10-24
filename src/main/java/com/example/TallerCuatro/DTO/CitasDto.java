package com.example.TallerCuatro.DTO;

import java.util.Date;

public class CitasDto {
    public Long idcita;
    public String titulo;
    public String nota;
    public Date fecha_cita;
    public String sintomas;
    public String medicamentos;
    public Integer tipocita;
    public Boolean antecedentes;
    public Long idmedico;
    public Long idpago;
    public Long idestatus;

    public CitasDto() {
    }

    public Long getIdcita() {
        return idcita;
    }

    public void setIdcita(Long idcita) {
        this.idcita = idcita;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Date getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(Date fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public Integer getTipocita() {
        return tipocita;
    }

    public void setTipocita(Integer tipocita) {
        this.tipocita = tipocita;
    }

    public Boolean getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(Boolean antecedentes) {
        this.antecedentes = antecedentes;
    }

    public Long getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(Long idmedico) {
        this.idmedico = idmedico;
    }

    public Long getIdpago() {
        return idpago;
    }

    public void setIdpago(Long idpago) {
        this.idpago = idpago;
    }

    public Long getIdestatus() {
        return idestatus;
    }

    public void setIdestatus(Long idestatus) {
        this.idestatus = idestatus;
    }
}
