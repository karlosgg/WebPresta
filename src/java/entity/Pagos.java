/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "pagos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagos.findAll", query = "SELECT p FROM Pagos p"),
    @NamedQuery(name = "Pagos.findByNumpago", query = "SELECT p FROM Pagos p WHERE p.pagosPK.numpago = :numpago"),
    @NamedQuery(name = "Pagos.findByNumprestamo", query = "SELECT p FROM Pagos p WHERE p.pagosPK.numprestamo = :numprestamo"),
    @NamedQuery(name = "Pagos.findByCapitalabonado", query = "SELECT p FROM Pagos p WHERE p.capitalabonado = :capitalabonado"),
    @NamedQuery(name = "Pagos.findByCapitalrestante", query = "SELECT p FROM Pagos p WHERE p.capitalrestante = :capitalrestante"),
    @NamedQuery(name = "Pagos.findBySaldoanterior", query = "SELECT p FROM Pagos p WHERE p.saldoanterior = :saldoanterior"),
    @NamedQuery(name = "Pagos.findByPagoporservicio", query = "SELECT p FROM Pagos p WHERE p.pagoporservicio = :pagoporservicio"),
    @NamedQuery(name = "Pagos.findByInteres", query = "SELECT p FROM Pagos p WHERE p.interes = :interes"),
    @NamedQuery(name = "Pagos.findByInterespormora", query = "SELECT p FROM Pagos p WHERE p.interespormora = :interespormora"),
    @NamedQuery(name = "Pagos.findByFechapago", query = "SELECT p FROM Pagos p WHERE p.fechapago = :fechapago")})
public class Pagos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PagosPK pagosPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "capitalabonado")
    private BigDecimal capitalabonado;
    @Column(name = "capitalrestante")
    private BigDecimal capitalrestante;
    @Column(name = "saldoanterior")
    private BigDecimal saldoanterior;
    @Column(name = "pagoporservicio")
    private BigDecimal pagoporservicio;
    @Column(name = "interes")
    private BigDecimal interes;
    @Column(name = "interespormora")
    private BigDecimal interespormora;
    @Column(name = "fechapago")
    @Temporal(TemporalType.DATE)
    private Date fechapago;
    @JoinColumn(name = "login", referencedColumnName = "login")
    @ManyToOne(optional = false)
    private Usuario login;
    @JoinColumn(name = "numprestamo", referencedColumnName = "numprestamo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Prestamos prestamos;

    public Pagos() {
    }

    public Pagos(PagosPK pagosPK) {
        this.pagosPK = pagosPK;
    }

    public Pagos(int numpago, int numprestamo) {
        this.pagosPK = new PagosPK(numpago, numprestamo);
    }

    public PagosPK getPagosPK() {
        return pagosPK;
    }

    public void setPagosPK(PagosPK pagosPK) {
        this.pagosPK = pagosPK;
    }

    public BigDecimal getCapitalabonado() {
        return capitalabonado;
    }

    public void setCapitalabonado(BigDecimal capitalabonado) {
        this.capitalabonado = capitalabonado;
    }

    public BigDecimal getCapitalrestante() {
        return capitalrestante;
    }

    public void setCapitalrestante(BigDecimal capitalrestante) {
        this.capitalrestante = capitalrestante;
    }

    public BigDecimal getSaldoanterior() {
        return saldoanterior;
    }

    public void setSaldoanterior(BigDecimal saldoanterior) {
        this.saldoanterior = saldoanterior;
    }

    public BigDecimal getPagoporservicio() {
        return pagoporservicio;
    }

    public void setPagoporservicio(BigDecimal pagoporservicio) {
        this.pagoporservicio = pagoporservicio;
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

    public Date getFechapago() {
        return fechapago;
    }

    public void setFechapago(Date fechapago) {
        this.fechapago = fechapago;
    }

    public Usuario getLogin() {
        return login;
    }

    public void setLogin(Usuario login) {
        this.login = login;
    }

    public Prestamos getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Prestamos prestamos) {
        this.prestamos = prestamos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pagosPK != null ? pagosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagos)) {
            return false;
        }
        Pagos other = (Pagos) object;
        if ((this.pagosPK == null && other.pagosPK != null) || (this.pagosPK != null && !this.pagosPK.equals(other.pagosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Pagos[ pagosPK=" + pagosPK + " ]";
    }
    
}
