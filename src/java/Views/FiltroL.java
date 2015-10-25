/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;
import Views.SessionControl;
import java.io.IOException;
import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Admin
 */
public class FiltroL implements Filter{
    private FilterConfig filterConfig = null;
    private HttpServletRequest httpServletRequest;
    FacesContext contexto;
      
      /**
     * Init method for this filter
     */
    @Override
    public void init(FilterConfig filterConfig) {      
        this.filterConfig = filterConfig;
    }
       
     
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
    FilterChain chain) throws IOException, ServletException {
          
  HttpServletRequest req = (HttpServletRequest) request;
  HttpServletResponse res = (HttpServletResponse) response;
  
  // Obtengo el bean que representa el usuario desde el scope sesión
  //Autentificacion loginBean = (Autentificacion) req.getSession().getAttribute("autentificacion");
    httpServletRequest=(HttpServletRequest)contexto.getExternalContext().getRequest();
  //Proceso la URL que está requiriendo el cliente
  String urlStr = req.getRequestURL().toString().toLowerCase();
  boolean noProteger = noProteger(urlStr);
  System.out.println(urlStr + " - desprotegido=[" + noProteger + "]");
    
  //Si no requiere protección continúo normalmente.
  if (noProteger(urlStr)) {
    chain.doFilter(request, response);
    return;
  }
    
  //El usuario no está logueado
  //if (loginBean == null || !loginBean.isLogeado()) {
  if(httpServletRequest.getSession().getAttribute("sessionUsuario")==null){
    res.sendRedirect(req.getContextPath() + "/faces/index.xhtml");
    return;
  }
    
  //El recurso requiere protección, pero el usuario ya está logueado.
  chain.doFilter(request, response);
}
  
     
      
  private boolean noProteger(String urlStr) {
    /*
     * Sin filtro
     */
    if (urlStr.endsWith("index.xhtml"))
      return true;
    if (urlStr.indexOf("/faces/resources/") != -1)
      return true;
    if (urlStr.indexOf("/javax.faces.resource/") != -1)
      return true;
      
  return false;
}
  
    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }  
}
