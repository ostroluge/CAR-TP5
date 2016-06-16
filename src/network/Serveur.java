package network;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domain.Repertoire;
import service.Noeud;
import service.impl.NoeudImpl;

public class Serveur {

    public static void main(String[] args) throws Exception {

	Repertoire rep = new Repertoire();
	NoeudImpl noeud = new NoeudImpl(rep);
	
	System.out.println("T'ES LE CHEF OU PAS ???!!!");
	Scanner sc = new Scanner(System.in);
	
	String str = sc.nextLine();
	
	if(str.equals("oui")){
	    Naming.rebind("Node", noeud);
	}else{
	    Noeud noeudDistant = (Noeud) Naming.lookup("//localhost/Node");
		List<Noeud> nodes = new ArrayList<>();

		nodes.clear();

		nodes = noeudDistant.getLesNoeuds();
		for (Noeud noeud1 : nodes) {
		    System.out.println(noeud1);
		}
	}


	
    }
}
