package pobj.motx.grille;

import java.util.List;
import java.util.ArrayList;

public class GrillePlaces {
	private List<Emplacement> places;
	private Grille grille;

	public GrillePlaces(Grille grille) {
		this.grille = grille;
		this.places = new ArrayList<Emplacement>();
		
		//Chercher l'emplacement de mot horizontal
		for(int i = 0; i < grille.nbLig(); i++) {
			List<Case> ligne = getLig(i);
			cherchePlaces(ligne);
		}
		
		//Chercher l'emplacement de mot vertical
		for(int i = 0; i < grille.nbCol(); i++) {
			List<Case> colonne = getCol(i);
			cherchePlaces(colonne);
		}
	}

	public List<Emplacement> getPlaces() {
		return new ArrayList<Emplacement>(this.places);
	}

	public int getNbHorizontal() {
		int nbHorizontal = 0;
		for(Emplacement e: this.places) {
			if(e.getType() == EmplacementType.HOR) {
				nbHorizontal++;
			}
		}
		return nbHorizontal;
	}

	private List<Case> getLig(int lig) {
		List<Case> ligne = new ArrayList<Case>();
		for(int col = 0; col < this.grille.nbCol(); col++) {
			ligne.add(this.grille.getCase(lig, col));
		}
		return ligne;
	}

	private List<Case> getCol(int col) {
		List<Case> colonne = new ArrayList<Case>();
		for (int lig = 0; lig < this.grille.nbLig(); lig++) {
			colonne.add(this.grille.getCase(lig, col));
		}
		return colonne;
	}
	
	public Grille getGrille() {
		return this.grille;
	}
	
	private void cherchePlaces(List<Case> cases) {
		Emplacement currentPlace = new Emplacement();
		
		for(Case c: cases) {
			if(!c.isPleine()) {
				currentPlace.add(c);
			} else { //Si c'est la case pleine
				if(currentPlace.size() >= 2) {
					this.places.add(currentPlace);
				}
				currentPlace = new Emplacement();
			}
		}
		
		if(currentPlace.size() >= 2) {
			this.places.add(currentPlace);
		}
	}
	
	//Partie 2 Question 7
	public GrillePlaces fixer(int m, String soluce) {
		Grille newG = this.grille.copy();
		Emplacement e = this.places.get(m);
		for(int i=0; i < soluce.length(); i++) {
			Case c = e.getCase(i);
			newG.getCase(c.getLig(), c.getCol()).setChar(soluce.charAt(i));
		}
		return new GrillePlaces(newG);
	}
}
