package pobj.motx.csp.test;

import org.junit.Test;

import pobj.csp.CSPSolver;
import pobj.csp.ICSP;
import pobj.motx.csp.GrilleContrainte;
import pobj.motx.csp.MotX;
import pobj.motx.grille.Grille;
import pobj.motx.grille.GrilleLoader;
import pobj.motx.grille.GrillePlaces;
import pobj.motx.mots.Dictionnaire;
import pobj.motx.test.TestWithDataDir;

public class GrilleSolverTest extends TestWithDataDir {

	@Test
	public void testHard() {
		Dictionnaire gut = Dictionnaire.loadDictionnaire(path_data_dir+"/frwords.txt");
		Grille gr = GrilleLoader.loadGrille(path_data_dir+"/hard.grl");

		System.out.println(gr);

		GrillePlaces grille = new GrillePlaces(gr);
		GrilleContrainte gp = new GrilleContrainte(grille, gut);
		
		// System.out.println(gp);
		// assertTrue(! gp.isDead());

		ICSP problem = new MotX(gp);
		CSPSolver solver = new CSPSolver();

		// solver.setStrat(new StratFirst());
		// solver.setStrat(new StratMin());
		
		long timestamp = System.currentTimeMillis();
		ICSP solution = solver.solve(problem);

		System.out.println("Solution \n" + solution + " \nCalculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
	}

}
