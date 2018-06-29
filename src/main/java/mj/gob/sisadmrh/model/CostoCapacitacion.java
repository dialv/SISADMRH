/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "COSTOCAPACITACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Costocapacitacion.findAll", query = "SELECT c FROM Costocapacitacion c"),
    @NamedQuery(name = "Costocapacitacion.findByCodigocostocapacitacion", query = "SELECT c FROM Costocapacitacion c WHERE c.codigocostocapacitacion = :codigocostocapacitacion"),
    @NamedQuery(name = "Costocapacitacion.findByCostopersona", query = "SELECT c FROM Costocapacitacion c WHERE c.costopersona = :costopersona"),
    @NamedQuery(name = "Costocapacitacion.findByNumeropersona", query = "SELECT c FROM Costocapacitacion c WHERE c.numeropersona = :numeropersona"),
    @NamedQuery(name = "Costocapacitacion.findByCostocapacitador", query = "SELECT c FROM Costocapacitacion c WHERE c.costocapacitador = :costocapacitador")})
public class Costocapacitacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGOCOSTOCAPACITACION")
    private Integer codigocostocapacitacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COSTOPERSONA")
    private Float costopersona;
    @Column(name = "NUMEROPERSONA")
    private Integer numeropersona;
    @Column(name = "COSTOCAPACITADOR")
    private Float costocapacitador;
    @JoinColumn(name = "CODIGOCAPACITACION", referencedColumnName = "CODIGOCAPACITACION")
    @ManyToOne(optional = false)
    private Capacitacion codigocapacitacion;

    public Costocapacitacion() {
    }

    public Costocapacitacion(Integer codigocostocapacitacion) {
        this.codigocostocapacitacion = codigocostocapacitacion;
    }

    public Integer getCodigocostocapacitacion() {
        return codigocostocapacitacion;
    }

    public void setCodigocostocapacitacion(Integer codigocostocapacitacion) {
        this.codigocostocapacitacion = codigocostocapacitacion;
    }

    public Float getCostopersona() {
        return costopersona;
    }

    public void setCostopersona(Float costopersona) {
        this.costopersona = costopersona;
    }

    public Integer getNumeropersona() {
        return numeropersona;
    }

    public void setNumeropersona(Integer numeropersona) {
        this.numeropersona = numeropersona;
    }

    public Float getCostocapacitador() {
        return costocapacitador;
    }

    public void setCostocapacitador(Float costocapacitador) {
        this.costocapacitador = costocapacitador;
    }

    public Capacitacion getCodigocapacitacion() {
        return codigocapacitacion;
    }

    public void setCodigocapacitacion(Capacitacion codigocapacitacion) {
        this.codigocapacitacion = codigocapacitacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigocostocapacitacion != null ? codigocostocapacitacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Costocapacitacion)) {
            return false;
        }
        Costocapacitacion other = (Costocapacitacion) object;
        if ((this.codigocostocapacitacion == null && other.codigocostocapacitacion != null) || (this.codigocostocapacitacion != null && !this.codigocostocapacitacion.equals(other.codigocostocapacitacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.Costocapacitacion[ codigocostocapacitacion=" + codigocostocapacitacion + " ]";
    }
    
}
