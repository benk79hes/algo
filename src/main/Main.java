package main;

public class Main
{
	public static void main(String[] args)
	{
		// testSearch(50, 35);
		// statSearch(1000, 35, 100);

		//testSort(10);

		int[] a = {0,2,6,6,9,15,22,69,101};
		Vector.showVector(a);
		int[] b = {5,9,10,24};
		Vector.showVector(b);

		int[] c = Merge.mergeSorted(a, b);
		Vector.showVector(c);

	}

	public static void testSort(int qty)
	{
		int[] vector = Vector.randomIntVector(qty, qty * 10);

		Sort.sort_1(vector);
		Vector.showVector(vector);
	}

	public static void testSearch(int qty, int search)
	{
		Search s = new Search(50);
		s.showVector();

		testSearchLinear(s, search);
		testSearchDico(s, search);
	}

	public static void testSearchLinear(Search o, int search) {

		int found = o.searchLinear(search);

		System.out.print("Test recherche linéaire: ");
		if (found < 0) {
			System.out.print("La valeur " + search + " n'a pas été trouvée dans le tableau.");
		}
		else {
			System.out.print("La valeur " + search + " se trouve à l'index " + found);
		}
		System.out.println(" (" + o.getCounter() + " essais)");
	}

	public static void testSearchDico(Search o, int search) {

		int found = o.searchDico(search, true);

		System.out.print("Test recherche dicotomique: ");
		if (found < 0) {
			System.out.print("La valeur " + search + " n'a pas été trouvée dans le tableau.");
		}
		else {
			System.out.print("La valeur " + search + " se trouve à l'index " + found);
		}
		System.out.println(" (" + o.getCounter() + " essais)");
	}

	public static void statSearch(int qty, int search, int tests)
	{
		int linearTests = 0;
		int dicoTests = 0;

		for (int i = 0; i < tests; i++) {

			Search s = new Search(qty);

			int element =  Vector.getRandomElement(s.getVector());
			s.searchLinear(element);
			linearTests += s.getCounter();

			s.searchDico(element);
			dicoTests += s.getCounter();
		}

		System.out.println("-----------------------------------------------");
		System.out.println("Statistique sur " + tests + " recherches dans un vecteur de longueur " + qty + ". (moyenne des essais)");
		System.out.println("Recherche linéaire " + (linearTests / (double)tests));
		System.out.println("Recherche dichotomique " + (dicoTests / (double)tests));
	}
}
