package game.classes;

public class Pion {

    protected Joueur joueur;
    protected String symbole;
    protected Case laCase;
    protected String couleur;


    /**
     * Renvoie une case
     * @return la case
     * @author Dounya
     */
    public Case getLaCase(){
        return laCase;
    }

    /**
     * @param laCase
     * Ne renvoie rien
     * @author Dounya
     */
    public void setLaCase(Case laCase) {
        this.laCase = laCase;
    }


    /**
     * @param joueur
     * @author Eloi
     */
    public Pion(Joueur joueur){
        this.joueur = joueur;
        symbole = joueur.getSymbole();
        couleur = joueur.getCouleur();
    }

    /**
     * Renvoie le symbole
     * @return symbole
     * @author Dounya
     */
    public String getSymbole() {
        return symbole;
    }

    /**
     * Renvoie la couleur
     * @return couleur
     * @author Dounya
     */
    public String getCouleur() {
        return couleur;
    }

    /**
     * @return 
     * @author Eloi
     */
    public PionStrategique toPionStrategique(){
        return new PionStrategique(joueur, laCase);
    }
}
