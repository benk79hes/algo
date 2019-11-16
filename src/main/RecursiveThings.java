package main;

public class RecursiveThings
{

	public static void main(String[] args)
	{
		//mistere("Nicole");
		//return;
		affichePossibilites01(3);
//		char[] test = {'a', 'b', 'c'};

//		afficheCharMultiVector(permutation(test));
		/*int[] vector = Vector.randomIntVector(10, 100);

		Vector.showVector(vector);
		int min = searchMinimum(vector);

		System.out.println("Index: " + min + ", valeur: " + vector[min]); */
	}

	public static void affichePossibilites01(int qty)
	{
		affichePossibilites01("", qty);
	}

	private static void affichePossibilites01(String fixed, int qty){
		int[] poss = {0, 1};

		if (qty == 0) {
			System.out.println(fixed);
			return;
		}

		for (int n = 0; n < poss.length; n++) {
			String f = fixed + poss[n];
			affichePossibilites01(f,qty - 1);
		}

	}

	public static void afficheCharMultiVector(char[][] vector)
	{
		for (int i = 0; i < vector.length; i++) {
			afficheCharVector(vector[i]);
		}
	}

	public static void afficheCharVector(char[] vector)
	{
		for (int j = 0; j < vector.length; j++) {
			System.out.print(vector[j]);
		}
		System.out.println();
	}


	/*
	 * Suite, Exerice 2
	 */

	public static int searchMinimum(int[] vector)
	{
		return searchMinimum(vector, 0, vector.length - 1);
	}

	public static int searchMinimum(int[] vector, int start, int end)
	{
		if (start == end)
			return start;

		int median = (end + start) / 2;

		int minIndex1 = searchMinimum(vector, start, median);
		int minIndex2 = searchMinimum(vector, median + 1, end);

		if (vector[minIndex1] > vector[minIndex2])
			return minIndex2;
		else
			return minIndex1;
	}

	/*
	 * Suite, Exerice 3
	 */
	static char tab[];
	public static char[][] permutation(int length){
		tab = new char[length];

		for (int i = 0; i < length; i++)
			tab[i] = (char)('A' + i);

		return permutation(tab);
	}

	public void echange(int i, int j){
		char temp = tab[i];
		tab[i] = tab[j];
		tab[j] = temp;
	}

	/* public static char[][] permutation(char[] vector){
		int[] indexes = new int[vector.length];

		for (int i = 0; i < vector.length; i++) {
			indexes[i] = i;
		}
		return permutation(vector, indexes);
	} */

	public static char[][] permutation(char[] vector)
	{
		int vLength = vector.length;
		int resLength = factorial(vector.length);

		System.out.print("Permutation de : ");
		afficheCharVector(vector);

		//char[][] result = new char[resLength][vLength];
		//char[][] result;

		if (vLength == 1) {
			char[][] result = {vector};
			return result;
		}

		int resI = 0;

		char[][] result = new char[resLength][];
		for (int i = 0; i < vector.length; i++) {
			char[] others = new char[vector.length - 1];

			char fixedChar = vector[i];


			int iI = 0;
			for (int j = 0; j < vector.length; j++){
				if (iI == i)
					continue;

				others[iI] = vector[j];
				iI++;
			}

			char[][] otherPermutations = permutation(others);


			for (int n = 0; n < otherPermutations.length; n++) {

				char[] newPerm = new char[otherPermutations[n].length + 1];

				newPerm[0] = fixedChar;

				for (int nn = 0; nn < otherPermutations[n].length; nn++) {
					newPerm[nn+1] = otherPermutations[n][nn];
				}

				result[resI] = newPerm;
				resI++;
			}
//			char first =
		}

		return result;
	}

	private static int factorial(int number) {
		int result = 1;

		for (int factor = 2; factor <= number; factor++) {
			result *= factor;
		}

		return result;
	}


	public static void mistere(String s)
	{
		int l = s.length();
		mistere (s, l - 1);
	}

	private static void mistere(String s, int position)
	{
		if (position < 0)
			return;

		System.out.println(s.charAt(position));
		mistere(s, position-1);
	}



	public static int[] sort_1(int[] vector) {

		for (int position = 0; position < vector.length -1; position++) {

			int replaceWith = searchMin(vector, position);

			if (replaceWith > position) {
				int tmp = vector[position];
				vector[position] = vector[replaceWith];
				vector[replaceWith] = tmp;
			}

		}

		return vector;
	}

	public static int searchMin (int[] vector, int start) {
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

}
