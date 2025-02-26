package pobj.motx.csp;

import java.util.List;
import java.util.ArrayList;

import pobj.csp.ICSP;
import pobj.csp.IVariable;
import pobj.motx.grille.Emplacement;

public class MotX implements ICSP {
	private List<DicoVariable> listeDicoVar;
	private GrilleContrainte gc;
	
	public MotX(GrilleContrainte gc) {
		this.gc = gc;
		this.listeDicoVar = new ArrayList<DicoVariable>();
		
		List<Emplacement> listeE = gc.getGrillePlaces().getPlaces();
		for(int i=0; i<listeE.size(); i++) {
			if(listeE.get(i).hasCaseVide()) {
				this.listeDicoVar.add(new DicoVariable(i,gc));
			}
		}
	}
	
	@Override 
	public List<IVariable> getVars() {
		
		List<IVariable> vars = new ArrayList<IVariable>();
		for(IVariable var: this.listeDicoVar) {
			vars.add(var);
		}
		return vars;
	}
	
	@Override
	public boolean isConsistent() {
		for(DicoVariable dicoVar: this.listeDicoVar) {
			if(dicoVar.getDomain().isEmpty()) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public ICSP assign(IVariable vi, String val) {
		if(vi instanceof DicoVariable) {
			DicoVariable dicoVi = (DicoVariable)vi;
			return new MotX(dicoVi.getGrilleContrainte().fixer(dicoVi.getIndex(), val));
		}
		return null;
	}
	
	public String toString() {
		return this.gc.toString();
	}
}
