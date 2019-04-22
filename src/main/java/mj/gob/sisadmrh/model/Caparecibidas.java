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
@Table(name = "caparecibidas")
@NamedQueries({
    @NamedQuery(name = "Caparecibidas.findAll", query = "SELECT c FROM Caparecibidas c")})
public class Caparecibidas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigocaparecibidas")
    private Integer codigocaparecibidas;
    @Size(max = 50)
    @Column(name = "tipoevento")
    private String tipoevento;
    @Size(max = 50)
    @Column(name = "especialidad")
    private String especialidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dhoras")
    private int dhoras;
    @Column(name = "estadocapa")
    private int estadocapa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ddias")
    private int ddias;
    @Column(name = "fechaevento")
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaevento;
    @Size(max = 200)
    @Column(name = "organismo")
    private String organismo;
    @Size(max = 200)
    @Column(name = "pais")
    private String pais;

    public Caparecibidas() {
    }

    public Caparecibidas(Integer codigocaparecibidas) {
        this.codigocaparecibidas = codigocaparecibidas;
    }

    public Caparecibidas(Integer codigocaparecibidas, int dhoras, int ddias) {
        this.codigocaparecibidas = codigocaparecibidas;
        this.dhoras = dhoras;
        this.ddias = ddias;
    }

    public Integer getCodigocaparecibidas() {
        return codigocaparecibidas;
    }

    public void setCodigocaparecibidas(Integer codigocaparecibidas) {
        this.codigocaparecibidas = codigocaparecibidas;
    }

    public String getTipoevento() {
        return tipoevento;
    }

    public void setTipoevento(String tipoevento) {
        this.tipoevento = tipoevento;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getDhoras() {
        return dhoras;
    }

    public void setDhoras(int dhoras) {
        this.dhoras = dhoras;
    }

    public int getDdias() {
        return ddias;
    }

    public void setDdias(int ddias) {
        this.ddias = ddias;
    }

    public Date getFechaevento() {
        return fechaevento;
    }

    public void setFechaevento(Date fechaevento) {
        this.fechaevento = fechaevento;
    }

    public String getOrganismo() {
        return organismo;
    }

    public void setOrganismo(String organismo) {
        this.organismo = organismo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigocaparecibidas != null ? codigocaparecibidas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caparecibidas)) {
            return false;
        }
        Caparecibidas other = (Caparecibidas) object;
        if ((this.codigocaparecibidas == null && other.codigocaparecibidas != null) || (this.codigocaparecibidas != null && !this.codigocaparecibidas.equals(other.codigocaparecibidas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.Caparecibidas[ codigocaparecibidas=" + codigocaparecibidas + " ]";
    }

    public int getEstadocapa() {
        return estadocapa;
    }

    public void setEstadocapa(int estadocapa) {
        this.estadocapa = estadocapa;
    }
    
}
