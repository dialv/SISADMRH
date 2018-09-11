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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "CUADRODIRECTIVO")

@NamedQueries({
    @NamedQuery(name = "CuadroDirectivo.findAll", query = "SELECT cd FROM CuadroDirectivo cd")})

public class CuadroDirectivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CODIGOCUADRODIRECTIVO")
    private Integer codigocuadrodirectivo;
    @Size(max = 30)
   @Column(name = "RESPONSABLECUADRODIRECTIVO")
    
    private String responsablecuadrodirectivo;

    @Size(max = 30)
    @Column(name = "AREA")
    
    private String area;
    @Size(max = 100)
    @Column(name = "DESRIPCIONCUADRODIRECTIVO")
     
    private String desripcioncuadrodirectivo;
    @Column(name = "FECHAPRESENTACION")
   @DateTimeFormat(pattern = "YYYY-MM-dd")
     
    private Date fechapresentacion;
    @JoinColumn(name = "CODIGOEMPLEADO", referencedColumnName = "CODIGOEMPLEADO")
    @ManyToOne(optional = false)
    private Empleado codigoempleado;

    public CuadroDirectivo() {
    }

    public CuadroDirectivo(Integer codigocuadrodirectivo) {
        this.codigocuadrodirectivo = codigocuadrodirectivo;
    }

    public Integer getCodigocuadrodirectivo() {
        return codigocuadrodirectivo;
    }

    public void setCodigocuadrodirectivo(Integer codigocuadrodirectivo) {
        this.codigocuadrodirectivo = codigocuadrodirectivo;
    }

    public String getResponsablecuadrodirectivo() {
        return responsablecuadrodirectivo;
    }

    public void setResponsablecuadrodirectivo(String responsablecuadrodirectivo) {
        this.responsablecuadrodirectivo = responsablecuadrodirectivo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDesripcioncuadrodirectivo() {
        return desripcioncuadrodirectivo;
    }

    public void setDesripcioncuadrodirectivo(String desripcioncuadrodirectivo) {
        this.desripcioncuadrodirectivo = desripcioncuadrodirectivo;
    }

    public Date getFechapresentacion() {
        return fechapresentacion;
    }

    public void setFechapresentacion(Date fechapresentacion) {
        this.fechapresentacion = fechapresentacion;
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
        hash += (codigocuadrodirectivo != null ? codigocuadrodirectivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuadroDirectivo)) {
            return false;
        }
        CuadroDirectivo other = (CuadroDirectivo) object;
        if ((this.codigocuadrodirectivo == null && other.codigocuadrodirectivo != null) || (this.codigocuadrodirectivo != null && !this.codigocuadrodirectivo.equals(other.codigocuadrodirectivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.Cuadrodirectivo[ codigocuadrodirectivo=" + codigocuadrodirectivo + " ]";
    }
    
}
