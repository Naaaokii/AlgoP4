package Puissance4;


public interface Constantes {

    public final static int DELAI_RAFFRAICHISSEMENT = 25;
    
    public final static int NB_CASE_X = 7;
    public final static int NB_CASE_Y = 6;
    public final static int DIM_CASE = 40;
    
    public final static boolean GRIILE_ON = true;

    public final static String GAME_OVER = "game over";
    public final static String VERSION = "1.0";
    public final static String TITRE = "Puissance 4 avec Java2D";
    
    public enum Direction {
        
      VERS_LA_DROITE,
      VERS_LE_BAS,
      VERS_LA_GAUCHE;
    }
      
}
