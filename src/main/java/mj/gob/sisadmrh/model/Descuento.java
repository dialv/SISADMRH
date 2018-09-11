/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author gladiador
 */
@Entity
@Table(name = "descuento")
@NamedQueries({
    @NamedQuery(name = "Descuento.findAll", query = "SELECT d FROM Descuento d")})
public class Descuento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGODESCUENTO")
    private Integer codigodescuento;
    @Size(max = 50)
    @Column(name = "NOMBREDESCUENTO")
    private String nombredescuento;
    @Size(max = 50)
    @Column(name = "TIPODESCUENTO")
    private String tipodescuento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONTODESCUENTO")
    private Float montodescuento;
    @Size(max = 100)
    @Column(name = "TIPOBANCO")
    private String tipobanco;
    @Size(max = 100)
    @Column(name = "CLASE")
    private String clase;
    @Column(name = "MONTOPAGO")
    private Float montopago;
    @Column(name = "SALARIO")
    private Float salario;
//    @ManyToMany(mappedBy = "descuentoList")
//    private List<Empleado> empleadoList;
//    

    public Descuento() {
    }

    public Descuento(Integer codigodescuento) {
        this.codigodescuento = codigodescuento;
    }

    public Integer getCodigodescuento() {
        return codigodescuento;
    }

    public void setCodigodescuento(Integer codigodescuento) {
        this.codigodescuento = codigodescuento;
    }

    public String getNombredescuento() {
        return nombredescuento;
    }

    public void setNombredescuento(String nombredescuento) {
        this.nombredescuento = nombredescuento;
    }

    public String getTipodescuento() {
        return tipodescuento;
    }

    public void setTipodescuento(String tipodescuento) {
        this.tipodescuento = tipodescuento;
    }

    public Float getMontodescuento() {
        return montodescuento;
    }

    public void setMontodescuento(Float montodescuento) {
        this.montodescuento = montodescuento;
    }

    public String getTipobanco() {
        return tipobanco;
    }

    public void setTipobanco(String tipobanco) {
        this.tipobanco = tipobanco;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public Float getMontopago() {
        return montopago;
    }

    public void setMontopago(Float montopago) {
        this.montopago = montopago;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

//    public List<Empleado> getEmpleadoList() {
//        return empleadoList;
//    }
//
//    public void setEmpleadoList(List<Empleado> empleadoList) {
//        this.empleadoList = empleadoList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigodescuento != null ? codigodescuento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Descuento)) {
            return false;
        }
        Descuento other = (Descuento) object;
        if ((this.codigodescuento == null && other.codigodescuento != null) || (this.codigodescuento != null && !this.codigodescuento.equals(other.codigodescuento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.Descuento[ codigodescuento=" + codigodescuento + " ]";
    }
    
}
