/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.context.RequestContext;
 
/**
 *
 * @author KevinArnold
 */
@ManagedBean
@RequestScoped
public class SessionControl {
 
    private String usuario;
    private final HttpServletRequest httpServletRequest;
    private final FacesContext faceContext;
    private FacesMessage facesMessage;
     
    public SessionControl() 
    {
        faceContext=FacesContext.getCurrentInstance();
        httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();
        if(httpServletRequest.getSession().getAttribute("sessionUsuario")!=null)
        {
            usuario=httpServletRequest.getSession().getAttribute("sessionUsuario").toString();
        }
        else{
            RequestContext.getCurrentInstance().update("index.xhtml?faces-redirect=true");
        }
    }
     
    public String cerrarSession()
    {
        httpServletRequest.getSession().removeAttribute("sessionUsuario");
        facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO, "Sesion cerrada", null);
        faceContext.addMessage(null, facesMessage);
        RequestContext.getCurrentInstance().update("faces/index.xhtml?faces-redirect=true");
        return "faces/index.xhtml?faces-redirect=true";
    }
 
    public String getUsuario() {
        return usuario;
    }
 
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }    
}