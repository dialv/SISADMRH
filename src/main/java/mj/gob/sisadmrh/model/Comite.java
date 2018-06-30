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

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "COMITE")
@NamedQueries({
@NamedQuery(name = "Comite.findAll", query = "SELECT c FROM Comite c")})
public class Comite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGOCOMITE")
    private Integer codigocomite;
    @Size(max = 50)
    @Column(name = "NOMBRECOMITE")
    private String nombrecomite;
    @Size(max = 30)
    @Column(name = "RESPONSABLECOMITE")
    private String responsablecomite;
    @Size(max = 100)
    @Column(name = "DESRIPCIONCOMITE")
    private String desripcioncomite;
    @Column(name = "NUMEROACUERDOCOMITE")
    private Integer numeroacuerdocomite;
    @Column(name = "MIEMBROMAXIMO")
    private Integer miembromaximo;
    @Column(name = "FECHADESDECOMITE")
    @Temporal(TemporalType.DATE)
    private Date fechadesdecomite;
    @Column(name = "FECHAHASTACOMITE")
    @Temporal(TemporalType.DATE)
    private Date fechahastacomite;
    @JoinColumn(name = "CODIGOEMPLEADO", referencedColumnName = "CODIGOEMPLEADO")
    @ManyToOne(optional = false)
    private Empleado codigoempleado;

    public Comite() {
    }

    public Comite(Integer codigocomite) {
        this.codigocomite = codigocomite;
    }

    public Integer getCodigocomite() {
        return codigocomite;
    }

    public void setCodigocomite(Integer codigocomite) {
        this.codigocomite = codigocomite;
    }

    public String getNombrecomite() {
        return nombrecomite;
    }

    public void setNombrecomite(String nombrecomite) {
        this.nombrecomite = nombrecomite;
    }

    public String getResponsablecomite() {
        return responsablecomite;
    }

    public void setResponsablecomite(String responsablecomite) {
        this.responsablecomite = responsablecomite;
    }

    public String getDesripcioncomite() {
        return desripcioncomite;
    }

    public void setDesripcioncomite(String desripcioncomite) {
        this.desripcioncomite = desripcioncomite;
    }

    public Integer getNumeroacuerdocomite() {
        return numeroacuerdocomite;
    }

    public void setNumeroacuerdocomite(Integer numeroacuerdocomite) {
        this.numeroacuerdocomite = numeroacuerdocomite;
    }

    public Integer getMiembromaximo() {
        return miembromaximo;
    }

    public void setMiembromaximo(Integer miembromaximo) {
        this.miembromaximo = miembromaximo;
    }

    public Date getFechadesdecomite() {
        return fechadesdecomite;
    }

    public void setFechadesdecomite(Date fechadesdecomite) {
        this.fechadesdecomite = fechadesdecomite;
    }

    public Date getFechahastacomite() {
        return fechahastacomite;
    }

    public void setFechahastacomite(Date fechahastacomite) {
        this.fechahastacomite = fechahastacomite;
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
        hash += (codigocomite != null ? codigocomite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comite)) {
            return false;
        }
        Comite other = (Comite) object;
        if ((this.codigocomite == null && other.codigocomite != null) || (this.codigocomite != null && !this.codigocomite.equals(other.codigocomite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.Comite[ codigocomite=" + codigocomite + " ]";
    }
    
}