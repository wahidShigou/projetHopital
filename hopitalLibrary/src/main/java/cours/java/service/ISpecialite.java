package cours.java.service;

import cours.java.model.Specialite;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ISpecialite extends Remote {
    public void add(Specialite s) throws RemoteException;
    public Specialite find(int id) throws RemoteException;
    public List<Specialite> findAll() throws RemoteException;
    public Specialite findByLibelle(String libelle) throws RemoteException;
}
