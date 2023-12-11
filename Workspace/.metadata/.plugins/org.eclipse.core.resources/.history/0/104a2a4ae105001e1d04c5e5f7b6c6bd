/*
 * Solution.java                                 10/05/2023
 * pas de copyright ni de "copyleft"
 */
package iut.info1.sae.solution;

import iut.info1.sae.labyrinthe.Cellule;
import iut.info1.sae.labyrinthe.Labyrinthe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * La classe Solution appelle un labyrinthe et renvoi la solution du
 * parcours de celui-ci
 *
 * @author rafael.roma
 * @author antonin.veyre
 * @author aurelien.soleil
 * @author lohan.vignals
 */
public class Solution {
	
	private Labyrinthe laby;
	
	/**
	 * Constructeur de la classe solution qui renvoie les tableaux de 
	 * solution
	 *
     * @throws IllegalArgumentException 
     */
	public Solution(Labyrinthe lab) {
		
		if (!lab.estFini()) {
			throw new IllegalArgumentException("Le labyrinthe n'est pas finit, aucune solution trouvable.");
		}
		this.laby = lab;
		
	}
	
	/**
	 * Le programme permet de déterminer la solution du labyrinthe en méthode 
	 * main droite 
	 * @param xDepart
	 * @param yDepart
	 * @param xArrive
	 * @param yArrive
	 * @return liste du parcours en main droite
	 */
	public int[][] solutionMainDroite(int xDepart, int yDepart, int xArrive, int yArrive) {
		
		if (xDepart == xArrive && yDepart == yArrive) {
			throw new IllegalArgumentException("Le point de départ et d'arrivé ne peut etre les memes.");
		}
		
		// Vérification de l'existance des cellules d'arrivé et départ
		Cellule cellDepart = this.laby.getCellule(xDepart, yDepart);
		
		Cellule cellCourante = cellDepart;
		
		List<int[]> listCoordPassage = new ArrayList<>();
		
		int xCourant = xDepart;
		int yCourant = yDepart;
		char direction = 'E';
		
		while ((xCourant != xArrive) || (yCourant != yArrive)) {
			
			listCoordPassage.add(new int[]{xCourant, yCourant});
			
			switch(direction) {

			case 'E':
				
				if (!cellCourante.estMurPresent('S')) {
					
					direction = 'S';
					xCourant ++;
					cellCourante = this.laby.getCellule(xCourant, yCourant);
					
				} else if (!cellCourante.estMurPresent('E')) {

					yCourant ++;
					cellCourante = this.laby.getCellule(xCourant, yCourant);

				} else if (!cellCourante.estMurPresent('N')) {
					
					direction = 'N';
					xCourant --;
					cellCourante = this.laby.getCellule(xCourant, yCourant);
					
				} else {
					
					direction = 'O';
					yCourant --;
					cellCourante = this.laby.getCellule(xCourant, yCourant);
					
				}
					
				break;
			case 'N':
				if (!cellCourante.estMurPresent('E')) {
					
					direction = 'E';
					yCourant ++;
					cellCourante = this.laby.getCellule(xCourant, yCourant);
					
				} else if (!cellCourante.estMurPresent('N')) {

					xCourant --;
					cellCourante = this.laby.getCellule(xCourant, yCourant);

				} else if (!cellCourante.estMurPresent('O')) {
					
					direction = 'O';
					yCourant --;
					cellCourante = this.laby.getCellule(xCourant, yCourant);
					
				} else {
					
					direction = 'S';
					xCourant ++;
					cellCourante = this.laby.getCellule(xCourant, yCourant);
					
				}
				break;
			case 'O':
				if (!cellCourante.estMurPresent('N')) {
					
					direction = 'N';
					xCourant --;
					cellCourante = this.laby.getCellule(xCourant, yCourant);
					
				} else if (!cellCourante.estMurPresent('O')) {

					yCourant --;
					cellCourante = this.laby.getCellule(xCourant, yCourant);

				} else if (!cellCourante.estMurPresent('S')) {
					
					direction = 'S';
					xCourant ++;
					cellCourante = this.laby.getCellule(xCourant, yCourant);
					
				} else {
					
					direction = 'E';
					yCourant ++;
					cellCourante = this.laby.getCellule(xCourant, yCourant);
					
				}
				break;
			default:
				if (!cellCourante.estMurPresent('O')) {
					
					direction = 'O';
					yCourant --;
					cellCourante = this.laby.getCellule(xCourant, yCourant);
					
				} else if (!cellCourante.estMurPresent('S')) {

					xCourant ++;
					cellCourante = this.laby.getCellule(xCourant, yCourant);

				} else if (!cellCourante.estMurPresent('E')) {
					
					direction = 'E';
					yCourant ++;
					cellCourante = this.laby.getCellule(xCourant, yCourant);
					
				} else {
					
					direction = 'N';
					xCourant --;
					cellCourante = this.laby.getCellule(xCourant, yCourant);
					
				}
				break;
			}
			
		}
		
		listCoordPassage.add(new int[]{xCourant, yCourant});
		
		int[][] listeInt = new int[listCoordPassage.size()][];
		
		for (int i = 0; i < listCoordPassage.size(); i++) {
			listeInt[i] = listCoordPassage.get(i);
		}
		
		return listeInt;
	}

