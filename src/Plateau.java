public class Plateau {

    

    private char[][] plateau = {
        {'-','-','-','-','-','-','-'},
        {'-','-','-','-','-','-','-'},
        {'-','-','-','-','-','-','-'},
        {'-','-','-','-','-','-','-'},
        {'-','-','-','-','-','-','-'},
        {'-','-','-','-','-','-','-'}
        };


    private final int nbLignes = 6;

    private final int nbColonnes = 7;

    public int getNbLignes() {
        return nbLignes;
    }

    public int getNbColonnes() {
        return nbColonnes;
    }

    public char[][] getPlateau() 
    {
        return plateau;
    }

    public void setPlateau(char[][] plateau) 
    {
        this.plateau = plateau;
    }

    public char getCase(int ligne, int colonne)
    {
        return this.plateau[ligne][colonne];
    }

    public void setCase(int ligne, int colonne,char car)
    {
        this.plateau[ligne][colonne] = car;
    }

    public void afficher()
    {
        for(char[] i : this.getPlateau())
        {
            for(char j : i )
            {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public boolean insererPion(int colonne, char pion)
    {
        int lignes = nbLignes;
        char caseActuelle = 'X';
        while(caseActuelle != 'O')
        {
            caseActuelle = this.getCase(lignes, colonne);
            if(caseActuelle != 'O'){
                lignes--;
            }  
            if(lignes < 0){
                return false;
            }     
        }
        this.setCase(lignes,colonne,pion);
        return true;
    }

}
