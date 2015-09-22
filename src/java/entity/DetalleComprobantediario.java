/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "detalle_comprobantediario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleComprobantediario.findAll", query = "SELECT d FROM DetalleComprobantediario d"),
    @NamedQuery(name = "DetalleComprobantediario.findByNumcomprobante", query = "SELECT d FROM DetalleComprobantediario d WHERE d.numcomprobante = :numcomprobante"),
    @NamedQuery(name = "DetalleComprobantediario.findByCargo", query = "SELECT d FROM DetalleComprobantediario d WHERE d.cargo = :cargo"),
    @NamedQuery(name = "DetalleComprobantediario.findByAbono", query = "SELECT d FROM DetalleComprobantediario d WHERE d.abono = :abono"),
    @NamedQuery(name = "DetalleComprobantediario.findByDescripcion", query = "SELECT d FROM DetalleComprobantediario d WHERE d.descripcion = :descripcion")})
public class DetalleComprobantediario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numcomprobante")
    private Integer numcomprobante;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cargo")
    private BigDecimal cargo;
    @Column(name = "abono")
    private BigDecimal abono;
    @Size(max = 75)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "numcomprobante", referencedColumnName = "numcomprobante", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private ComprobanteDiario comprobanteDiario;
    @JoinColumn(name = "idcuenta", referencedColumnName = "idcuenta")
    @ManyToOne(optional = false)
    private CatalogoCuentas idcuenta;

    public DetalleComprobantediario() {
    }

    public DetalleComprobantediario(Integer numcomprobante) {
        this.numcomprobante = numcomprobante;
    }

    public Integer getNumcomprobante() {
        return numcomprobante;
    }

    public void setNumcomprobante(Integer numcomprobante) {
        this.numcomprobante = numcomprobante;
    }

    public BigDecimal getCargo() {
        return cargo;
    }

    public void setCargo(BigDecimal cargo) {
        this.cargo = cargo;
    }

    public BigDecimal getAbono() {
        return abono;
    }

    public void setAbono(BigDecimal abono) {
        this.abono = abono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ComprobanteDiario getComprobanteDiario() {
        return comprobanteDiario;
    }

    public void setComprobanteDiario(ComprobanteDiario comprobanteDiario) {
        this.comprobanteDiario = comprobanteDiario;
    }

    public CatalogoCuentas getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(CatalogoCuentas idcuenta) {
        this.idcuenta = idcuenta;
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
        if (!(object instanceof DetalleComprobantediario)) {
            return false;
        }
        DetalleComprobantediario other = (DetalleComprobantediario) object;
        if ((this.numcomprobante == null && other.numcomprobante != null) || (this.numcomprobante != null && !this.numcomprobante.equals(other.numcomprobante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DetalleComprobantediario[ numcomprobante=" + numcomprobante + " ]";
    }
    
}
