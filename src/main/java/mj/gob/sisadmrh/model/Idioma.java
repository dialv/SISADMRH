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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author developer
 */
@Entity
@Table(name = "idioma")
@NamedQueries({
    @NamedQuery(name = "Idioma.findAll", query = "SELECT i FROM Idioma i")})
public class Idioma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoidioma")
    private Integer codigoidioma;
    @Size(max = 50)
    @Column(name = "nombreidioma")
    private String nombreidioma;
    @Size(max = 2)
    @Column(name = "escribe")
    private String escribe;
    @Size(max = 2)
    @Column(name = "habla")
    private String habla;
    @Size(max = 2)
    @Column(name = "traduce")
    private String traduce;
    @Size(max = 2)
    @Column(name = "nivel")
    private String nivel;

    public Idioma() {
    }

    public Idioma(Integer codigoidioma) {
        this.codigoidioma = codigoidioma;
    }

    public Integer getCodigoidioma() {
        return codigoidioma;
    }

    public void setCodigoidioma(Integer codigoidioma) {
        this.codigoidioma = codigoidioma;
    }

    public String getNombreidioma() {
        return nombreidioma;
    }

    public void setNombreidioma(String nombreidioma) {
        this.nombreidioma = nombreidioma;
    }

    public String getEscribe() {
        return escribe;
    }

    public void setEscribe(String escribe) {
        this.escribe = escribe;
    }

    public String getHabla() {
        return habla;
    }

    public void setHabla(String habla) {
        this.habla = habla;
    }

    public String getTraduce() {
        return traduce;
    }

    public void setTraduce(String traduce) {
        this.traduce = traduce;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoidioma != null ? codigoidioma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Idioma)) {
            return false;
        }
        Idioma other = (Idioma) object;
        if ((this.codigoidioma == null && other.codigoidioma != null) || (this.codigoidioma != null && !this.codigoidioma.equals(other.codigoidioma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.Idioma[ codigoidioma=" + codigoidioma + " ]";
    }
    
}
