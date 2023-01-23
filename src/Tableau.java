package src;
import java.util.ArrayList;

public class Tableau {

    private ArrayList<ArrayList<Integer>> tableau;
    final static int LIGNES = 6;
    final static int COLONNES = 7;

    public Tableau() {
        tableau = new ArrayList<ArrayList<Integer>>();
        for (int ligne = 0; ligne < LIGNES; ligne++) {
            ArrayList<Integer> newLigne = new ArrayList<Integer>();
            for (int colonne = 0; colonne < COLONNES; colonne++) {
                newLigne.add(0);
            }
            tableau.add(newLigne);
        }
    }

    public ArrayList<ArrayList<Integer>> getTableau() {
        return tableau;
    }

    public void setGrid(ArrayList<ArrayList<Integer>> tableau) {
        this.tableau = tableau;
    }
    
    public void displayGrid() {
        System.out.println("\n"); // Sauter une ligne
        for (int numeroColonnes = 1 ; numeroColonnes < COLONNES + 1 ; numeroColonnes++){
            System.out.print(" " + numeroColonnes + " " );
        }
        System.out.println();
        for (int tour = 0; tour < COLONNES + 2 * COLONNES; tour++)
            System.out.print('-');
        System.out.println();
        for (int ligne = 0 ; ligne < LIGNES ; ligne++) {
            for (int colonne = 0; colonne < COLONNES; colonne++) {
                System.out.print("|" + tableau.get(ligne).get(colonne) + "|");
            }
            System.out.println();
        }
        for (int tour = 0; tour < COLONNES + 2  * COLONNES; tour++)
            System.out.print('-');
        System.out.println();
    }
}
