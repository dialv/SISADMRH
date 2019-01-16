/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author gladiador
 */
@Entity
@Table(name = "contrato")
@NamedQueries({
    @NamedQuery(name = "Contrato.findAll", query = "SELECT c FROM Contrato c")})
public class Contrato implements Serializable {

    @Size(max = 100)
    @Column(name = "PLAZANOMINAL")
    private String plazanominal;
    @Size(max = 50)
    @Column(name = "SISTEMAPAGO")
    private String sistemapago;
    @Size(max = 100)
    @Column(name = "UNIDADPRECIDE")
    private String unidadprecide;
    @Size(max = 100)
    @Column(name = "LINEATRABAJO")
    private String lineatrabajo;
    @Size(max = 9)
    @Column(name = "PARTIDACONTRATO")
    private String partidacontrato;
    @Size(max = 100)
    @Column(name = "SUBPARTIDACONTRATO")
    private String subpartidacontrato;
    @Column(name = "estadocontrato")
    private Integer estadocontrato;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CODIGOCONTRATO")
    private Integer codigocontrato;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SALARIOACTUAL")
    private Float salarioactual;
    @Column(name = "FECHAINICIOCONTRATO")
    @DateTimeFormat(pattern = "YYYY/MM/dd")
    private Date fechainiciocontrato;
    @Column(name = "FECHAFINCONTRATO")
    @DateTimeFormat(pattern = "YYYY/MM/dd")
    private Date fechafincontrato;
    @JoinColumn(name = "CODIGOEMPLEADO", referencedColumnName = "CODIGOEMPLEADO")
    @ManyToOne(optional = false)
    private Empleado codigoempleado;

    public Contrato() {
    }

    public Contrato(Integer codigocontrato) {
        this.codigocontrato = codigocontrato;
    }

    public Integer getCodigocontrato() {
        return codigocontrato;
    }

    public void setCodigocontrato(Integer codigocontrato) {
        this.codigocontrato = codigocontrato;
    }

    public Float getSalarioactual() {
        return salarioactual;
    }

    public void setSalarioactual(Float salarioactual) {
        this.salarioactual = salarioactual;
    }


    public Date getFechainiciocontrato() {
        return fechainiciocontrato;
    }

    public void setFechainiciocontrato(Date fechainiciocontrato) {
        this.fechainiciocontrato = fechainiciocontrato;
    }

    public Date getFechafincontrato() {
        return fechafincontrato;
    }

    public void setFechafincontrato(Date fechafincontrato) {
        this.fechafincontrato = fechafincontrato;
    }

    public Empleado getCodigoempleado() {
        return codigoempleado;
    }

    public void setCodigoempleado(Empleado codigoempleado) {
        this.codigoempleado = codigoempleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigocontrato != null ? codigocontrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contrato)) {
            return false;
        }
        Contrato other = (Contrato) object;
        if ((this.codigocontrato == null && other.codigocontrato != null) || (this.codigocontrato != null && !this.codigocontrato.equals(other.codigocontrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.Contrato[ codigocontrato=" + codigocontrato + " ]";
    }

    public String getPlazanominal() {
        return plazanominal;
    }

    public void setPlazanominal(String plazanominal) {
        this.plazanominal = plazanominal;
    }

    public String getSistemapago() {
        return sistemapago;
    }

    public void setSistemapago(String sistemapago) {
        this.sistemapago = sistemapago;
    }

    public String getUnidadprecide() {
        return unidadprecide;
    }

    public void setUnidadprecide(String unidadprecide) {
        this.unidadprecide = unidadprecide;
    }

    public String getLineatrabajo() {
        return lineatrabajo;
    }

    public void setLineatrabajo(String lineatrabajo) {
        this.lineatrabajo = lineatrabajo;
    }

    public String getPartidacontrato() {
        return partidacontrato;
    }

    public void setPartidacontrato(String partidacontrato) {
        this.partidacontrato = partidacontrato;
    }

    public String getSubpartidacontrato() {
        return subpartidacontrato;
    }

    public void setSubpartidacontrato(String subpartidacontrato) {
        this.subpartidacontrato = subpartidacontrato;
    }

    public Integer getEstadocontrato() {
        return estadocontrato;
    }

    public void setEstadocontrato(Integer estadocontrato) {
        this.estadocontrato = estadocontrato;
    }
    
}
