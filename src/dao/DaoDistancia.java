package dao;

import hibernet.ConexionHibernet;
import hibernet.Configuracion;
import hibernet.Distancia;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DaoDistancia {
    private static SessionFactory factory;


    public DaoDistancia() {
        ConexionHibernet.generarConexion();
        factory=ConexionHibernet.getFactory();
    }

    public List getDisatanci(){
        Session session = factory.openSession();
        Criteria crit = session.createCriteria(Distancia.class);
        crit.setProjection(Projections.groupProperty("valor"));
        List listaCiudad = crit.list();
        return  listaCiudad;


    }

}
