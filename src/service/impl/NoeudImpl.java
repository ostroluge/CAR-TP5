package service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import domain.Repertoire;
import service.Noeud;

@SuppressWarnings("serial")
public class NoeudImpl extends UnicastRemoteObject implements Noeud {

    public Repertoire repertoire;
    public List<Noeud> noeuds = new ArrayList<>();

    public NoeudImpl(Repertoire repertoire) throws RemoteException {
	super();
	this.repertoire = repertoire;
    }

    public String[] lister() throws RemoteException {
	String[] fichiers = null;
	if (repertoire != null) {
	    fichiers = new String[repertoire.fichiers.size()];
	    fichiers = repertoire.fichiers.toArray(fichiers);
	}
	return fichiers;
    }

    public byte[] getContenu(String nomFichier) throws RemoteException {
	return null;
    }

    public List<Noeud> getLesNoeuds() throws RemoteException {
	return noeuds;
    }

    public boolean addNoeud(Noeud noeud) throws RemoteException {
	return noeuds.add(noeud);
    }

    public boolean removeNoeud(Noeud noeud) throws RemoteException {
	return noeuds.remove(noeud);
    }
}
