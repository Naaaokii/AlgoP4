package game.classes;

public class Direction {

    public static final String GAUCHE = "GAUCHE";
    public static final String DROITE = "DROITE";

    public static final String HAUT = "HAUT";
    public static final String BAS = "BAS";

    public static final String HAUT_GAUCHE = "HAUT_GAUCHE";
    public static final String HAUT_DROITE = "HAUT_DROITE";

    public static final String BAS_GAUCHE = "BAS_GAUCHE";
    public static final String BAS_DROITE = "BAS_DROITE";

    public static final String HORIZONTAL = "HORIZONTAL";
    public static final String VERTICAL = "VERTICAL";
    public static final String DIAGONALE_1 = "DIAGONALE_1";
    public static final String DIAGONALE_2 = "DIAGONALE_2";


    /**
     * Ligne horizontale de gauche à droite
     * @return Le couple de directions Gauche Droite
     * @author Eloi
     */
    public static String[] HORIZONTAL(){
        return new String[]{GAUCHE, DROITE};
    }

    /**
     * Ligne verticale de bas en haut
     * @return Le couple de directions Bas Haut
     * @author Eloi
     */
    public static String[] VERTICAL(){
        return new String[] {BAS, HAUT};
    }

    /**
     * Diagonale allant du haut à gauche au bas à droite.
     * @return Le couple de directions Haut-Gauche Bas-Droite
     * @author Eloi
     */
    public static String[] DIAGONALE_1(){
        return new String[] {HAUT_GAUCHE, BAS_DROITE};
    }

    /**
     * Diagonale allant du bas gauche au haut droite.
     * @return Le couple de directions Bas-Gauche Haut-Droite
     * @author Eloi
     */
    public static String[] DIAGONALE_2() {
        return new String[]{BAS_GAUCHE, HAUT_DROITE};
    }

    /**
     * Directions acceptées : HORIZONTAL, VERTICAL, DIAGONALE_1, DIAGONALE_2
     * @param axe Le String d'une axe
     * @return Le couple de directions associé.
     * @author Eloi
     */
    public static String[] getDirections (String axe){
        axe = axe.toUpperCase();
        String[] lesDirections = {null, null};
        switch (axe) {
            case HORIZONTAL -> lesDirections = HORIZONTAL();
            case VERTICAL -> lesDirections = VERTICAL();
            case DIAGONALE_1 -> lesDirections = DIAGONALE_1();
            case DIAGONALE_2 -> lesDirections = DIAGONALE_2();
        }
        return lesDirections;
    }

    public static String getAxe(String direction){
        direction = direction.toUpperCase();
        String axe = null;
        switch (direction){
            case HAUT -> axe = VERTICAL;
            case BAS -> axe = VERTICAL;
            case GAUCHE -> axe = HORIZONTAL;
            case DROITE -> axe = HORIZONTAL;
            case HAUT_GAUCHE -> axe = DIAGONALE_1;
            case BAS_DROITE -> axe = DIAGONALE_1;
            case HAUT_DROITE -> axe = DIAGONALE_2;
            case BAS_GAUCHE -> axe = DIAGONALE_2;
        }
        return axe;
    }

    /**
     * Retourne toutes les directions (Horizontal, Vertical, ...)
     * @return Array de directions.
     * @author Eloi
     */
    public static String[] getAxes(){
        return new String[]{"HORIZONTAL", "VERTICAL", "DIAGONALE_1", "DIAGONALE_2"};
    }

    /**
     * Compare caseReference par rapport à caseComparee
     * Ex: A1, B1 = DROITE
     * @param caseReference Case de référence
     * @param caseComparee Case à laquelle comparer
     * @return Direction, null si pas voisin.
     * @author Eloi
     */
    public static String compareCase(Case caseReference, Case caseComparee){
        int diffColonne = caseReference.idColonne()-caseComparee.idColonne();
        int diffLigne = caseReference.idLigne()-caseComparee.idLigne();
        if(diffColonne <= -1){
            if(diffLigne == 0){
                return DROITE;
            } 
            if(diffLigne == diffColonne){
                return HAUT_DROITE;
            } 
            if(diffColonne == -1*diffLigne){
                return BAS_DROITE;
            } 
            else{
                return null;
            } 
        }else
            if (diffColonne == 0){
                if (diffLigne <= -1){
                    return HAUT;
                } 
                if(diffLigne >= 1){
                    return BAS;
                } 
                else{
                    return null;
                } 
            }else{ //>=1
                    if(diffLigne == 0){
                        return GAUCHE;
                    } 
                    if(-1*diffColonne==  diffLigne){
                        return HAUT_GAUCHE;
                    } 
                    if (-1*diffLigne == -1*diffColonne){
                        return BAS_GAUCHE;
                    } 
                }
        return null;
    }
}