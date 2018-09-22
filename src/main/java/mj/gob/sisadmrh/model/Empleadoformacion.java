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
@Table(name = "empleadoformacion")
@NamedQueries({
    @NamedQuery(name = "Empleadoformacion.findAll", query = "SELECT e FROM Empleadoformacion e")})
public class Empleadoformacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpleadoformacionPK empleadoformacionPK;

    public Empleadoformacion() {
    }

    public Empleadoformacion(EmpleadoformacionPK empleadoformacionPK) {
        this.empleadoformacionPK = empleadoformacionPK;
    }

    public Empleadoformacion(int codigoempleado, int codigoformacionacademica) {
        this.empleadoformacionPK = new EmpleadoformacionPK(codigoempleado, codigoformacionacademica);
    }

    public EmpleadoformacionPK getEmpleadoformacionPK() {
        return empleadoformacionPK;
    }

    public void setEmpleadoformacionPK(EmpleadoformacionPK empleadoformacionPK) {
        this.empleadoformacionPK = empleadoformacionPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empleadoformacionPK != null ? empleadoformacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleadoformacion)) {
            return false;
        }
        Empleadoformacion other = (Empleadoformacion) object;
        if ((this.empleadoformacionPK == null && other.empleadoformacionPK != null) || (this.empleadoformacionPK != null && !this.empleadoformacionPK.equals(other.empleadoformacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.Empleadoformacion[ empleadoformacionPK=" + empleadoformacionPK + " ]";
    }
    
}
