package pobj.motx.grille.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

import pobj.motx.grille.Case;
import pobj.motx.grille.Grille;
import pobj.motx.grille.GrilleLoader;
import pobj.motx.test.TestWithDataDir;

public class GrilleTest extends TestWithDataDir {

	@Test
	public void testGrille() {

		Grille gr = GrilleLoader.loadGrille(path_data_dir+"/easy.grl");

		assertEquals(5, gr.nbCol());
		assertEquals(5, gr.nbLig());
		
		gr = GrilleLoader.loadGrille(path_data_dir+"/hard.grl");

		assertEquals(5, gr.nbCol());
		assertEquals(5, gr.nbLig());

		gr = GrilleLoader.loadGrille(path_data_dir+"/enonce.grl");

		assertEquals(16, gr.nbCol());
		assertEquals(12, gr.nbLig());

		gr = GrilleLoader.loadGrille(path_data_dir+"/large2.grl");

		assertEquals(20, gr.nbCol());
		assertEquals(20, gr.nbLig());
		
		gr = GrilleLoader.loadGrille(path_data_dir+"/larger.grl");

		assertEquals(40, gr.nbCol());
		assertEquals(40, gr.nbLig());


	}

	@Test
	public void testGetCase() {
		Grille gr = GrilleLoader.loadGrille(path_data_dir+"/large2.grl");

		assertEquals(20, gr.nbCol());
		assertEquals(20, gr.nbLig());

		testContenu(gr, 0, 0, ' ');
		testContenu(gr, 10, 0, ' ');
		testContenu(gr, 0, 14, 'a');
		testContenu(gr, 19, 19, '*');
		testContenu(gr, 5, 7, ' ');
		testContenu(gr, 7, 5, ' ');
		testContenu(gr, 12, 17, '*');
		testContenu(gr, 17, 12, 'm');
		testContenu(gr, 8, 19, 'e');
		testContenu(gr, 19, 8, 's');

	}

	private void testContenu(Grille gr, int i, int j, char ch) {
		Case c = gr.getCase(i, j);
		assertEquals(ch + "", c.getChar() + "");
		assertEquals(i, c.getLig());
		assertEquals(j, c.getCol());
	}

	@Test
	public void testCopy() {
		Grille gr = GrilleLoader.loadGrille(path_data_dir+"/large2.grl");

		assertEquals(20, gr.nbCol());
		assertEquals(20, gr.nbLig());

		Grille gr2 = gr.copy();

		assertEquals(20, gr2.nbCol());
		assertEquals(20, gr2.nbLig());

		for (int l = 0; l < gr2.nbLig(); l++) {
			for (int c = 0; c < gr.nbCol(); c++) {
				assertNotSame(gr.getCase(l, c), gr2.getCase(l, c));
			}
		}

		testContenu(gr2, 0, 0, ' ');
		testContenu(gr2, 10, 0, ' ');
		testContenu(gr2, 0, 14, 'a');
		testContenu(gr2, 19, 19, '*');
		testContenu(gr2, 5, 7, ' ');
		testContenu(gr2, 7, 5, ' ');
		testContenu(gr2, 12, 17, '*');
		testContenu(gr2, 17, 12, 'm');
		testContenu(gr2, 8, 19, 'e');
		testContenu(gr2, 19, 8, 's');

	}

	@Test
	public void testIO() {

		String f1 = path_data_dir+"/large2.grl";
		String f2 = path_data_dir+"/reverse.grl";

		try {
			Grille gr = GrilleLoader.loadGrille(f1);

			// System.out.println(gr);

			Files.deleteIfExists(Paths.get(f2));
			GrilleLoader.saveGrille(gr, f2);

			byte[] fc1 = Files.readAllBytes(Paths.get(f1));
			byte[] fc2 = Files.readAllBytes(Paths.get(f2));
			// Le contenu des deux fichiers est censé être identique.
			assertArrayEquals(fc1, fc2);
		} catch (IOException e) {
			fail("IO error");
		}
	}

}
