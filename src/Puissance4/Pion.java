package Puissance4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;


public class Pion implements Constantes {
    
    private int indiceX;
    private int indiceY;
    private Color couleur;
    
    public Pion (int posX, int posY, Color couleur) {
        
        this.indiceX = posX;
        this.indiceY = posY;
        this.couleur = couleur;
    }
    
    public void afficher(Graphics g) {
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(this.couleur);
        g.fillOval(this.getX()+4, this.getY()+4, DIM_CASE-8, DIM_CASE-8);
    }

    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Pion) {
            Pion c = (Pion)obj;
            return this.getPosX() == c.getPosX() && this.getPosY() == c.getPosY();
        }
        return false;
    }
    
    public void setColor(Color couleur) {
        
        this.couleur = couleur;
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
