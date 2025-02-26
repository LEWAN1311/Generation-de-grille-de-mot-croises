package pobj.motx.csp;

import pobj.csp.IContrainte;
import pobj.motx.grille.Emplacement;
import pobj.motx.grille.GrillePlaces;
import pobj.motx.grille.GrillePotentiel;
import pobj.motx.mots.Dictionnaire;

import java.util.List;
import java.util.ArrayList;

public class GrilleContrainte extends GrillePotentiel{
	private List<IContrainte> contraintes;
	
	public GrilleContrainte(GrillePlaces grille, Dictionnaire dicoComplet) {
		super(grille,dicoComplet);
		this.contraintes = new ArrayList<IContrainte>();
		
		//Parcours des emplacements horizontaux
		for(int iMotHor=0; iMotHor<grille.getNbHorizontal(); iMotHor++) {
			Emplacement eHor = grille.getPlaces().get(iMotHor); //Emplacement horizontal
			int ligHor = eHor.getCase(0).getLig(); //Ligne d'emplacement hozizontal
			int colHor = eHor.getCase(0).getCol(); //Colonne de la 1ere case de l'emplacement hozizontal
			
			//Parcours des emplacements verticaux
			for(int iMotVer=grille.getNbHorizontal(); iMotVer<grille.getPlaces().size(); iMotVer++) {
				Emplacement eVer = grille.getPlaces().get(iMotVer);
				int ligVer = eVer.getCase(0).getLig();//Colonne d'emplacement vertical
				int colVer = eVer.getCase(0).getCol();// Ligne de la 1ere case de l'emplacement vertical
				
				/* Si la colonne de la 1ere case de l'emplacement horizontal n'est pas sur la colonne après l'emplacement vertical
				 * La colonne de l'emplacement vertical est toujours < le somme de la colonne de la 1ere case d'emplacement horizontal et la taille de l'emplacement horizontal
				 * Si la ligne de la 1ere case de l'emplacement vertical est toujours <= la ligne de l'emplacement horizontal 
				 * ...*/
				if(!(colHor > colVer) && ((colHor + eHor.size()) > colVer) && (ligVer <= ligHor) && ((ligVer + eVer.size()) > ligHor)) {
					int c1 = colVer - colHor; //Indice de la case croisement de l'emplacement horizontal
					int c2 = ligHor - ligVer; //Indice de la case croisement de l'emplacement vertical
					
					if(eHor.getCase(c1).isVide() && eVer.getCase(c2).isVide()) {
						contraintes.add(new CroixContrainte(iMotHor,c1,iMotVer,c2));// Ajout de la contrainte si la case est vide
					}
				}
			}
		}
		
		this.propage();
	}
	
	private boolean propage() {
		int nbMotElimine = -1;
		while(!(this.isDead()) && nbMotElimine != 0) {
			nbMotElimine = 0;
			for(IContrainte c : this.contraintes) {
				nbMotElimine += c.reduce(this);
			}
		}
		
		return !(this.isDead());
	}
	
	public List<IContrainte> getContraintes(){
		return new ArrayList<IContrainte>(this.contraintes);
	}
	
	public GrilleContrainte fixer(int m, String soluce) {
		return new GrilleContrainte(this.grille.fixer(m, soluce), this.dicoComplet);
	}
}
