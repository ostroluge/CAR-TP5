package service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import service.Noeud;

public class NoeudImpl extends UnicastRemoteObject implements Noeud {

	public NoeudImpl() throws RemoteException {
		super();
	}

	public String[] lister() throws RemoteException {
		return null;
	}

	public byte[] getContenu(String nomFichier) throws RemoteException {
		return null;
	}

	public List<Noeud> getLesNoeuds() throws RemoteException {
		return null;
	}

	public boolean addNoeud(Noeud noeud) throws RemoteException {
		return false;
	}
}
