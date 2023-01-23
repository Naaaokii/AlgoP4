package src;

import java.text.ParseException;

import src.model.*;


/**
 * Rassemble des méthodes qui gèrent le menu et les choix de l'utilisateur
 */
public class Menu {

    /**
     * Permet d'affiche le menu du jeu avec différents choix
     */
    public static void displayMenu() throws ParseException {
        do {
            System.out.println(Couleurs.GREEN + "  -- Menu --");
            System.out.println("1- Jouer seul");
            System.out.println("2- Jouer à deux ");
            System.out.println("3- Afficehr le top 10");
            System.out.println("q- Quitter le menu" /*+ ConsoleColors.DEFAULT*/);

            String input = Scan.saisieUtilisateur();

            switch (input) {
                case "1":
                    // Jouer seul
                    break;
                case "2":
                    // Jouer à deux
                    break;
                case "3":
                    // Afficher le top score;
                    break;
                case "q":
                    // Quitter;
                    return;
                default:
                    System.out.println(Couleurs.RED + "NONNNNNNNN ! Vous ne savez pas lire ?!?!" + Couleurs.DEFAULT);
                    break;
            }
        } while (true);
    }
}