/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "comprobante_diario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComprobanteDiario.findAll", query = "SELECT c FROM ComprobanteDiario c"),
    @NamedQuery(name = "ComprobanteDiario.findByNumcomprobante", query = "SELECT c FROM ComprobanteDiario c WHERE c.numcomprobante = :numcomprobante"),
    @NamedQuery(name = "ComprobanteDiario.findByFecha", query = "SELECT c FROM ComprobanteDiario c WHERE c.fecha = :fecha")})
public class ComprobanteDiario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numcomprobante")
    private Integer numcomprobante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "comprobanteDiario")
    private DetalleComprobantediario detalleComprobantediario;

    public ComprobanteDiario() {
    }

    public ComprobanteDiario(Integer numcomprobante) {
        this.numcomprobante = numcomprobante;
    }

    public ComprobanteDiario(Integer numcomprobante, Date fecha) {
        this.numcomprobante = numcomprobante;
        this.fecha = fecha;
    }

    public Integer getNumcomprobante() {
        return numcomprobante;
    }

    public void setNumcomprobante(Integer numcomprobante) {
        this.numcomprobante = numcomprobante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public DetalleComprobantediario getDetalleComprobantediario() {
        return detalleComprobantediario;
    }

    public void setDetalleComprobantediario(DetalleComprobantediario detalleComprobantediario) {
        this.detalleComprobantediario = detalleComprobantediario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numcomprobante != null ? numcomprobante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComprobanteDiario)) {
            return false;
        }
        ComprobanteDiario other = (ComprobanteDiario) object;
        if ((this.numcomprobante == null && other.numcomprobante != null) || (this.numcomprobante != null && !this.numcomprobante.equals(other.numcomprobante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ComprobanteDiario[ numcomprobante=" + numcomprobante + " ]";
    }
    
}
