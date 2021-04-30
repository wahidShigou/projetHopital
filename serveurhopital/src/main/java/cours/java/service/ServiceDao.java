package cours.java.service;

import cours.java.model.Medecin;
import cours.java.model.Service;
import cours.java.model.Specialite;
import cours.java.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ServiceDao extends UnicastRemoteObject implements IService{

    private Session session;
    public ServiceDao() throws RemoteException{
        session = HibernateUtil.getSession();
    }

    @Override
    public void add(Service service) throws RemoteException {
        Transaction t = session.getTransaction();
        try {
            t.begin();
            session.save(service);
            t.commit();
        }catch (Exception e){
            t.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Service find(int id) throws RemoteException {
        return session.find(Service.class, id);
    }

    @Override
    public Service findByLibelle(String libelle) throws RemoteException {
        try {
            return session.createQuery("SELECT s FROM Service s WHERE s.libelle = :lib", Service.class)
                    .setParameter("lib", libelle)
                    .getSingleResult();
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public List<Service> findAll() throws RemoteException {
        return session.createQuery("SELECT s FROM Service s").list();
    }
}
