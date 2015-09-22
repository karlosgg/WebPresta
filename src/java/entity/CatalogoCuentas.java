/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "catalogo_cuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatalogoCuentas.findAll", query = "SELECT c FROM CatalogoCuentas c"),
    @NamedQuery(name = "CatalogoCuentas.findByIdcuenta", query = "SELECT c FROM CatalogoCuentas c WHERE c.idcuenta = :idcuenta"),
    @NamedQuery(name = "CatalogoCuentas.findByTipocuenta", query = "SELECT c FROM CatalogoCuentas c WHERE c.tipocuenta = :tipocuenta"),
    @NamedQuery(name = "CatalogoCuentas.findByIdcuentapadre", query = "SELECT c FROM CatalogoCuentas c WHERE c.idcuentapadre = :idcuentapadre"),
    @NamedQuery(name = "CatalogoCuentas.findByNombre", query = "SELECT c FROM CatalogoCuentas c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "CatalogoCuentas.findByCargo", query = "SELECT c FROM CatalogoCuentas c WHERE c.cargo = :cargo"),
    @NamedQuery(name = "CatalogoCuentas.findByAbono", query = "SELECT c FROM CatalogoCuentas c WHERE c.abono = :abono")})
public class CatalogoCuentas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "idcuenta")
    private String idcuenta;
    @Column(name = "tipocuenta")
    private Integer tipocuenta;
    @Size(max = 40)
    @Column(name = "idcuentapadre")
    private String idcuentapadre;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cargo")
    private BigDecimal cargo;
    @Column(name = "abono")
    private BigDecimal abono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcuenta")
    private List<DetalleComprobantediario> detalleComprobantediarioList;

    public CatalogoCuentas() {
    }

    public CatalogoCuentas(String idcuenta) {
        this.idcuenta = idcuenta;
    }

    public String getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(String idcuenta) {
        this.idcuenta = idcuenta;
    }

    public Integer getTipocuenta() {
        return tipocuenta;
    }

    public void setTipocuenta(Integer tipocuenta) {
        this.tipocuenta = tipocuenta;
    }

    public String getIdcuentapadre() {
        return idcuentapadre;
    }

    public void setIdcuentapadre(String idcuentapadre) {
        this.idcuentapadre = idcuentapadre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    @XmlTransient
    public List<DetalleComprobantediario> getDetalleComprobantediarioList() {
        return detalleComprobantediarioList;
    }

    public void setDetalleComprobantediarioList(List<DetalleComprobantediario> detalleComprobantediarioList) {
        this.detalleComprobantediarioList = detalleComprobantediarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcuenta != null ? idcuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatalogoCuentas)) {
            return false;
        }
        CatalogoCuentas other = (CatalogoCuentas) object;
        if ((this.idcuenta == null && other.idcuenta != null) || (this.idcuenta != null && !this.idcuenta.equals(other.idcuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CatalogoCuentas[ idcuenta=" + idcuenta + " ]";
    }
    
}
