package game.classes;

public class Pion {

    protected Joueur joueur;
    protected String couleur;
    protected Case laCase;


    public Case getLaCase(){
        return laCase;
    }

    public void setLaCase(Case laCase) {
        this.laCase = laCase;
    }


    public Pion(Joueur joueur){
        this.joueur = joueur;
        couleur = joueur.getCouleur();
    }

    public String getCouleur() {
        return couleur;
    }
}
