package entity;

import entity.PagosPK;
import entity.Prestamos;
import entity.Usuario;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-07T12:18:33")
@StaticMetamodel(Pagos.class)
public class Pagos_ { 

    public static volatile SingularAttribute<Pagos, BigDecimal> saldoanterior;
    public static volatile SingularAttribute<Pagos, Prestamos> prestamos;
    public static volatile SingularAttribute<Pagos, PagosPK> pagosPK;
    public static volatile SingularAttribute<Pagos, Date> fechapago;
    public static volatile SingularAttribute<Pagos, BigDecimal> pagoporservicio;
    public static volatile SingularAttribute<Pagos, BigDecimal> interespormora;
    public static volatile SingularAttribute<Pagos, Usuario> login;
    public static volatile SingularAttribute<Pagos, BigDecimal> capitalabonado;
    public static volatile SingularAttribute<Pagos, BigDecimal> capitalrestante;
    public static volatile SingularAttribute<Pagos, BigDecimal> interes;

}