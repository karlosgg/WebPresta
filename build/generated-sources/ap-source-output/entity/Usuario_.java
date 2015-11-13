package entity;

import entity.Pagos;
import entity.Prestamos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-08T23:25:02")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> direccion;
    public static volatile SingularAttribute<Usuario, String> nombres;
    public static volatile SingularAttribute<Usuario, String> apellidos;
    public static volatile SingularAttribute<Usuario, String> email;
    public static volatile ListAttribute<Usuario, Prestamos> prestamosList;
    public static volatile SingularAttribute<Usuario, String> nit;
    public static volatile SingularAttribute<Usuario, String> telefono;
    public static volatile SingularAttribute<Usuario, String> login;
    public static volatile SingularAttribute<Usuario, String> pass;
    public static volatile ListAttribute<Usuario, Pagos> pagosList;

}