package pobj.motx.grille;

import java.util.List;
import java.util.ArrayList;

import pobj.motx.mots.Dictionnaire;

public class GrillePotentiel {
	protected GrillePlaces grille;
	protected Dictionnaire dicoComplet;
	private List<Dictionnaire> motsPot;
	
	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet) {
		this.grille = grille;
		this.dicoComplet = dicoComplet;
		this.motsPot = new ArrayList<Dictionnaire>();
		
		for(Emplacement e: this.grille.getPlaces()) {
			Dictionnaire filtreDico = this.dicoComplet.copy();
			filtreDico.filtreLongueur(e.size());
			for(int i=0; i<e.size(); i++) {
				Case c = e.getCase(i);
				//Si la case contient une lettre
				if(!c.isVide()) {
					filtreDico.filtreParLettre(c.getChar(), i);
				}
			}
			this.motsPot.add(filtreDico);// Ajout du dictionnaire filtré
		}
		
	}
	
	public List<Dictionnaire> getMotsPot() {
		return new ArrayList<Dictionnaire>(this.motsPot);
	}
	
	public GrillePlaces getGrillePlaces() {
		return this.grille;
	}
	
	public boolean isDead() {
		for(Dictionnaire dico: this.motsPot) {
			if (dico.size() == 0) {
				return true;
			}
		}
		return false;
	}
	
	public GrillePotentiel fixer(int m, String soluce) {
		return new GrillePotentiel(this.grille.fixer(m, soluce),this.dicoComplet);
	}
}
