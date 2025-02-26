package pobj.motx.grille;

import java.util.List;
import java.util.ArrayList;

public class Emplacement {
	private List<Case> lettres;
	private EmplacementType type;
	
	public Emplacement() {
		this.lettres = new ArrayList<Case>();
		this.type = EmplacementType.VID;
	}
	
	public int size() {
		return this.lettres.size();
	}
	
	public Case getCase(int i) {
		return this.lettres.get(i);
	}
	
	public void add(Case newCase) {
		//Si l'emplacement n'est pas vide, on prend la case précédente, sinon, il n'existe pas la case précédent
		Case prev = (this.type != EmplacementType.VID) ? this.lettres.get(this.lettres.size()-1) : null;
		this.lettres.add(newCase);
		//Après avoir ajouté un lettre dans la liste d'emplacement, on va affecter la case currente est la dernière case 
		Case cur = newCase;
		
		switch (this.type) {
			case VID:
				this.type = EmplacementType.UNE;
				break;
			case UNE:
				// Si la nouvelle case(case currente) est sur la même ligne et sur la colonne suivante par rapport à la case précédente
				if((cur.getLig() == prev.getLig()) && (cur.getCol() > prev.getCol())) {
					this.type = EmplacementType.HOR;
				}
				// Si la nouvelle case(case currente) est sur la même colonne et sur la ligne suivante par rapport à la case précédente
				else if((cur.getLig() > prev.getLig()) && (cur.getCol() == prev.getCol())) {
					this.type = EmplacementType.VER;
				}
				// L'inconhérente
				else {
					this.type = EmplacementType.INC;
				}
				break;
			case HOR:
				if (cur.getLig() != prev.getLig() || cur.getCol() <= prev.getCol()) {
	                this.type = EmplacementType.INC;
	            }
	            break;
			case VER:
				if (cur.getLig() <= prev.getLig() || cur.getCol() != prev.getCol()) {
	                this.type = EmplacementType.INC;
	            }
	            break;
			case INC:
				break;	
		}
	}
	
	public EmplacementType getType() {
		return this.type;
	}
		
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Case mot: lettres) {
			sb.append(mot.getChar());
		}
		return sb.toString();
	}
	
	// Partie 3 Question 12
	public boolean hasCaseVide() {
		for(Case c: this.lettres) {
			if(c.isVide()) {
				return true;
			}
		}
		return false;
	}
}
