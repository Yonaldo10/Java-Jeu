package model;

import java.util.Random;

public class ShiFumiModel {

    private int scoreJoueur;
    private int scoreOrdinateur;
    private Random random;
    private String[] options = {"Pierre", "Feuille", "Ciseaux"};

    public ShiFumiModel() {
        random = new Random();
        scoreJoueur = 0;
        scoreOrdinateur = 0;
    }

    public String jouer(String choixJoueur) {
        String choixOrdinateur = options[random.nextInt(options.length)];

        String resultat;

        if (choixJoueur.equals(choixOrdinateur)) {
            resultat = "Égalité ! (Ordi : " + choixOrdinateur + ")";
        } else if (
            (choixJoueur.equals("Pierre") && choixOrdinateur.equals("Ciseaux")) ||
            (choixJoueur.equals("Feuille") && choixOrdinateur.equals("Pierre")) ||
            (choixJoueur.equals("Ciseaux") && choixOrdinateur.equals("Feuille"))
        ) {
            scoreJoueur++;
            resultat = "Vous gagnez ! (Ordi : " + choixOrdinateur + ") | Score : " + scoreJoueur + " - " + scoreOrdinateur;
        } else {
            scoreOrdinateur++;
            resultat = "Ordi gagne ! (Ordi : " + choixOrdinateur + ") | Score : " + scoreJoueur + " - " + scoreOrdinateur;
        }

        return resultat;
    }

    public void resetScores() {
        scoreJoueur = 0;
        scoreOrdinateur = 0;
    }
}