package pobj.motx.grille;

public class Grille {
	private Case[][] grille;
	
	public Grille(int hauteur, int largeur) {
		this.grille = new Case[hauteur][largeur];
		for(int i=0; i<hauteur; i++) {
			for(int j=0; j<largeur; j++) {
				this.grille[i][j] = new Case(i,j,' ');
			}
		}
	}
	
	public Case getCase(int lig, int col) {
		return this.grille[lig][col];
	}
	
	public int nbLig() {
		return this.grille.length;
	}
	
	public int nbCol() {
		return this.grille[0].length;
	}
	
	public Grille copy() {
		Grille newG = new Grille(this.nbLig(),this.nbCol());
		for(int i=0; i< this.nbLig(); i++) {
			for(int j=0; j< this.nbCol(); j++) {
				newG.grille[i][j].setChar(this.grille[i][j].getChar());
			}
		}
		return newG;
	}
	
	public String toString() {
		return GrilleLoader.serialize(this, false);
	}
	
}
