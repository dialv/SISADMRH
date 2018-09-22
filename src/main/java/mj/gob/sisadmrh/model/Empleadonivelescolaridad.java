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
@Table(name = "empleadonivelescolaridad")
@NamedQueries({
    @NamedQuery(name = "Empleadonivelescolaridad.findAll", query = "SELECT e FROM Empleadonivelescolaridad e")})
public class Empleadonivelescolaridad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpleadonivelescolaridadPK empleadonivelescolaridadPK;

    public Empleadonivelescolaridad() {
    }

    public Empleadonivelescolaridad(EmpleadonivelescolaridadPK empleadonivelescolaridadPK) {
        this.empleadonivelescolaridadPK = empleadonivelescolaridadPK;
    }

    public Empleadonivelescolaridad(int codigoempleado, int codigonivelnivelescolaridad) {
        this.empleadonivelescolaridadPK = new EmpleadonivelescolaridadPK(codigoempleado, codigonivelnivelescolaridad);
    }

    public EmpleadonivelescolaridadPK getEmpleadonivelescolaridadPK() {
        return empleadonivelescolaridadPK;
    }

    public void setEmpleadonivelescolaridadPK(EmpleadonivelescolaridadPK empleadonivelescolaridadPK) {
        this.empleadonivelescolaridadPK = empleadonivelescolaridadPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empleadonivelescolaridadPK != null ? empleadonivelescolaridadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleadonivelescolaridad)) {
            return false;
        }
        Empleadonivelescolaridad other = (Empleadonivelescolaridad) object;
        if ((this.empleadonivelescolaridadPK == null && other.empleadonivelescolaridadPK != null) || (this.empleadonivelescolaridadPK != null && !this.empleadonivelescolaridadPK.equals(other.empleadonivelescolaridadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.Empleadonivelescolaridad[ empleadonivelescolaridadPK=" + empleadonivelescolaridadPK + " ]";
    }
    
}
