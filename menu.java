import java.util.Scanner;

import Plateau.*;
import Joueur.*;
import Game.*;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        boolean Menu = false;
        while (!Menu) {
            System.out.println("-- Menu --");
            System.out.println("1.Jouer");
            System.out.println("q.Quitter");
            System.out.print("redirection vers : ");
            String choix = scanner.nextLine();
            switch (choix) {
                case "1":
                    System.out.println("-- Jouer --");
                    System.out.println("1.1 joueur");
                    System.out.println("2.2 joueurs");
                    System.out.println("q.Quitter");
                    System.out.print("redirection vers : ");
                    String choix1 = scanner.nextLine();
                    switch (choix1) {
                        case "1":
                            Joueur_2.joueur();
                            Plateau.Tableau();
                            break;
                        case "2":
                            Game.Jeu();
                            break;
                        case "q":
                            break;
                        default:
                            System.out.println("\033[31mChoisissez une option\033[0m");
                            break;
                    }
                    break;
                case "q":
                    return;
                default:
                    System.out.println("\033[31mChoisissez une option\033[0m");
                    break;
            }
        }
    }
}
