package com.example.TallerCuatro.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "citas")
public class CitasEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcita")
    private Long idcita;

    @Column(name = "titulo", length = 50)
    private String titulo;

    @Column(name = "nota", length = 50)
    private String nota;

    @Column(name = "fecha_cita")
    @Temporal(TemporalType.DATE)
    private Date fecha_cita;

    @Column(name = "sintomas", length = 100)
    private String sintomas;

    @Column(name = "medicamentos", length = 100)
    private String medicamentos;

    @Column(name = "tipocita", length = 100)
    private Integer tipocita;

    @Column(name = "antecedentes")
    private Boolean antecedentes;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idmedico", referencedColumnName = "idmedico")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private MedicosEntity medico;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idpago", referencedColumnName = "idpago")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PagosEntity pago;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idestatus", referencedColumnName = "idestatus")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private EstatusEntity estatus;



    //Agendas


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

    public MedicosEntity getMedico() {
        return medico;
    }

    public void setMedico(MedicosEntity medico) {
        this.medico = medico;
    }

    public PagosEntity getPago() {
        return pago;
    }

    public void setPago(PagosEntity pago) {
        this.pago = pago;
    }

    public EstatusEntity getEstatus() {
        return estatus;
    }

    public void setEstatus(EstatusEntity estatus) {
        this.estatus = estatus;
    }
}
