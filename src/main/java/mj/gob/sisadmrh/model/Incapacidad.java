package mj.gob.sisadmrh.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author jorge
 */
@Entity
@Table(name = "incapacidad")
@NamedQueries({
    @NamedQuery(name = "Incapacidad.findAll", query = "SELECT i FROM Incapacidad i")})
public class Incapacidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGOINCAPACIDAD")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigoincapacidad;
    @Size(max = 12)
    @Column(name = "NUMEROFICHAISSS")
    private String numerofichaisss;
     @Size(max = 70)
    @Column(name = "NOMBREINCAPACIDAD")
    private String nombreincapacidad;
    @Column(name = "ESTADOINCAPACIDAD")
    private Integer estadoincapacidad;
    @Column(name = "SUBSIDIO")
    private Float subsidio;
    @Size(max = 100)
    @Column(name = "FORMAINCAPACIDAD")
    private String formaincapacidad;
     @Size(max = 12)
    @Column(name = "ISSS")
    private String isss;
     
      @Size(max = 500)
    @Column(name = "DIAGNOSTICO")
    private String diagnostico;
    
    @Size(max = 12)
    @Column(name = "DUI")
    private String dui;
    
    @Size(max = 200)
    @Column(name = "FONDOINCAPACIDAD")
    private String fondoincapacidad;
    @Size(max = 500)
    @Column(name = "OBSERVACION")
    private String observacion;
    @Lob
    @Column(name = "DOCUMENTO1")
    private byte[] documento1;//sube el formularios
    @Lob
    @Column(name = "DOCUMENTO2")
    private byte[] documento2;
    @Column(name = "FECHADESDEINCAPACIDAD")
  //  @Temporal(TemporalType.DATE)
      @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechadesdeincapacidad;
    @Column(name = "FECHAHASTAINCAPACIDAD")
   // @Temporal(TemporalType.DATE)
      @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechahastaincapacidad;
    @Column(name = "FECHAEMISION")
  //  @Temporal(TemporalType.DATE)
     @DateTimeFormat(pattern = "YYYY-MM-dd")
    private Date fechaemision;
    @Size(max = 30)
    @Column(name = "TIPOINCAPACIDAD")
    private String tipoincapacidad;
    @JoinColumn(name = "CODIGOEMPLEADO", referencedColumnName = "CODIGOEMPLEADO")
    @ManyToOne(optional = false)
    private Empleado codigoempleado;

    public Incapacidad() {
    }

    public Incapacidad(Integer codigoincapacidad) {
        this.codigoincapacidad = codigoincapacidad;
    }

    public Integer getCodigoincapacidad() {
        return codigoincapacidad;
    }

    public void setCodigoincapacidad(Integer codigoincapacidad) {
        this.codigoincapacidad = codigoincapacidad;
    }

    public String getNombreincapacidad() {
        return nombreincapacidad;
    }

    public void setNombreincapacidad(String nombreincapacidad) {
        this.nombreincapacidad = nombreincapacidad;
    }

    public String getNumerofichaisss() {
        return numerofichaisss;
    }

    public void setNumerofichaisss(String numerofichaisss) {
        this.numerofichaisss = numerofichaisss;
    }

    public Float getSubsidio() {
        return subsidio;
    }

    public void setSubsidio(Float subsidio) {
        this.subsidio = subsidio;
    }
    
     public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getFormaincapacidad() {
        return formaincapacidad;
    }

    public void setFormaincapacidad(String formaincapacidad) {
        this.formaincapacidad = formaincapacidad;
    }
    
      public String getIsss() {
        return isss;
    }

    public void setIsss(String isss) {
        this.isss = isss;
    }
      public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }
    

    public String getFondoincapacidad() {
        return fondoincapacidad;
    }

    public void setFondoincapacidad(String fondoincapacidad) {
        this.fondoincapacidad = fondoincapacidad;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public byte[] getDocumento1() {
        return documento1;
    }

    public void setDocumento1(byte[] documento1) {
        this.documento1 = documento1;
    }

    public byte[] getDocumento2() {
        return documento2;
    }

    public void setDocumento2(byte[] documento2) {
        this.documento2 = documento2;
    }

    public Date getFechadesdeincapacidad() {
        return fechadesdeincapacidad;
    }

    public void setFechadesdeincapacidad(Date fechadesdeincapacidad) {
        this.fechadesdeincapacidad = fechadesdeincapacidad;
    }

    public Date getFechahastaincapacidad() {
        return fechahastaincapacidad;
    }

    public void setFechahastaincapacidad(Date fechahastaincapacidad) {
        this.fechahastaincapacidad = fechahastaincapacidad;
    }

    public Date getFechaemision() {
        return fechaemision;
    }

    public void setFechaemision(Date fechaemision) {
        this.fechaemision = fechaemision;
    }

    public String getTipoincapacidad() {
        return tipoincapacidad;
    }

    public void setTipoincapacidad(String tipoincapacidad) {
        this.tipoincapacidad = tipoincapacidad;
    }

    public Empleado getCodigoempleado() {
        return codigoempleado;
    }

    public void setCodigoempleado(Empleado codigoempleado) {
        this.codigoempleado = codigoempleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoincapacidad != null ? codigoincapacidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Incapacidad)) {
            return false;
        }
        Incapacidad other = (Incapacidad) object;
        if ((this.codigoincapacidad == null && other.codigoincapacidad != null) || (this.codigoincapacidad != null && !this.codigoincapacidad.equals(other.codigoincapacidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.Incapacidad[ codigoincapacidad=" + codigoincapacidad + " ]";
    }

    public Integer getEstadoincapacidad() {
        return estadoincapacidad;
    }

    public void setEstadoincapacidad(Integer estadoincapacidad) {
        this.estadoincapacidad = estadoincapacidad;
    }
    
}
