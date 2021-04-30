package cours.java.service;

import cours.java.model.Specialite;
import cours.java.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class SpecialiteDao extends UnicastRemoteObject implements ISpecialite{

    private Session session;
    public SpecialiteDao() throws RemoteException{
        session = HibernateUtil.getSession();
    }

    @Override
    public void add(Specialite specialite) throws RemoteException {
        Transaction t = session.getTransaction();
        try {
            t.begin();
            session.save(specialite);
            t.commit();
        }catch (Exception e){
            t.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Specialite find(int id) throws RemoteException {
        return session.find(Specialite.class, id);
    }

    @Override
    public Specialite findByLibelle(String libelle) throws RemoteException {
        try {
            return session.createQuery("SELECT s FROM Specialite s WHERE s.libelle = :lib", Specialite.class)
                    .setParameter("lib", libelle)
                    .getSingleResult();
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public List<Specialite> findAll() throws RemoteException {
        return session.createQuery("SELECT s FROM Specialite s",Specialite.class).list();
    }
}
