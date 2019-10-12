package main;

public class Hanoi
{
	public static void main(String[] args)
	{
		//move(3, 'A', 'B', 'C');
		//int n = 35, r;
		//r = elementFibonacci(n);
		//System.out.println("Factoriel de " + n + " = " + r);
		//System.out.println("Fibonacci de " + n + " = " + r);

		String mot = "sugus";
		char[] test = mot.toCharArray();
		if (palindrome(test)) {
			System.out.println(mot + " est un palyndrome");
		}
		else {
			System.out.println(mot + " n'est pas un palyndrome");
		}
	}

	public static void move(int qty, char from, char inter, char to)
	{
		// final clause
		if (qty == 1) {
			System.out.println(from + " -> " + to);
			return;
		}

		// recursive step
		move (qty - 1, from, to, inter);
		move (1, from, inter, to);
		move (qty - 1, inter, from, to);
	}


	public static int factoriel(int n)
	{
		// final clause
		if (n == 0) {
			return 1;
		}

		// recursive step
		return n * factoriel(n-1);
	}



	public static int elementFibonacci(int level)
	{
		if (level == 0)
			return 1;
		if (level == 1)
			return 2;

		return elementFibonacci(level - 1) + elementFibonacci(level - 2);
	}



	public static boolean palindrome(char[] lettres)
	{
		if (lettres.length <= 1)
			return true;

		if (lettres[0] != lettres[lettres.length - 1])
			return false;


		char[] intern = new char[lettres.length-2];

		for (int i = 0; i < intern.length; i++) {
			intern[i] = lettres[i+1];
		}
		return palindrome(intern);
	}

}
