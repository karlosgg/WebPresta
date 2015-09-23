package entity;

import entity.Clientes;
import entity.Pagos;
import entity.Usuario;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-23T16:28:49")
@StaticMetamodel(Prestamos.class)
public class Prestamos_ { 

    public static volatile SingularAttribute<Prestamos, String> articulo;
    public static volatile SingularAttribute<Prestamos, BigDecimal> prima;
    public static volatile SingularAttribute<Prestamos, Clientes> dui;
    public static volatile SingularAttribute<Prestamos, Date> fechapago;
    public static volatile SingularAttribute<Prestamos, BigDecimal> cuota;
    public static volatile SingularAttribute<Prestamos, BigDecimal> interespormora;
    public static volatile SingularAttribute<Prestamos, Usuario> login;
    public static volatile SingularAttribute<Prestamos, Integer> numprestamo;
    public static volatile SingularAttribute<Prestamos, BigDecimal> saldo;
    public static volatile SingularAttribute<Prestamos, BigDecimal> monto;
    public static volatile SingularAttribute<Prestamos, BigDecimal> interes;
    public static volatile ListAttribute<Prestamos, Pagos> pagosList;

}