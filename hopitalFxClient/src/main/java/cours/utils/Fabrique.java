package cours.utils;

import cours.java.service.IMedecin;
import cours.java.service.IService;
import cours.java.service.ISpecialite;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Fabrique {
    private static IService iService;
    private static IMedecin iMedecin;
    private static ISpecialite iSpecialite;

    private static void init() throws Exception{
        try {
            Registry registry = LocateRegistry.getRegistry(5003);
            iService = (IService) registry.lookup("serviceRemote");
            iSpecialite = (ISpecialite) registry.lookup("specialiteRemote");
            iMedecin = (IMedecin) registry.lookup("medecinRemote");
        }
        catch(Exception e){
            throw e;
        }
    }

    public static IService getiService() throws  Exception{

        try {
            if(iService == null) {
                init();
            }
            return iService;
        }
        catch(Exception e){
            throw e;
        }

    }
    public static ISpecialite getiSpecialite() throws  Exception{

        try {
            if(iSpecialite == null) {
                init();
            }
            return iSpecialite;
        }
        catch(Exception e){
            throw e;
        }

    }
    public static IMedecin getiMedecin() throws  Exception{
        try {
            if(iMedecin == null) {
                init();
            }
            return iMedecin;
        }
        catch(Exception e){
            throw e;
        }

    }
}
