package main;

import java.util.Random;

public class Search
{
	private int[] vector;

	private int counter = 0;

	public Search (int qty) {
		vector = Vector.randomOrderedVector(qty);
	}

	public void showVector()
	{
		for (int i = 0; i < vector.length; i++) {
			System.out.println(i + " =>\t" + vector[i]);
		}
	}

	public static void stat()
	{

	}

	public int searchLinear(int value)
	{
		counter = 0;
		for (int i = 0; i < vector.length; i++) {

			counter++;

			if (vector[i] == value)
				return i;

			if (vector[i] > value)
				return -1;
		}

		return -1;
	}

	public int searchDico(int value, boolean output)
	{
		counter = 0;

		int limitInf = 0;
		int limitSup = vector.length;

		while (limitSup >= limitInf) {
			counter++;
			if (output)
				System.out.println ("from " + limitInf + " to " + limitSup);

			int median = (limitSup + limitInf) / 2;

			if (vector[median] == value) {
				return median;
			}

			if (vector[median] > value) {
				limitSup = median - 1;
			}
			else {
				limitInf = median + 1;
			}
		}

		return -1;
	}

	public int searchDico(int value)
	{
		return searchDico(value, false);
	}



	public int getCounter(){
		return counter;
	}

	public int[] getVector(){
		return vector;
	}
}
