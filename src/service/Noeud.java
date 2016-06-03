package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Noeud extends Remote {

    String[] lister() throws RemoteException;

    byte[] getContenu(String nomFichier) throws RemoteException;

    List<Noeud> getLesNoeuds() throws RemoteException;

    boolean addNoeud(Noeud noeud) throws RemoteException;
}
