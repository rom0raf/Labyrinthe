/**
 * CreationAscendante.java
 * Iut Rodez pas de droits d'auteurs
 */
package iut.info1.sae.create;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import iut.info1.sae.labyrinthe.Cellule;
import iut.info1.sae.labyrinthe.Labyrinthe;

/**
 * Classe responsable de la création ascendante d'un labyrinthe.
 * 
 * @author rafael.roma
 * @author aurelien.soleil
 * @author lohan.vignals
 * @author antonin.veyre
 */
public class CreationAscendante {
    private int largeur;
    private int hauteur;
    private Cellule[][] cellules;
    private int[][] marques;

    /**
     * Constructeur par défaut de la classe CreationAscendante.
     */
    public CreationAscendante() {}
    
    /**
     * Crée un labyrinthe en utilisant l'algorithme de création ascendante.
     * 
     * @param hauteur La hauteur du labyrinthe à créer.
     * @param largeur La largeur du labyrinthe à créer.
     * @return Le labyrinthe créé.
     */
    public Labyrinthe CreationAscendanteDeChaine(int hauteur, int largeur) {
    	
        this.largeur = largeur;
        this.hauteur = hauteur;
        cellules = new Cellule[hauteur][largeur];
        marques = new int[hauteur][largeur];
        initializeCells();
        
        int derniereMarque = 1;
        
        int nbArretes = 0;
        int maxArretes = (hauteur * largeur) - 1;
        
        while (nbArretes < maxArretes) {
        	
        	int randX = ThreadLocalRandom.current().nextInt(hauteur);
        	int randY = ThreadLocalRandom.current().nextInt(largeur);
        	
        	int marquesCellActive = marques[randX][randY];
        	
        	List<int[]> cellulesAdjacentes = new ArrayList<int[]>();
        	if ((randX + 1) < hauteur && (
        			( marques[randX + 1][randY] == 0 && marquesCellActive == 0 ) 
        			|| marques[randX + 1][randY] != marquesCellActive)) {
        		cellulesAdjacentes.add(new int[]{randX + 1, randY});
        	}
        	if ((randY + 1) < largeur && (
        			( marques[randX][randY + 1] == 0 && marquesCellActive == 0 ) 
        			|| marques[randX][randY + 1] != marquesCellActive)) {
        		cellulesAdjacentes.add(new int[]{randX, randY + 1});
        	}
        	if ((randX - 1) >= 0 && (
        			( marques[randX - 1 ][randY] == 0 && marquesCellActive == 0 ) 
        			|| marques[randX - 1 ][randY] != marquesCellActive)) {
        		cellulesAdjacentes.add(new int[]{randX - 1, randY});
        	}
        	if ((randY - 1) >= 0 && (
        			( marques[randX][randY - 1] == 0 && marquesCellActive == 0 ) 
        			|| marques[randX][randY - 1] != marquesCellActive)) {
        		cellulesAdjacentes.add(new int[]{randX, randY - 1});
        	}
        	
        	if (!(cellulesAdjacentes.isEmpty())) {
        	
        		int iRandCelluleVoisine = new Random().nextInt(cellulesAdjacentes.size());
            	int xVoisine = cellulesAdjacentes.get(iRandCelluleVoisine)[0];
            	int yVoisine = cellulesAdjacentes.get(iRandCelluleVoisine)[1];
            	int marqueVoisine = marques[xVoisine][yVoisine];
            	
            	if (xVoisine == randX) {
            		if (yVoisine > randY) {
            			cellules[xVoisine][yVoisine].modifierMur('O', false);
            			cellules[randX][randY].modifierMur('E', false);
            		} else {
            			cellules[xVoisine][yVoisine].modifierMur('E', false);
            			cellules[randX][randY].modifierMur('O', false);
            		}
            	} else {
            		if (xVoisine > randX) {
            			cellules[xVoisine][yVoisine].modifierMur('N', false);
            			cellules[randX][randY].modifierMur('S', false);
            		} else {
            			cellules[xVoisine][yVoisine].modifierMur('S', false);
            			cellules[randX][randY].modifierMur('N', false);
            		}
            	}
            	
            	if (marqueVoisine == 0) {
            		if (marquesCellActive == 0) {
            			marques[randX][randY] = derniereMarque;
            			marques[xVoisine][yVoisine] = derniereMarque;
            			derniereMarque++;
            		} else {
            			marques[xVoisine][yVoisine] = marques[randX][randY];
            		}
            	} else if (marquesCellActive == 0) {
            		if (marqueVoisine == 0) {
            			marques[randX][randY] = derniereMarque;
            			marques[xVoisine][yVoisine] = derniereMarque;
            			derniereMarque++;
            		} else {
            			marques[randX][randY] = marques[xVoisine][yVoisine];
            		}
            	} else {
            		for (int i = 0; i < marques.length; i ++) {
            			for (int j = 0; j < marques[i].length; j++) {
            				if (marques[i][j] == marqueVoisine) {
            					marques[i][j] = marquesCellActive;
            				}
            			}
            		}
            	}
            	
            	nbArretes++;
        		
        	}
        	
        }
        
        return new Labyrinthe(cellules);
    }

    /**
     * Initialise les cellules et les marques du labyrinthe.
     */
    private void initializeCells() {
        for (int x = 0; x < hauteur; x++) {
            for (int y = 0; y < largeur; y++) {
                cellules[x][y] = new Cellule(new boolean[]{true,true,true,true});
                marques[x][y] = 0;
            }
        }
    }
}
