package entity;

import entity.DetalleComprobantediario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-07T12:18:33")
@StaticMetamodel(ComprobanteDiario.class)
public class ComprobanteDiario_ { 

    public static volatile SingularAttribute<ComprobanteDiario, Date> fecha;
    public static volatile SingularAttribute<ComprobanteDiario, DetalleComprobantediario> detalleComprobantediario;
    public static volatile SingularAttribute<ComprobanteDiario, Integer> numcomprobante;

}