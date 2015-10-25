/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import entity.Prestamos;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Admin
 */
@Stateless
public class PrestamosFacade extends AbstractFacade<Prestamos> {
    @PersistenceContext(unitName = "WebPrestaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrestamosFacade() {
        super(Prestamos.class);
    }
    
    public List ObtenerFechaLimite(String fechalimite, String hoy) throws ParseException{
        em = getEntityManager();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date parsed = format.parse(fechalimite);
        java.sql.Date feclim = new java.sql.Date(parsed.getTime());
        Date parsed2 = format.parse(hoy);
        java.sql.Date fechoy = new java.sql.Date(parsed2.getTime());
        Query q = em.createNamedQuery("Prestamos.cercadepago").setParameter("fechalimite", feclim).setParameter("hoy", fechoy);
        List<Prestamos> prestares = em.createNamedQuery("Prestamos.cercadepago").setParameter("fechalimite", feclim).setParameter("hoy", fechoy).getResultList();
       
        return (prestares); 
    }
    
}
