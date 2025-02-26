package pobj.motx.grille;

public class Case {
	private int lig;
	private int col;
	private char c;
	
	public Case(int lig, int col, char c) {
		this.lig = lig;
		this.col = col;
		this.c = c;
	}
	
	public int getLig() {
		return this.lig;
	}
	
	public int getCol() {
		return this.col;
	}
	
	public char getChar() {
		return this.c;
	}
	
	public void setChar(char c) {
		this.c = c;
	}
	
	public boolean isVide() {
		return this.c == ' ';
	}
	
	public boolean isPleine() {
		return this.c == '*';
	}
}
