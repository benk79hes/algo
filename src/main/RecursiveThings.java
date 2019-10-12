package main;

public class RecursiveThings
{

	public static void main(String[] args)
	{
		int[] vector = Vector.randomIntVector(10, 100);

		Vector.showVector(vector);
		int min = searchMinimum(vector);

		System.out.println("Index: " + min + ", valeur: " + vector[min]);
	}

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
}
