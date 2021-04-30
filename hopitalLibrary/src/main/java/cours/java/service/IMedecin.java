package cours.java.service;

import cours.java.model.Medecin;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IMedecin extends Remote {
    public void add(Medecin s) throws RemoteException;
    public Medecin find(int id) throws RemoteException;
    public Medecin findByMatricule(String matricule) throws RemoteException;
    public List<Medecin> findAll() throws RemoteException;
}
