package pobj.motx.grille.test;

import static org.junit.Assert.*;

import org.junit.Test;

import pobj.motx.grille.Grille;
import pobj.motx.grille.GrilleLoader;
import pobj.motx.grille.GrillePlaces;
import pobj.motx.grille.GrillePotentiel;
import pobj.motx.mots.Dictionnaire;
import pobj.motx.test.TestWithDataDir;

public class GrillePotentielTest extends TestWithDataDir{

	public static void testNombrePot(GrillePotentiel gp, int[] expected) {
		assertEquals(expected.length, gp.getMotsPot().size());
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], gp.getMotsPot().get(i).size());
		}
	}

	@Test
	public void testSplit() {

		Dictionnaire gut = Dictionnaire.loadDictionnaire(path_data_dir+"/frwords.txt");
		// grille 6x5, mots sans croisement
		Grille gr = GrilleLoader.loadGrille(path_data_dir+"/split.grl");

		assertEquals(5, gr.nbCol());
		assertEquals(6, gr.nbLig());


		GrillePlaces grille = new GrillePlaces(gr);

		GrillePotentiel gp = new GrillePotentiel(grille, gut);

		assertTrue(!gp.isDead());

		int[] expected = { 5916, 427, 81, 81 };

		testNombrePot(gp, expected);
	}

}
