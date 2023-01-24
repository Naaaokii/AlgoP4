import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.IOException;
import jeu.Joueur;

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
                            joueur();
                            
                            break;
                        case "2":
                            joueur();
                            joueur();
                            
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

    private static void joueur() throws IOException {
        Joueur c = new Joueur();

        System.out.print("Saisir le prénom du joueur: ");
        String prenom = scanner.nextLine();
        while (prenom.isBlank()) {
            System.out.println("\033[31mLe prénom est obligatoire\033[0m");
            System.out.println();
            System.out.print("Saisir le prénom du joueur: ");
            prenom = scanner.nextLine();
        }
        c.setPrenom(prenom);

        System.out.println("-- Couleur --");
        System.out.println("1.Rouge");
        System.out.println("2.Bleu");
        System.out.println("3.Vert");
        System.out.println("4.Jaune");
        System.out.print("Saisir la couleur du joueur : ");
        String couleur = scanner.nextLine();
        while (!isValid(couleur)) {
            System.out.println("\033[31mCouleur non valide\033[0m");
            System.out.println();
            System.out.print("Saisir la couleur du joueur : ");
            couleur = scanner.nextLine();
        }
        c.setCouleur(couleur);

        System.out.println("-- Forme --");
        System.out.println("1.§");
        System.out.println("2.&");
        System.out.println("3.@");
        System.out.println("4.#");
        System.out.print("Saisir la forme du joueur : ");
        String forme = scanner.nextLine();
        while (!isValid(forme)) {
            System.out.println("\033[31mForme non valide\033[0m");
            System.out.println();
            System.out.print("Saisir la forme du joueur : ");
            forme = scanner.nextLine();
        }
        c.setForme(forme);
        c.enregistrer();
    }

    public static boolean isValid(String valid) {
            String validRegex = "^[1-4]$";
    
            Pattern pat = Pattern.compile(validRegex);
            if (valid == null)
                return false;
            return pat.matcher(valid).matches();
    }
}