package model;

import java.util.Random;

public class BatailleNavaleModel {
    private int[][] grille;
    private int tentatives;
    private int bateauLigne;
    private int bateauColonne;
    private boolean partieTerminee;
    
    public BatailleNavaleModel() {
        grille = new int[5][5];
        nouveauJeu();
    }
    
    public void nouveauJeu() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                grille[i][j] = 0;
            }
        }
        
        Random rand = new Random();
        bateauLigne = rand.nextInt(5);
        bateauColonne = rand.nextInt(5);
        tentatives = 0;
        partieTerminee = false;
    }
    
    public String tirer(int ligne, int colonne) {
        if (partieTerminee) return "Partie terminée, nouveau jeu !";
        if (grille[ligne][colonne] != 0) return "Déjà tiré ici !";
        
        tentatives++;
        
        if (ligne == bateauLigne && colonne == bateauColonne) {
            grille[ligne][colonne] = 2;
            partieTerminee = true;
            return "COULÉ ! Vous avez gagné en " + tentatives + " tirs !";
        } else {
            grille[ligne][colonne] = 1;
            return "PLOUF ! Raté...";
        }
    }
    
    public int getGrille(int ligne, int colonne) {
        return grille[ligne][colonne];
    }
}