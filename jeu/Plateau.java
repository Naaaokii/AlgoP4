package jeu;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Plateau {
    private static Scanner scanner = new Scanner(System.in);

    public static void Tableau() {
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
        
        boolean choix = false;
        while (!choix) {
            System.out.println();
            System.out.print("Saisir un nombre : ");
            String nombre = scanner.nextLine();
            while (!isValidNumero(nombre)) {
                System.out.print("Saisir un nombre : ");
                nombre = scanner.nextLine();
            }
            
            if (nombre.equals(nombre)) {
                int chiffre = Integer.parseInt(nombre);
                for (int a = 5; a >= 0; a--) {
                    if (colones.get(a).get(chiffre).equals(" ")) {
                        colones.get(a).set(chiffre, "@");
                        break;
                    }
                }
            }
            String tableau = "\n" + "  1   2   3   4   5   6   7  \n" + "\n";
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
            System.out.print("\033[H\033[2J");
            System.out.println(tableau);
        }
    }

    public static boolean isValidNumero(String valid) {
        String validRegex = "^[1-7]$";
        Pattern pat = Pattern.compile(validRegex);
        if (valid == null)
            return false;
        return pat.matcher(valid).matches();
    }
}