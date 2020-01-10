package main;

import java.io.*;

public class Sudoku
{
	static int [][] matriceBase = {{0, 0, 4, 0, 0, 0, 5, 0, 0},
		{0, 0, 3, 2, 0, 6, 9, 0, 0},
		{6, 0, 0, 0, 5, 0, 0, 0, 3},
		{0, 4, 1, 7, 0, 9, 3, 5, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 0},
		{0, 5, 6, 3, 0, 2, 8, 7, 0},
		{8, 0, 0, 0, 3, 0, 0, 0, 7},
		{0, 0, 2, 9, 0, 7, 1, 0, 0},
		{0, 0, 7, 0, 0, 0, 6, 0, 0}} ;

	static int [][] matriceTravail ;

	public static void main(String[] args) {
		matriceTravail = matriceBase;
		affiche(matriceTravail);
		int[] caseLibre = prochainLibre(-1, 8);
		placeChiffre(caseLibre[0], caseLibre[1]);

	}

	static void placeChiffre(int ligne, int colonne) {
		// System.out.println("placeChiffre,  (" + ligne + " " +colonne + ")");
		if (ligne == 9) {
			affiche(matriceTravail);
			return;
		}

		//if (matriceBase[ligne-1][colonne-1] == 0) {
		for (int n = 1; n < 10; n++) {
			if (possible(ligne, colonne, n)) {
				matriceTravail[ligne][colonne] = n;
				//affiche(matriceTravail);

				int[] caseLibre = prochainLibre(ligne, colonne);
				placeChiffre(caseLibre[0], caseLibre[1]);
				matriceTravail[ligne][colonne] = 0;
			}
		}
		//}
	}

	static boolean possible(int ligne, int colonne, int valeur) {
		// ligne
		for (int ic = 0; ic < 9; ic++) {
			if (ic == colonne)
				continue;

			if (matriceTravail[ligne][ic] == valeur) {
				// System.out.println("Ligne, " + valeur);
				return false;

			}
		}

		// colonne
		for (int il = 0; il < 9; il++) {
			if (il == ligne)
				continue;

			if (matriceTravail[il][colonne] == valeur) {
				//System.out.println("Colonne, " + valeur + " (" + colonne + " " +il + ")");
				return false;

			}
		}

		// carre
		int lCarre = ligne / 3;
		int cCarre = colonne / 3;
		int ilCarre = lCarre * 3;
		int icCarre = cCarre * 3;
		// System.out.println("Carré, " + lCarre + " " + cCarre + " " + ilCarre + " " + icCarre);

		for (int il = ilCarre; il < ilCarre + 3; il++) {

			for (int ic = icCarre; ic < icCarre + 3; ic++) {
				// System.out.println("(" + il + " " + ic + ")");

				if (il == ligne && ic == colonne)
					continue;

				if (matriceTravail[il][ic] == valeur) {
					//System.out.println("Carré, " + valeur);
					return false;

				}
			}

		}

		return true;
	}


	static int[] prochain(int ligne, int colonne) {
		colonne++;
		if (colonne == 9) {
			colonne = 0;
			ligne++;
		}

		int res[] = {
			ligne, colonne
		};
		return res;
	}

	static int[] prochainLibre(int ligne, int colonne) {

		int res[] = {
			ligne, colonne
		};

		do {
			res = prochain(res[0], res[1]);
			if (res[0] == 9)
				return res;
		}
		while (matriceBase[res[0]][res[1]] != 0);

		return res;
	}

	public static void affiche(int[][] matrice)
	{
		for (int i = 0; i < matrice.length; i++) {

			for (int j = 0; j < matrice[i].length; j++) {
				System.out.print(matrice[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	static void write(String text){
		File file = new File ("c:/temp/output.txt");


		FileWriter writer;
		try {
			writer = new FileWriter(file);


			writer.write(text + "\n");
			writer.flush();
			// permet de garder en mémoire dans notre fichier , on met un flush ou un close
			writer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
