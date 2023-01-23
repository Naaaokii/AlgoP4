package src;

import src.model.Scan;

public class App {
    public static void main(String[] args) throws Exception {

        Tableau monTableau = new Tableau();
        monTableau.displayGrid();
        // Pion mypion = new Pion(monTableau);
        Pion Pion = new Pion(monTableau);

        // int colonne = 6;
        // colonne--;
        // Pion.ajouterPion(colonneonne);
        // monTableau.displayTableau();
        // Pion.ajouterPion(colonneonne);
        // monTableau.displayTableau();
        Victoire verifVictoire = new Victoire(monTableau);
        int joueurActuel = 1;
        Joueur joueur = new Joueur();
        do {
        boolean victoire = verifVictoire.verifierVictoire(joueurActuel);
        if (victoire) {
            System.out.println("joueur " + joueur.getJoueur() + " a gagné !");
            break;
        }
            int colonne;
            String input = Scan.saisieUtilisateur();
            switch (input) {
                case "q":
                    System.out.println("Bye bye");
                    System.exit(0);
                    return;
                    
                case "1":
                    colonne = 1;
                    colonne--;
                    joueur.changerDeJoueur();

                    Pion.ajouterPion(colonne, joueurActuel);
                    monTableau.displayGrid();
                    break;
                case "2":
                    colonne = 2;
                    colonne--;
                    joueur.changerDeJoueur();

                    Pion.ajouterPion(colonne, joueurActuel);

                    monTableau.displayGrid();
                    break;
                case "3":
                    colonne = 3;
                    colonne--;
                    joueur.changerDeJoueur();

                    Pion.ajouterPion(colonne, joueurActuel);

                    monTableau.displayGrid();
                    break;
                case "4":
                    colonne = 4;
                    colonne--;
                    joueur.changerDeJoueur();

                    Pion.ajouterPion(colonne, joueurActuel);

                    monTableau.displayGrid();
                    break;
                case "5":
                    colonne = 5;
                    colonne--;
                    joueur.changerDeJoueur();

                    Pion.ajouterPion(colonne, joueurActuel);

                    monTableau.displayGrid();
                    break;
                case "6":
                    colonne = 6;
                    colonne--;
                    joueur.changerDeJoueur();

                    Pion.ajouterPion(colonne, joueurActuel);

                    monTableau.displayGrid();
                    break;
                case "7":
                    colonne = 7;
                    colonne--;
                    joueur.changerDeJoueur();

                    Pion.ajouterPion(colonne, joueurActuel);

                    monTableau.displayGrid();
                    break;
                default:
                    System.out.println("Veuillez saisir un chiffre entre 1 et 7");
                    monTableau.displayGrid();
                    break;
            }
            joueurActuel = joueurActuel == 1 ? 2 : 1;
            System.out.println(joueurActuel);
        } while (true);

    }
}