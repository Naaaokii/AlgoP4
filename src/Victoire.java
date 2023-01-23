package src;
import java.util.ArrayList;

public class Victoire {
    private static Tableau tableau;

    public Victoire(Tableau tableau) {
        this.tableau = tableau;
    }

    public boolean verifierVictoire(int player) {
        ArrayList<ArrayList<Integer>> tableauActuel = tableau.getTableau();

        // Vérifie les lignes
        for (int ligne = 0; ligne < Tableau.LIGNES; ligne++) {
            for (int colonne = 0; colonne < Tableau.COLONNES - 3; colonne++) {
                if (tableauActuel.get(ligne).get(colonne) == player 
                    && tableauActuel.get(ligne).get(colonne + 1) == player 
                    && tableauActuel.get(ligne).get(colonne + 2) == player 
                    && tableauActuel.get(ligne).get(colonne + 3) == player) {
                    return true;
                }
            }
        }

        // Vérifie les COLONNES
        for (int colonne = 0; colonne < Tableau.COLONNES; colonne++) {
            for (int ligne = 0; ligne < Tableau.LIGNES - 3; ligne++) {
                if (tableauActuel.get(ligne).get(colonne) == player 
                    && tableauActuel.get(ligne + 1).get(colonne) == player 
                    && tableauActuel.get(ligne + 2).get(colonne) == player 
                    && tableauActuel.get(ligne + 3).get(colonne) == player) {
                    return true;
                }
            }
        }

        // Vérifie les diagonales
        for (int ligne = 0; ligne < Tableau.LIGNES - 3; ligne++) {
            for (int colonne = 0; colonne < Tableau.COLONNES - 3; colonne++) {
                if (tableauActuel.get(ligne).get(colonne) == player 
                    && tableauActuel.get(ligne + 1).get(colonne + 1) == player 
                    && tableauActuel.get(ligne + 2).get(colonne + 2) == player
                    && tableauActuel.get(ligne + 3).get(colonne + 3) == player) {
                    return true;
                }else if (tableauActuel.get(ligne).get(colonne + 3) == player
                && tableauActuel.get(ligne + 1).get(colonne + 2) == player
                && tableauActuel.get(ligne + 2).get(colonne + 1) == player
                && tableauActuel.get(ligne + 3).get(colonne) == player) {
                return true;
                }
            }
        }
        return false;
}
}
