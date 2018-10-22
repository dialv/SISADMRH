/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.model;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;

/**
 *
 * @author developer
 */
@Entity
@Table(name = "empleadoubicacionfisica")
@NamedQueries({
    @NamedQuery(name = "Empleadoubicacionfisica.findAll", query = "SELECT e FROM Empleadoubicacionfisica e")})
public class Empleadoubicacionfisica implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpleadoubicacionfisicaPK empleadoubicacionfisicaPK;
     @JoinColumn(name = "codigoubicacion", referencedColumnName = "codigoubicacion", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ubicacionfisica ubicacionfisica;

    public Ubicacionfisica getUbicacionfisica() {
        return ubicacionfisica;
    }

    public void setUbicacionfisica(Ubicacionfisica ubicacionfisica) {
        this.ubicacionfisica = ubicacionfisica;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "b_activo")
    private int bActivo;

    public Empleadoubicacionfisica() {
    }

    public Empleadoubicacionfisica(EmpleadoubicacionfisicaPK empleadoubicacionfisicaPK) {
        this.empleadoubicacionfisicaPK = empleadoubicacionfisicaPK;
    }

    public Empleadoubicacionfisica(EmpleadoubicacionfisicaPK empleadoubicacionfisicaPK, int bActivo) {
        this.empleadoubicacionfisicaPK = empleadoubicacionfisicaPK;
        this.bActivo = bActivo;
    }

    public Empleadoubicacionfisica(int codigoempleado, int codigoubicacion) {
        this.empleadoubicacionfisicaPK = new EmpleadoubicacionfisicaPK(codigoempleado, codigoubicacion);
    }

    public EmpleadoubicacionfisicaPK getEmpleadoubicacionfisicaPK() {
        return empleadoubicacionfisicaPK;
    }

    public void setEmpleadoubicacionfisicaPK(EmpleadoubicacionfisicaPK empleadoubicacionfisicaPK) {
        this.empleadoubicacionfisicaPK = empleadoubicacionfisicaPK;
    }

    public int getBActivo() {
        return bActivo;
    }

    public void setBActivo(int bActivo) {
        this.bActivo = bActivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empleadoubicacionfisicaPK != null ? empleadoubicacionfisicaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleadoubicacionfisica)) {
            return false;
        }
        Empleadoubicacionfisica other = (Empleadoubicacionfisica) object;
        if ((this.empleadoubicacionfisicaPK == null && other.empleadoubicacionfisicaPK != null) || (this.empleadoubicacionfisicaPK != null && !this.empleadoubicacionfisicaPK.equals(other.empleadoubicacionfisicaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.Empleadoubicacionfisica[ empleadoubicacionfisicaPK=" + empleadoubicacionfisicaPK + " ]";
    }
    
}
