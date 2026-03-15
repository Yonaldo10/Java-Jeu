package model;

import java.util.Random;

public class DevineNombreModel {

    private int nombreSecret;
    private Random random;

    public DevineNombreModel() {
        random = new Random();
        nouveauJeu();
    }

    public void nouveauJeu() {
        nombreSecret = random.nextInt(100) + 1;
    }

    public String verifierProposition(int proposition) {
        if (proposition < 1 || proposition > 100) {
            return "Le nombre doit être entre 1 et 100 !";
        } else if (proposition < nombreSecret) {
            return "C'est plus grand !";
        } else if (proposition > nombreSecret) {
            return "C'est plus petit !";
        } else {
            return "Bravo ! Vous avez trouvé ! Le nombre était : " + nombreSecret; // ✅
        }
    }
}