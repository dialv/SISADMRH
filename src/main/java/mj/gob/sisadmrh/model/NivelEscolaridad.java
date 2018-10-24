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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "NIVELESCOLARIDAD")

//@NamedQueries({
//@NamedQuery(name = "Nivelescolaridad.findAll", query = "SELECT n FROM Nivelescolaridad n")})

public class NivelEscolaridad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGONIVELNIVELESCOLARIDAD")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigonivelnivelescolaridad;
    @Size(max = 50)
    @Column(name = "CENTROEDUCATIVO")
    private String centroeducativo;
    @Column(name = "ANIOSAPROBADOS")
    private Integer aniosaprobados;
    @Size(max = 300)
    @Column(name = "ESTUDIOREALIZADO")
    private String estudiorealizado;
    @Size(max = 2)
    @Column(name = "FINALIZADO")
    private String finalizado;
    @Size(max = 50)
    @Column(name = "TITULOOBTENIDO")
    private String tituloobtenido;
    @Size(max = 50)
    @Column(name = "PAISNIVELESCOLARIDAD")
    private String paisnivelescolaridad;
    @Column(name = "FECHADESDENIVELESCOLARIDAD")
     @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechadesdenivelescolaridad;
    @Column(name = "FECHAHASTANIVELESCOLARIDAD")
    //@Temporal(TemporalType.DATE)
      @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechahastanivelescolaridad;
    @Lob
    @Column(name = "TITULO")
    private byte[] titulo;//sube el formularios

    
//   @ManyToMany(mappedBy = "nivelescolaridadList")
//   private List<Empleado> empleadoList;

    public NivelEscolaridad() {
    }

    public NivelEscolaridad(Integer codigonivelnivelescolaridad) {
        this.codigonivelnivelescolaridad = codigonivelnivelescolaridad;
    }

    public Integer getCodigonivelnivelescolaridad() {
        return codigonivelnivelescolaridad;
    }

    public void setCodigonivelnivelescolaridad(Integer codigonivelnivelescolaridad) {
        this.codigonivelnivelescolaridad = codigonivelnivelescolaridad;
    }

    public String getCentroeducativo() {
        return centroeducativo;
    }

    public void setCentroeducativo(String centroeducativo) {
        this.centroeducativo = centroeducativo;
    }

    public Integer getAniosaprobados() {
        return aniosaprobados;
    }

    public void setAniosaprobados(Integer aniosaprobados) {
        this.aniosaprobados = aniosaprobados;
    }

    public String getEstudiorealizado() {
        return estudiorealizado;
    }

    public void setEstudiorealizado(String estudiorealizado) {
        this.estudiorealizado = estudiorealizado;
    }

    public String getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(String finalizado) {
        this.finalizado = finalizado;
    }

    public String getTituloobtenido() {
        return tituloobtenido;
    }

    public void setTituloobtenido(String tituloobtenido) {
        this.tituloobtenido = tituloobtenido;
    }

    public String getPaisnivelescolaridad() {
        return paisnivelescolaridad;
    }

    public void setPaisnivelescolaridad(String paisnivelescolaridad) {
        this.paisnivelescolaridad = paisnivelescolaridad;
    }

    public Date getFechadesdenivelescolaridad() {
        return fechadesdenivelescolaridad;
    }

    public void setFechadesdenivelescolaridad(Date fechadesdenivelescolaridad) {
        this.fechadesdenivelescolaridad = fechadesdenivelescolaridad;
    }

    public Date getFechahastanivelescolaridad() {
        return fechahastanivelescolaridad;
    }

    public void setFechahastanivelescolaridad(Date fechahastanivelescolaridad) {
        this.fechahastanivelescolaridad = fechahastanivelescolaridad;
    }

    public byte[] getTitulo() {
        return titulo;
    }

    public void setTitulo(byte[] titulo) {
        this.titulo = titulo;
    }
//    public List<Empleado> getEmpleadoList() {
//        return empleadoList;
//    }
//
//    public void setEmpleadoList(List<Empleado> empleadoList) {
//       this.empleadoList = empleadoList;
//   }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigonivelnivelescolaridad != null ? codigonivelnivelescolaridad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelEscolaridad)) {
            return false;
        }
        NivelEscolaridad other = (NivelEscolaridad) object;
        if ((this.codigonivelnivelescolaridad == null && other.codigonivelnivelescolaridad != null) || (this.codigonivelnivelescolaridad != null && !this.codigonivelnivelescolaridad.equals(other.codigonivelnivelescolaridad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.Nivelescolaridad[ codigonivelnivelescolaridad=" + codigonivelnivelescolaridad + " ]";
    }
    
}
