/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import entity.DetalleComprobantediario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Admin
 */
@Stateless
public class DetalleComprobantediarioFacade extends AbstractFacade<DetalleComprobantediario> {
    @PersistenceContext(unitName = "WebPrestaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleComprobantediarioFacade() {
        super(DetalleComprobantediario.class);
    }
    
}
