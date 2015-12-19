package OwenDHerman;

/*************************************************/
/*** Simple test class for Sort class          ***/
/***                                           ***/
/*** Author: Jason Steggles    20/09/2015      ***/
/*************************************************/

public class TestSort {
	public static void main(String[] args) {
		Sort sortTest = new Sort(100);

		/** Read in test data into array **/
		sortTest.readIn("test5.txt");

		/** Display array **/
		sortTest.display(10, "Array of Integers");

		/** Sort using insertion sort **/
		sortTest.insertionSort();

		/** Display sorted array **/
		sortTest.display(10, "\nSorted Array of Integers (Insertion Sort)");

		/** Display Insertion sort comparison counter **/
		System.out.println("\n\nInsertion sort comparison counter: " + sortTest.compIS);

		/** Read in test data into array **/
		sortTest.readIn("test4.txt");

		/** Sort using Quicksort **/
		sortTest.quicksortParameters();

		/** Display sorted array **/
		sortTest.display(10, "\nSorted Array of Integers (Quicksort)");

		/** Display Quicksort comparison counter **/
		System.out.println("\n\nQuicksort comparison counter: " + sortTest.compQS);

		/** Read in test data into array **/
		sortTest.readIn("test3.txt");

		/** Sort using new sort **/
		sortTest.newSort();

		/** Display sorted array **/
		sortTest.display(10, "\nSorted Array of Integers (New Sort)");

		/** Display Quicksort comparison counter **/
		System.out.println("\n\nNew Sort comparison counter: " + sortTest.compNewS);

	}

}
/** End of Test class **/