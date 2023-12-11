package iut.info1.sae.joueur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ToucheEvent {

    private boolean isListening;
    private Thread eventThread;
    private Joueur joueur;

    public ToucheEvent() {
        isListening = false;
        eventThread = null;
    }

    public void activer() {
        if (!isListening) {
            isListening = true;
            eventThread = new Thread(() -> {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                    while (isListening) {
                        int input = reader.read();
                        if (input != -1) {
                            handleKeyEvent(input);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            eventThread.start();
        }
    }
    
    public void desactiver() {
        if (isListening) {
            isListening = false;
            try {
                eventThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void handleKeyEvent(int input) {
        char direction = getDirectionFromKey(input);
        if (direction != '\0') {
            if (this.joueur != null) {
                boolean estDeplace;
                estDeplace = joueur.deplacer(direction);

                if (!estDeplace) {
                    System.out.println("Ce mouvement est illégal.");
                    return;
                }

                joueur.afficherLabyrintheJoueur();
            }
        }
    }

    private static char getDirectionFromKey(int input) {
        switch (input) {
            case 'N':
                return 'N';
            case 'S':
                return 'S';
            case 'E':
                return 'E';
            case 'O':
                return 'O';
            default:
                return '\0';
        }
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
}
