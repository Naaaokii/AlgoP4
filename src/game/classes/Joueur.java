package game.classes;

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

public class Joueur implements Comparable<Joueur> {

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

    public Joueur(String nom, String symbole){
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

    public void setNom(String nom){
        this.nom = nom.replaceFirst(".",(nom.charAt(0)+"").toUpperCase());
    }

    public int getCoups() {
        return coups;
    }

    public int getCoups2() {
        return coups - 1;
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
        if(histoCoups.size() == 0){
            return null;
        } 
        return histoCoups.get(histoCoups.size()-1);
    }

    protected char colonneAleatoire(char Min, char Max){

        return (char)(Min + (int)(Math.random() * ((Max - Min) + 1)));
    }

    // Déclarer une méthode nommée "sauvegarderTop10" qui peut lever une IOException
    /**
     * Permet d'inscrire les 10 meilleurs joueurs dans le fichier csv
     * @throws IOException
     * Ne renvoie rien
     */
    public void sauvegarderTop10() throws IOException { //exception fichier 
        
        // Créer un objet PrintWriter qui écrira dans un fichier nommé "top10.csv" en utilisant l'option "true" pour ajouter du contenu à la fin du fichier
        PrintWriter printwriter = new PrintWriter(new BufferedWriter(new FileWriter("scoreTop10.csv", true)));
        
        try {
            // Écrire la chaîne de caractères représentant l'objet courant dans le fichier
            printwriter.println(this.toString());
        } finally {
            // Fermer le flux de données lorsque la méthode est terminée
            printwriter.close();
        }
    }

    public static ArrayList<String> lister() throws FileNotFoundException, IOException, ParseException {
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader buf = new BufferedReader(new FileReader("scoreTop10.csv"))) {
            String ligne = buf.readLine();
            while (ligne != null) {
                String[] tab = ligne.split(SEPARATEUR);
                String ensemble;
                if (Integer.parseInt(tab[1]) > 9){
                    ensemble = tab[0] + " " + tab[1];
                }else{
                    ensemble = tab[0] + "  0" + tab[1];
                }
                list.add(ensemble);
                ligne = buf.readLine();
            }
        }
        return list;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        // Créer un objet StringBuilder vide
        StringBuilder builder = new StringBuilder();
        
        // Ajouter le nom de l'objet suivi du séparateur
        builder.append(getNom());
        builder.append(SEPARATEUR);
        
        // Ajouter les coups de l'objet suivi du séparateur
        builder.append(getCoups());
        
        // Renvoyer la chaîne de caractères contenue dans l'objet StringBuilder
        return builder.toString();
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Joueur joueur) {
        return this.getNom().compareTo(joueur.getNom());
    }
}
