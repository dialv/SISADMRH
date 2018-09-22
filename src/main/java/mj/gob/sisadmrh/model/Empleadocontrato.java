/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author developer
 */
@Entity
@Table(name = "empleadocontrato")
@NamedQueries({
    @NamedQuery(name = "Empleadocontrato.findAll", query = "SELECT e FROM Empleadocontrato e")})
public class Empleadocontrato implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpleadocontratoPK empleadocontratoPK;

    public Empleadocontrato() {
    }

    public Empleadocontrato(EmpleadocontratoPK empleadocontratoPK) {
        this.empleadocontratoPK = empleadocontratoPK;
    }

    public Empleadocontrato(int codigoempleado, int codigocontrato) {
        this.empleadocontratoPK = new EmpleadocontratoPK(codigoempleado, codigocontrato);
    }

    public EmpleadocontratoPK getEmpleadocontratoPK() {
        return empleadocontratoPK;
    }

    public void setEmpleadocontratoPK(EmpleadocontratoPK empleadocontratoPK) {
        this.empleadocontratoPK = empleadocontratoPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empleadocontratoPK != null ? empleadocontratoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleadocontrato)) {
            return false;
        }
        Empleadocontrato other = (Empleadocontrato) object;
        if ((this.empleadocontratoPK == null && other.empleadocontratoPK != null) || (this.empleadocontratoPK != null && !this.empleadocontratoPK.equals(other.empleadocontratoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.Empleadocontrato[ empleadocontratoPK=" + empleadocontratoPK + " ]";
    }
    
}
