package entity;

import entity.CatalogoCuentas;
import entity.ComprobanteDiario;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-07T12:18:33")
@StaticMetamodel(DetalleComprobantediario.class)
public class DetalleComprobantediario_ { 

    public static volatile SingularAttribute<DetalleComprobantediario, CatalogoCuentas> idcuenta;
    public static volatile SingularAttribute<DetalleComprobantediario, String> descripcion;
    public static volatile SingularAttribute<DetalleComprobantediario, BigDecimal> abono;
    public static volatile SingularAttribute<DetalleComprobantediario, Integer> numcomprobante;
    public static volatile SingularAttribute<DetalleComprobantediario, BigDecimal> cargo;
    public static volatile SingularAttribute<DetalleComprobantediario, ComprobanteDiario> comprobanteDiario;

}