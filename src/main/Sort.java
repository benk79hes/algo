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
}
