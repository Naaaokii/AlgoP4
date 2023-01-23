import java.util.Scanner;

public class Joueur {

    private String pseudo;

	private int score;
    
	private char pion; // + ou - (pour l'instant)
	
	private static Scanner sc2 = new Scanner(System.in);

	public Joueur(String pseudo, char pion)
	{
		setPseudo(pseudo);
		setScore(0);
		setpion(pion);
	}
	
	public String getPseudo() 
	{
		return this.pseudo;
	}

	public void setPseudo(String pseudo) 
	{
		this.pseudo = pseudo;
	}

	public int getScore() 
	{
		return this.score;
	}

	public void setScore(int score) 
	{
		this.score = score;
	}
	
	public char getpion() 
	{
		return pion;
	}

	public void setpion(char pion) 
	{
		this.pion = pion;
	}

	public void jouer(Plateau plateau, Game game)
	{
		int c = 8;
		System.out.println(this.getPseudo() + ", c'est à toi de jouer !");
		while(c < 1 || c >7)
			c = sc2.nextInt();
		if(!plateau.insererPion(c-1, this.getpion()))
			System.out.println("La colonne est déjà remplie !!!!!!! Tu aurais du y penser...");
	}
}
