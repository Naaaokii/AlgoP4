package Puissance4;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;



public class Game implements Constantes {
       
    private final Plateau plateau;
    private Curseur curseur;
    private ArrayList<Pion> listePions;
    
    private Color couleurPionBleu;
    private Color couleurPionRouge;
    
    private int compteurCouleur;
    private boolean isPartieFinie;
    
    public Game() {
        
        this.couleurPionBleu = Color.blue;
        this.couleurPionRouge = Color.red;
        this.plateau = new Plateau();
        this.curseur = new Curseur(4);
        this.listePions = new ArrayList<Pion>();
        this.compteurCouleur = 0;
        this.isPartieFinie = false;

    }

    public void calcul() {
        
        this.curseur.calcul();
        isFinDePartie();
    }

    public void affichage(Graphics g) {
        
        if(GRIILE_ON)
            this.plateau.Affichage(g);
        
        // Dessin des pions
        for (Pion p : this.listePions) {
            
            p.afficher(g);
            System.out.println("size"+this.listePions.size());
        }
        
        g.setColor(Color.BLACK);
        this.curseur.affichage(g);
        
        if(isPartieFinie) {
            
            g.setColor(Color.red);
            g.drawString("partie finie", 100, 100);
        }
        
    }
    
    public void ajouterPion() {
        
        Pion pion = new Pion(this.curseur.getPosX(), NB_CASE_Y-1, this.couleurPionBleu);
        
        for (Pion p : this.listePions) {
            
            if(pion.equals(p))
                pion.setPosY(p.getPosY()-1);
        } 
        
        if(this.compteurCouleur % 2 == 0)
            pion.setColor(couleurPionRouge);

        if(pion.getPosY() >= 0)
            this.listePions.add(pion);
        
        this.compteurCouleur++;
    }
    
    public void gestionDuClavier(KeyEvent ke) {
        
        if(ke.getKeyCode() == KeyEvent.VK_RIGHT)
            this.curseur.deplacerCurseur(Curseur.Direction.VERS_LA_DROITE);
        else if(ke.getKeyCode() == KeyEvent.VK_LEFT)
            this.curseur.deplacerCurseur(Curseur.Direction.VERS_LA_GAUCHE);
        else if(ke.getKeyCode() == KeyEvent.VK_DOWN) {
            this.ajouterPion();
        }
    }
    
    public boolean isFinDePartie() {
        
        for (Pion p : this.listePions) {
            
            
        }  
            
        if(this.listePions.size() >= NB_CASE_X*NB_CASE_Y)
            this.isPartieFinie = true;
            
        return this.isPartieFinie;
    }
  
}
