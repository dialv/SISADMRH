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
@Table(name = "formacionacademica")
@NamedQueries({
    @NamedQuery(name = "Formacionacademica.findAll", query = "SELECT f FROM Formacionacademica f")})
public class Formacionacademica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "codigoformacionacademica")
    private Integer codigoformacionacademica;
    @Size(max = 50)
    @Column(name = "estudiosrealizados")
    private String estudiosrealizados;
    @Size(max = 50)
    @Column(name = "centroeducativo")
    private String centroeducativo;
    @Basic(optional = false)
    @Column(name = "aniosaprobados")
    private int aniosaprobados;
    @Column(name = "fechadesdeformacionacademica")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/YYYY")
    private Date fechadesdeformacionacademica;
    @Column(name = "fechahastaformacionacademica")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/YYYY")
    private Date fechahastaformacionacademica;
    @Size(max = 200)
    @Column(name = "termino")
    private String termino;
    @Size(max = 200)
    @Column(name = "tituloobtenido")
    private String tituloobtenido;
    @Basic(optional = false)
    @Lob
    @Column(name = "doctitulo")
    private byte[] doctitulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estadoformacion")
    private int estadoformacion;

    public Formacionacademica() {
    }

    public Formacionacademica(Integer codigoformacionacademica) {
        this.codigoformacionacademica = codigoformacionacademica;
    }

    public Formacionacademica(Integer codigoformacionacademica, int aniosaprobados, byte[] doctitulo, int estadoformacion) {
        this.codigoformacionacademica = codigoformacionacademica;
        this.aniosaprobados = aniosaprobados;
        this.doctitulo = doctitulo;
        this.estadoformacion = estadoformacion;
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

    public byte[] getDoctitulo() {
        return doctitulo;
    }

    public void setDoctitulo(byte[] doctitulo) {
        this.doctitulo = doctitulo;
    }

    public int getEstadoformacion() {
        return estadoformacion;
    }

    public void setEstadoformacion(int estadoformacion) {
        this.estadoformacion = estadoformacion;
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
