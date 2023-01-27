package game.classes;

import java.util.ArrayList;
import java.util.List;

public class PionStrategique extends Pion{

    private List<Case> casesAPrendre = new ArrayList<>();
    private int valeur;
    private static final int PTS_CASE_VIDE = 10;
    private static final int PTS_CASE_AMIE = 30;
    public static final int POINTS = 0;
    public final int BLOQUE = 1;
    public static final int ALLIGNEMENT = 2;


    /**
     * @param joueur
     * @param laCase
     * @author Eloi
     */
    public PionStrategique(Joueur joueur, Case laCase) {
        super(joueur);
        setLaCase(laCase);
    }

    /**
     * @return valeur
     * @author Eloi
     */
    public int getValeur() {
        return valeur;
    }

    /**
     * @return
     * @author Eloi
     */
    public List<Case> getCasesAPrendre() {
        return casesAPrendre;
    }


    /**
     * Calcule la valeur stratégique du pion
     * 10pts pour chaque case dispo
     * 20pts pour chaque case adjacente du même symbole, (1.5 pour 2 du même symbole sur une ligne/col/diag).
     * @return La valeur déterminée.
     * @author Eloi
     */
    public int score(){
        this.casesAPrendre.clear();
        var score = 0;
        String[] directions = Direction.getAxes();
        var dir = 0;
        do{
            score += verifie2Sens(laCase, Direction.getDirections(directions[dir++]))[POINTS];
        }while (dir <= 3);
        valeur = score;
        return score;
    }

    /**
     * Parcourt une direction en partant d'une case, à la recherhce des cases de la même symbole.
     * @param direction Couple de directions qui vont être cherchées. Utiliser les méthodes de classe Direction.
     * @return Le score total des deux sens sd'une direction.
     * @author Eloi
     */
    public int[] verifie2Sens(Case laCase, String[] direction){
        int[] score2Sens = {0, 0, 0};
        int[] scoreTemp;
        for(int i = 0; i <2; i ++){

             scoreTemp = verifieUnSens(laCase, direction[i], new int[]{0, 0, 0});
             score2Sens[POINTS] += scoreTemp[POINTS];
             score2Sens[BLOQUE] += scoreTemp[BLOQUE];
             score2Sens[ALLIGNEMENT] += scoreTemp[ALLIGNEMENT];
        }
        if(score2Sens[BLOQUE] == -2){
            score2Sens[POINTS] = 0; // Pions ennemies de part et d'autre
            score2Sens[ALLIGNEMENT] = 0;
        }
        if(score2Sens[ALLIGNEMENT] == 2 ){
            score2Sens[POINTS]+=1000; // Trois pions allignées
        } 
        return score2Sens;
    }

    /**
     *
     * @param laCase laCase Case de référence (utilisé pour la récursivité de la fonction).
     * @param direction Direction dans laquelle chercher.
     * @param score 1ère valeur : Points de la direction prise: 10pts si case dipo, 20pts par pion amie.
     *              2è valeur : -1 si mur/pion ennemie.
     *              3è Valeur : Nombre de pions amies rencontrées.     *
     * @return Données de scoring.
     * @author Eloi
     */
    public int[] verifieUnSens(Case laCase, String direction, int[] score){
        Case nextCase = laCase.getVoisins(direction);
        if(nextCase != null){
            if (nextCase.getPion() != null){
                if(nextCase.getPion().getSymbole().equals(laCase.getPion().getSymbole())){
                    score[POINTS]+= PTS_CASE_AMIE; // Pion ami
                    score[ALLIGNEMENT] += 1;
                    score = verifieUnSens(nextCase, direction, score);
                }else{
                    score[BLOQUE] = -1;
                    return score;
                }
            }else { // Case dispo
                if(!plafondAtteint(laCase, direction)){
                    casesAPrendre.add(nextCase);
                    Case sautDeCase = nextCase.getVoisins(direction);
                    if (sautDeCase != null && sautDeCase.getPion() != null && sautDeCase.getPion().getSymbole().equals(laCase.getPion().getSymbole())){
                        score[POINTS] += PTS_CASE_AMIE;
                        score[ALLIGNEMENT] += 1;
                    }
                    score[POINTS]+= PTS_CASE_VIDE;
                    return score;
                }
            }
        }else{ //Bordure : Pas de possibilités.
            score[BLOQUE] = -1;
            return score ;
        }
        return score;
    }

    // Problème avec les diagonales
    /**
     *
     * @param laCase
     * @return True si le plafond est atteint (pas d'allignement colonne possible), fale sinon.
     * @author Eloi
     */
    private boolean plafondAtteint(Case laCase, String direction){
        if (direction.equals(Direction.HAUT) && laCase.idLigne() >= 3){
            int allignement = verifieUnSens(laCase, Direction.BAS, new int[]{0,0,0})[ALLIGNEMENT];
            return 6 - (laCase.idLigne() - allignement) < 3; // Calcul de la distance entre la première de la colonne en cours et le plafond
        }
        return false;
    }
}