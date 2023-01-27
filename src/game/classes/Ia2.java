package src.game.classes;

public class Ia2 extends Joueur{
    public Ia2(String symbole, String nom) {
        super(symbole, nom);
    }
 /**
     * Pilotage d'un tour du jeu.
     */
    public void tour(){
        char choixColonne;
        if (Joueur(placePion())) {
            bloquerJoueur();
        } else {choixColonne = colonneAleatoire('A', 'G');
        placePion(choixColonne);
        }
    }

    private void bloquerJoueur(char[][] grille) {
        // Boucle à travers chaque ligne de la grille
        for (int i = 0; i < grille.length; i++) {
            // Boucle à travers chaque colonne de la grille
            for (int j = 0; j < grille[i].length; j++) {
                // Vérifie si la case actuelle est occupée par le joueur
                if (grille[i][j] == 'J') {
                    // Vérifie si les trois cases suivantes sont également occupées par le joueur
                    if (j <= grille[i].length - 4 && grille[i][j + 1] == 'J' && grille[i][j + 2] == 'J' && grille[i][j + 3] == 'J') {
                        // Si oui, bloque le joueur en plaçant un pion à côté de la série de 3 pions
                        grille[i][j + 4] = 'IA';
                        return;
                    }
                    // Vérifie si les trois cases précédentes sont également occupées par le joueur
                    if (j >= 3 && grille[i][j - 1] == 'J' && grille[i][j - 2] == 'J' && grille[i][j - 3] == 'J') {
                        // Si oui, bloque le joueur en plaçant un pion à côté de la série de 3 pions
                        grille[i][j - 4] = 'IA';
                        return;
                    }
                }
            }
        }
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