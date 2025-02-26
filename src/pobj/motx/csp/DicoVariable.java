package pobj.motx.csp;

import java.util.ArrayList;
import java.util.List;

import pobj.csp.IVariable;
import pobj.motx.mots.Dictionnaire;

public class DicoVariable implements IVariable{
	private int index;
	private GrilleContrainte gp;
	
	public DicoVariable(int index, GrilleContrainte gp) {
		this.index = index;
		this.gp = gp;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public GrilleContrainte getGrilleContrainte() {
		return this.gp;
	}
	
	@Override
	public List<String> getDomain() {
		List<String> listeDomain = new ArrayList<String>();
		Dictionnaire dico = this.gp.getMotsPot().get(index);
		for(int i=0; i<dico.size(); i++) {
			listeDomain.add(dico.get(i));
		}
		return listeDomain;
	}
	
	@Override
	public String toString() {
		return "DicoVariable{index= " + this.index + ", GrilleContrainte= " + this.gp + "}\n";
	}
}
