import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.IOException;
import jeu.*;
import java.util.ArrayList;

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
                            Tableau();
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

        System.out.println("-- Prenom --");
        System.out.print("Saisir le prénom du joueur: ");
        String prenom = scanner.nextLine();
        while (prenom.isBlank()) {
            System.out.println("\033[31mLe prénom est obligatoire\033[0m");
            System.out.println();
            System.out.print("Saisir le prénom du joueur: ");
            prenom = scanner.nextLine();
        }
        c.setPrenom(prenom);

        System.out.println("-- Forme --");
        System.out.println("§");
        System.out.println("&");
        System.out.println("@");
        System.out.println("#");
        System.out.print("Saisir la forme du joueur : ");
        String forme = scanner.nextLine();
        while (!isValidForme(forme)) {
            System.out.println("\033[31mForme non valide\033[0m");
            System.out.println();
            System.out.print("Saisir la forme du joueur : ");
            forme = scanner.nextLine();
        }
        c.setForme(forme);

        System.out.println("-- Couleur --");
        System.out.println("1.Rouge");
        System.out.println("2.Bleu");
        System.out.println("3.Vert");
        System.out.println("4.Jaune");
        System.out.print("Saisir la couleur du joueur : ");
        String couleur = scanner.nextLine();
        while (!isValidColor(couleur)) {
            System.out.println("\033[31mCouleur non valide\033[0m");
            System.out.println();
            System.out.print("Saisir la couleur du joueur : ");
            couleur = scanner.nextLine();
        }
        if (couleur.equals("1")) {
            System.out.println("Forme et couleur choisie : " + "\033[31m" + forme + "\033[0m");
        } else if (couleur.equals("2")) {
            System.out.println("Forme et couleur choisie : " + "\033[34m" + forme + "\033[0m");
        } else if (couleur.equals("3")) {
            System.out.println("Forme et couleur choisie : " + "\033[32m" + forme + "\033[0m");
        } else if (couleur.equals("4")) {
            System.out.println("Forme et couleur choisie : " + "\033[33m" + forme + "\033[0m");
        }

        c.setCouleur(couleur);
        c.enregistrer();
    }

    public static boolean isValidForme(String valid) {
            String validRegex = "^[&#@§]{1}$";
            Pattern pat = Pattern.compile(validRegex);
            if (valid == null)
                return false;
            return pat.matcher(valid).matches();
    }

    public static boolean isValidColor(String valid) {
        String validRegex = "^[1-4]$";
        Pattern pat = Pattern.compile(validRegex);
        if (valid == null)
            return false;
        return pat.matcher(valid).matches();
    }

    public static boolean isValidNumero(String valid) {
        String validRegex = "^[1-7]$";
        Pattern pat = Pattern.compile(validRegex);
        if (valid == null)
            return false;
        return pat.matcher(valid).matches();
    }

    public static void Tableau() {
        String tableau = "\n" + "  1   2   3   4   5   6   7  \n" + "\n";
        ArrayList<ArrayList<String>> colones = new ArrayList<ArrayList<String>>();
    
        for (int i = 0; i < 6; i++) {
            ArrayList<String> lignes = new ArrayList<String>();
            lignes.add("\n");
            for (int j = 0; j < 7; j++) {
                lignes.add(" ");
            }
            colones.add(lignes);
        }

        System.out.println("------------ Jeu ------------");
        System.out.println();
        System.out.println("  1   2   3   4   5   6   7  ");
        System.out.println();
        System.out.println("|   |   |   |   |   |   |   |");
        System.out.println("|---+---+---+---+---+---+---|");
        System.out.println("|   |   |   |   |   |   |   |");
        System.out.println("|---+---+---+---+---+---+---|");
        System.out.println("|   |   |   |   |   |   |   |");
        System.out.println("|---+---+---+---+---+---+---|");
        System.out.println("|   |   |   |   |   |   |   |");
        System.out.println("|---+---+---+---+---+---+---|");
        System.out.println("|   |   |   |   |   |   |   |");
        System.out.println("|---+---+---+---+---+---+---|");
        System.out.println("|   |   |   |   |   |   |   |");
        System.out.println("\\===========================/");
        
    
        boolean x = false;
        while (!x) {
            System.out.println();
            System.out.print("Saisir un nombre : ");
            String nombre = scanner.nextLine();
            while (!isValidNumero(nombre)) {
                System.out.println("\033[31mLe nombre est obligatoire\033[0m");
                System.out.println();
                System.out.print("Saisir un nombre: ");
                nombre = scanner.nextLine();
        }
        if (nombre.equals("1")) {
            colones.get(5).set(1, "@");
        }
        if (nombre.equals("2")) {
            colones.get(5).set(2, "@");
        }
        if (nombre.equals("3")) {
            colones.get(5).set(3, "@");
        }
        if (nombre.equals("4")) {
            colones.get(5).set(4, "@");
        }
        if (nombre.equals("5")) {
            colones.get(5).set(5, "@");
        }
        if (nombre.equals("6")) {
            colones.get(5).set(6, "@");
        }
        if (nombre.equals("7")) {
            colones.get(5).set(7, "@");
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 1; j < 8; j++) {
                tableau += "| " +colones.get(i).get(j) + " ";
            }
            tableau += "|\n|---+---+---+---+---+---+---|\n";
        }
        for (int i = 5; i < 6; i++) {
            for (int j = 1; j < 8; j++) {
                tableau += "| " +colones.get(i).get(j) + " ";
            }
            tableau += "|\n\\===========================/";
        }
        System.out.println(tableau);
        }
    }
}