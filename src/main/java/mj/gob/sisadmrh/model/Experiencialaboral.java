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
@Table(name = "experiencialaboral")
@NamedQueries({
    @NamedQuery(name = "Experiencialaboral.findAll", query = "SELECT e FROM Experiencialaboral e")})
public class Experiencialaboral implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigoexperiencialaboral")
    private Integer codigoexperiencialaboral;
    @Size(max = 50)
    @Column(name = "nombreinstitucion")
    private String nombreinstitucion;
    @Column(name = "fechadesdeexperiencialaboral")
//    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechadesdeexperiencialaboral;
    @Column(name = "fechahastaexperiencialaboral")
//    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechahastaexperiencialaboral;
    @Column(name = "salarioinicial")
    private Float salarioinicial;
    @Column(name = "salariofinal")
    private Float salariofinal;
    @Column(name = "estadoexp")
    private Integer estadoexp;
    @Size(max = 200)
    @Column(name = "motivoretiro")
    private String motivoretiro;
    @Size(max = 200)
    @Column(name = "cargo")
    private String cargo;
    @Size(max = 100)
    @Column(name = "categorialaboral")
    private String categorialaboral;
    @Size(max = 10)
    @Column(name = "interno")
    private String interno;
    @Column(name = "codigocontrato")
    private Integer codigocontrato;

    public Integer getCodigocontrato() {
        return codigocontrato;
    }

    public void setCodigocontrato(Integer codigocontrato) {
        this.codigocontrato = codigocontrato;
    }

    public String getInterno() {
        return interno;
    }

    public void setInterno(String interno) {
        this.interno = interno;
    }

    public String getCategorialaboral() {
        return categorialaboral;
    }

    public void setCategorialaboral(String categorialaboral) {
        this.categorialaboral = categorialaboral;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    @Size(max = 20)
    @Column(name = "sectorexperiencialaboral")
    private String sectorexperiencialaboral;

    public Experiencialaboral() {
    }

    public Experiencialaboral(Integer codigoexperiencialaboral) {
        this.codigoexperiencialaboral = codigoexperiencialaboral;
    }

    public Integer getCodigoexperiencialaboral() {
        return codigoexperiencialaboral;
    }

    public void setCodigoexperiencialaboral(Integer codigoexperiencialaboral) {
        this.codigoexperiencialaboral = codigoexperiencialaboral;
    }

    public String getNombreinstitucion() {
        return nombreinstitucion;
    }

    public void setNombreinstitucion(String nombreinstitucion) {
        this.nombreinstitucion = nombreinstitucion;
    }

    public Date getFechadesdeexperiencialaboral() {
        return fechadesdeexperiencialaboral;
    }

    public void setFechadesdeexperiencialaboral(Date fechadesdeexperiencialaboral) {
        this.fechadesdeexperiencialaboral = fechadesdeexperiencialaboral;
    }

    public Date getFechahastaexperiencialaboral() {
        return fechahastaexperiencialaboral;
    }

    public void setFechahastaexperiencialaboral(Date fechahastaexperiencialaboral) {
        this.fechahastaexperiencialaboral = fechahastaexperiencialaboral;
    }

    public Float getSalarioinicial() {
        return salarioinicial;
    }

    public void setSalarioinicial(Float salarioinicial) {
        this.salarioinicial = salarioinicial;
    }

    public Float getSalariofinal() {
        return salariofinal;
    }

    public void setSalariofinal(Float salariofinal) {
        this.salariofinal = salariofinal;
    }

    public String getMotivoretiro() {
        return motivoretiro;
    }

    public void setMotivoretiro(String motivoretiro) {
        this.motivoretiro = motivoretiro;
    }

    public String getSectorexperiencialaboral() {
        return sectorexperiencialaboral;
    }

    public void setSectorexperiencialaboral(String sectorexperiencialaboral) {
        this.sectorexperiencialaboral = sectorexperiencialaboral;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoexperiencialaboral != null ? codigoexperiencialaboral.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Experiencialaboral)) {
            return false;
        }
        Experiencialaboral other = (Experiencialaboral) object;
        if ((this.codigoexperiencialaboral == null && other.codigoexperiencialaboral != null) || (this.codigoexperiencialaboral != null && !this.codigoexperiencialaboral.equals(other.codigoexperiencialaboral))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.Experiencialaboral[ codigoexperiencialaboral=" + codigoexperiencialaboral + " ]";
    }

    public Integer getEstadoexp() {
        return estadoexp;
    }

    public void setEstadoexp(Integer estadoexp) {
        this.estadoexp = estadoexp;
    }
    
}
