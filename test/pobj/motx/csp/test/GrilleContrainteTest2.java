package pobj.motx.csp.test;

import static org.junit.Assert.*;
import static pobj.motx.grille.test.GrillePotentielTest.testNombrePot;

import org.junit.Test;

import pobj.motx.csp.GrilleContrainte;
import pobj.motx.grille.Grille;
import pobj.motx.grille.GrilleLoader;
import pobj.motx.grille.GrillePlaces;
import pobj.motx.mots.Dictionnaire;
import pobj.motx.test.TestWithDataDir;

public class GrilleContrainteTest2 extends TestWithDataDir{

	@Test
	public void testMedium() {

		Dictionnaire gut = Dictionnaire.loadDictionnaire(path_data_dir+"/frwords.txt");
		Grille gr = GrilleLoader.loadGrille(path_data_dir+"/medium.grl");

		assertEquals(5, gr.nbCol());
		assertEquals(5, gr.nbLig());

		// System.out.println(gr);

		GrillePlaces grille = new GrillePlaces(gr);

		GrilleContrainte gp = new GrilleContrainte(grille, gut);

		assertTrue(!gp.isDead());

		assertEquals(9, gp.getContraintes().size());

		int[] expected = { 5916, 5916, 5320, 5916, 5916, 5320 };

		testNombrePot(gp, expected);


	}

	@Test
	public void testEasy() {

		Dictionnaire gut = Dictionnaire.loadDictionnaire(path_data_dir+"/frwords.txt");
		Grille gr = GrilleLoader.loadGrille(path_data_dir+"/easy.grl");

		assertEquals(5, gr.nbCol());
		assertEquals(5, gr.nbLig());

		// System.out.println(gr);

		GrillePlaces grille = new GrillePlaces(gr);

		GrilleContrainte gp = new GrilleContrainte(grille, gut);

		assertTrue(!gp.isDead());

		assertEquals(2, gp.getContraintes().size());

		int[] expected = { 5916, 5688 , 5916};

		testNombrePot(gp, expected);


	}
	
	@Test
	public void testHard() {

		Dictionnaire gut = Dictionnaire.loadDictionnaire(path_data_dir+"/frwords.txt");
		Grille gr = GrilleLoader.loadGrille(path_data_dir+"/hard.grl");

		assertEquals(5, gr.nbCol());
		assertEquals(5, gr.nbLig());

		// System.out.println(gr);

		GrillePlaces grille = new GrillePlaces(gr);

		GrilleContrainte gp = new GrilleContrainte(grille, gut);

		assertTrue(!gp.isDead());

		assertEquals(25, gp.getContraintes().size());

		int[] expected = { 5916, 5916, 5916, 5916, 5185, 5916, 5916, 5916, 5916, 5185 };

		testNombrePot(gp, expected);

	}

}
