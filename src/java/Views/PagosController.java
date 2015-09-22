package Views;

import entity.Pagos;
import Views.util.JsfUtil;
import Views.util.JsfUtil.PersistAction;
import Models.PagosFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@ManagedBean(name = "pagosController")
@SessionScoped
public class PagosController implements Serializable {

    @EJB
    private Models.PagosFacade ejbFacade;
    private List<Pagos> items = null;
    private Pagos selected;

    public PagosController() {
    }

    public Pagos getSelected() {
        return selected;
    }

    public void setSelected(Pagos selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getPagosPK().setNumprestamo(selected.getPrestamos().getNumprestamo());
    }

    protected void initializeEmbeddableKey() {
        selected.setPagosPK(new entity.PagosPK());
    }

    private PagosFacade getFacade() {
        return ejbFacade;
    }

    public Pagos prepareCreate() {
        selected = new Pagos();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("PagosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("PagosUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("PagosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Pagos> getItems() {
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

    public List<Pagos> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Pagos> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Pagos.class)
    public static class PagosControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PagosController controller = (PagosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "pagosController");
            return controller.getFacade().find(getKey(value));
        }

        entity.PagosPK getKey(String value) {
            entity.PagosPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new entity.PagosPK();
            key.setNumpago(Integer.parseInt(values[0]));
            key.setNumprestamo(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(entity.PagosPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getNumpago());
            sb.append(SEPARATOR);
            sb.append(value.getNumprestamo());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Pagos) {
                Pagos o = (Pagos) object;
                return getStringKey(o.getPagosPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Pagos.class.getName()});
                return null;
            }
        }

    }

}
