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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author developer
 */
@Entity
@Table(name = "hijodiscapacidad")
@NamedQueries({
    @NamedQuery(name = "Hijodiscapacidad.findAll", query = "SELECT h FROM Hijodiscapacidad h")})
public class Hijodiscapacidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigohijodiscapacidad")
    private Integer codigohijodiscapacidad;
    @Size(max = 50)
    @Column(name = "nombrehijodiscapacidad")
    private String nombrehijodiscapacidad;
    @Size(max = 50)
    @Column(name = "apellidohijodiscapacidad")
    private String apellidohijodiscapacidad;
    @Size(max = 50)
    @Column(name = "nombrediscapacidad")
    private String nombrediscapacidad;
    @Size(max = 50)
    @Column(name = "tipodiscapacidad")
    private String tipodiscapacidad;
    @Column(name = "fechanamimientohijosdiscapacidad")
    @DateTimeFormat(pattern = "YYYY/MM/dd")
    private Date fechanamimientohijosdiscapacidad;

    public Hijodiscapacidad() {
    }

    public Hijodiscapacidad(Integer codigohijodiscapacidad) {
        this.codigohijodiscapacidad = codigohijodiscapacidad;
    }

    public Integer getCodigohijodiscapacidad() {
        return codigohijodiscapacidad;
    }

    public void setCodigohijodiscapacidad(Integer codigohijodiscapacidad) {
        this.codigohijodiscapacidad = codigohijodiscapacidad;
    }

    public String getNombrehijodiscapacidad() {
        return nombrehijodiscapacidad;
    }

    public void setNombrehijodiscapacidad(String nombrehijodiscapacidad) {
        this.nombrehijodiscapacidad = nombrehijodiscapacidad;
    }

    public String getApellidohijodiscapacidad() {
        return apellidohijodiscapacidad;
    }

    public void setApellidohijodiscapacidad(String apellidohijodiscapacidad) {
        this.apellidohijodiscapacidad = apellidohijodiscapacidad;
    }

    public String getNombrediscapacidad() {
        return nombrediscapacidad;
    }

    public void setNombrediscapacidad(String nombrediscapacidad) {
        this.nombrediscapacidad = nombrediscapacidad;
    }

    public String getTipodiscapacidad() {
        return tipodiscapacidad;
    }

    public void setTipodiscapacidad(String tipodiscapacidad) {
        this.tipodiscapacidad = tipodiscapacidad;
    }

    public Date getFechanamimientohijosdiscapacidad() {
        return fechanamimientohijosdiscapacidad;
    }

    public void setFechanamimientohijosdiscapacidad(Date fechanamimientohijosdiscapacidad) {
        this.fechanamimientohijosdiscapacidad = fechanamimientohijosdiscapacidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigohijodiscapacidad != null ? codigohijodiscapacidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hijodiscapacidad)) {
            return false;
        }
        Hijodiscapacidad other = (Hijodiscapacidad) object;
        if ((this.codigohijodiscapacidad == null && other.codigohijodiscapacidad != null) || (this.codigohijodiscapacidad != null && !this.codigohijodiscapacidad.equals(other.codigohijodiscapacidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.Hijodiscapacidad[ codigohijodiscapacidad=" + codigohijodiscapacidad + " ]";
    }
    
}