	/**
	 * Le programme permet de déterminer la solution du labyrinthe de la maniere 
	 * la plus courte possible
	 * @param xDepart
	 * @param yDepart
	 * @param xArrive
	 * @param yArrive
	 * @return liste du parcours en main droite
	 */

	public int[][] solutionProfondeur(int xDepart, int yDepart, int xArrive, int yArrive) {
		if (xDepart == xArrive && yDepart == yArrive) {
			throw new IllegalArgumentException("Le point de départ et d'arrivé ne peut etre les memes.");
		}

		int pointeur = 0;	

		List<int[]> parcoursDesPieces = new ArrayList<>();
		int xCourant = xDepart;
		int yCourant = yDepart;
		int xAvant = xCourant;
		int yAvant = yCourant;
		boolean deja = false;

		final int HAUTEUR = this.laby.getHauteur();
		final int LARGEUR = this.laby.getLargeur();

		int[][] dejaVisite =  new int[HAUTEUR * LARGEUR][2];
		int pointeurVisite = 1;
		dejaVisite[0] = new int[]{xCourant,yCourant};

		while ((xCourant != xArrive) || (yCourant!= yArrive)) {
			for (int i = 0; i < pointeur; i++){
				if (parcoursDesPieces.get(i)[0] == xCourant && parcoursDesPieces.get(i)[1] == yCourant) {
					for (int j = pointeur - 1; j >= i; j--) {
						for (int n = 0; n < pointeurVisite - 2; n++){
							if (dejaVisite[n] == parcoursDesPieces.get(j)){
								deja = true;
							}
						}
						if (!deja) {
							
							dejaVisite[pointeurVisite - 1] = parcoursDesPieces.get(j);
							pointeurVisite++;
						}
						deja = false;
						parcoursDesPieces.remove(j);
					}
					pointeur = i;
				}
			}
			parcoursDesPieces.add(new int[]{xCourant, yCourant});
			pointeur++;

			int[] res = Parcours(xCourant,yCourant,dejaVisite,pointeurVisite, xAvant, yAvant);
			
			xAvant = xCourant;
			yAvant = yCourant;
			
			xCourant = res[0];
			yCourant = res[1];

		}

		parcoursDesPieces.add(new int[]{xCourant, yCourant});

		int[][] listeInt = new int[parcoursDesPieces.size()][];
		
		for (int i = 0; i < parcoursDesPieces.size(); i++) {
			listeInt[i] = parcoursDesPieces.get(i);
		}
		return listeInt;
	}

	/**
	 * Determine la prochaine piece a visiter et nous renvoi ces coordonnées
	 *
	 * @param xCourant
	 * @param yCourant
	 * @param dejVisite
	 * @param pointeur
	 * @param xAvant
	 * @param yAvant
	 * @return nouvelleCell
	 */

	private int[] Parcours(int xCourant, int yCourant, int[][] dejVisite, int pointeur, int xAvant, int yAvant){
		Cellule cellCourante = this.laby.getCellule(xCourant, yCourant);
		if(!cellCourante.estMurPresent('E') && !this.estVisite(xCourant, yCourant + 1, dejVisite, pointeur) && (xCourant != xAvant || yCourant + 1 != yAvant)) {
			yCourant ++;
					
		} else if (!cellCourante.estMurPresent('S') && !this.estVisite(xCourant + 1, yCourant, dejVisite, pointeur) && (xCourant +1 != xAvant || yCourant!= yAvant)) {
			xCourant ++;

		} else if  (!cellCourante.estMurPresent('O') && !this.estVisite(xCourant, yCourant - 1, dejVisite, pointeur)&& (xCourant != xAvant || yCourant - 1 != yAvant)) {				
			yCourant --;
					
		} else if (!cellCourante.estMurPresent('N') && !this.estVisite(xCourant - 1, yCourant, dejVisite, pointeur) && (xCourant - 1 != xAvant || yCourant != yAvant)) {
			xCourant --;	
		}
		int[] nouvelleCell = {xCourant,yCourant};
		return nouvelleCell;

	}

	/**
	 * Détermine si la pièce a déjà était visité et renvoi true, false sinon
	 *
	 * @param x
	 * @param y
	 * @param visite
	 * @param pointeur
	 * @return boolean
	 */ 
	private boolean estVisite(int x, int y, int[][] visite, int pointeur) {
		for (int i = 0; i < pointeur; i++) {
			if (x== visite[i][0] && y== visite[i][1]){
				return true;
			}
		}
		return false;
	}
	
}