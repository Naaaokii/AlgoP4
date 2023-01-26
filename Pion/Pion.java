package Pion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Pion {

    public String joueur; 
    public String forme;
    public String couleur;
    public Pion pion;
    public int x;

    public String getJoueur() {
        return joueur;
    }
    
    public void setJoueur(String joueur) {
        this.joueur = joueur;
    }

    public String getForme() {
        return forme;
    }
    
    public void setForme(String forme) {
        this.forme = forme;
    }

    public String getCouleur() {
        return couleur;
    }
    
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public Pion getPion() {
        return pion;
    }
    
    public void setPion(Pion pion) {
        this.pion = pion;
    }

    public int getX() {
        return x;
    }
    
    public void setX(int x) {
        this.x = x;
    }

    public void enregistrer() throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("Joueurs.csv", true)));
        try {
            pw.println(this.toString());
        } finally {
            pw.close();
        }
    }
}
