package Joueur;
import java.util.Scanner;
import java.util.regex.Pattern;

import java.io.IOException;

public class Joueur_2 {
    private static Scanner scanner = new Scanner(System.in);

    public static void joueur() throws IOException {
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
        System.out.println("--- Forme ---");
        System.out.println("§ - & - @ - #");
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
        System.out.println("2.Vert");
        System.out.println("3.Jaune");
        System.out.println("4.Bleu");
        System.out.print("Saisir la couleur du joueur : ");
        String couleur = scanner.nextLine();
        while (!isValidColor(couleur)) {
            System.out.println("\033[31mCouleur non valide\033[0m");
            System.out.println();
            System.out.print("Saisir la couleur du joueur : ");
            couleur = scanner.nextLine();
        }
        c.setCouleur(couleur);
        c.enregistrer();
        if (couleur.equals(couleur)) {
            System.out.println("Forme et couleur choisie : " + "\033[3" + couleur + "m" + forme + "\033[0m");
        }
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
}
