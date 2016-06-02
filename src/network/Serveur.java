package network;

import java.rmi.Naming;

import service.impl.NoeudImpl;

public class Serveur {

public static void main(String[] args) throws Exception {
		
		NoeudImpl obj = new NoeudImpl();
		
		Naming.rebind("Node", obj);
		System.out.println("Le serveur Java RMI est prêt...");
	}
}
