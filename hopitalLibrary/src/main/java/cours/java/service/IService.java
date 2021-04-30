package cours.java.service;

import cours.java.model.Service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IService extends Remote {
    public void add(Service s) throws RemoteException;
    public Service find(int id) throws RemoteException;
    public Service findByLibelle(String libelle) throws RemoteException;
    public List<Service> findAll() throws RemoteException;
}
