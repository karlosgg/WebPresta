package Views;

import entity.Prestamos;
import Views.util.JsfUtil;
import Views.util.JsfUtil.PersistAction;
import Models.PrestamosFacade;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@ManagedBean(name = "prestamosController")
@SessionScoped
public class PrestamosController implements Serializable {

    @EJB
    private Models.PrestamosFacade ejbFacade;
    private List<Prestamos> items = null;
    private Prestamos selected;
    
    public void obtenerproximos() throws ParseException{
        Date ahora = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        
        Calendar c = Calendar.getInstance();
        c.setTime(ahora);
        c.add(Calendar.DATE, 7);
        
        String hoy =  sdf.format(ahora);
        String fechalimite = sdf.format(c.getTime());
        List<Prestamos> result = getFacade().ObtenerFechaLimite(fechalimite, hoy);
        for(Prestamos p: result){
            System.out.println(p.getLogin());
        }
        System.out.println(result.toString());
        FacesContext contexto = FacesContext.getCurrentInstance();
        
        contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Retorno","Ejecutada la consulta"));
  
    }
    
    public Date getHoy(){
        Date ahora = new Date();
    return ahora;
    }
    
    public Date getLimite(){
        Date ahora = new Date();
       
        Calendar c = Calendar.getInstance();
        c.setTime(ahora);
        c.add(Calendar.DATE, 7);
        Date fechalimite = c.getTime();
    return fechalimite;
    }
    
    public Date getAlertaLimite(){
        Date ahora = new Date();
       
        Calendar c = Calendar.getInstance();
        c.setTime(ahora);
        c.add(Calendar.DATE, 7);
        Date fechalimite = c.getTime();
    return fechalimite;
    }
    
    
    public PrestamosController() {
    }

    public Prestamos getSelected() {
        return selected;
    }

    public void setSelected(Prestamos selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private PrestamosFacade getFacade() {
        return ejbFacade;
    }

    public Prestamos prepareCreate() {
        selected = new Prestamos();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("PrestamosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("PrestamosUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("PrestamosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Prestamos> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public List<Prestamos> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Prestamos> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Prestamos.class)
    public static class PrestamosControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PrestamosController controller = (PrestamosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "prestamosController");
            return controller.getFacade().find(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Prestamos) {
                Prestamos o = (Prestamos) object;
                return getStringKey(o.getNumprestamo());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Prestamos.class.getName()});
                return null;
            }
        }

    }

}
