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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Entity
@Table(name = "rol")
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r")})
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CODIGOROL")
    private Integer codigorol;
    @Size(max = 100)
    @Column(name = "NOMBREROL")
    private String nombrerol;
    @Size(max = 30)
    @Column(name = "descripcionrol")
    private String descripcionrol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADOROL")
    private int estadorol;

    public Rol() {
    }

    public Rol(Integer codigorol) {
        this.codigorol = codigorol;
    }

    public Rol(Integer codigorol, int estadorol) {
        this.codigorol = codigorol;
        this.estadorol = estadorol;
    }

    public Integer getCodigorol() {
        return codigorol;
    }

    public void setCodigorol(Integer codigorol) {
        this.codigorol = codigorol;
    }

    public String getNombrerol() {
        return nombrerol;
    }

    public void setNombrerol(String nombrerol) {
        this.nombrerol = nombrerol;
    }

    public String getDescripcionrol() {
        return descripcionrol;
    }

    public void setDescripcionrol(String descripcionrol) {
        this.descripcionrol = descripcionrol;
    }

    public int getEstadorol() {
        return estadorol;
    }

    public void setEstadorol(int estadorol) {
        this.estadorol = estadorol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigorol != null ? codigorol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.codigorol == null && other.codigorol != null) || (this.codigorol != null && !this.codigorol.equals(other.codigorol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.Rol[ codigorol=" + codigorol + " ]";
    }
    
}
