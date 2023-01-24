package game.classes;

import java.util.*;

public class Ia extends Joueur {

    private static final int NB_PIONS_A_TRAITER = 3;

    public List<PionStrategique> getPionsStrategiques() { // juste pour le test
        return pionsStrategiques;
    }

    private List<PionStrategique> pionsStrategiques;
    private List<PionStrategique> pionsAdversaires = new ArrayList<>();
    private Joueur adversaire;


    public Ia(String couleur, String nom) {
        super(couleur, nom);
        pionsStrategiques = new ArrayList<>();
    }

    /**
     * Ajout de le dernier pion adversaire à la watchlist.
     */
    public void ajoutDernierCoupAdversaire(){
        Case lastCoupAdversaire = adversaire.lastCoup();
        if(lastCoupAdversaire != null) pionsAdversaires.add(lastCoupAdversaire.getPion().toPionStrategique());
    }

    /**
     * Ajoute l'adversaire, c-à-d l'autre joueur de Jeu.
     */
    private void setAdversaire(){
        if(jeu.getJoueur1() == this){
            this.adversaire = jeu.getJoueur2();
        }
        else this.adversaire = jeu.getJoueur1();
    }

    /**
     * Pilotage d'un tour du jeu.
     */
    public void tour(){
        char choixColonne;

        if(coups==1) setAdversaire();

        //Ajoute le dernier coup de l'adversaire dans la watchlist de ses pièces stratégiques.
        ajoutDernierCoupAdversaire();

        //Debut du match : Pions au hasard dans les cases centrales.
        if(coups <= 2){
            choixColonne = colonneAleatoire('C', 'E');
        }
        // Puis détermine la meilleure case, en fonction du jeu actuel.
        else {
            refreshValeursStrategiques(pionsStrategiques);
            refreshValeursStrategiques(pionsAdversaires);
            choixColonne = choixStrategie();
        }
        placePion(choixColonne);
    }

    /**
     * Détermine s'il vaut mieux se défendre (en cas de défaite imminente) ou attaquer.
     * @return Colonne à laquelle il vaut mieux placer le pion.
     */
    public char choixStrategie(){
        char meilleurCoupAdverse = caseLaPlusStrat(pionsAdversaires);

        // Defense
        if(verifieVictoire(meilleurCoupAdverse, adversaire)){
            return meilleurCoupAdverse;
        }else{ //Attaque
            return caseLaPlusStrat(pionsStrategiques);
        }
    }

    /**
     * Regarde les trois pions les plus stratégiques.
     * Si une case à conquérir est à portée, la choisit.
     * Sinon, choisit la case dont la portée est la plus proche parmi ces trois cases.
     * @return Char représentant la colonne la plus stratégique à jouer.
     */
    private char caseLaPlusStrat(List<PionStrategique> listePionsStrategiques){

        Pion choixPion = null;
        int nb = NB_PIONS_A_TRAITER;

        if (listePionsStrategiques.size() < 3){
            nb = listePionsStrategiques.size();
        } 

        var distanceMin = 7;
        var choixColonne = 'D';

        for (int i = 0; i < nb; i++){ // On vérifie les pions stratégiques
            
            PionStrategique pionStrategique = listePionsStrategiques.get(i);

            // Si le pion a une valeur "gagnante" (+1000), on retourne la colonne où placer le pion final.
            if (pionStrategique.getValeur() > 1000){
                for (Case caseAPrendre: pionStrategique.getCasesAPrendre()){
                    if(testeVictoire(caseAPrendre, pionStrategique.joueur)){
                        return caseAPrendre.idColonne();
                    }
                }
            }
            // Si pas gagnante
            for (Case caseAPrendre: pionStrategique.getCasesAPrendre()) {
                Case caseDispo = jeu.caseDispo(caseAPrendre.idColonne());

                // Nombre de cases entre la case à prendre et la case sur laquelle on va tomber.
                int distance = caseAPrendre.idLigne() - caseDispo.idLigne();

                // Si elle est dispo immédiatement, on retourne la case où placer la pièce.
                if(distance == 0){
                    choixColonne = caseAPrendre.idColonne();
                    if(!verifieSiBloque(pionStrategique.getLaCase(), caseDispo)){
                        return caseAPrendre.idColonne();
                    }
                }
                // Sinon, on garde la case dont la distance est la plus petite.
                else if(distance < distanceMin){
                    distanceMin = distance;
                    choixPion = pionStrategique;
                    choixColonne = caseAPrendre.idColonne();
                }
            }
        }

        if(choixPion == null){
            caseLaPlusStrat(listePionsStrategiques);
        }
        return choixColonne;
    }

    /**
     * Verifie si le chemin est bloqué dans l'axe de caseRef->caseATester
     * ex: caseRef A1, caseATesterB1, vérifie l'axe HORIZONTAL pour trouver un blocage.
     * @param caseRef Case de référence
     * @param caseATester Case à tester.
     * @return True si blocage des deux côtés de l'axe, false sinon.
     */
    public boolean verifieSiBloque(Case caseRef, Case caseATester) {
        Case caseDispo = jeu.caseDispo(caseATester.idColonne()); // Pas  utile (déjà testé dans caseLaPlusStrat)

        if(caseDispo != null){
            PionStrategique fauxPion = new PionStrategique(this, caseDispo);
            caseDispo.setPion(fauxPion);
            String direction = Direction.compareCase(caseRef, caseATester);
            String axe = Direction.getAxe(direction);
            var bloque = 0;

            bloque += fauxPion.verifie2Sens(caseDispo, Direction.getDirections(axe))[fauxPion.BLOQUE];
            caseDispo.setPion();
            return bloque == -2; // true (bloqué) si 2 blocages (-2), false pas bloqué.
        }
        return true;
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
        if(oi) {
            pionsStrategiques.add(lastCoup().getPion().toPionStrategique());

        }
        else{ // Si l'ajout n'a pas fonctionné, aucune stratégie : Placement aléatoire.
            do{
                oi = super.placePion(colonneAleatoire('A', 'G'));
            }while (!oi);
        }
        return oi;
    }

    /**
     * Simule le placement d'une pièce de l'adversaire.
     * @param nColonne Colonne où placer une "fausse pièce"
     * @return True si victoire de l'adversaire, sinon False.
     */
    private boolean verifieVictoire(char nColonne, Joueur joueurATester){
        Case caseDispo = jeu.caseDispo(nColonne);
            if(caseDispo != null){
                return testeVictoire(caseDispo, joueurATester);
            }
        return false;

    }

    /**
     * Simule le placement d'une pièce de l'adversaire sans la physique de la pièce qui tombe (sans tester les cases inférieures)
     * @return True si victoire de l'adversaire, sinon False.
     */
    private boolean testeVictoire(Case laCase, Joueur joueurATester){
        Pion fauxPion = new Pion(joueurATester);
        laCase.setPion(fauxPion);
        boolean victoire = jeu.finTour(laCase);
        laCase.setPion();
        return victoire;
    }

    /**
     * Rafraichit la liste des pièces stratégie :
     * Actualise les valeurs de chaque pièce
     * Enlève les pièces de valeur 0
     */
    private void refreshValeursStrategiques(List<PionStrategique> listePionsStrategiques){
        List<PionStrategique> aEnlever = new ArrayList<>();
        for (PionStrategique pionStrat: listePionsStrategiques) {
            pionStrat.score();
            if(pionStrat.getValeur() ==0) aEnlever.add(pionStrat);
        }
        for (PionStrategique pionStrategique : aEnlever) listePionsStrategiques.remove(pionStrategique);
        listePionsStrategiques.sort(new CompareValeurs());

    }

}
