/**
 * Réponse exercice 3, CC Algo
 *
 * @author Benjamin Keller
 */

package main;

public class Exercice2
{
	public static void main(String[] args) {

		up(10);
		System.out.println();

		down(10);
		System.out.println();

		upAndDown(10);
		System.out.println();

		downAndup(10);
		System.out.println();/**/

	}

	public static void up(int n) {
		// Clause de finitude
		if (n < 1)
			return;

		// Pas recursif
		up (n - 1);
		System.out.print(n + " ");
	}

	public static void down(int n) {
		// Clause de finitude
		if (n < 1)
			return;

		// Pas recursif
		System.out.print(n + " ");
		down (n - 1);
	}


	public static void upAndDown(int n) {
		upAndDown(1, n);
	}

	private static void upAndDown(int current, int max) {
		// Clause de finitude
		if (current > max)
			return;

		// Pas recursif
		System.out.print(current + " ");
		upAndDown (current + 1, max);
		System.out.print(current + " ");
	}



	public static void downAndup(int n) {
		// Clause de finitude
		if (n < 1)
			return;

		// Pas recursif
		System.out.print(n + " ");
		downAndup (n - 1);
		System.out.print(n + " ");
	}

}
