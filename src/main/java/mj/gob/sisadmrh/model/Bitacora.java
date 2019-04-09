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
 * @author root
 */
@Entity
@Table(name = "BITACORA")
@NamedQueries({
    @NamedQuery(name = "Bitacora.findAll", query = "SELECT b FROM Bitacora b")})
public class Bitacora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "CODIGOBITACORA")
    private Integer codigobitacora;
    @Column(name = "CODIGOEVENTOBITACORA")
    private Integer codigoeventobitacora;
    @Size(max = 50)
    @Column(name = "NOMBREEVENTOBITACORA")
    private String nombreeventobitacora;
    @Column(name = "FECHABITACORA")
    @Temporal(TemporalType.DATE)
    //@DateTimeFormat(pattern = "dd/MM/YYYY")
    private Date fechabitacora;
    @Size(max = 18)
    @Column(name = "IP")
    private String ip;
    @Size(max = 10)
    @Column(name = "CODIGOUSUARIOBITACORA")
    private String codigousuariobitacora;

    public Bitacora() {
    }

    public Bitacora(Integer codigobitacora) {
        this.codigobitacora = codigobitacora;
    }

    public Integer getCodigobitacora() {
        return codigobitacora;
    }

    public void setCodigobitacora(Integer codigobitacora) {
        this.codigobitacora = codigobitacora;
    }

    public Integer getCodigoeventobitacora() {
        return codigoeventobitacora;
    }

    public void setCodigoeventobitacora(Integer codigoeventobitacora) {
        this.codigoeventobitacora = codigoeventobitacora;
    }

    public String getNombreeventobitacora() {
        return nombreeventobitacora;
    }

    public void setNombreeventobitacora(String nombreeventobitacora) {
        this.nombreeventobitacora = nombreeventobitacora;
    }

    public Date getFechabitacora() {
        return fechabitacora;
    }

    public void setFechabitacora(Date fechabitacora) {
        this.fechabitacora = fechabitacora;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCodigousuariobitacora() {
        return codigousuariobitacora;
    }

    public void setCodigousuariobitacora(String codigousuariobitacora) {
        this.codigousuariobitacora = codigousuariobitacora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigobitacora != null ? codigobitacora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bitacora)) {
            return false;
        }
        Bitacora other = (Bitacora) object;
        if ((this.codigobitacora == null && other.codigobitacora != null) || (this.codigobitacora != null && !this.codigobitacora.equals(other.codigobitacora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.Bitacora[ codigobitacora=" + codigobitacora + " ]";
    }
    
}
