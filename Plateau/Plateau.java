package Plateau;

import java.util.ArrayList;
import Pion.Pion;

public class Plateau {
    public static void Tableau() {
        System.out.println("------------ Jeu ------------");
        ArrayList<ArrayList<String>> colones = new ArrayList<ArrayList<String>>();
    
        for (int i = 0; i < 6; i++) {
            ArrayList<String> lignes = new ArrayList<String>();
            lignes.add("\n");
            for (int j = 0; j < 7; j++) {
                lignes.add(" ");
            }
            colones.add(lignes);
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
        System.out.println(tableau);
    }
}