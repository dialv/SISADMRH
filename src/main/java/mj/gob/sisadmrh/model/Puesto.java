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
 * @author daniel
 */
@Entity
@Table(name = "puesto")
@NamedQueries({
    @NamedQuery(name = "Puesto.findAll", query = "SELECT p FROM Puesto p")})
//    @NamedQuery(name = "Puesto.findByCodigopuesto", query = "SELECT p FROM Puesto p WHERE p.codigopuesto = :codigopuesto"),
//    @NamedQuery(name = "Puesto.findByCategoriapuesto", query = "SELECT p FROM Puesto p WHERE p.categoriapuesto = :categoriapuesto"),
//    @NamedQuery(name = "Puesto.findByCategoriasueldo", query = "SELECT p FROM Puesto p WHERE p.categoriasueldo = :categoriasueldo"),
//    @NamedQuery(name = "Puesto.findByCodigocargopuesto", query = "SELECT p FROM Puesto p WHERE p.codigocargopuesto = :codigocargopuesto"),
//    @NamedQuery(name = "Puesto.findByEstadoplanilla", query = "SELECT p FROM Puesto p WHERE p.estadoplanilla = :estadoplanilla"),
//    @NamedQuery(name = "Puesto.findByEstadopuesto", query = "SELECT p FROM Puesto p WHERE p.estadopuesto = :estadopuesto"),
//    @NamedQuery(name = "Puesto.findByFechaaprobacion", query = "SELECT p FROM Puesto p WHERE p.fechaaprobacion = :fechaaprobacion"),
//    @NamedQuery(name = "Puesto.findByFechaautorizacionpuesto", query = "SELECT p FROM Puesto p WHERE p.fechaautorizacionpuesto = :fechaautorizacionpuesto"),
//    @NamedQuery(name = "Puesto.findByFechabaja", query = "SELECT p FROM Puesto p WHERE p.fechabaja = :fechabaja"),
//    @NamedQuery(name = "Puesto.findByFechacontrataciondesde", query = "SELECT p FROM Puesto p WHERE p.fechacontrataciondesde = :fechacontrataciondesde"),
//    @NamedQuery(name = "Puesto.findByFechacontratacionhasta", query = "SELECT p FROM Puesto p WHERE p.fechacontratacionhasta = :fechacontratacionhasta"),
//    @NamedQuery(name = "Puesto.findByFechacreacion", query = "SELECT p FROM Puesto p WHERE p.fechacreacion = :fechacreacion"),
//    @NamedQuery(name = "Puesto.findByFechamodificacion", query = "SELECT p FROM Puesto p WHERE p.fechamodificacion = :fechamodificacion"),
//    @NamedQuery(name = "Puesto.findByFechanombramiento", query = "SELECT p FROM Puesto p WHERE p.fechanombramiento = :fechanombramiento"),
//    @NamedQuery(name = "Puesto.findByFechavacante", query = "SELECT p FROM Puesto p WHERE p.fechavacante = :fechavacante"),
//    @NamedQuery(name = "Puesto.findByFormapago", query = "SELECT p FROM Puesto p WHERE p.formapago = :formapago"),
//    @NamedQuery(name = "Puesto.findByNivelpuesto", query = "SELECT p FROM Puesto p WHERE p.nivelpuesto = :nivelpuesto"),
//    @NamedQuery(name = "Puesto.findByNombrejerarquia", query = "SELECT p FROM Puesto p WHERE p.nombrejerarquia = :nombrejerarquia"),
//    @NamedQuery(name = "Puesto.findByNombrepuesto", query = "SELECT p FROM Puesto p WHERE p.nombrepuesto = :nombrepuesto"),
//    @NamedQuery(name = "Puesto.findByNumeropartidapuesto", query = "SELECT p FROM Puesto p WHERE p.numeropartidapuesto = :numeropartidapuesto"),
//    @NamedQuery(name = "Puesto.findByNumerosubpartidapuesto", query = "SELECT p FROM Puesto p WHERE p.numerosubpartidapuesto = :numerosubpartidapuesto"),
//    @NamedQuery(name = "Puesto.findBySublinea", query = "SELECT p FROM Puesto p WHERE p.sublinea = :sublinea"),
//    @NamedQuery(name = "Puesto.findBySueldobase", query = "SELECT p FROM Puesto p WHERE p.sueldobase = :sueldobase"),
//    @NamedQuery(name = "Puesto.findBySueldotopepuesto", query = "SELECT p FROM Puesto p WHERE p.sueldotopepuesto = :sueldotopepuesto"),
//    @NamedQuery(name = "Puesto.findByTipofinanza", query = "SELECT p FROM Puesto p WHERE p.tipofinanza = :tipofinanza"),
//    @NamedQuery(name = "Puesto.findByUbicacionpuesto", query = "SELECT p FROM Puesto p WHERE p.ubicacionpuesto = :ubicacionpuesto"),
//    @NamedQuery(name = "Puesto.findByUltimoempleado", query = "SELECT p FROM Puesto p WHERE p.ultimoempleado = :ultimoempleado"),
//    @NamedQuery(name = "Puesto.findByAcuerdo", query = "SELECT p FROM Puesto p WHERE p.acuerdo = :acuerdo")})
public class Puesto implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "acuerdo")
    private Integer acuerdo;
    @Size(max = 50)
    @Column(name = "categoriapuesto")
    private String categoriapuesto;
    @Size(max = 50)
    @Column(name = "categoriasueldo")
    private String categoriasueldo;
    @Size(max = 10)
    @Column(name = "codigocargopuesto")
    private String codigocargopuesto;
    @Size(max = 10)
    @Column(name = "estadoplanilla")
    private String estadoplanilla;
    @Size(max = 20)
    @Column(name = "formapago")
    private String formapago;
    @Size(max = 25)
    @Column(name = "nivelpuesto")
    private String nivelpuesto;
    @Size(max = 50)
    @Column(name = "nombrejerarquia")
    private String nombrejerarquia;
    @Size(max = 50)
    @Column(name = "nombrepuesto")
    private String nombrepuesto;
    @Size(max = 10)
    @Column(name = "numeropartidapuesto")
    private String numeropartidapuesto;
    @Size(max = 10)
    @Column(name = "numerosubpartidapuesto")
    private String numerosubpartidapuesto;
    @Size(max = 75)
    @Column(name = "sublinea")
    private String sublinea;
    @Size(max = 50)
    @Column(name = "tipofinanza")
    private String tipofinanza;
    @Size(max = 50)
    @Column(name = "ubicacionpuesto")
    private String ubicacionpuesto;
    @Size(max = 50)
    @Column(name = "ultimoempleado")
    private String ultimoempleado;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
     @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigopuesto")
    private Integer codigopuesto;
    @Column(name = "estadopuesto")
    private Integer estadopuesto;
    @Column(name = "fechaaprobacion")
