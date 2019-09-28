package main;

public class Merge
{
	public static int[] mergeSorted(int[] a, int[] b)
	{
		int[] result;
		result = new int[a.length + b.length];

		int insertedAI = -1;
		int insertedBI = -1;

		int[] remainsVector = a;
		int remainsI = 0;


		int insertingI = 0;

		for (int i = 0; i < result.length; i++) {
			int minA = a[insertedAI + 1];
			int minB = b[insertedBI + 1];
			if (minA < minB) {
				result[i] = minA;
				insertedAI++;
				if (insertedAI == a.length -1) {
					remainsVector = b;
					remainsI = insertedBI + 1;
					insertingI = i;
					break;
				}
			}
			else {
				result[i] = minB;
				insertedBI++;
				if (insertedBI == b.length -1) {
					remainsVector = a;
					remainsI = insertedAI + 1;
					insertingI = i;
					break;
				}
			}
		}

		for (int i = remainsI; i < remainsVector.length; i++)
		{
			insertingI ++;
			result[insertingI] = remainsVector[i];
		}

		return result;
	}
}
