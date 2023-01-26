package src.game.classes;

import java.util.*;

import game.classes.Case;

public class Joueur {

    protected static int compteur = 0;
    protected int idJoueur;
    protected int coups = 1;
    protected Pion[] pions;
    protected String symbole;
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
        initPions();
    }

    public void setJeu(Jeu jeu){
        this.jeu = jeu;
    }

    public int getCoups() {
        return coups;
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
