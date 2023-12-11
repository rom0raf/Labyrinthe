/*
 * Sauvegarde.java			06/05/2023
 * pas de copyright ni de "copyleft"
 */
package iut.info1.sae.save;

import java.io.File;
import com.google.gson.*;
import iut.info1.sae.labyrinthe.Labyrinthe;

import java.io.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * La classe Sauvegarde permet d'enrgistrer le labyrinthe dans un fichier
 * pour pouvoir le réutiliser plus tard si voulu
 *
 * @author rafael.roma
 * @author antonin.veyre
 * @author aurelien.soleil
 * @author lohan.vignals
 */
public class Sauvegarde {

	/** Le nom du fichier */
	private String nomfichier;
	
	/** Le labyrinthe a sauvegarder */
	private Labyrinthe laby;
	
	/**
	 * Constructeur de la classe Sauvegarde
	 * Initialise les variables nomFichier (private) et laby (private)
	 * Avant initialisation vérifie que le labyrinthe est complet
	 * et que le nom du fichier est valide.
	 * 
	 * @param labyrinthe le labyrinthe a sauvegarder
	 * @param nomfichier le nom du fichier pour la sauvegarde
	 */
	public Sauvegarde(Labyrinthe labyrinthe,String nomfichier) {		
		nomfichier = "D:\\LabyrintheV1\\Sauvegarde\\" + nomfichier + ".json";
		
		this.verifNomFichier(nomfichier);
		
		if (!labyrinthe.estFini()) {
			throw new IllegalArgumentException("Le labyrinthe n'est pas finit il ne peut donc pas etre sauvegarder");
		}
		
		this.laby = labyrinthe;		
		this.nomfichier = nomfichier;
	}
	
	/**
	 * Vérifie qu'aucun fichier du même nom n'existe déjà
	 * @param nomFichier le nom du fichier
	 * @throws IllegalArgumentException si un fichier du même nom existe déjà
	 */
	private void verifNomFichier(String nomFichier) {
		File fichier = new File(nomFichier);
		if (fichier.exists() && !fichier.isDirectory()) {
			throw new IllegalArgumentException("Le fichier de sauvegarde existe deja.");
		}
	}
	
	/**
	 * Génère le json a partir du labyrinthe
	 * Ce json contiendra toute les informations du labyrinthe 
	 * pour pouvoir le recharger a un autre moment
	 * 
	 * @return la string qui contient le json
	 */
	private String generateJson() {
		final Gson GSON_OBJECT = new GsonBuilder().setPrettyPrinting().create(); 
		return GSON_OBJECT.toJson(this.laby);
	}
	
	/**
	 * se dirige vers le dossier en le créant s'il n'existe pas
	 * puis ajoute les lignes pour le labyrinthe afin de le sauvegarder
	 * @throws IOException 
	 */
	public void sauver() throws IOException {
		final String JSON_F = this.generateJson();
		
		try {
			Files.createDirectories(Paths.get("D:\\LabyrintheV1\\Sauvegarde\\"));
		} catch (IOException err) {
			// Pass meme si une erreur apparait	
		}
		
		final Path PATH_F = Paths.get(this.nomfichier);
		
		try {
			Files.writeString(PATH_F, JSON_F, StandardCharsets.UTF_8);
		} catch (IOException e) {
			throw new IOException("Une erreur est survenue lors de l'écriture du fichier."
								  + "\nErreur: " + e.getMessage());
		}
	}
	
}
