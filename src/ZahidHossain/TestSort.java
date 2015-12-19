package ZahidHossain;

/*************************************************/
/*** Simple test class for Sort class          ***/
/***                                           ***/
/*** Author: Jason Steggles    20/09/2015      ***/
/*************************************************/


public class TestSort
{
	public static void main(String[] args)
	{
		Sort sortTest = new Sort(100);

		/** Display comparison counters **/
		System.out.println("\n\nInsertion sort comparison counter: " + sortTest.compIS);
		System.out.println("Quicksort comparison counter: " + sortTest.compQS);

		/** Read in test data into array (please change text when testing the program)**/
		sortTest.readIn("test3.txt");


		/** Display array **/
		sortTest.display(10,"Array of Integers");
		/** Insertion sort ***/
		/**Import InsertionSort  **/
		sortTest.insertionSort();
		/**Display array after InsertionSort**/
		sortTest.display(10,"\n Array of Integers after Insetion sort");
		/**show comparison counter **/
		System.out.println("\n\nInsertion sort comparison counter: " + sortTest.compIS);

		/**QuickSort **/
		/**Reset array (please change text when testing the program)**/
		sortTest.readIn("test3.txt");
		/**Import Quicksort **/ /**full array size until the end of it. **/
		sortTest.quickSort(0, (sortTest.getSize() - 1));
		/**Display array after QuickSort  **/
		sortTest.display(10,"\n Array of Integers after Quick sort");
		/**show comparison counter **/
		System.out.println("\n\nQuick sort comparison counter: " + sortTest.compQS);

		/** NewSort **/
		/**Reset array (please change text when testing the program)**/
		sortTest.readIn("test3.txt");
		/**import new sort  **/
		sortTest.newSort();
		/**Display array after NewSort**/
		sortTest.display(10,"\nArray of Integers after New sort");
		/**show comparison counter **/
		System.out.println("\n\nNew sort comparison counter: " + sortTest.compNewS);

	}

} /** End of Test class **/