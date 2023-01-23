import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) 
	{
		Plateau mainGrille = new Plateau();
		Game puissance4 = new Game(mainGrille);
		Scanner sc = new Scanner(System.in);
		String nom;
		Joueur[] tabJoueur = new Joueur[2];
		String pion = new String("OX");
		int i = 0;
		System.out.println("--------------- Puissance 4 ! ---------------");
		
		for(int j = 1; j <= 2; j++)
		{
            if (j == 1){
                System.out.println("Entrez le nom du premier joueur :");
            }else{
                System.out.println("Entrez le nom du second joueur :");
            }
			nom = sc.nextLine();
			Joueur joueur = new Joueur(nom,pion.charAt(j-1));
			tabJoueur[j-1] = joueur;
		}
		mainGrille.afficher();
		
		while(true)
		{
			tabJoueur[i].jouer(mainGrille, puissance4);
			mainGrille.afficher();
			if(puissance4.verifGagne(mainGrille))
			{
				puissance4.finGame(tabJoueur[i]);
				break;
			}
				
			
			if(i == 0) i++;
			else if(i == 1 ) i--;
		}
		sc.close();
	}

}
