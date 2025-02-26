package pobj.motx.grille.test;

import static org.junit.Assert.*;

import org.junit.Test;

import pobj.motx.grille.Case;
import pobj.motx.grille.Emplacement;
import static pobj.motx.grille.EmplacementType.*;
public class EmplacementTest {

	@Test
	public void testEmpty() {
		Emplacement e = new Emplacement();
		assertEquals(0, e.size());
	}

	@Test
	public void testAdd() {
		Emplacement e = new Emplacement();
		e.add(new Case(0, 1, '*'));
		assertEquals(1, e.size());
		e.add(new Case(1, 2, '@'));
		assertEquals(2, e.size());
	}

	@Test
	public void testGet() {
		Emplacement e = new Emplacement();
		Case c1 = new Case(0, 1, '*');
		Case c2 = new Case(1, 2, '@');
		e.add(c1);
		e.add(c2);
		assertSame(c1, e.getCase(0));
		assertSame(c2, e.getCase(1));
	}
	
	@Test
	public void testToString() {
		Emplacement e = new Emplacement();
		Case c1 = new Case(0, 1, 'b');
		Case c2 = new Case(0, 2, 'o');
		Case c3 = new Case(0, 2, 'n');
		e.add(c1);
		e.add(c2);
		e.add(c3);
		assertEquals(3,e.size());
		assertEquals("bon",e.toString());
	}
	
	@Test
	public void testGetType1() {
		Emplacement e = new Emplacement();
		assertEquals(VID, e.getType());
		
		e.add(new Case(5,5,' '));
		assertEquals(UNE, e.getType());
		e.add(new Case(5,6,' '));
		assertEquals(HOR, e.getType());
		e.add(new Case(5,7,' '));
		assertEquals(HOR, e.getType());	
		e.add(new Case(5,7,' '));
		assertEquals(INC, e.getType());	
		
	}
	
	@Test
	public void testGetType2() {
		Emplacement e = new Emplacement();
		assertEquals(VID, e.getType());
		
		e.add(new Case(5,5,' '));
		assertEquals(UNE, e.getType());
		
		e.add(new Case(6,5,' '));
		assertEquals(VER, e.getType());
	
		e.add(new Case(7,5,' '));
		assertEquals(VER, e.getType());
		
		e.add(new Case(6,5,' '));
		assertEquals(INC, e.getType());
		
	}
	@Test
	public void testGetType3() {
		Emplacement e = new Emplacement();
		assertEquals(VID, e.getType());
		
		e.add(new Case(5,5,' '));
		assertEquals(UNE, e.getType());
		
		e.add(new Case(7,7,' '));
		assertEquals(INC, e.getType());
	
		e.add(new Case(7,8,' '));
		assertEquals(INC, e.getType());
		
	}
}
