package main;

import java.util.Random;

public class Vector
{
	public static int[] randomOrderedVector(int qty)
	{
		int[] vector = new int[qty];
		Random rand = new Random();
		int n = 0;
		int min = 1;
		int max = 3;

		for (int i = 0; i < qty; i++) {
			n = n + min + rand.nextInt(max);
			vector[i] = n;
		}

		return vector;
	}

	public static int[] randomIntVector(int qty, int max)
	{
		int[] vector = new int[qty];
		Random rand = new Random();

		for (int i = 0; i < qty; i++) {
			vector[i] = rand.nextInt(max);
		}

		return vector;
	}

	public static int getRandomElement(int[] vector)
	{
		Random rand = new Random();
		int n = rand.nextInt(vector.length-1);

		return vector[n];
	}

	public static void showVector(int[] vector)
	{
		for (int i = 0; i < vector.length; i++) {
			System.out.println(i + " =>\t" + vector[i]);
		}
	}
}