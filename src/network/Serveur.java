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

	if(str.equals("oui")) {
	    Naming.rebind("Node", noeud);
	} else {
	    Noeud noeudDistant = (Noeud) Naming.lookup("//localhost/Node");
	    List<Noeud> nodes = new ArrayList<>();

	    nodes.clear();


	    boolean stop = false;

	    while(!stop){
		System.out.println("1. Ajouter un fichier");
		System.out.println("2. Modifier un fichier");
		System.out.println("3. Supprimer un fichier");
		System.out.println("4. Lister les fichiers");

		Scanner scan = new Scanner(System.in);
		String input = sc.nextLine();
		 
		switch(input) {
		case "1":
		    System.out.println("Veuillez saisir le nom du fichier à ajouter : ");
		    String fileToAdd = sc.nextLine();
		    if (noeud.repertoire.addFichier(fileToAdd)) {
			System.out.println("Le fichier " + fileToAdd + " a été ajouté avec succes");
		    } else {
			System.out.println("Echec de l'ajout du fichier " + fileToAdd);
		    }

		    break;
		case "2":
		    System.out.println("Veuillez saisir le nom du fichier à modifier : ");
		    break;
		case "3":
		    System.out.println("Veuillez saisir le nom du fichier à supprimer : ");
		    break;
		case "4":
		    for (String files : noeud.repertoire.fichiers) {
			System.out.println(files);
		    }
		    break;
		default:
		    stop=true;
		    System.out.println("Commande Inconnue");
		    break;
		}

		nodes = noeudDistant.getLesNoeuds();
		for (Noeud noeud1 : nodes) {
		    System.out.println(noeud1);
		}

	    }
	}
    }
}
