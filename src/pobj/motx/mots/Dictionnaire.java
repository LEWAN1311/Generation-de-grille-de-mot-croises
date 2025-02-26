package pobj.motx.mots;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Dictionnaire {
	private List<String> mots;
	
	public Dictionnaire() {
		this.mots = new ArrayList<String>();
	}
	
	public void add(String mot) {
		this.mots.add(mot.toLowerCase());
	}
	
	public int size() {
		return this.mots.size();
	}
	
	public String get(int i) {
		return this.mots.get(i);
	}
	
	public Dictionnaire copy() {
		Dictionnaire cloneDico = new Dictionnaire();
		for(String mot: this.mots) {
			cloneDico.add(mot);
		}
		return cloneDico;
	}
	
	public int filtreLongueur(int len) {
		int nbMotSupprime = 0;
		List<String> filtre = new ArrayList<String>();
		for(String mot: this.mots) {
			if(mot.length() == len) {
				filtre.add(mot);
			}
			else {
				nbMotSupprime++;
			}
		}
		this.mots = filtre;
		return nbMotSupprime;
	}
	
	public int filtreParLettre(char c, int i) {
		int nbMotSupprime = 0;
		List<String> filtre = new ArrayList<String>();
		for(String mot: this.mots) {
			if(mot.charAt(i) == c) {
				filtre.add(mot);
			}
			else {
				nbMotSupprime++;
			}
		}
		this.mots = filtre;
		return nbMotSupprime;
	}
	
	// Partie 3 Question 2
	public EnsembleLettre lettresPossibles(int index) {
		EnsembleLettre ensLettres = new EnsembleLettre();
		
		for(String mot: this.mots) {
			if(index < mot.length()) {
				char lettre = mot.charAt(index);
				ensLettres.add(lettre);
			}
		}
		return ensLettres;
	}
	
	public int filtreParEnsembleLettre(EnsembleLettre l, int index) {
		int nbMotSupprime = 0;
		List<String> filtre = new ArrayList<String>();
		
		for(String mot: this.mots) {
			if(index < mot.length() && l.contains(mot.charAt(index))) {
				filtre.add(mot);
			} else {
				nbMotSupprime++;
			}
		}
		this.mots = filtre;
		return nbMotSupprime;
	}
	
	//Lecture fichier
	public static Dictionnaire loadDictionnaire(String path) {
		Dictionnaire dico = new Dictionnaire();
		// Try-with-resource : cette syntaxe permet d’accéder au contenu du fichier ligne par ligne.
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			for(String line = br.readLine(); line != null; line = br.readLine()) {
				dico.add(line);
			}
		} catch (IOException e){
			// Problème d’accès au fichier.
			e.printStackTrace();
		}
		return dico;
	}	
}
