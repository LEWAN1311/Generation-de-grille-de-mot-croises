package pobj.motx.csp.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pobj.motx.csp.CroixContrainte;
import pobj.motx.grille.Grille;
import pobj.motx.grille.GrilleLoader;
import pobj.motx.grille.GrillePlaces;
import pobj.motx.grille.GrillePotentiel;
import pobj.motx.mots.Dictionnaire;
import pobj.motx.test.TestWithDataDir;

public class CroixContrainteTest extends TestWithDataDir {

	@Test
	public void test1() {
		Dictionnaire gut = Dictionnaire.loadDictionnaire(path_data_dir+"/frwords.txt");
		Grille gr = GrilleLoader.loadGrille(path_data_dir+"/easy2.grl");

		System.out.println(gr);

		GrillePlaces grille = new GrillePlaces(gr);
		GrillePotentiel gp = new GrillePotentiel(grille, gut);
		
		CroixContrainte c1 = new CroixContrainte(0,3,2,0);
		assertEquals(242, c1.reduce(gp));

		CroixContrainte c2 = new CroixContrainte(1,3,2,4);
		assertEquals(236, c2.reduce(gp));
	}

	@Test
	public void test2() {
		Dictionnaire gut = Dictionnaire.loadDictionnaire(path_data_dir+"/frwords.txt");
		Grille gr = GrilleLoader.loadGrille(path_data_dir+"/hard.grl");

		System.out.println(gr);

		GrillePlaces grille = new GrillePlaces(gr);
		GrillePotentiel gp = new GrillePotentiel(grille, gut);
		
		CroixContrainte c = new CroixContrainte(0,0,5,0);
		assertEquals(0, c.reduce(gp));
	}

}
