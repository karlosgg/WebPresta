package entity;

import entity.Prestamos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-03T20:31:22")
@StaticMetamodel(Clientes.class)
public class Clientes_ { 

    public static volatile SingularAttribute<Clientes, String> direccion;
    public static volatile SingularAttribute<Clientes, String> nombres;
    public static volatile SingularAttribute<Clientes, String> dui;
    public static volatile SingularAttribute<Clientes, String> apellidos;
    public static volatile SingularAttribute<Clientes, String> email;
    public static volatile SingularAttribute<Clientes, String> profesion;
    public static volatile ListAttribute<Clientes, Prestamos> prestamosList;
    public static volatile SingularAttribute<Clientes, String> nit;
    public static volatile SingularAttribute<Clientes, String> telefono;

}