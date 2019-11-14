/**
 * Réponse exercice 3, CC Algo
 *
 * @author Benjamin Keller
 */

package main;

public class Exercice3
{
	/**
	 * Le main pour tester le tout ...
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		int[] v = {
			15, 56, 24, 12,
			7, 42, 18, 31,
			55, 40, 8, 11
		};

		showVector(v);
		sort(v);
		showVector(v);
	}

	/**
	 * Methode principale de tri,
	 * fait appel à la méthode searchMin qui fait partie intégrante
	 * de la réponse à l'exercice.
	 */
	public static void sort(int[] vector) {

		for (int position = 0; position < vector.length -1; position++) {

			int replaceWith = searchMin(vector, position);

			if (replaceWith > position) {
				int tmp = vector[position];
				vector[position] = vector[replaceWith];
				vector[replaceWith] = tmp;
			}
		}
	}

	/**
	 * Petite méthode utilitaire pour simplifier la lecture
	 */
	private static int searchMin (int[] vector, int start) {
		int found = -1;
		int min = vector[start];

		for (int i = start + 1; i < vector.length; i++) {
			if (vector[i] < min) {
				found = i;
				min = vector[found];
			}
		}

		return found;
	}

	/**
	 * Methode pour afficher
	 */
	private static void showVector(int[] vector)
	{
		for (int i = 0; i < vector.length; i++) {
			if (i%4 == 0)
				System.out.println();

			System.out.print(vector[i] + "\t");
		}
		System.out.println();
	}
}
