package DanwenHuang;

/*************************************************/
/*** Simple test class for Sort class          ***/
/***                                           ***/
/*** Author: Jason Steggles    20/09/2015      ***/
/*************************************************/

public class TestSort {
	public static void main(String[] args) {
		Sort sortTest = new Sort(100);

		/** Read in test data into array **/
		sortTest.readIn("src/test5.txt");

		/** Display array **/
		sortTest.display(10, "Array of Integers");

		// Insertion sort
		sortTest.insertionSort();
		sortTest.display(10, "\nInsertion sorted array");
		/** Display comparison counter for insertion sort **/
		System.out.println("\n\nInsertion sort comparison counter: " + sortTest.compIS);

		/** Read in test data into array **/
		sortTest.readIn("src/test4.txt");

		/** Display array **/
		sortTest.display(10, "Array of Integers");

		// Quick sort
		sortTest.sort();
		sortTest.display(10, "\nQuicksort sorted array");
		/** Display comparison counter for quick sort **/
		System.out.println("\n\nQuicksort comparison counter: " + sortTest.compQS);

		/** Read in test data into array **/
		sortTest.readIn("src/test5.txt");

		/** Display array **/
		sortTest.display(10, "Array of Integers");

		// New sort
		sortTest.newSort();
		sortTest.display(10, "\nNew sort sorted array");
		/** Display comparison counter for quick sort **/
		System.out.println("\n\nNew sort comparison counter: " + sortTest.compNewS);

	}

}
/** End of Test class **/