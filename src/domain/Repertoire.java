package domain;

import java.util.ArrayList;
import java.util.List;

public class Repertoire {

	public List<String> fichiers = new ArrayList<>();
	
	public boolean addFichier(String fichier) {
		return fichiers.add(fichier);
	}

	public boolean removeFichier(String fichier) {
		return fichiers.remove(fichier);
	}

	public boolean editFichier(String fichier, String newFichier) {
		return fichiers.remove(fichier) && fichiers.add(newFichier);
	}
}
