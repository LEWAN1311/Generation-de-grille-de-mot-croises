package pobj.motx.csp;

import pobj.csp.IContrainte;
import pobj.motx.grille.GrillePotentiel;
import pobj.motx.mots.Dictionnaire;
import pobj.motx.mots.EnsembleLettre;

public class CroixContrainte implements IContrainte{
	private int m1,c1,m2,c2;
	
	public CroixContrainte(int m1, int c1, int m2, int c2) {
		this.m1=m1;
		this.c1=c1;
		this.m2=m2;
		this.c2=c2;
	}
	
	@Override
	public boolean equals(Object other) {
		if(other == this) {
			return true;
		}
		if(other == null) {
			return false;
		}
		if(!(other instanceof CroixContrainte)) {
			return false;
		}
		CroixContrainte cc = (CroixContrainte)other;
		return this.m1 == cc.m1 && this.c1 == cc.c1 && this.m2 == cc.m2 && this.c2 == cc.c2;
	}
	
	@Override
	public int reduce(GrillePotentiel grille) {
		Dictionnaire dicoM1 = grille.getMotsPot().get(m1);
		Dictionnaire dicoM2 = grille.getMotsPot().get(m2);
		
		EnsembleLettre l1 = dicoM1.lettresPossibles(c1);
		EnsembleLettre l2 = dicoM2.lettresPossibles(c2);
		
		EnsembleLettre s = l1.intersection(l2);
		int nbMotsSupprimes = 0;
		if(l1.size() > s.size()) {
			nbMotsSupprimes += dicoM1.filtreParEnsembleLettre(s, c1);
		}
		if(l2.size() > s.size()) {
			nbMotsSupprimes += dicoM2.filtreParEnsembleLettre(s, c2);
		}
		
		return nbMotsSupprimes;
	}
}
