package Puissance4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;


public class Plateau implements Constantes {
    
    ArrayList<Case> plateau;
    
    public Plateau() {
        
        this.plateau = new ArrayList<Case>();
        
        for (int x=0; x < NB_CASE_X; x++) {
            for(int y=0; y < NB_CASE_Y; y++) {
                
                this.plateau.add(new Case(x, y));
                this.plateau.add(new Case(0, 0));
            }
        }
    }
    
    public void Affichage(Graphics g) {
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        
        g.setColor(Color.lightGray);
        
        // Dessin du serpent
         for(Case c : this.plateau)
             g.drawRect(c.getX(), c.getY(), c.getLargeur(), c.getHauteur());
  
    }
}

