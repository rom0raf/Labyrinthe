/**
 * Sample Skeleton for 'Scene1LancementLabyrinthe.fxml' Controller Class
 */
package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;

public class ControlleurScene1 {

    @FXML // fx:id="jouer"
    private Button jouer; // Value injected by FXMLLoader

    @FXML // fx:id="largeur"
    private TextField largeur; // Value injected by FXMLLoader

    @FXML // fx:id="ascendanceDeChaine"
    private RadioButton ascendanceDeChaine; // Value injected by FXMLLoader

    @FXML // fx:id="Methode"
    private ToggleGroup Methode; // Value injected by FXMLLoader

    @FXML // fx:id="backtracking"
    private RadioButton backtracking; // Value injected by FXMLLoader

    @FXML // fx:id="panelbase"
    private Pane panelbase; // Value injected by FXMLLoader

    @FXML // fx:id="chargerLab"
    private Button chargerLab; // Value injected by FXMLLoader

    @FXML // fx:id="hauteur"
    private TextField hauteur; // Value injected by FXMLLoader

    @FXML
    void clickBoutonJouer() {
    	hauteur.getText();
    }

    @FXML
    void presseTailleHauteur() {
    	System.out.println("presse bouton hauteur");
    }

    @FXML
    void presseTailleLargeur() {
    	System.out.println("presse bouton largeur");
    }

    @FXML
    void clickBoutonMethodeAscendante() {
    	System.out.println("clickBouton Ascendante");
    }

    @FXML
    void clickBoutonMethodeBacktracking() {
    	System.out.println("clickBouton Backtracking");
    }

    @FXML
    void clickBoutonChargerLaby() {
    	System.out.println("clickBouton charger le labyrinthe");
    }

}
