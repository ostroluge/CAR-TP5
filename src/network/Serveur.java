package network;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;

import service.Noeud;

public class Serveur {

    public static void main(String[] args) throws Exception {

	Noeud noeudDistant = (Noeud) Naming.lookup("//localhost/Node");

	List<Noeud> nodes = new ArrayList<>();

	nodes.clear();

	nodes = noeudDistant.getLesNoeuds();

	for (Noeud noeud : nodes) {
	    System.out.println(noeud);
	}
    }
}
