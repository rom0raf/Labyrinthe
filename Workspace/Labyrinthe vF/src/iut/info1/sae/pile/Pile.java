/**
 * Pile.java    12 mai 2023
 * IUR Rodez pas de droits d'auteurs
 */
package iut.info1.sae.pile;

import java.util.Arrays;

import iut.info1.sae.pile.err.PileVideException;

/**
 * La classe Pile permet d'empiler, dépiler des éléments dans une pile
 * 
 * @author rafael.roma
 * @author antonin.veyre
 */
public class Pile {
	
	//taille du tableau 
	private static final int CAPACITE_DEFAUT = 10;
	
	//coefficient de grossissement du tableau a reallouer
    private static final double GROSSISSEMENT = 1.2;

	// numéro d'indice du sommet dans le tableau
	// si indice = 0 le tableau est vide
	private int indiceSommet;
	
	// éléments de la pile
	private Object[] elements;
	
	
	
	/**
	 * Constructeur de Pile : construit une pile vide
	 * Pile de type Object
	 */
	public Pile() {
		elements = new Object[CAPACITE_DEFAUT];
		indiceSommet = 0;
	}
	/**
	 * la fonction estVide permet de vérifier si la pile contient aucun élément
	 * @return true si elle est vide false sinon
	 */
	public boolean estVide() {
	
	    return indiceSommet == 0; 
	}
	
	/**
	 * la fonction empiler ajoute un élément à la pile
	 * @param aAjouter de type Object 
	 * @return la nouvelle Pile
	 * @throws NullPointerException si l'élément à ajouter est null
	 */
	public Pile empiler(Object aAjouter) {
		if(aAjouter == null) {
		    throw new NullPointerException("L'objet à ajouter est null");
		}
		if(elements.length == indiceSommet) {
		    elements = Arrays.copyOf(elements,(int)Math.ceil( indiceSommet * GROSSISSEMENT));
		}
		elements[indiceSommet] = aAjouter;
		indiceSommet++;
		return this; 
	}
	
	/**
	 * la fonction sommet donne l'élément le plus haut de la pile
	 * @return le sommet de la Pile
	 * @throws PileVideException si la pile est vide
	 */
	public Object sommet() {
		if(this.estVide()) {
		    throw new PileVideException();
		}
		return elements[indiceSommet - 1]; 
	}
	
	/**
	 * la fonction dépiler enlève le sommet de la Pile
	 * @return la nouvelle Pile
	 * @throws PileVideException si la pile est vide
	 */
	public Pile depiler() {
		if(this.estVide()) {
		    throw new PileVideException();
		}
		indiceSommet --;
		return this;
	}
}