//     
    @Temporal(javax.persistence.TemporalType.DATE)  
    private Date fechaaprobacion;
    @Column(name = "fechaautorizacionpuesto")
//     
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaautorizacionpuesto;
    @Column(name = "fechabaja")
//     
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechabaja;
    @Column(name = "fechacontrataciondesde")
//     
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechacontrataciondesde;
    @Column(name = "fechacontratacionhasta")
//     
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechacontratacionhasta;
    @Column(name = "fechacreacion")
//     
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechacreacion;
    @Column(name = "fechamodificacion")
//     
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechamodificacion;
    @Column(name = "fechanombramiento")
//     
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechanombramiento;
    @Column(name = "fechavacante")
//     
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechavacante;
    @Column(name = "sueldobase")
    private Float sueldobase;
    @Column(name = "sueldotopepuesto")
    private Float sueldotopepuesto;

    public Puesto() {
    }

    public Puesto(Integer codigopuesto) {
        this.codigopuesto = codigopuesto;
    }

    public Puesto(Integer codigopuesto, Integer acuerdo) {
        this.codigopuesto = codigopuesto;
        this.acuerdo = acuerdo;
    }

    public Integer getCodigopuesto() {
        return codigopuesto;
    }

    public void setCodigopuesto(Integer codigopuesto) {
        this.codigopuesto = codigopuesto;
    }


    public Integer getEstadopuesto() {
        return estadopuesto;
    }

    public void setEstadopuesto(Integer estadopuesto) {
        this.estadopuesto = estadopuesto;
    }

    public Date getFechaaprobacion() {
        return fechaaprobacion;
    }

    public void setFechaaprobacion(Date fechaaprobacion) {
        this.fechaaprobacion = fechaaprobacion;
    }

    public Date getFechaautorizacionpuesto() {
        return fechaautorizacionpuesto;
    }

    public void setFechaautorizacionpuesto(Date fechaautorizacionpuesto) {
        this.fechaautorizacionpuesto = fechaautorizacionpuesto;
    }

    public Date getFechabaja() {
        return fechabaja;
    }

    public void setFechabaja(Date fechabaja) {
        this.fechabaja = fechabaja;
    }

    public Date getFechacontrataciondesde() {
        return fechacontrataciondesde;
    }

    public void setFechacontrataciondesde(Date fechacontrataciondesde) {
        this.fechacontrataciondesde = fechacontrataciondesde;
    }

    public Date getFechacontratacionhasta() {
        return fechacontratacionhasta;
    }

    public void setFechacontratacionhasta(Date fechacontratacionhasta) {
        this.fechacontratacionhasta = fechacontratacionhasta;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Date getFechamodificacion() {
        return fechamodificacion;
    }

    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    public Date getFechanombramiento() {
        return fechanombramiento;
    }

    public void setFechanombramiento(Date fechanombramiento) {
        this.fechanombramiento = fechanombramiento;
    }

    public Date getFechavacante() {
        return fechavacante;
    }

    public void setFechavacante(Date fechavacante) {
        this.fechavacante = fechavacante;
    }
    public Float getSueldobase() {
        return sueldobase;
    }
    public void setSueldobase(Float sueldobase) {
        this.sueldobase = sueldobase;
    }
    public Float getSueldotopepuesto() {
        return sueldotopepuesto;
    }
    public void setSueldotopepuesto(Float sueldotopepuesto) {
        this.sueldotopepuesto = sueldotopepuesto;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigopuesto != null ? codigopuesto.hashCode() : 0);
        return hash;
    }
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Puesto)) {
            return false;
        }
        Puesto other = (Puesto) object;
        if ((this.codigopuesto == null && other.codigopuesto != null) || (this.codigopuesto != null && !this.codigopuesto.equals(other.codigopuesto))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.Puesto[ codigopuesto=" + codigopuesto + " ]";
    }

    public Integer getAcuerdo() {
        return acuerdo;
    }

    public void setAcuerdo(Integer acuerdo) {
        this.acuerdo = acuerdo;
    }

    public String getCategoriapuesto() {
        return categoriapuesto;
    }

    public void setCategoriapuesto(String categoriapuesto) {
        this.categoriapuesto = categoriapuesto;
    }

    public String getCategoriasueldo() {
        return categoriasueldo;
    }

    public void setCategoriasueldo(String categoriasueldo) {
        this.categoriasueldo = categoriasueldo;
    }

    public String getCodigocargopuesto() {
        return codigocargopuesto;
    }

    public void setCodigocargopuesto(String codigocargopuesto) {
        this.codigocargopuesto = codigocargopuesto;
    }

    public String getEstadoplanilla() {
        return estadoplanilla;
    }

    public void setEstadoplanilla(String estadoplanilla) {
        this.estadoplanilla = estadoplanilla;
    }

    public String getFormapago() {
        return formapago;
    }

    public void setFormapago(String formapago) {
        this.formapago = formapago;
    }

    public String getNivelpuesto() {
        return nivelpuesto;
    }

    public void setNivelpuesto(String nivelpuesto) {
        this.nivelpuesto = nivelpuesto;
    }

    public String getNombrejerarquia() {
        return nombrejerarquia;
    }

    public void setNombrejerarquia(String nombrejerarquia) {
        this.nombrejerarquia = nombrejerarquia;
    }

    public String getNombrepuesto() {
        return nombrepuesto;
    }

    public void setNombrepuesto(String nombrepuesto) {
        this.nombrepuesto = nombrepuesto;
    }

    public String getNumeropartidapuesto() {
        return numeropartidapuesto;
    }

    public void setNumeropartidapuesto(String numeropartidapuesto) {
        this.numeropartidapuesto = numeropartidapuesto;
    }

    public String getNumerosubpartidapuesto() {
        return numerosubpartidapuesto;
    }

    public void setNumerosubpartidapuesto(String numerosubpartidapuesto) {
        this.numerosubpartidapuesto = numerosubpartidapuesto;
    }

    public String getSublinea() {
        return sublinea;
    }

    public void setSublinea(String sublinea) {
        this.sublinea = sublinea;
    }

    public String getTipofinanza() {
        return tipofinanza;
    }

    public void setTipofinanza(String tipofinanza) {
        this.tipofinanza = tipofinanza;
    }

    public String getUbicacionpuesto() {
        return ubicacionpuesto;
    }

    public void setUbicacionpuesto(String ubicacionpuesto) {
        this.ubicacionpuesto = ubicacionpuesto;
    }

    public String getUltimoempleado() {
        return ultimoempleado;
    }

    public void setUltimoempleado(String ultimoempleado) {
        this.ultimoempleado = ultimoempleado;
    }
    
}
