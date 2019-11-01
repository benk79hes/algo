package main;

public class Sort
{
	public Sort() {

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

	/**
	 * @todo
	 * @return
	 */
	public static int[] sortBubble(){
		return null;
	}

	/**
	 * @todo
	 * @return
	 */
	public static int[] sortCocktailBubble(){
		return null;
	}

	/**
	 * @todo
	 * @return
	 */
	public static int[] sortInsert(int[] vector){

		for (int sorting = 1; sorting < vector.length; sorting++) {
			int sortingValue = vector[sorting];

			for (int comparing = sorting - 1; comparing >= 0; comparing--) {
				// if (comparing > )
			}
		}
		return null;
	}


	/**
	 * @return
	 */
	public static int[] sortFrequency(int[] vector)
	{
		int k = Vector.getMaxInteger(vector) + 1;
		int[] frequency = new int[k];

		for (int i = 0; i < vector.length; i++) {
			frequency[vector[i]]++;
		}

		Vector.showVector(frequency);

		int[] result = new int[vector.length];

		int resI = 0;
		for (int i = 0; i < frequency.length; i++) {
			for (int q = 0; q < frequency[i]; q++) {
				result[resI] = i;
				resI++;
			}
		}
		return result;
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








	public static void quickSort(int[] vector)
	{
		quickSort(vector, 0, vector.length - 1);
	}

	private static void quickSort(int[] vector, int initialLeft, int initialRight)
	{
		System.out.println("Sort from " + initialLeft + " to " + initialRight);
		Vector.showVector(vector);
		// clause de finitude
		if (initialLeft == initialRight || initialRight < initialLeft)
			return;

		// pas recursif
		int pivotPosition = initialLeft;
		int pivot = vector[pivotPosition];


		int l = initialLeft + 1;
		int r = initialRight;

		l++;


		while (r >= l) {

			while (vector[l] <= pivot && l <= r) {
				l++;
			}
			while (vector[r] > pivot && l < r) {
				r--;
			}

			if (r > l) {
				permutePosition(vector, l, r);
				r--;
				l++;
			}

		}

		int newPivotPosition = r;

		permutePosition(vector, pivotPosition, newPivotPosition);

		Vector.showVector(vector);

		quickSort(vector, initialLeft, newPivotPosition - 1);
		quickSort(vector, newPivotPosition + 1, initialRight);
	}

	private static void quickSort1(int[] vector, int l, int r)
	{
		System.out.println("Sort from " + l + " to " + r);
		Vector.showVector(vector);
		// clause de finitude
		if (l == r || r < l)
			return;

		// pas recursif
		int pivotPosition = l;
		int initialLeft = l;
		int initialRight = r;
		int pivot = vector[l];

		int lastLeft = l;

		boolean toRight = true;

		while (r > l) {

			if (toRight) {
				l++;
				if (vector[l] >= pivot) {
					toRight = false;
				}
				else {

				}
			}
			else {
				if (vector[r] < pivot) {
					permutePosition(vector, l, r);
					toRight = true;
				}
				r--;
			}
		}

		int newPivotPosition = l-1;
		permutePosition(vector, pivotPosition, newPivotPosition);

		Vector.showVector(vector);
		quickSort(vector, initialLeft, newPivotPosition - 1);
		quickSort(vector, newPivotPosition + 1, initialRight);
	}

	private static void permutePosition(int[] vector, int a, int b)
	{
		int t = vector[a];
		vector[a] = vector[b];
		vector[b] = t;
	}

	public static boolean isSorted(int[] vector)
	{
		for (int i = 1; i < vector.length; i++) {
			if (vector[i] < vector[i-1])
				return false;
		}
		return true;
	}
}
