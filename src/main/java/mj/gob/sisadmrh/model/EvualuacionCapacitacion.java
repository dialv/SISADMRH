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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "EVUALUACIONCAPACITACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evualuacioncapacitacion.findAll", query = "SELECT e FROM Evualuacioncapacitacion e"),
    @NamedQuery(name = "Evualuacioncapacitacion.findByCodigoevaluacioncapacitacion", query = "SELECT e FROM Evualuacioncapacitacion e WHERE e.codigoevaluacioncapacitacion = :codigoevaluacioncapacitacion"),
    @NamedQuery(name = "Evualuacioncapacitacion.findByLugarcapacitacion", query = "SELECT e FROM Evualuacioncapacitacion e WHERE e.lugarcapacitacion = :lugarcapacitacion"),
    @NamedQuery(name = "Evualuacioncapacitacion.findByHoraevualuacioncapacitacion", query = "SELECT e FROM Evualuacioncapacitacion e WHERE e.horaevualuacioncapacitacion = :horaevualuacioncapacitacion"),
    @NamedQuery(name = "Evualuacioncapacitacion.findByDominiotema", query = "SELECT e FROM Evualuacioncapacitacion e WHERE e.dominiotema = :dominiotema"),
    @NamedQuery(name = "Evualuacioncapacitacion.findByHabilidadcomunicacion", query = "SELECT e FROM Evualuacioncapacitacion e WHERE e.habilidadcomunicacion = :habilidadcomunicacion"),
    @NamedQuery(name = "Evualuacioncapacitacion.findByEspectativa", query = "SELECT e FROM Evualuacioncapacitacion e WHERE e.espectativa = :espectativa"),
    @NamedQuery(name = "Evualuacioncapacitacion.findByClaridadtema", query = "SELECT e FROM Evualuacioncapacitacion e WHERE e.claridadtema = :claridadtema"),
    @NamedQuery(name = "Evualuacioncapacitacion.findByAlclaradudas", query = "SELECT e FROM Evualuacioncapacitacion e WHERE e.alclaradudas = :alclaradudas"),
    @NamedQuery(name = "Evualuacioncapacitacion.findByInterestema", query = "SELECT e FROM Evualuacioncapacitacion e WHERE e.interestema = :interestema"),
    @NamedQuery(name = "Evualuacioncapacitacion.findBySatifacciondetema", query = "SELECT e FROM Evualuacioncapacitacion e WHERE e.satifacciondetema = :satifacciondetema"),
    @NamedQuery(name = "Evualuacioncapacitacion.findByComprenciondetema", query = "SELECT e FROM Evualuacioncapacitacion e WHERE e.comprenciondetema = :comprenciondetema"),
    @NamedQuery(name = "Evualuacioncapacitacion.findByPlaneaciontiempo", query = "SELECT e FROM Evualuacioncapacitacion e WHERE e.planeaciontiempo = :planeaciontiempo"),
    @NamedQuery(name = "Evualuacioncapacitacion.findByDistribuciontiempo", query = "SELECT e FROM Evualuacioncapacitacion e WHERE e.distribuciontiempo = :distribuciontiempo"),
    @NamedQuery(name = "Evualuacioncapacitacion.findByContenidoclaro", query = "SELECT e FROM Evualuacioncapacitacion e WHERE e.contenidoclaro = :contenidoclaro"),
    @NamedQuery(name = "Evualuacioncapacitacion.findByContenidoaplicadotrabajo", query = "SELECT e FROM Evualuacioncapacitacion e WHERE e.contenidoaplicadotrabajo = :contenidoaplicadotrabajo"),
    @NamedQuery(name = "Evualuacioncapacitacion.findBySatisfechocontenido", query = "SELECT e FROM Evualuacioncapacitacion e WHERE e.satisfechocontenido = :satisfechocontenido"),
    @NamedQuery(name = "Evualuacioncapacitacion.findByNecesariocapacitacion", query = "SELECT e FROM Evualuacioncapacitacion e WHERE e.necesariocapacitacion = :necesariocapacitacion"),
    @NamedQuery(name = "Evualuacioncapacitacion.findByEquipotecnologico", query = "SELECT e FROM Evualuacioncapacitacion e WHERE e.equipotecnologico = :equipotecnologico"),
    @NamedQuery(name = "Evualuacioncapacitacion.findByMaterialutilizado", query = "SELECT e FROM Evualuacioncapacitacion e WHERE e.materialutilizado = :materialutilizado"),
    @NamedQuery(name = "Evualuacioncapacitacion.findByTiempocapacitacionoptimo", query = "SELECT e FROM Evualuacioncapacitacion e WHERE e.tiempocapacitacionoptimo = :tiempocapacitacionoptimo"),
    @NamedQuery(name = "Evualuacioncapacitacion.findByComentario", query = "SELECT e FROM Evualuacioncapacitacion e WHERE e.comentario = :comentario"),
    @NamedQuery(name = "Evualuacioncapacitacion.findByPuntualidad", query = "SELECT e FROM Evualuacioncapacitacion e WHERE e.puntualidad = :puntualidad")})
