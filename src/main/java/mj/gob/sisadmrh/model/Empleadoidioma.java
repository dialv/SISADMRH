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
@Table(name = "empleadoidioma")
@NamedQueries({
    @NamedQuery(name = "Empleadoidioma.findAll", query = "SELECT e FROM Empleadoidioma e")})
public class Empleadoidioma implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpleadoidiomaPK empleadoidiomaPK;

    public Empleadoidioma() {
    }

    public Empleadoidioma(EmpleadoidiomaPK empleadoidiomaPK) {
        this.empleadoidiomaPK = empleadoidiomaPK;
    }

    public Empleadoidioma(int codigoempleado, int codigoidioma) {
        this.empleadoidiomaPK = new EmpleadoidiomaPK(codigoempleado, codigoidioma);
    }

    public EmpleadoidiomaPK getEmpleadoidiomaPK() {
        return empleadoidiomaPK;
    }

    public void setEmpleadoidiomaPK(EmpleadoidiomaPK empleadoidiomaPK) {
        this.empleadoidiomaPK = empleadoidiomaPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empleadoidiomaPK != null ? empleadoidiomaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleadoidioma)) {
            return false;
        }
        Empleadoidioma other = (Empleadoidioma) object;
        if ((this.empleadoidiomaPK == null && other.empleadoidiomaPK != null) || (this.empleadoidiomaPK != null && !this.empleadoidiomaPK.equals(other.empleadoidiomaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.Empleadoidioma[ empleadoidiomaPK=" + empleadoidiomaPK + " ]";
    }
    
}
