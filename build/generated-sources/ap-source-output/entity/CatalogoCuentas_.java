package entity;

import entity.DetalleComprobantediario;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-03T20:31:22")
@StaticMetamodel(CatalogoCuentas.class)
public class CatalogoCuentas_ { 

    public static volatile SingularAttribute<CatalogoCuentas, String> nombre;
    public static volatile SingularAttribute<CatalogoCuentas, String> idcuentapadre;
    public static volatile SingularAttribute<CatalogoCuentas, String> idcuenta;
    public static volatile SingularAttribute<CatalogoCuentas, BigDecimal> abono;
    public static volatile SingularAttribute<CatalogoCuentas, Integer> tipocuenta;
    public static volatile SingularAttribute<CatalogoCuentas, BigDecimal> cargo;
    public static volatile ListAttribute<CatalogoCuentas, DetalleComprobantediario> detalleComprobantediarioList;

}