package main;

public class Dames
{
	//static int dame = 0;

	static  int[] dames = new int[8];

	public static void main(String[] args) {



	}


	private static void placeDame(int colonne){

		if (colonne == 9) {
			// afficheSolution();
			return;
		}


		for (int ligne = 1; ligne < 9; ligne++) {
			if (possible()) {
				dames[colonne] = ligne;
				placeDame(colonne + 1);
				return;
			}
		}

		//if
		//back();
		//findNext();

		//if()
	}

	private static boolean possible()
	{
		return false;
	}

}