public class Evualuacioncapacitacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGOEVALUACIONCAPACITACION")
    private Integer codigoevaluacioncapacitacion;
    @Size(max = 100)
    @Column(name = "LUGARCAPACITACION")
    private String lugarcapacitacion;
    @Column(name = "HORAEVUALUACIONCAPACITACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaevualuacioncapacitacion;
    @Size(max = 4)
    @Column(name = "DOMINIOTEMA")
    private String dominiotema;
    @Size(max = 2)
    @Column(name = "HABILIDADCOMUNICACION")
    private String habilidadcomunicacion;
    @Size(max = 2)
    @Column(name = "ESPECTATIVA")
    private String espectativa;
    @Size(max = 2)
    @Column(name = "CLARIDADTEMA")
    private String claridadtema;
    @Size(max = 2)
    @Column(name = "ALCLARADUDAS")
    private String alclaradudas;
    @Size(max = 2)
    @Column(name = "INTERESTEMA")
    private String interestema;
    @Size(max = 2)
    @Column(name = "SATIFACCIONDETEMA")
    private String satifacciondetema;
    @Size(max = 2)
    @Column(name = "COMPRENCIONDETEMA")
    private String comprenciondetema;
    @Size(max = 4)
    @Column(name = "PLANEACIONTIEMPO")
    private String planeaciontiempo;
    @Size(max = 4)
    @Column(name = "DISTRIBUCIONTIEMPO")
    private String distribuciontiempo;
    @Size(max = 4)
    @Column(name = "CONTENIDOCLARO")
    private String contenidoclaro;
    @Size(max = 4)
    @Column(name = "CONTENIDOAPLICADOTRABAJO")
    private String contenidoaplicadotrabajo;
    @Size(max = 2)
    @Column(name = "SATISFECHOCONTENIDO")
    private String satisfechocontenido;
    @Size(max = 2)
    @Column(name = "NECESARIOCAPACITACION")
    private String necesariocapacitacion;
    @Size(max = 2)
    @Column(name = "EQUIPOTECNOLOGICO")
    private String equipotecnologico;
    @Size(max = 2)
    @Column(name = "MATERIALUTILIZADO")
    private String materialutilizado;
    @Size(max = 2)
    @Column(name = "TIEMPOCAPACITACIONOPTIMO")
    private String tiempocapacitacionoptimo;
    @Size(max = 100)
    @Column(name = "COMENTARIO")
    private String comentario;
    @Size(max = 2)
    @Column(name = "PUNTUALIDAD")
    private String puntualidad;
    @JoinColumn(name = "CODIGOCAPACITACION", referencedColumnName = "CODIGOCAPACITACION")
    @ManyToOne(optional = false)
    private Capacitacion codigocapacitacion;

    public Evualuacioncapacitacion() {
    }

    public Evualuacioncapacitacion(Integer codigoevaluacioncapacitacion) {
        this.codigoevaluacioncapacitacion = codigoevaluacioncapacitacion;
    }

    public Integer getCodigoevaluacioncapacitacion() {
        return codigoevaluacioncapacitacion;
    }

    public void setCodigoevaluacioncapacitacion(Integer codigoevaluacioncapacitacion) {
        this.codigoevaluacioncapacitacion = codigoevaluacioncapacitacion;
    }

    public String getLugarcapacitacion() {
        return lugarcapacitacion;
    }

    public void setLugarcapacitacion(String lugarcapacitacion) {
        this.lugarcapacitacion = lugarcapacitacion;
    }

    public Date getHoraevualuacioncapacitacion() {
        return horaevualuacioncapacitacion;
    }

    public void setHoraevualuacioncapacitacion(Date horaevualuacioncapacitacion) {
        this.horaevualuacioncapacitacion = horaevualuacioncapacitacion;
    }

    public String getDominiotema() {
        return dominiotema;
    }

    public void setDominiotema(String dominiotema) {
        this.dominiotema = dominiotema;
    }

    public String getHabilidadcomunicacion() {
        return habilidadcomunicacion;
    }

    public void setHabilidadcomunicacion(String habilidadcomunicacion) {
        this.habilidadcomunicacion = habilidadcomunicacion;
    }

    public String getEspectativa() {
        return espectativa;
    }

    public void setEspectativa(String espectativa) {
        this.espectativa = espectativa;
    }

    public String getClaridadtema() {
        return claridadtema;
    }

    public void setClaridadtema(String claridadtema) {
        this.claridadtema = claridadtema;
    }

    public String getAlclaradudas() {
        return alclaradudas;
    }

    public void setAlclaradudas(String alclaradudas) {
        this.alclaradudas = alclaradudas;
    }

    public String getInterestema() {
        return interestema;
    }

    public void setInterestema(String interestema) {
        this.interestema = interestema;
    }

    public String getSatifacciondetema() {
        return satifacciondetema;
    }

    public void setSatifacciondetema(String satifacciondetema) {
        this.satifacciondetema = satifacciondetema;
    }

    public String getComprenciondetema() {
        return comprenciondetema;
    }

    public void setComprenciondetema(String comprenciondetema) {
        this.comprenciondetema = comprenciondetema;
    }

    public String getPlaneaciontiempo() {
        return planeaciontiempo;
    }

    public void setPlaneaciontiempo(String planeaciontiempo) {
        this.planeaciontiempo = planeaciontiempo;
    }

    public String getDistribuciontiempo() {
        return distribuciontiempo;
    }

    public void setDistribuciontiempo(String distribuciontiempo) {
        this.distribuciontiempo = distribuciontiempo;
    }

    public String getContenidoclaro() {
        return contenidoclaro;
    }

    public void setContenidoclaro(String contenidoclaro) {
        this.contenidoclaro = contenidoclaro;
    }

    public String getContenidoaplicadotrabajo() {
        return contenidoaplicadotrabajo;
    }

    public void setContenidoaplicadotrabajo(String contenidoaplicadotrabajo) {
        this.contenidoaplicadotrabajo = contenidoaplicadotrabajo;
    }

    public String getSatisfechocontenido() {
        return satisfechocontenido;
    }

    public void setSatisfechocontenido(String satisfechocontenido) {
        this.satisfechocontenido = satisfechocontenido;
    }

    public String getNecesariocapacitacion() {
        return necesariocapacitacion;
    }

    public void setNecesariocapacitacion(String necesariocapacitacion) {
        this.necesariocapacitacion = necesariocapacitacion;
    }

    public String getEquipotecnologico() {
        return equipotecnologico;
    }

    public void setEquipotecnologico(String equipotecnologico) {
        this.equipotecnologico = equipotecnologico;
    }

    public String getMaterialutilizado() {
        return materialutilizado;
    }

    public void setMaterialutilizado(String materialutilizado) {
        this.materialutilizado = materialutilizado;
    }

    public String getTiempocapacitacionoptimo() {
        return tiempocapacitacionoptimo;
    }

    public void setTiempocapacitacionoptimo(String tiempocapacitacionoptimo) {
        this.tiempocapacitacionoptimo = tiempocapacitacionoptimo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getPuntualidad() {
        return puntualidad;
    }

    public void setPuntualidad(String puntualidad) {
        this.puntualidad = puntualidad;
    }

    public Capacitacion getCodigocapacitacion() {
        return codigocapacitacion;
    }

    public void setCodigocapacitacion(Capacitacion codigocapacitacion) {
        this.codigocapacitacion = codigocapacitacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoevaluacioncapacitacion != null ? codigoevaluacioncapacitacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evualuacioncapacitacion)) {
            return false;
        }
        Evualuacioncapacitacion other = (Evualuacioncapacitacion) object;
        if ((this.codigoevaluacioncapacitacion == null && other.codigoevaluacioncapacitacion != null) || (this.codigoevaluacioncapacitacion != null && !this.codigoevaluacioncapacitacion.equals(other.codigoevaluacioncapacitacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.Evualuacioncapacitacion[ codigoevaluacioncapacitacion=" + codigoevaluacioncapacitacion + " ]";
    }
    
}
