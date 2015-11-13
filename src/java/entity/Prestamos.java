/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "prestamos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestamos.findAll", query = "SELECT p FROM Prestamos p ORDER BY p.fechapago ASC"),
    @NamedQuery(name = "Prestamos.findByNumprestamo", query = "SELECT p FROM Prestamos p WHERE p.numprestamo = :numprestamo"),
    @NamedQuery(name = "Prestamos.findByMonto", query = "SELECT p FROM Prestamos p WHERE p.monto = :monto"),
    @NamedQuery(name = "Prestamos.findByCuota", query = "SELECT p FROM Prestamos p WHERE p.cuota = :cuota"),
    @NamedQuery(name = "Prestamos.findByArticulo", query = "SELECT p FROM Prestamos p WHERE p.articulo = :articulo"),
    @NamedQuery(name = "Prestamos.findByInteres", query = "SELECT p FROM Prestamos p WHERE p.interes = :interes"),
    @NamedQuery(name = "Prestamos.findByInterespormora", query = "SELECT p FROM Prestamos p WHERE p.interespormora = :interespormora"),
    @NamedQuery(name = "Prestamos.findBySaldo", query = "SELECT p FROM Prestamos p WHERE p.saldo = :saldo"),
    @NamedQuery(name = "Prestamos.findByFechapago", query = "SELECT p FROM Prestamos p WHERE p.fechapago = :fechapago"),
    @NamedQuery(name = "Prestamos.findByPrima", query = "SELECT p FROM Prestamos p WHERE p.prima = :prima"),
    @NamedQuery(name = "Prestamos.cercadepago", query = "SELECT p FROM Prestamos p WHERE p.fechapago < :fechalimite AND p.fechapago > :hoy")})
public class Prestamos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numprestamo")
    private Integer numprestamo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private BigDecimal monto;
    @Column(name = "cuota")
    private BigDecimal cuota;
    @Size(max = 50)
    @Column(name = "articulo")
    private String articulo;
    @Column(name = "interes")
    private BigDecimal interes;
    @Column(name = "interespormora")
    private BigDecimal interespormora;
    @Column(name = "saldo")
    private BigDecimal saldo;
    @Column(name = "fechapago")
    @Temporal(TemporalType.DATE)
    private Date fechapago;
    @Column(name = "prima")
    private BigDecimal prima;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prestamos")
    private List<Pagos> pagosList;
    @JoinColumn(name = "login", referencedColumnName = "login")
    @ManyToOne(optional = false)
    private Usuario login;
    @JoinColumn(name = "dui", referencedColumnName = "dui")
    @ManyToOne(optional = false)
    private Clientes dui;

    public Prestamos() {
    }

    public Prestamos(Integer numprestamo) {
        this.numprestamo = numprestamo;
    }

    public Integer getNumprestamo() {
        return numprestamo;
    }

    public void setNumprestamo(Integer numprestamo) {
        this.numprestamo = numprestamo;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getCuota() {
        return cuota;
    }

    public void setCuota(BigDecimal cuota) {
        this.cuota = cuota;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public BigDecimal getInteres() {
        return interes;
    }

    public void setInteres(BigDecimal interes) {
        this.interes = interes;
    }

    public BigDecimal getInterespormora() {
        return interespormora;
    }

    public void setInterespormora(BigDecimal interespormora) {
        this.interespormora = interespormora;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Date getFechapago() {
        return fechapago;
    }

    public void setFechapago(Date fechapago) {
        this.fechapago = fechapago;
    }

    public BigDecimal getPrima() {
        return prima;
    }

    public void setPrima(BigDecimal prima) {
        this.prima = prima;
    }

    @XmlTransient
    public List<Pagos> getPagosList() {
        return pagosList;
    }

    public void setPagosList(List<Pagos> pagosList) {
        this.pagosList = pagosList;
    }

    public Usuario getLogin() {
        return login;
    }

    public void setLogin(Usuario login) {
        this.login = login;
    }

    public Clientes getDui() {
        return dui;
    }

    public void setDui(Clientes dui) {
        this.dui = dui;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numprestamo != null ? numprestamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestamos)) {
            return false;
        }
        Prestamos other = (Prestamos) object;
        if ((this.numprestamo == null && other.numprestamo != null) || (this.numprestamo != null && !this.numprestamo.equals(other.numprestamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Prestamos[ numprestamo=" + numprestamo + " ]";
    }
    
}
