package src;
import java.util.ArrayList;

public class Pion {
    public static Tableau tableau;
    public Pion(Tableau tableau) {
        Pion.tableau = tableau;
    }

    public void ajouterPion(int col, int player) {
        ArrayList<ArrayList<Integer>> tableauActuel = tableau.getTableau();
        for (int ligne = Tableau.LIGNES-1; ligne >= 0; ligne--) {
            if (tableauActuel.get(ligne).get(col) == 0) {
                tableauActuel.get(ligne).set(col, player);
                tableau.setGrid(tableauActuel);
                break;
            }
        }
    }
}
