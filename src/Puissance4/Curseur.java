package Puissance4;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;


public class Curseur implements Constantes {
    
    private int indiceX;
    private Direction nouvelleDirection;
    
    public Curseur(int posX) {
        
        this.indiceX = posX;
    }
    
    public void calcul() {

    }
    
    public void affichage(Graphics g) {
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2.fillOval(this.indiceX*DIM_CASE+DIM_CASE/2-4, 10, 8, 8);
    }

    public void deplacerCurseur(Direction nouvelleDir) {

        this.nouvelleDirection = nouvelleDir;
        
        if(this.nouvelleDirection == Direction.VERS_LA_DROITE)
            this.setPosX(this.getPosX()+1);
        else if(this.nouvelleDirection == Direction.VERS_LA_GAUCHE)
            this.setPosX(this.getPosX()-1);
        
        if(this.getPosX() < 0)
            this.setPosX(0);
        if(this.getPosX() > NB_CASE_X)
            this.setPosX(NB_CASE_X-1);
    }
    
     public void setPosX(int indiceX) {
        this.indiceX = indiceX;
    }
    
    public int getPosX() {
        return this.indiceX;
    }
    
    public int getX() {
        return this.indiceX*DIM_CASE;
    }
}
