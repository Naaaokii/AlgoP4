package src.game.classes;

public class Pion {

    protected Joueur joueur;
    protected String symbole;
    protected Case laCase;


    public Case getLaCase(){
        return laCase;
    }

    public void setLaCase(Case laCase) {
        this.laCase = laCase;
    }


    public Pion(Joueur joueur){
        this.joueur = joueur;
        symbole = joueur.getSymbole();
    }

    public String getSymbole() {
        return symbole;
    }
}
