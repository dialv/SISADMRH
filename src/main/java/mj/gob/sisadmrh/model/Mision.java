/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "MISION")
@NamedQueries({
    @NamedQuery(name = "Mision.findAll", query = "SELECT m FROM Mision m")})
public class Mision implements Serializable {
    @Size(max = 50)
    @Column(name = "NOMBREMISION")
    private String nombremision;
    @Size(max = 100)
    @Column(name = "OBJETIVOMISION")
    private String objetivomision;
    @Size(max = 50)
    @Column(name = "RESPONSABLEGASTO")
    private String responsablegasto;
    @Size(max = 50)
    @Column(name = "ORGANISMOPATROCINADOR")
    private String organismopatrocinador;
    @Size(max = 50)
    @Column(name = "ORGANISMOINVITA")
    private String organismoinvita;
    @Size(max = 100)
    @Column(name = "DEPARTAMENTOMISION")
    private String departamentomision;
    @Size(max = 50)
    @Column(name = "PAISDESTINO")
    private String paisdestino;
    @Size(max = 50)
    @Column(name = "CIUDAD")
    private String ciudad;
    @Size(max = 30)
    @Column(name = "TIPOTRANSPORTE")
    private String tipotransporte;
    @Column(name = "VIATICOS")
    private Float viaticos;
    @Size(max = 50)
    @Column(name = "DOCUMENTO")
    private String documento;
    @Size(max = 20)
    @Column(name = "BOLETO")
    private String boleto;
    @Column(name = "NUMEROACUERDO")
    private Integer numeroacuerdo;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGOMISION")
    private Integer codigomision;
    @Column(name = "CANTIDADDIA")
    private Integer cantidaddia;
    @Column(name = "FECHAACUERDOMISION")
    @Temporal(TemporalType.DATE)
    private Date fechaacuerdomision;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "GASTOVIAJE")
    private Float gastoviaje;
    @Column(name = "GASTOTERMINALES")
    private Float gastoterminales;
    @Column(name = "GASTOSTOTALES")
    private Float gastostotales;
    @Column(name = "CANTIDADMESES")
    private Integer cantidadmeses;
    @Column(name = "TIPOMISION")
    private Integer tipomision;
    @Column(name = "FECHASALIDAMISION")
    @Temporal(TemporalType.DATE)
    private Date fechasalidamision;
    @Column(name = "FECHAREGRESOMISION")
    @Temporal(TemporalType.DATE)
    private Date fecharegresomision;
//    @ManyToMany(mappedBy = "misionList")
//    private List<Empleado> empleadoList;

    public Mision() {
    }

    public Mision(Integer codigomision) {
        this.codigomision = codigomision;
    }

    public Integer getCodigomision() {
        return codigomision;
    }

    public void setCodigomision(Integer codigomision) {
        this.codigomision = codigomision;
    }


    public Integer getCantidaddia() {
        return cantidaddia;
    }

    public void setCantidaddia(Integer cantidaddia) {
        this.cantidaddia = cantidaddia;
    }

    public Date getFechaacuerdomision() {
        return fechaacuerdomision;
    }

    public void setFechaacuerdomision(Date fechaacuerdomision) {
        this.fechaacuerdomision = fechaacuerdomision;
    }

    public Float getGastoviaje() {
        return gastoviaje;
    }

    public void setGastoviaje(Float gastoviaje) {
        this.gastoviaje = gastoviaje;
    }


    public Float getGastoterminales() {
        return gastoterminales;
    }

    public void setGastoterminales(Float gastoterminales) {
        this.gastoterminales = gastoterminales;
    }

    public Float getGastostotales() {
        return gastostotales;
    }

    public void setGastostotales(Float gastostotales) {
        this.gastostotales = gastostotales;
    }

    public Integer getCantidadmeses() {
        return cantidadmeses;
    }

    public void setCantidadmeses(Integer cantidadmeses) {
        this.cantidadmeses = cantidadmeses;
    }


    public Integer getTipomision() {
        return tipomision;
    }

    public void setTipomision(Integer tipomision) {
        this.tipomision = tipomision;
    }

    public Date getFechasalidamision() {
        return fechasalidamision;
    }

    public void setFechasalidamision(Date fechasalidamision) {
        this.fechasalidamision = fechasalidamision;
    }

    public Date getFecharegresomision() {
        return fecharegresomision;
    }

    public void setFecharegresomision(Date fecharegresomision) {
        this.fecharegresomision = fecharegresomision;
    }
//
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
        hash += (codigomision != null ? codigomision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mision)) {
            return false;
        }
        Mision other = (Mision) object;
        if ((this.codigomision == null && other.codigomision != null) || (this.codigomision != null && !this.codigomision.equals(other.codigomision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.Mision[ codigomision=" + codigomision + " ]";
    }
    public Integer getNumeroacuerdo() {
        return numeroacuerdo;
    }
    public void setNumeroacuerdo(Integer numeroacuerdo) {
        this.numeroacuerdo = numeroacuerdo;
    }

    public String getNombremision() {
        return nombremision;
    }

    public void setNombremision(String nombremision) {
        this.nombremision = nombremision;
    }

    public String getObjetivomision() {
        return objetivomision;
    }

    public void setObjetivomision(String objetivomision) {
        this.objetivomision = objetivomision;
    }

    public String getResponsablegasto() {
        return responsablegasto;
    }

    public void setResponsablegasto(String responsablegasto) {
        this.responsablegasto = responsablegasto;
    }

    public String getOrganismopatrocinador() {
        return organismopatrocinador;
    }

    public void setOrganismopatrocinador(String organismopatrocinador) {
        this.organismopatrocinador = organismopatrocinador;
    }

    public String getOrganismoinvita() {
        return organismoinvita;
    }

    public void setOrganismoinvita(String organismoinvita) {
        this.organismoinvita = organismoinvita;
    }

    public String getDepartamentomision() {
        return departamentomision;
    }

    public void setDepartamentomision(String departamentomision) {
        this.departamentomision = departamentomision;
    }

    public String getPaisdestino() {
        return paisdestino;
    }

    public void setPaisdestino(String paisdestino) {
        this.paisdestino = paisdestino;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTipotransporte() {
        return tipotransporte;
    }

    public void setTipotransporte(String tipotransporte) {
        this.tipotransporte = tipotransporte;
    }

    public Float getViaticos() {
        return viaticos;
    }

    public void setViaticos(Float viaticos) {
        this.viaticos = viaticos;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getBoleto() {
        return boleto;
    }

    public void setBoleto(String boleto) {
        this.boleto = boleto;
    }
    
}
