package Puissance4;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;


public class Case implements Constantes {
    
    private int indiceX;
    private int indiceY;
    
    public Case (int posX, int posY) {
        
        this.indiceX = posX;
        this.indiceY = posY;
    }
    
    public void AffichageCase(Graphics g) {
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        
        g.drawRect(indiceX, indiceX, DIM_CASE, DIM_CASE);
    }

    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Case) {
            Case c = (Case)obj;
            return this.getPosX() == c.getPosX() && this.getPosY() == c.getPosY();
        }
        return false;
    }
    
    public int getPosX() {
        return this.indiceX;
    }
    
    public void setPosX(int indiceX) {
        this.indiceX = indiceX;
    }
    
    public int getPosY() {
        return this.indiceY;
    }
    
    public void setPosY(int indiceY) {
        this.indiceY = indiceY;
    }
    
    public int getX() {
        return this.indiceX*DIM_CASE;
    }
    
    public int getY() {
        return this.indiceY*DIM_CASE;
    }
    
    public int getLargeur() {
        return DIM_CASE;
    }
    
    public int getHauteur() {
        return DIM_CASE;
    }
    
}
