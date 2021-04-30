package cours.java.service;


import cours.java.model.Medecin;
import cours.java.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class MedecinDao extends UnicastRemoteObject implements IMedecin{

    private Session session;
    public MedecinDao() throws RemoteException{
        session = HibernateUtil.getSession();
    }

    @Override
    public void add(Medecin medecin) throws RemoteException {
        Transaction t = session.getTransaction();
        try {
            t.begin();
            session.save(medecin);
            t.commit();
        }catch (Exception e){
            t.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Medecin find(int id) throws RemoteException {
        return session.find(Medecin.class, id);
    }

    @Override
    public Medecin findByMatricule(String mat) throws RemoteException {
        try {
            return session.createQuery("SELECT s FROM Medecin s WHERE s.matricule = :mat", Medecin.class)
                    .setParameter("mat", mat)
                    .getSingleResult();
        }catch(Exception e){
            return null;
        }
    }



    @Override
    public List<Medecin> findAll() throws RemoteException {
        return session.createQuery("SELECT s FROM Medecin s", Medecin.class).list();
    }
}
