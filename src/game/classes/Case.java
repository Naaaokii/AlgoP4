package game.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Case {
    Jeu jeu;
    /*
    Cases : Identifiées par concaténation colonne+ligne
     */
    private String idCase;
    private Pion pion;
    private List<Case> voisins;


    /**
     * @param jeu 
     * @param colonne de type str
     * @param ligne de type str
     * @author Dounya
     */
    public Case(Jeu jeu, String colonne, String ligne){
        this.jeu = jeu;
        idCase = colonne + ligne;
        pion = null;
        voisins = new ArrayList<>();

    }

    /**
     * @return le pion
     * @author Dounya
     */
    public Pion getPion() {
        return pion;
    }

    /**
     * Met une pièce sur la case.
     * @param pion
     * @author Dounya
     * Ne renvoie rien
     */
    public void setPion(Pion pion) {
        this.pion = pion;
        pion.setLaCase(this);
    }

    /**
     * Enlève la pièce de la case.
     * @author Dounya
     * Ne renvoie rien
     */
    public void setPion(){
        this.pion = null;
    }

    /**
     * @return l'id de la case
     * @author Dounya 
     */
    public String getIdCase() {
        return idCase;
    }

    /**
     * @return l'id de la colonne de la case
     * @author Dounya
     */
    public char idColonne(){
        return idCase.charAt(0);
    }

    /**
     * @return l'id de la ligne de la case
     * @author Dounya
     */
    public int idLigne(){
        return Integer.parseInt(idCase.substring(1));
    }



    /**
     * Récupérer les voisins d'un pion et les mets dans voisins
     * Ne renvoie rien
     * @author Eloi
     */
    public void setVoisins(){
        if(voisins.isEmpty()){
            char colonne = this.idColonne();
            int ligne = this.idLigne();

            // Haut
            if(ligne != 6){
                if(colonne !='A'){
                    voisins.add(jeu.getCase((char)(colonne-1), ligne+1)); //Gauche
                }else{
                    voisins.add(null);
                } 
                voisins.add(jeu.getCase(colonne, ligne+1)); // Milieu
                if(colonne !='G'){
                    voisins.add(jeu.getCase((char)(colonne+1), ligne+1)); // Droite
                }else{
                    voisins.add(null);
                } 
            }else{
                for(var k=0; k<3;k++){
                    voisins.add(null);
                }
            }

            // Gauche
            if(colonne != 'A'){
                voisins.add(jeu.getCase((char)(colonne-1), ligne));
            }else{
                voisins.add(null);
            } 

            // Droite
            if(colonne != 'G'){
                voisins.add(jeu.getCase((char)(colonne+1), ligne));
            }else{
                voisins.add(null);
            } 

            // Bas
            if(ligne != 1){
                if(colonne !='A'){
                    voisins.add(jeu.getCase((char)(colonne-1), ligne-1)); //Gauche
                }else{
                    voisins.add(null);
                } 
                voisins.add(jeu.getCase(colonne,ligne-1)); // Milieu
                if(colonne !='G'){
                    voisins.add(jeu.getCase((char)(colonne+1),ligne-1)); // Droite
                } 
                else{
                    voisins.add(null);
                } 
            }
            else{
                for(var k=0; k<3;k++){
                    voisins.add(null);
                }
            }
        }
    }

    /**
     * Retourne la case voisinne dans une direction spécifiée.
     * @param direction exemples : "HAUT_GAUCHE", "DROITE", "BAS".
     * @return La case voisine.
     * @author Eloi
     */
    public Case getVoisins(String direction){
        direction = direction.toUpperCase(Locale.ROOT);
        Case voisin;
        switch (direction) {
            case "HAUT_GAUCHE" -> voisin = voisins.get(0);
            case "HAUT" -> voisin = voisins.get(1);
            case "HAUT_DROITE" -> voisin = voisins.get(2);
            case "GAUCHE" -> voisin = voisins.get(3);
            case "DROITE" -> voisin = voisins.get(4);
            case "BAS_GAUCHE" -> voisin = voisins.get(5);
            case "BAS" -> voisin = voisins.get(6);
            case "BAS_DROITE" -> voisin = voisins.get(7);
            default -> voisin = this;
        }
        return voisin;
    }


    /**
     * Renvoie le voisin
     * @return la List<Case> voisins
     * @author Eloi
     */
    public List<Case> getVoisins(){
        return voisins;
    }

    /**
     * Vérifie que les voisins d'un pion ont le même symbole
     * @param symbole type str 
     * @return la liste<Case> de ses voisins qui lui sont identiques 
     * @author Eloi
     */
    public List<Case> verifieVoisins(String symbole){
        List<Case> voisinsIdentiques = new ArrayList<>();

        for (Case voisin : voisins) {
            if(voisin.getPion() != null && voisin.getPion().getSymbole().equals(symbole)){
                voisinsIdentiques.add(voisin);
            }
        }
        return voisinsIdentiques;
    }
    /**
     * Compte les pièces allignées dans toutes les directions.
     * @return un entier 
     * @author Eloi
     */
    public int compteAllignements(){
        int allignement;
        String[] directions = {"HORIZONTAL", "VERTICAL", "DIAGONALE_1", "DIAGONALE_2"};
        var dir = 0;
        do{
            allignement = 0;
            allignement += this.verifie2Sens(Direction.getDirections(directions[dir++])); // Peut-être que je peux l'alléger ?
            if(allignement ==3){
                break;
            } 
        }while (dir <= 3);

        return allignement;
    }

    /**
     * Parcourt une direction en partant d'une case, à la recherhce des cases de la même symbole.
     * @param direction Couple de directions qui vont être cherchées. Utiliser les méthodes de classe Direction.
     * @return Le nombre de pions du même symbole des deux côtés de la direction.
     * @author Eloi
     */
    public int verifie2Sens(String[] direction){
        var score = 0;
        for(var k=0; k<2; k++){
            score += verifieUnSens(this, direction[k], 0);
        }
        return score;
    }

    /**
     * Vérifie et renvoie les pions du même symbole dans une direction
     * @param laCase laCase Case de référence (utilisé pour la récursivité de la fonction).
     * @param direction Direction dans laquelle chercher.
     * @param score Nombre de pions de même symbole (sans compter la case de ref).
     * @return Nombre de pions du même symbole dans la direction.
     * @author Eloi
     */
    public int verifieUnSens(Case laCase, String direction, int score){
        Case nextCase = laCase.getVoisins(direction);
        if(nextCase != null && nextCase.getPion() != null && nextCase.getPion().getSymbole().equals(pion.getSymbole())){
            score++;
            score = verifieUnSens(nextCase, direction, score);
        }
        return score;
    }
}