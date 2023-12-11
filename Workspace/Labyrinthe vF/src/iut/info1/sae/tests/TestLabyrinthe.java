package iut.info1.sae.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import iut.info1.sae.labyrinthe.Labyrinthe;
import iut.info1.sae.labyrinthe.Cellule;

public class TestLabyrinthe {

    @Test
    @DisplayName("Test avec une largeur invalide")
    public void testLabyrintheLargeurInvalide() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Labyrinthe(-1, 5);
        });
        assertEquals("La hauteur ou largeur du labyrinthe est invalide.", exception.getMessage());
    }

    @Test
    @DisplayName("Test avec une hauteur invalide")
    public void testLabyrintheHauteurInvalide() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Labyrinthe(5, 0);
        });
        assertEquals("La hauteur ou largeur du labyrinthe est invalide.", exception.getMessage());
    }

    @Test
    @DisplayName("Test avec des dimensions valides")
    public void testLabyrintheDimensionsValides() {
        assertDoesNotThrow(() -> {
            Labyrinthe lab = new Labyrinthe(5, 5);
        });
    }

    @Test
    void testAjoutCelluleValide() {
        Labyrinthe labyrinthe = new Labyrinthe(10, 10);
        labyrinthe.ajoutCellule(0, 0, true, false, true, true);
        assertEquals(labyrinthe.getCellule(0, 0).estMurPresent('N'), true);
        assertEquals(labyrinthe.getCellule(0, 0).estMurPresent('S'), false);
        assertEquals(labyrinthe.getCellule(0, 0).estMurPresent('E'), true);
        assertEquals(labyrinthe.getCellule(0, 0).estMurPresent('O'), true);
    }

    @Test
    void testAjoutCelluleCoordonneesExistantes() {
        Labyrinthe labyrinthe = new Labyrinthe(10, 10);
        labyrinthe.ajoutCellule(0, 0, true, true, false, true);
        assertThrows(IllegalArgumentException.class, () -> {
            labyrinthe.ajoutCellule(0, 0, true, true, false, true);
        });
    }

    @Test
    void testAjoutCelluleCoordonneesInvalides() {
        Labyrinthe labyrinthe = new Labyrinthe(10, 10);
        assertThrows(IllegalArgumentException.class, () -> {
            labyrinthe.ajoutCellule(11, 11, false, true, false, true);
        });
    }

    @Test
    void testAjoutCelluleMursInvalides() {
        Labyrinthe labyrinthe = new Labyrinthe(10, 10);
        assertThrows(IllegalArgumentException.class, () -> {
            labyrinthe.ajoutCellule(1, 0, false, false, true, false);
            labyrinthe.ajoutCellule(0, 0, true, false, true, false);
        });
    }

    @Test
    void testAjoutCelluleIsolation() {
        Labyrinthe labyrinthe = new Labyrinthe(10, 10);
        labyrinthe.ajoutCellule(0, 0, true, false, true, true);
        assertThrows(IllegalArgumentException.class, () -> {
            labyrinthe.ajoutCellule(1, 0, true, true, true, true);
        });
    }

    // Test pour une coordonnée valide
    @Test
    public void testGetCelluleCoordonneesValides() {
        Labyrinthe labyrinthe = new Labyrinthe(5, 5);
        labyrinthe.ajoutCellule(2, 2, true, false, true, true);
        Cellule cellule = labyrinthe.getCellule(2, 2);
        assertNotNull(cellule);
    }

    // Test pour une coordonnée hors limites en x
    @Test
    public void testGetCelluleCoordonneeXInvalide() {
        Labyrinthe labyrinthe = new Labyrinthe(5, 5);
        assertThrows(IllegalArgumentException.class, () -> {
            labyrinthe.getCellule(-1, 2);
        });
    }

    // Test pour une coordonnée hors limites en y
    @Test
    public void testGetCelluleCoordonneeYInvalide() {
        Labyrinthe labyrinthe = new Labyrinthe(5, 5);
        assertThrows(IllegalArgumentException.class, () -> {
            labyrinthe.getCellule(2, 10);
        });
    }

    // Test pour une coordonnée hors limites en x et y
    @Test
    public void testGetCelluleCoordonneesInvalide() {
        Labyrinthe labyrinthe = new Labyrinthe(5, 5);
        assertThrows(IllegalArgumentException.class, () -> {
            labyrinthe.getCellule(-1, 10);
        });
    }

}
