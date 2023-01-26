package game.classes;

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

public class Joueur {

    protected static int compteur = 0;
    protected int idJoueur;
    protected int coups = 1;
    protected Pion[] pions;
    protected String symbole;
    protected String couleur;
    protected Jeu jeu;
    protected String nom;
    protected List<Case> histoCoups;

    public static final String SEPARATEUR = ";";

    public Joueur(String symbole){
        idJoueur = compteur;
        compteur++;
        this.symbole = symbole;
        pions = new Pion[21];
        histoCoups = new ArrayList<>();
        Arrays.fill(pions, new Pion(this));
    }

    public Joueur(String symbole, String nom){
        this(symbole);
        this.nom = nom;
    }

    public Joueur(String symbole, String nom, String couleur){
        this(symbole, nom);
        this.couleur = couleur;
        initPions();
    }

    public void setJeu(Jeu jeu){
        this.jeu = jeu;
    }

    public int getCoups() {
        return coups;
    }

    public int getCoups2() {
        return coups-1;
    }

    /**
     * Place une pièce dans la grille.
     * @param nColonne Colonne à laquelle placer la pièce.
     * @return true si pion placé, false si pas de case dispo.
     */
    public boolean placePion(char nColonne){

        Case caseDispo = jeu.caseDispo(nColonne);
        if(caseDispo != null){
            caseDispo.setPion(pions[21-coups]);
            histoCoups.add(caseDispo);
            pions[21-coups]= null;
            coups++;
            return true;
        }
        return false;
    }
    
    public void placePion(){
        placePion(colonneAleatoire('A', 'G'));
    }

    public void initPions(){
        Arrays.fill(pions, new Pion(this));
    }

    public String getSymbole() {
        return symbole;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getNom() {
        return nom;
    }

    /**
     * Obtient la dernière case jouée.
     * @return Case du dernier coup.
     */
    public Case lastCoup(){
        if(histoCoups.size() == 0) return null;
        return histoCoups.get(histoCoups.size()-1);
    }

    protected char colonneAleatoire(char Min, char Max){

        return (char)(Min + (int)(Math.random() * ((Max - Min) + 1)));
    }

}
