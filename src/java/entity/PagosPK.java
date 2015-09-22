/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Admin
 */
@Embeddable
public class PagosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "numpago")
    private int numpago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numprestamo")
    private int numprestamo;

    public PagosPK() {
    }

    public PagosPK(int numpago, int numprestamo) {
        this.numpago = numpago;
        this.numprestamo = numprestamo;
    }

    public int getNumpago() {
        return numpago;
    }

    public void setNumpago(int numpago) {
        this.numpago = numpago;
    }

    public int getNumprestamo() {
        return numprestamo;
    }

    public void setNumprestamo(int numprestamo) {
        this.numprestamo = numprestamo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numpago;
        hash += (int) numprestamo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagosPK)) {
            return false;
        }
        PagosPK other = (PagosPK) object;
        if (this.numpago != other.numpago) {
            return false;
        }
        if (this.numprestamo != other.numprestamo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PagosPK[ numpago=" + numpago + ", numprestamo=" + numprestamo + " ]";
    }
    
}
