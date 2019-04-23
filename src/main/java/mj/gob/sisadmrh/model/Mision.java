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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author developer
 */
@Entity
@Table(name = "mision")
@NamedQueries({
    @NamedQuery(name = "Mision.findAll", query = "SELECT m FROM Mision m")})
public class Mision implements Serializable {

    private static final long serialVersionUID = 1L;
       @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigomision")
    private Integer codigomision;
    @Column(name = "cantidaddia")
    private Integer cantidaddia;
    @Column(name = "cantidadmeses")
    private Integer cantidadmeses;
    @Size(max = 100)
    @Column(name = "departamentomision")
    private String departamentomision;
    @Size(max = 50)
    @Column(name = "documento")
    private String documento;
    @Column(name = "fechaacuerdomision")
//    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaacuerdomision;
    @Column(name = "fecharegresomision")
//    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecharegresomision;
    @Column(name = "fechasalidamision")
//     
    @Temporal(javax.persistence.TemporalType.DATE)
     private Date fechasalidamision;
    @Column(name = "gastostotales")
    private Float gastostotales;
    @Column(name = "gastoterminales")
    private Float gastoterminales;
    @Column(name = "gastoviaje")
    private Float gastoviaje;
    @Column(name = "estadomision")
    private Integer estadomision;
    @Size(max = 50)
    @Column(name = "nombremision")
    private String nombremision;
    @Size(max = 100)
    @Column(name = "objetivomision")
    private String objetivomision;
    @Size(max = 50)
    @Column(name = "paisdestino")
    private String paisdestino;
    @Size(max = 50)
    @Column(name = "responsablegasto")
    private String responsablegasto;
    @Size(max = 50)
    @Column(name = "tipomision")
    private String tipomision;
    @Size(max = 30)
    @Column(name = "tipotransporte")
    private String tipotransporte;
    @Size(max = 20)
    @Column(name = "boleto")
    private String boleto;
    @Column(name = "numeroacuerdo")
    private Integer numeroacuerdo;
    @Size(max = 50)
    @Column(name = "ciudad")
    private String ciudad;
    @Size(max = 50)
    @Column(name = "organismoinvita")
    private String organismoinvita;
    @Size(max = 50)
    @Column(name = "organismopatrocinador")
    private String organismopatrocinador;
     @Size(max = 100)
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "viaticos")
    private Float viaticos;
    @Size(max = 200)
    @Column(name = "boletoterr")
    private String boletoterr;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "docacuerdo")
    private byte[] docacuerdo;

    public byte[] getDocacuerdo() {
        return docacuerdo;
    }

    public void setDocacuerdo(byte[] docacuerdo) {
        this.docacuerdo = docacuerdo;
    }

    public Mision() {
    }

    public Mision(Integer codigomision) {
        this.codigomision = codigomision;
    }
    
    public Mision(Integer codigomision, byte[] docacuerdo) {
        this.codigomision = codigomision;
        this.docacuerdo = docacuerdo;
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

    public Integer getCantidadmeses() {
        return cantidadmeses;
    }

    public void setCantidadmeses(Integer cantidadmeses) {
        this.cantidadmeses = cantidadmeses;
    }

    public String getDepartamentomision() {
        return departamentomision;
    }

    public void setDepartamentomision(String departamentomision) {
        this.departamentomision = departamentomision;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Date getFechaacuerdomision() {
        return fechaacuerdomision;
    }

    public void setFechaacuerdomision(Date fechaacuerdomision) {
        this.fechaacuerdomision = fechaacuerdomision;
    }

    public Date getFecharegresomision() {
        return fecharegresomision;
    }

    public void setFecharegresomision(Date fecharegresomision) {
        this.fecharegresomision = fecharegresomision;
    }

    public Date getFechasalidamision() {
        return fechasalidamision;
    }

    public void setFechasalidamision(Date fechasalidamision) {
        this.fechasalidamision = fechasalidamision;
    }

    public Float getGastostotales() {
        return gastostotales;
    }

    public void setGastostotales(Float gastostotales) {
        this.gastostotales = gastostotales;
    }

    public Float getGastoterminales() {
        return gastoterminales;
    }

    public void setGastoterminales(Float gastoterminales) {
        this.gastoterminales = gastoterminales;
    }

    public Float getGastoviaje() {
        return gastoviaje;
    }

    public void setGastoviaje(Float gastoviaje) {
        this.gastoviaje = gastoviaje;
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

    public String getPaisdestino() {
        return paisdestino;
    }

    public void setPaisdestino(String paisdestino) {
        this.paisdestino = paisdestino;
    }

    public String getResponsablegasto() {
        return responsablegasto;
    }

    public void setResponsablegasto(String responsablegasto) {
        this.responsablegasto = responsablegasto;
    }

    public String getTipomision() {
        return tipomision;
    }

    public void setTipomision(String tipomision) {
        this.tipomision = tipomision;
    }

    public String getTipotransporte() {
        return tipotransporte;
    }

    public void setTipotransporte(String tipotransporte) {
        this.tipotransporte = tipotransporte;
    }

    public String getBoleto() {
        return boleto;
    }

    public void setBoleto(String boleto) {
        this.boleto = boleto;
    }

    public Integer getNumeroacuerdo() {
        return numeroacuerdo;
    }

    public void setNumeroacuerdo(Integer numeroacuerdo) {
        this.numeroacuerdo = numeroacuerdo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getOrganismoinvita() {
        return organismoinvita;
    }

    public void setOrganismoinvita(String organismoinvita) {
        this.organismoinvita = organismoinvita;
    }

    public String getOrganismopatrocinador() {
        return organismopatrocinador;
    }

    public void setOrganismopatrocinador(String organismopatrocinador) {
        this.organismopatrocinador = organismopatrocinador;
    }

    public Float getViaticos() {
        return viaticos;
    }

    public void setViaticos(Float viaticos) {
        this.viaticos = viaticos;
    }

    public String getBoletoterr() {
        return boletoterr;
    }

    public void setBoletoterr(String boletoterr) {
        this.boletoterr = boletoterr;
    }
    
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

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

    public Integer getEstadomision() {
        return estadomision;
    }

    public void setEstadomision(Integer estadomision) {
        this.estadomision = estadomision;
    }
    
}
