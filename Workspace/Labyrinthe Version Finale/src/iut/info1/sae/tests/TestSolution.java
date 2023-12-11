package iut.info1.sae.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import iut.info1.sae.create.CreationAscendante;
import iut.info1.sae.labyrinthe.Labyrinthe;
import iut.info1.sae.solution.Solution;

public class TestSolution {
	
	@Test
	public void testConstructeurLabyrintheNonFini() {
		Labyrinthe labyrintheNonFini = new Labyrinthe(4,4);
		// Le labyrinthe n'est pas fini, une exception IllegalArgumentException doit être levée
		assertThrows(IllegalArgumentException.class, () -> new Solution(labyrintheNonFini));
	}

	@Test
	public void testSolutionMainDroitePointDepartEtArriveIdentiques() {
        Labyrinthe labyrinthe = new CreationAscendante().CreationAscendanteDeChaine(4, 4);
		// Le point de départ et d'arrivée sont identiques, une exception IllegalArgumentException doit être levée
		assertThrows(IllegalArgumentException.class, () -> new Solution(labyrinthe).solutionMainDroite(0, 0, 0, 0));
	}
//
//	@Test
//	public void testSolutionMainDroite() {
//		int xDepart = 0;
//		int yDepart = 0;
//		int xArrive = 4;
//		int yArrive = 4;
//		
//		int[][] resultatAttendu = { {0, 0}, {0, 1}, {1, 1}, {2, 1}, {2, 2}, {2, 3}, {3, 3}, {4, 3}, {4, 4} };
//		
//		int[][] resultatObtenu = solution.solutionMainDroite(xDepart, yDepart, xArrive, yArrive);
//		
//		assertArrayEquals(resultatAttendu, resultatObtenu);
//	}
//	
//	@Test(expected = IllegalArgumentException.class)
//	public void testSolutionProfondeurPointDepartEtArriveIdentiques() {
//		int xDepart = 0;
//		int yDepart = 0;
//		int xArrive = 0;
//		int yArrive = 0;
//		// Le point de départ et d'arrivée sont identiques, une exception IllegalArgumentException doit être levée
//		solution.solutionProfondeur(xDepart, yDepart, xArrive, yArrive);
//	}
//
//	@Test
//	public void testSolutionProfondeur() {
//		int xDepart = 0;
//		int yDepart = 0;
//		int xArrive = 4;
//		int yArrive = 4;
//		
//		int[][] resultatAttendu = { {0, 0}, {0, 1}, {1, 1}, {2, 1}, {2, 2}, {2, 3}, {3, 3}, {4, 3}, {4, 4} };
//		
//		int[][] resultatObtenu = solution.solutionProfondeur(xDepart, yDepart, xArrive, yArrive);
//		
//		assertArrayEquals(resultatAttendu, resultatObtenu);
//	}
}