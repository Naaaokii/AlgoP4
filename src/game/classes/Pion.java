package src.game.classes;

public class Pion {

    protected Joueur joueur;
    protected String symbole;
    protected Case laCase;
    protected String couleur;


    public Case getLaCase(){
        return laCase;
    }

    public void setLaCase(Case laCase) {
        this.laCase = laCase;
    }


    public Pion(Joueur joueur){
        this.joueur = joueur;
        symbole = joueur.getSymbole();
        couleur = joueur.getCouleur();
    }

    public String getSymbole() {
        return symbole;
    }

    public String getCouleur() {
        return couleur;
    }

    public PionStrategique toPionStrategique(){
        return new PionStrategique(joueur, laCase);
    }
}
