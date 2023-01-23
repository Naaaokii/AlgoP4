package src;
public class Joueur {
    private int joueurActuel;

    public void joueur() {
        joueurActuel = 1;
    }

    public int getJoueur() {
        return joueurActuel;
    }

    public void changerDeJoueur() {
        if (joueurActuel == 1) {
            joueurActuel = 2;
        } else {
            joueurActuel = 1;
        }
    }
}
