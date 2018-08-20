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

/**
 *
 * @author developer
 */
@Entity
@Table(name = "formacionacademica")
@NamedQueries({
    @NamedQuery(name = "Formacionacademica.findAll", query = "SELECT f FROM Formacionacademica f")})
public class Formacionacademica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoformacionacademica", nullable = false)
    private Integer codigoformacionacademica;
    @Size(max = 50)
    @Column(name = "estudiosrealizados", length = 50)
    private String estudiosrealizados;
    @Size(max = 50)
    @Column(name = "centroeducativo", length = 50)
    private String centroeducativo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aniosaprobados", nullable = false)
    private int aniosaprobados;
    @Column(name = "fechadesdeformacionacademica")
    @Temporal(TemporalType.DATE)
    private Date fechadesdeformacionacademica;
    @Column(name = "fechahastaformacionacademica")
    @Temporal(TemporalType.DATE)
    private Date fechahastaformacionacademica;
    @Size(max = 200)
    @Column(name = "termino", length = 200)
    private String termino;
    @Size(max = 200)
    @Column(name = "tituloobtenido", length = 200)
    private String tituloobtenido;

    public Formacionacademica() {
    }

    public Formacionacademica(Integer codigoformacionacademica) {
        this.codigoformacionacademica = codigoformacionacademica;
    }

    public Formacionacademica(Integer codigoformacionacademica, int aniosaprobados) {
        this.codigoformacionacademica = codigoformacionacademica;
        this.aniosaprobados = aniosaprobados;
    }

    public Integer getCodigoformacionacademica() {
        return codigoformacionacademica;
    }

    public void setCodigoformacionacademica(Integer codigoformacionacademica) {
        this.codigoformacionacademica = codigoformacionacademica;
    }

    public String getEstudiosrealizados() {
        return estudiosrealizados;
    }

    public void setEstudiosrealizados(String estudiosrealizados) {
        this.estudiosrealizados = estudiosrealizados;
    }

    public String getCentroeducativo() {
        return centroeducativo;
    }

    public void setCentroeducativo(String centroeducativo) {
        this.centroeducativo = centroeducativo;
    }

    public int getAniosaprobados() {
        return aniosaprobados;
    }

    public void setAniosaprobados(int aniosaprobados) {
        this.aniosaprobados = aniosaprobados;
    }

    public Date getFechadesdeformacionacademica() {
        return fechadesdeformacionacademica;
    }

    public void setFechadesdeformacionacademica(Date fechadesdeformacionacademica) {
        this.fechadesdeformacionacademica = fechadesdeformacionacademica;
    }

    public Date getFechahastaformacionacademica() {
        return fechahastaformacionacademica;
    }

    public void setFechahastaformacionacademica(Date fechahastaformacionacademica) {
        this.fechahastaformacionacademica = fechahastaformacionacademica;
    }

    public String getTermino() {
        return termino;
    }

    public void setTermino(String termino) {
        this.termino = termino;
    }

    public String getTituloobtenido() {
        return tituloobtenido;
    }

    public void setTituloobtenido(String tituloobtenido) {
        this.tituloobtenido = tituloobtenido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoformacionacademica != null ? codigoformacionacademica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formacionacademica)) {
            return false;
        }
        Formacionacademica other = (Formacionacademica) object;
        if ((this.codigoformacionacademica == null && other.codigoformacionacademica != null) || (this.codigoformacionacademica != null && !this.codigoformacionacademica.equals(other.codigoformacionacademica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.Formacionacademica[ codigoformacionacademica=" + codigoformacionacademica + " ]";
    }
    
}
