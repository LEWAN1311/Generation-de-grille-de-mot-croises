package pobj.motx.grille;

public enum EmplacementType {
	VID,//emplacement est vide et ne contient aucune case
	UNE,//emplacement contient une seule case
	HOR,//emplacement possède plus d’une case et qu’il est horizontal
	VER,//emplacement plus d’une case et qu’il est vertical
	INC //emplacement plus d’une case et qu’il est incohérent ne satisfaisant ni les contraintes de HOR, ni les contraintes de VER
}
