package main;

public class RecursiveThings
{

	public static void main(String[] args)
	{
		//mistere("Nicole");
		//return;

		char[] test = {'a', 'b', 'c'};

		afficheCharMultiVector(permutation(test));
		/*int[] vector = Vector.randomIntVector(10, 100);

		Vector.showVector(vector);
		int min = searchMinimum(vector);

		System.out.println("Index: " + min + ", valeur: " + vector[min]); */
	}

	public static void afficheCharMultiVector(char[][] vector)
	{
		for (int i = 0; i < vector.length; i++) {
			for (int j = 0; j < vector[i].length; j++) {
				System.out.print(" " + vector[i][j]);
			}
			System.out.println();
		}
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
	public static char[][] permutation(char[] vector){
		int[] indexes = new int[vector.length];

		for (int i = 0; i < vector.length; i++) {
			indexes[i] = i;
		}
		return permutation(vector, indexes);
	}

	public static char[][] permutation(char[] vector, int[] indexes)
	{
		int vLength = indexes.length;
		int resLength = factorial(indexes.length);
		char[][] result = new char[2][vLength];

		if (vLength == 2) {
			result[0] = vector;
			result[1][0] = vector[indexes[0]];
			result[1][1] = vector[indexes[1]];
			result[1][0] = vector[indexes[1]];
			result[1][1] = vector[indexes[0]];
			return result;
		}

		int resI = 0;
		for (int i = 0; i < indexes.length; i++) {
			int[] others = new int[vLength-1];

			int iI = 0;
			for (int j = 0; j < others.length; j++){
				if (iI == i)
					continue;

				others[j] = indexes[iI];
				iI++;
			}

			char[][] otherPermutations = permutation(vector, others);

			//char[][]
			//result[i][0] = vector[];

			for (int n = 0; n < otherPermutations.length; n++) {
				char[] newPerm = new char[indexes.length];
				newPerm[0] = vector[indexes[i]];

				for (int nn = 0; nn < otherPermutations[n].length; nn++) {
					newPerm[nn+1] = otherPermutations[n][nn];
				}
				//result[resI]
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
