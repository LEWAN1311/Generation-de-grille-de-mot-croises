package pobj.motx.grille.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import pobj.motx.grille.Emplacement;
import pobj.motx.grille.EmplacementType;
import pobj.motx.grille.Grille;
import pobj.motx.grille.GrilleLoader;
import pobj.motx.grille.GrillePlaces;
import pobj.motx.test.TestWithDataDir;

public class GrillePlacesTest extends TestWithDataDir {
	
	@Test
	public void testGrilleEasy() {
		// 3 mots
		Grille gr = GrilleLoader.loadGrille(path_data_dir+"/easy.grl");
				
		GrillePlaces grille = new GrillePlaces(gr);

		assertSame(gr,grille.getGrille());
		
		assertEquals(2, grille.getNbHorizontal());
		assertEquals(3, grille.getPlaces().size());

		int[] expected = { 5, 5, 5 };
		assertEquals(expected.length, grille.getPlaces().size());

		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], grille.getPlaces().get(i).size());
		}
	}

	@Test
	public void testGrilleEnonce() {
		Grille gr = GrilleLoader.loadGrille(path_data_dir+"/enonce.grl");

		GrillePlaces grille = new GrillePlaces(gr);
		
		assertSame(gr,grille.getGrille());

		assertEquals(7, grille.getNbHorizontal());
		assertEquals(12, grille.getPlaces().size());

		int[] expected = { 9, 5, 14, 8, 5, 9, 10, 10, 10, 6, 4, 8 };
		assertEquals(expected.length, grille.getPlaces().size());

		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], grille.getPlaces().get(i).size());
		}
	}

	@Test
	public void testGrilleEasy2() {
		// avec des lettres placees
		Grille gr = GrilleLoader.loadGrille(path_data_dir+"/easy2.grl");


		GrillePlaces grille = new GrillePlaces(gr);
		
		assertSame(gr,grille.getGrille());

		assertEquals(2, grille.getNbHorizontal());
		assertEquals(3, grille.getPlaces().size());
	}

	@Test
	public void testGrilleSplit() {
		// grille 6x5, mots sans croisement
		Grille gr = GrilleLoader.loadGrille(path_data_dir+"/split.grl");

		assertEquals(5, gr.nbCol());
		assertEquals(6, gr.nbLig());


		GrillePlaces grille = new GrillePlaces(gr);
		assertSame(gr,grille.getGrille());

		assertEquals(4, grille.getNbHorizontal());
		assertEquals(4, grille.getPlaces().size());
	}

	@Test
	public void testGrilleMedium() {
		Grille gr = GrilleLoader.loadGrille(path_data_dir+"/medium.grl");


		GrillePlaces grille = new GrillePlaces(gr);
		
		assertSame(gr,grille.getGrille());

		assertEquals(3, grille.getNbHorizontal());
		assertEquals(6, grille.getPlaces().size());
	}

	@Test
	public void testGrilleHard() {
		Grille gr = GrilleLoader.loadGrille(path_data_dir+"/hard.grl");

		assertEquals(5, gr.nbCol());
		assertEquals(5, gr.nbLig());


		GrillePlaces grille = new GrillePlaces(gr);
		assertSame(gr,grille.getGrille());

		assertEquals(5, grille.getNbHorizontal());
		assertEquals(10, grille.getPlaces().size());
	}

	@Test
	public void testGrilleLarge() {
		Grille gr = GrilleLoader.loadGrille(path_data_dir+"/large.grl");

		assertEquals(20, gr.nbCol());
		assertEquals(20, gr.nbLig());


		GrillePlaces grille = new GrillePlaces(gr);
		assertSame(gr,grille.getGrille());

		assertEquals(63, grille.getNbHorizontal());
		assertEquals(124, grille.getPlaces().size());

		int[] expected = { 6, 5, 6, 5, 4, 2, 5, 9, 7, 2, 5, 8, 4, 2, 5, 3, 2, 6, 3, 7, 2, 7, 5, 3, 4, 3, 4, 6, 5, 2, 3,
				3, 6, 7, 3, 7, 3, 3, 6, 2, 6, 10, 5, 2, 2, 8, 3, 6, 3, 3, 6, 13, 2, 4, 2, 5, 3, 7, 2, 2, 7, 9, 9, 6, 4,
				4, 3, 4, 9, 3, 4, 6, 4, 6, 6, 9, 2, 2, 2, 8, 2, 2, 2, 6, 2, 4, 6, 5, 2, 7, 6, 3, 2, 11, 4, 3, 5, 5, 3,
				4, 3, 6, 6, 2, 2, 11, 6, 6, 3, 3, 9, 3, 2, 8, 5, 2, 7, 4, 2, 7, 12, 3, 3, 5 };

		assertEquals(expected.length, grille.getPlaces().size());

		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], grille.getPlaces().get(i).size());
		}
	}

	@Test
	public void testGrilleLarge2() {
		Grille gr = GrilleLoader.loadGrille(path_data_dir+"/large2.grl");

		GrillePlaces grille = new GrillePlaces(gr);
		assertSame(gr,grille.getGrille());

		assertEquals(63, grille.getNbHorizontal());
		assertEquals(124, grille.getPlaces().size());

		int[] expected = { 6, 5, 6, 5, 4, 2, 5, 9, 7, 2, 5, 8, 4, 2, 5, 3, 2, 6, 3, 7, 2, 7, 5, 3, 4, 3, 4, 6, 5, 2, 3,
				3, 6, 7, 3, 7, 3, 3, 6, 2, 6, 10, 5, 2, 2, 8, 3, 6, 3, 3, 6, 13, 2, 4, 2, 5, 3, 7, 2, 2, 7, 9, 9, 6, 4,
				4, 3, 4, 9, 3, 4, 6, 4, 6, 6, 9, 2, 2, 2, 8, 2, 2, 2, 6, 2, 4, 6, 5, 2, 7, 6, 3, 2, 11, 4, 3, 5, 5, 3,
				4, 3, 6, 6, 2, 2, 11, 6, 6, 3, 3, 9, 3, 2, 8, 5, 2, 7, 4, 2, 7, 12, 3, 3, 5 };

		assertEquals(expected.length, grille.getPlaces().size());

		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], grille.getPlaces().get(i).size());
		}
	}
	
	
	@Test
	public void testGetPlaces() {
		Grille gr = GrilleLoader.loadGrille(path_data_dir+"/large2.grl");
		
		GrillePlaces grille = new GrillePlaces(gr);
		assertSame(gr,grille.getGrille());

		int nb_horizontal = 63;
		assertEquals(nb_horizontal, grille.getNbHorizontal());
		
		List<Emplacement> places = grille.getPlaces();
		List<Emplacement> places_cpy = new ArrayList<>(places);
		try {
			places.clear();
		}catch (Exception e) {}
		assertNotSame(places, grille.getPlaces());
		assertEquals(places_cpy, grille.getPlaces());
		
		for(int i=0;i<places.size();i++) {
			Emplacement cur = places.get(0);
			if(i<nb_horizontal) {
				assertEquals(EmplacementType.HOR,cur.getType());
			}else {
				assertEquals(EmplacementType.VER,cur.getType());
			}
			
		}
		
		
	}
}
