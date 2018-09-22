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
@Table(name = "empleadohijodiscapacidad")
@NamedQueries({
    @NamedQuery(name = "Empleadohijodiscapacidad.findAll", query = "SELECT e FROM Empleadohijodiscapacidad e")})
public class Empleadohijodiscapacidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpleadohijodiscapacidadPK empleadohijodiscapacidadPK;

    public Empleadohijodiscapacidad() {
    }

    public Empleadohijodiscapacidad(EmpleadohijodiscapacidadPK empleadohijodiscapacidadPK) {
        this.empleadohijodiscapacidadPK = empleadohijodiscapacidadPK;
    }

    public Empleadohijodiscapacidad(int codigoempleado, int codigohijodiscapacidad) {
        this.empleadohijodiscapacidadPK = new EmpleadohijodiscapacidadPK(codigoempleado, codigohijodiscapacidad);
    }

    public EmpleadohijodiscapacidadPK getEmpleadohijodiscapacidadPK() {
        return empleadohijodiscapacidadPK;
    }

    public void setEmpleadohijodiscapacidadPK(EmpleadohijodiscapacidadPK empleadohijodiscapacidadPK) {
        this.empleadohijodiscapacidadPK = empleadohijodiscapacidadPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empleadohijodiscapacidadPK != null ? empleadohijodiscapacidadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleadohijodiscapacidad)) {
            return false;
        }
        Empleadohijodiscapacidad other = (Empleadohijodiscapacidad) object;
        if ((this.empleadohijodiscapacidadPK == null && other.empleadohijodiscapacidadPK != null) || (this.empleadohijodiscapacidadPK != null && !this.empleadohijodiscapacidadPK.equals(other.empleadohijodiscapacidadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.Empleadohijodiscapacidad[ empleadohijodiscapacidadPK=" + empleadohijodiscapacidadPK + " ]";
    }
    
}
