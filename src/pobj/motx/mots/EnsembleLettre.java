package pobj.motx.mots;

import java.util.List;
import java.util.ArrayList;

public class EnsembleLettre {
	private List<Character> ensLettres;
	
	public EnsembleLettre() {
		this.ensLettres = new ArrayList<Character>();
	}
	
	public void add(Character c) {
		if(!this.ensLettres.contains(c)) {
			this.ensLettres.add(c);
		}
	}
	
	public boolean contains(Character c) {
		return this.ensLettres.contains(c);
	}
	
	public int size() {
		return this.ensLettres.size();
	}
	
	public List<Character> getEnsLettres() {
		return new ArrayList<Character>(this.ensLettres);
	}
	
	public EnsembleLettre intersection(EnsembleLettre autre) {
		EnsembleLettre res = new EnsembleLettre();
		for(Character c: this.ensLettres) {
			if(autre.contains(c)) {
				res.add(c);
			}
		}
		return res;
	}
}
