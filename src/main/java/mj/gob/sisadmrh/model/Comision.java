package mj.gob.sisadmrh.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "comision")
@NamedQueries({
    @NamedQuery(name = "Comision.findAll", query = "SELECT c FROM Comision c")})
public class Comision implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigocomision")
    private Integer codigocomision;
    @Column(name = "fechadesdecomision")
    @Temporal(TemporalType.DATE)
//    
    private Date fechadesdecomision;
    @Column(name = "fechahastacomision")
    @Temporal(TemporalType.DATE)
//    
    private Date fechahastacomision;
    @Column(name = "nivelcomision")
    private Integer nivelcomision;
    @Column(name = "estadocomision")
    private Integer estadocomision;
    @Size(max = 50)
    @Column(name = "nombrecomision")
    private String nombrecomision;
    @Column(name = "numeroacuerdocomision")
    private Integer numeroacuerdocomision;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "docaprovacion")
    private byte[] docaprovacion;

    public Comision() {
    }

    public Comision(Integer codigocomision) {
        this.codigocomision = codigocomision;
    }

    public Comision(Integer codigocomision, byte[] docaprovacion) {
        this.codigocomision = codigocomision;
        this.docaprovacion = docaprovacion;
    }

    public Integer getCodigocomision() {
        return codigocomision;
    }

    public void setCodigocomision(Integer codigocomision) {
        this.codigocomision = codigocomision;
    }

    public Date getFechadesdecomision() {
        return fechadesdecomision;
    }

    public void setFechadesdecomision(Date fechadesdecomision) {
        this.fechadesdecomision = fechadesdecomision;
    }

    public Date getFechahastacomision() {
        return fechahastacomision;
    }

    public void setFechahastacomision(Date fechahastacomision) {
        this.fechahastacomision = fechahastacomision;
    }

    public Integer getNivelcomision() {
        return nivelcomision;
    }

    public void setNivelcomision(Integer nivelcomision) {
        this.nivelcomision = nivelcomision;
    }

    public String getNombrecomision() {
        return nombrecomision;
    }

    public void setNombrecomision(String nombrecomision) {
        this.nombrecomision = nombrecomision;
    }

    public Integer getNumeroacuerdocomision() {
        return numeroacuerdocomision;
    }

    public void setNumeroacuerdocomision(Integer numeroacuerdocomision) {
        this.numeroacuerdocomision = numeroacuerdocomision;
    }

    public byte[] getDocaprovacion() {
        return docaprovacion;
    }

    public void setDocaprovacion(byte[] docaprovacion) {
        this.docaprovacion = docaprovacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigocomision != null ? codigocomision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comision)) {
            return false;
        }
        Comision other = (Comision) object;
        if ((this.codigocomision == null && other.codigocomision != null) || (this.codigocomision != null && !this.codigocomision.equals(other.codigocomision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.Comision[ codigocomision=" + codigocomision + " ]";
    }

    public Integer getEstadocomision() {
        return estadocomision;
    }

    public void setEstadocomision(Integer estadocomision) {
        this.estadocomision = estadocomision;
    }
    
}
