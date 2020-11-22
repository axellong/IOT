package hibernet;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class ConexionHibernet {

    private static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;
    private static Configuration configuration;
    private static String driver;

    private ConexionHibernet() {

    }

    public static void generarConexion() {

        System.err.println("Iniciando");
        try {
            System.err.println("Leyendo configuracion.");
            generarConfiguracion();
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            factory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.err.println("No se puede crear la Sesion" + ex);
            throw new ExceptionInInitializerError(ex);
        }


    }

    public static SessionFactory getFactory() {
        return factory;
    }

    private static void generarConfiguracion() {
        configuration = new Configuration();
        configuration.configure("/hibernet/" + driver + ".cfg.xml");
    }

    public static String getDriver() {
        return driver;
    }

    public static void setDriver(String driver) {
        ConexionHibernet.driver = driver;
    }


}
