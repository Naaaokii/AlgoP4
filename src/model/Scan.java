package src.model;

import java.util.Scanner;

public class Scan {
    /**
     * Permet de récupérer ce que saisie l'utilisateur
     * @return La chaine de caractères saisie
     */
    public static String saisieUtilisateur() {
        Scanner scanner = new Scanner(System.in);
        String saisieUtilisateur = scanner.nextLine();
        return saisieUtilisateur;
    }
}
