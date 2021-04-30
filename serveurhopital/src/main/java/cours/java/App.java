package cours.java;

import cours.java.service.*;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            System.setSecurityManager(new SecurityManager());
            Registry registry = LocateRegistry.createRegistry(5003);

            IService iService = new ServiceDao();
            registry.bind("serviceRemote", iService);

            ISpecialite iSpecialite = new SpecialiteDao();
            registry.bind("specialiteRemote", iSpecialite);

            IMedecin iMedecin = new MedecinDao();
            registry.bind("medecinRemote", iMedecin);

            System.out.println("Serveur lance sur le port 5003");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
