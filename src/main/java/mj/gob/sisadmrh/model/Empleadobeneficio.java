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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author root
 */
@Entity
@Table(name = "empleadobeneficio")
@NamedQueries({
    @NamedQuery(name = "Empleadobeneficio.findAll", query = "SELECT e FROM Empleadobeneficio e")})
public class Empleadobeneficio implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpleadobeneficioPK empleadobeneficioPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHABENEFICIO")
//    
    private Date fechabeneficio;
    @JoinColumn(name = "CODIGOBENEFICIO", referencedColumnName = "CODIGOBENEFICIO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Beneficio beneficio;
    @JoinColumn(name = "CODIGOEMPLEADO", referencedColumnName = "CODIGOEMPLEADO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleado empleado;

    public Empleadobeneficio() {
    }

    public Empleadobeneficio(EmpleadobeneficioPK empleadobeneficioPK) {
        this.empleadobeneficioPK = empleadobeneficioPK;
    }

    public Empleadobeneficio(EmpleadobeneficioPK empleadobeneficioPK, Date fechabeneficio) {
        this.empleadobeneficioPK = empleadobeneficioPK;
        this.fechabeneficio = fechabeneficio;
    }

    public Empleadobeneficio(int codigoempleado, int codigobeneficio) {
        this.empleadobeneficioPK = new EmpleadobeneficioPK(codigoempleado, codigobeneficio);
    }

    public EmpleadobeneficioPK getEmpleadobeneficioPK() {
        return empleadobeneficioPK;
    }

    public void setEmpleadobeneficioPK(EmpleadobeneficioPK empleadobeneficioPK) {
        this.empleadobeneficioPK = empleadobeneficioPK;
    }

    public Date getFechabeneficio() {
        return fechabeneficio;
    }

    public void setFechabeneficio(Date fechabeneficio) {
        this.fechabeneficio = fechabeneficio;
    }

    public Beneficio getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(Beneficio beneficio) {
        this.beneficio = beneficio;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empleadobeneficioPK != null ? empleadobeneficioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleadobeneficio)) {
            return false;
        }
        Empleadobeneficio other = (Empleadobeneficio) object;
        if ((this.empleadobeneficioPK == null && other.empleadobeneficioPK != null) || (this.empleadobeneficioPK != null && !this.empleadobeneficioPK.equals(other.empleadobeneficioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.Empleadobeneficio[ empleadobeneficioPK=" + empleadobeneficioPK + " ]";
    }
    
}
