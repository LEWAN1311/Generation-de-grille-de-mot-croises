package pobj.motx.grille.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pobj.motx.grille.Case;

public class CaseTest {

	@Test
	public void testIsPleine() {
		Case cv = new Case(0, 1, ' ');
		Case cp = new Case(1, 0, '*');
		Case cc = new Case(7, 5, 'z');
		assertFalse(cv.isPleine());
		assertTrue(cp.isPleine());
		assertFalse(cc.isPleine());
	}

	@Test
	public void testIsVide() {
		Case cv = new Case(0, 1, ' ');
		Case cp = new Case(1, 0, '*');
		Case cc = new Case(7, 5, 'z');
		assertTrue(cv.isVide());
		assertFalse(cp.isVide());
		assertFalse(cc.isVide());
	}

	@Test
	public void testGetChar() {
		Case cv = new Case(0, 1, ' ');
		Case cp = new Case(1, 0, '*');
		Case cc = new Case(7, 5, 'z');
		assertEquals(' ', cv.getChar());
		assertEquals('*', cp.getChar());
		assertEquals('z', cc.getChar());
	}

	@Test
	public void testGetLig() {
		Case cv = new Case(0, 1, ' ');
		Case cp = new Case(1, 0, '*');
		Case cc = new Case(7, 5, 'z');
		assertEquals(0, cv.getLig());
		assertEquals(1, cp.getLig());
		assertEquals(7, cc.getLig());
	}

	@Test
	public void testGetCol() {
		Case cv = new Case(0, 1, ' ');
		Case cp = new Case(1, 0, '*');
		Case cc = new Case(7, 5, 'z');
		assertEquals(1, cv.getCol());
		assertEquals(0, cp.getCol());
		assertEquals(5, cc.getCol());
	}

	@Test
	public void testSetChar() {
		Case cv = new Case(0, 1, ' ');
		Case cp = new Case(1, 0, '*');
		Case cc = new Case(7, 5, 'z');
		assertEquals(' ', cv.getChar());
		assertEquals('*', cp.getChar());
		assertEquals('z', cc.getChar());
		cv.setChar('a');
		cp.setChar(' ');
		cc.setChar('*');
		assertEquals('a', cv.getChar());
		assertEquals(' ', cp.getChar());
		assertEquals('*', cc.getChar());
	}

}
