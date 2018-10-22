/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author developer
 */
@Entity
@Table(name = "empleadodependiente")
@NamedQueries({
    @NamedQuery(name = "Empleadodependiente.findAll", query = "SELECT e FROM Empleadodependiente e")})
public class Empleadodependiente implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpleadodependientePK empleadodependientePK;
     @JoinColumn(name = "codigodependiente", referencedColumnName = "codigodependiente", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Dependiente dependiente;

    public Dependiente getDependiente() {
        return dependiente;
    }

    public void setDependiente(Dependiente dependiente) {
        this.dependiente = dependiente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    @JoinColumn(name = "codigoempleado", referencedColumnName = "codigoempleado", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleado empleado;

    public Empleadodependiente() {
    }

    public Empleadodependiente(EmpleadodependientePK empleadodependientePK) {
        this.empleadodependientePK = empleadodependientePK;
    }

    public Empleadodependiente(int codigoempleado, int codigodependiente) {
        this.empleadodependientePK = new EmpleadodependientePK(codigoempleado, codigodependiente);
    }

    public EmpleadodependientePK getEmpleadodependientePK() {
        return empleadodependientePK;
    }

    public void setEmpleadodependientePK(EmpleadodependientePK empleadodependientePK) {
        this.empleadodependientePK = empleadodependientePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empleadodependientePK != null ? empleadodependientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleadodependiente)) {
            return false;
        }
        Empleadodependiente other = (Empleadodependiente) object;
        if ((this.empleadodependientePK == null && other.empleadodependientePK != null) || (this.empleadodependientePK != null && !this.empleadodependientePK.equals(other.empleadodependientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.Empleadodependiente[ empleadodependientePK=" + empleadodependientePK + " ]";
    }
    
}
