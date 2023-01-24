package jeu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.text.ParseException;

public class Joueur {

    private static final String SEPARATEUR = ";";

    private String prenom;
    private String couleur;
    private String niveau;

    public String getPrenom() {
        return prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCouleur() {
        return couleur;
    }
    
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getForme() {
        return niveau;
    }
    
    public void setForme(String niveau) {
        this.niveau = niveau;
    }

    public void enregistrer() throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("joueurs.csv", true)));
        try {
            pw.println(this.toString());
        } finally {
            pw.close();
        }
    }

    public static ArrayList<Joueur> lister() throws FileNotFoundException, IOException, ParseException {
        ArrayList<Joueur> list = new ArrayList<>();
        try (BufferedReader buf = new BufferedReader(new FileReader("joueurs.csv"))) {
            String ligne = buf.readLine();
            while (ligne != null) {
                String[] tab = ligne.split(SEPARATEUR);
                Joueur c = new Joueur();
                c.setPrenom(tab[0]);
                c.setCouleur(tab[1]);
                c.setForme(tab[2]);
                list.add(c);
                ligne = buf.readLine();
            }
        }
        return list;
    }
    
    @Override
        public String toString() {
            StringBuilder build = new StringBuilder();
            build.append(this.getPrenom());
            build.append(SEPARATEUR);
            build.append(this.getCouleur());
            build.append(SEPARATEUR);
            build.append(this.getForme());
            return build.toString();
        }
}