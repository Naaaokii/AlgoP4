package src.game.classes;

import java.util.Scanner;
import src.game.classes.*;

public class Ia extends Joueur{
    public Ia(String symbole, String nom) {
        super(symbole, nom);
    }
 /**
     * Pilotage d'un tour du jeu.
     */
    public void tour(){
        char choixColonne;

        choixColonne = colonneAleatoire('A', 'G');

        placePion(choixColonne);
    }
/**
     * Point d'accès au tour.
     */
    @Override
    public void placePion(){
        tour();
    }

    /**
     * Place le pion choisi la grille.
     * @param nColonne Colonne à laquelle placer le pion.
     * @return True si la pièce a pu être placée, false sinon
     */
    @Override
    public boolean placePion(char nColonne) {
        boolean oi = super.placePion(nColonne);
        // Si l'ajout n'a pas fonctionné, aucune stratégie : Placement aléatoire.
        while (!oi);
        return oi;
    }
}
