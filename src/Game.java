
public class Game 
{
	private Plateau plateau;
	private boolean gagne;

	public Game(Plateau Plateau)
	{
		setPlateau(Plateau);
		setGagne(false);
	}
	
	public Plateau getPlateau() 
	{
		return this.plateau;
	}

	public void setPlateau(Plateau Plateau) 
	{
		this.plateau = Plateau;
	}
	
	public boolean verifGagne(Plateau Plateau)
	{
		if(this.checkHori(Plateau) || this.checkVert(Plateau) || this.verifSlash(Plateau) || this.verifAntiSlash(Plateau))
			return true;
		return false;
	}

	public boolean checkHori(Plateau Plateau){

		int scoreJoueur1 = 0;

		int scoreJoueur2 = 0;

		for(char[] i : Plateau.getPlateau())
		{
			for(char i2 : i )
			{
				switch (i2)
				{
					case 'O':
						if(scoreJoueur2 > 0){
                            scoreJoueur2 = 0;
                        }
						scoreJoueur1++;
						if(scoreJoueur1 >= 4 || scoreJoueur2 >= 4)
						{
							return true;
						}
						break;
					case 'X':
						if(scoreJoueur1 > 0){
                            scoreJoueur1 = 0;
                        }		
						scoreJoueur2++;
						if(scoreJoueur1 >= 4 || scoreJoueur2 >= 4)
						{
							return true;
						}
						break;
					default:
						scoreJoueur1 = 0;
						scoreJoueur2 = 0;
				}
			}
			scoreJoueur1 = 0;
			scoreJoueur2 = 0;
		}

		return false;
	}
	public boolean checkVert(Plateau Plateau)
	{
		int scoreJoueur1 = 0;
		int scoreJoueur2 = 0;
		for(int c = 0; c<= Plateau.getNbColonnes(); c++)
		{
			for(int l = 0; l<= Plateau.getNbLignes(); l++)
			{
				switch (Plateau.getCase(l, c))
				{
					case '-':
						if(scoreJoueur2 > 0)
							scoreJoueur2 = 0;
						scoreJoueur1++;
						if(scoreJoueur1 >= 4 || scoreJoueur2 >= 4)
						{
							return true;
						}
						break;
					case '+':
						if(scoreJoueur1 > 0)
							scoreJoueur1 = 0;
						scoreJoueur2++;
						if(scoreJoueur1 >= 4 || scoreJoueur2 >= 4)
						{
							return true;
						}
						break;
					default:
						scoreJoueur1 = 0;
						scoreJoueur2 = 0;
				}
			}
			scoreJoueur1 = 0;
			scoreJoueur2 = 0;
		}
		return false;
	}

	public boolean verifSlash(Plateau Plateau)
	{
		int scoreJoueur1 = 0;
		int scoreJoueur2 = 0;
		int colonne2,ligne2;
		for(int l = 3; l <= Plateau.getNbLignes(); l++)
		{
			for(int c = 0; c <= 3; c++)
			{
				switch (Plateau.getCase(l, c))
				{
					case '-':
						scoreJoueur1 = 0;
						if(scoreJoueur2 > 0)
							scoreJoueur2 = 0;
						scoreJoueur1++;
						colonne2 = c;
						ligne2 = l;
						for(int i = 1; i < 4; i++ )
						{
							colonne2++;
							ligne2--;
							if(Plateau.getCase(ligne2, colonne2) == '-')
								scoreJoueur1++;
							else if(Plateau.getCase(ligne2, colonne2) != '-')
							{
								scoreJoueur1 = 0;
								break;
							}
						}
						if(scoreJoueur1 >= 4 || scoreJoueur2 >= 4)
						{
							return true;
						}
						break;
					case '+':
						scoreJoueur2 = 0;
						if(scoreJoueur1 > 0)
							scoreJoueur1 = 0;
						scoreJoueur2++;
						colonne2 = c;
						ligne2 = l;
						for(int i = 1; i < 4; i++ )
						{
							colonne2++;
							ligne2--;
							if(Plateau.getCase(ligne2, colonne2) == '-')
								scoreJoueur2++;
							else if(Plateau.getCase(ligne2, colonne2) != '-')
							{
								scoreJoueur2 = 0;
								break;
							}
						}
						if(scoreJoueur1 >= 4 || scoreJoueur2 >= 4)
						{
							return true;
						}
						break;
					default:
						scoreJoueur1 = 0;
						scoreJoueur2 = 0;
				}
			}
			scoreJoueur1 = 0;
			scoreJoueur2 = 0;
		}
		return false;
	}


	public boolean verifAntiSlash(Plateau Plateau)
	{
		int scoreJoueur1 = 0;
		int scoreJoueur2 = 0;
		int colonne2,ligne2;
		for(int l = 3; l <= Plateau.getNbLignes(); l++)
		{
			for(int c = 3; c <= Plateau.getNbColonnes(); c++)
			{
				switch (Plateau.getCase(l, c))
				{
					case '-':
						scoreJoueur1 = 0;
						if(scoreJoueur2 > 0){
                            scoreJoueur2 = 0;
                        }
						scoreJoueur1++;
						colonne2 = c;
						ligne2 = l;
						for(int i = 1; i < 4; i++ ){
							colonne2--;
							ligne2--;
							if(Plateau.getCase(ligne2, colonne2) == '-')
								scoreJoueur1++;
							else if(Plateau.getCase(ligne2, colonne2) != '-')
							{
								scoreJoueur1 = 0;
								break;
							}
						}
						if(scoreJoueur1 >= 4 || scoreJoueur2 >= 4)
						{
							return true;
						}
						break;
					case '+':
						scoreJoueur2 = 0;
						if(scoreJoueur1 > 0)
							scoreJoueur1 = 0;
						scoreJoueur2++;
						colonne2 = c;
						ligne2 = l;
						for(int i = 1; i < 4; i++ )
						{
							colonne2--;
							ligne2--;
							if(Plateau.getCase(ligne2, colonne2) == '-')
								scoreJoueur2++;
							else if(Plateau.getCase(ligne2, colonne2) != '-')
							{
								scoreJoueur2 = 0;
								break;
							}
						}
						if(scoreJoueur1 >= 4 || scoreJoueur2 >= 4)
						{
							return true;
						}
						break;
					default:
						scoreJoueur1 = 0;
						scoreJoueur2 = 0;
				}
			}
			scoreJoueur1 = 0;
			scoreJoueur2 = 0;
		}
		return false;
	}


	public boolean isGagne() 
	{
		return this.gagne;
	}

	public void setGagne(boolean gagne) 
	{
		this.gagne = gagne;
	}
	public void finGame(Joueur joueur)
	{
		System.out.println(joueur.getPseudo() + " a gagné ! ");
		this.setGagne(true);
	}
}