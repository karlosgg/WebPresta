/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import entity.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Admin
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {
    @PersistenceContext(unitName = "WebPrestaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public String ObtenerUsuario(String login, String pass){
        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery("Usuario.logeo").setParameter("login", login).setParameter("pass", pass);
        return (String.valueOf(q.getSingleResult())); 
    }
    
    public Boolean existeUsuario(String login, String pass){
       
        try{
            EntityManager em = getEntityManager();
            Query q = em.createNamedQuery("Usuario.logeo").setParameter("login", login).setParameter("pass", pass);
            if(q.getSingleResult()!=null){
            return true;
            }
            return false;      
        }
        catch(Exception e){
            return false;
        }
    }

}