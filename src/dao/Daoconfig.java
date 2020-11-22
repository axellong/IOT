package dao;

import hibernet.ConexionHibernet;
import hibernet.Configuracion;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class Daoconfig {
    private static SessionFactory factory;


    public Daoconfig() {
        ConexionHibernet.generarConexion();
        factory=ConexionHibernet.getFactory();
    }

    public List<Configuracion> getConfig(){
        Session session = factory.openSession();
        Criteria crit = session.createCriteria(Configuracion.class);
        List <Configuracion> listaCiudad = crit.list();
        return  listaCiudad;


    }


}
