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
@Table(name = "empleadoexperiencialaboral")
@NamedQueries({
    @NamedQuery(name = "Empleadoexperiencialaboral.findAll", query = "SELECT e FROM Empleadoexperiencialaboral e")})
public class Empleadoexperiencialaboral implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpleadoexperiencialaboralPK empleadoexperiencialaboralPK;

    public Empleadoexperiencialaboral() {
    }

    public Empleadoexperiencialaboral(EmpleadoexperiencialaboralPK empleadoexperiencialaboralPK) {
        this.empleadoexperiencialaboralPK = empleadoexperiencialaboralPK;
    }

    public Empleadoexperiencialaboral(int codigoempleado, int codigoexperiencialaboral) {
        this.empleadoexperiencialaboralPK = new EmpleadoexperiencialaboralPK(codigoempleado, codigoexperiencialaboral);
    }

    public EmpleadoexperiencialaboralPK getEmpleadoexperiencialaboralPK() {
        return empleadoexperiencialaboralPK;
    }

    public void setEmpleadoexperiencialaboralPK(EmpleadoexperiencialaboralPK empleadoexperiencialaboralPK) {
        this.empleadoexperiencialaboralPK = empleadoexperiencialaboralPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empleadoexperiencialaboralPK != null ? empleadoexperiencialaboralPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleadoexperiencialaboral)) {
            return false;
        }
        Empleadoexperiencialaboral other = (Empleadoexperiencialaboral) object;
        if ((this.empleadoexperiencialaboralPK == null && other.empleadoexperiencialaboralPK != null) || (this.empleadoexperiencialaboralPK != null && !this.empleadoexperiencialaboralPK.equals(other.empleadoexperiencialaboralPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.Empleadoexperiencialaboral[ empleadoexperiencialaboralPK=" + empleadoexperiencialaboralPK + " ]";
    }
    
}
