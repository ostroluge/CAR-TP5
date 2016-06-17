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
				System.out.println("5. Quitter le programme");

				Scanner scan = new Scanner(System.in);
				String input = sc.nextLine();

				switch(input) {
				case "1":
					System.out.println("Veuillez saisir le nom du fichier à ajouter : ");
					String fileToAdd = sc.nextLine();
					if (noeud.repertoire.addFichier(fileToAdd)) {
						System.out.println("Le fichier " + fileToAdd + " a été ajouté avec succès");
					} else {
						System.out.println("Echec de l'ajout du fichier " + fileToAdd);
					}

					break;
				case "2":
					System.out.println("Veuillez saisir le nom du fichier à modifier : ");
					String fileToEdit = sc.nextLine();
					boolean fileToEditFound = false;
					for (String filename : noeud.repertoire.fichiers) {
						if (filename.equals(fileToEdit)) {
							fileToEditFound = true;
						}
					}
					if (fileToEditFound) {
						System.out.println("Veuillez saisir le nouveau nom du fichier : ");
						String newName = sc.nextLine();
						noeud.repertoire.fichiers.remove(fileToEdit);
						noeud.repertoire.fichiers.add(newName);
						System.out.println("La modification s'est déroulée avec succès");
					} else {
						System.out.println("Erreur : fichier invalide");
					}
					break;
				case "3":
					System.out.println("Veuillez saisir le nom du fichier à supprimer : ");
					String fileToDelete = sc.nextLine();
					boolean fileToDeleteFound = false;
					for (String filename : noeud.repertoire.fichiers) {
						if (filename.equals(fileToDelete)) {
							fileToDeleteFound = true;
						}
					}
					if (fileToDeleteFound) {
						noeud.repertoire.fichiers.remove(fileToDelete);
						System.out.println("La suppresion s'est déroulée avec succès");
					} else {
						System.out.println("Erreur : fichier invalide");
					}
					break;
				case "4":
					for (String filename : noeud.repertoire.fichiers) {
						System.out.println(filename);
					}
					if (noeud.repertoire.fichiers.isEmpty()) {
						System.out.println("Il n'y a aucun fichier");
					}
					break;
				case "5":
					stop=true;
					System.exit(0);
					break;
				default:
					System.out.println("Commande inconnue");
					break;
				}
			}
		}
	}
}
