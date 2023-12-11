package iut.info1.sae.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import iut.info1.sae.pile.err.PileVideException;
import iut.info1.sae.pile.Pile;

/**
 * classe de test de Pile
 * @author rafael.roma
 * @author antonin.veyre
 */
class TestPile {
        
    private Pile[] piles;

    @BeforeEach
    void setUp() {
        Pile[] piles = new Pile[3];
        
        piles[0] = new Pile();
        piles[0].empiler(Integer.valueOf(-3));
    }

	@Test
	void testPile() {
	    assertTrue(new Pile().estVide());
	}

	@Test
	void testEstVide() {
	    assertFalse(new Pile().empiler(Integer.valueOf(-3)).estVide());
	}

	@Test
	void testEmpiler() {
	    assertEquals(new Pile().empiler(Integer.valueOf(-3)).sommet(), -3);
	}

	@Test
	void testSommet() {
        assertThrows(PileVideException.class, ()-> new Pile().sommet());
        assertEquals(new Pile().empiler(Integer.valueOf(-3)).sommet(), -3);
        assertThrows(PileVideException.class, ()-> new Pile().empiler(Integer.valueOf(-3)).depiler().sommet() );
	}

	@Test
	void testDepiler() {
	    assertThrows(PileVideException.class, ()-> new Pile().depiler());
	    assertEquals(new Pile().empiler(Integer.valueOf(2)).empiler(Integer.valueOf(4)).depiler().sommet(), 2);
	}

}