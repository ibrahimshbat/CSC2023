package KiyavashKandar;

/*************************************************/
/*** Simple test class for Sort class          ***/
/***                                           ***/
/*** Author: Jason Steggles    20/09/2015      ***/
/*************************************************/

public class TestSort {
	public static void main(String[] args) {
		Sort sortTest = new Sort(100);

		/** Read in test data into array **/
		sortTest.readIn("test5.txt"); // Change test file name here

		/** Display unsorted array **/
		sortTest.display(10, "Array of Integers");

		/****************************************************************************************/
		/***
		 * TESTING - Delete comment symbols '//' below for each section to test
		 * one by one
		 ***/
		/****************************************************************************************/

		/**
		 * Sort via InsertionSort and display sorted array and comparison
		 * counter
		 **/
		// sortTest.insertionSort();
		// sortTest.display(10, "Sorted Array of Integers");
		// System.out.println("\n\nInsertion sort comparison counter (Once
		// sorted): " + sortTest.compIS);
		/** END OF INSERTIONSORT **/

		/**
		 * Sort via QuickSort and display sorted array and comparison counter
		 **/
		// sortTest.callQuickSort();
		// sortTest.display(10, "Sorted Array of Integers");
		// System.out.println("\n\nQuick Sort comparison counter (Once sorted):
		// " + sortTest.compQS);
		/** END OF QUICKSORT **/

		/** Sort via NewSort and display sorted array and comparison counter **/
		sortTest.sort();
		sortTest.display(10, "Sorted Array of Integers");
		System.out.println("\n\nNew Sort comparison counter (Once sorted): " + sortTest.compNewS);
		/** END OF NEWSORT **/
	}

} /** End of Test class **/