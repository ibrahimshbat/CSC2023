package BenjaminPLam;

/*************************************************/
/*** Simple test class for Sort class          ***/
/***                                           ***/
/*** Author: Jason Steggles    20/09/2015      ***/
/*************************************************/

public class TestSort {
	public static void main(String[] args) {

		Sort sortTest = new Sort(100);

		/** Initial values for comparison counters **/
		System.out.println("Initial values for comparison counters -->");
		System.out.println("Insertion sort comparison counter: " + sortTest.compIS);
		System.out.println("Quicksort comparison counter: " + sortTest.compQS);
		System.out.println("New sort comparison counter: " + sortTest.compNewS);

		System.out.println("\n---------------------        TEST 1       -------------------------");

		sortTest.readIn("test1.txt"); // A test file read in
		sortTest.display(10, "Test 1- Array of Integers"); // method to display
															// integer array

		sortTest.readIn("test1.txt");
		sortTest.insertionSort(); // calls insertion sort method
		sortTest.display(10, "\nAfter Insertion Sort");
		System.out.println("\nInsertion sort comparison counter: " + sortTest.compIS);
		// prints out value of comparison counter after sorting algorithm is run

		sortTest.readIn("test1.txt");
		sortTest.performQuickSort();
		sortTest.display(10, "\nAfter Quicksort");
		System.out.println("\nQuicksort comparison counter: " + sortTest.compQS);

		System.out.println("\n\n---------------------        TEST 2       -------------------------");

		sortTest.readIn("test2.txt");
		sortTest.display(10, "Test 2- Array of Integers");

		sortTest.readIn("test2.txt");
		sortTest.insertionSort();
		sortTest.display(10, "\nAfter Insertion Sort");
		System.out.println("\nInsertion sort comparison counter: " + sortTest.compIS);

		sortTest.readIn("test2.txt");
		sortTest.performQuickSort();
		sortTest.display(10, "\nAfter Quicksort");
		System.out.println("\nQuicksort comparison counter: " + sortTest.compQS);

		System.out.println("\n\n---------------------        TEST 3       -------------------------");

		sortTest.readIn("test3.txt");
		sortTest.display(10, "Test 3- Array of Integers");

		sortTest.readIn("test3.txt");
		sortTest.insertionSort();
		sortTest.display(10, "\nAfter Insertion Sort");
		System.out.println("\nInsertion sort comparison counter: " + sortTest.compIS);

		sortTest.readIn("test3.txt");
		sortTest.performQuickSort();
		sortTest.display(10, "\nAfter Quicksort");
		System.out.println("\nQuicksort comparison counter: " + sortTest.compQS);

		sortTest.readIn("test3.txt");
		sortTest.newSort();
		sortTest.display(10, "\nAfter NewSort");
		System.out.println("\nNew sort comparison counter: " + sortTest.compNewS);

		System.out.println("\n\n---------------------        TEST 4       -------------------------");

		sortTest.readIn("test4.txt");
		sortTest.display(10, "Test 4- Array of Integers");

		sortTest.readIn("test4.txt");
		sortTest.insertionSort();
		sortTest.display(10, "\nAfter Insertion Sort");
		System.out.println("\nInsertion sort comparison counter: " + sortTest.compIS);

		sortTest.readIn("test4.txt");
		sortTest.performQuickSort();
		sortTest.display(10, "\nAfter Quicksort");
		System.out.println("\nQuicksort comparison counter: " + sortTest.compQS);

		sortTest.readIn("test4.txt");
		sortTest.newSort();
		sortTest.display(10, "\nAfter NewSort");
		System.out.println("\nNew sort comparison counter: " + sortTest.compNewS);

		System.out.println("\n\n---------------------        TEST 5       -------------------------");

		sortTest.readIn("test5.txt");
		sortTest.display(10, "Test 5- Array of Integers");

		sortTest.readIn("test5.txt");
		sortTest.insertionSort();
		sortTest.display(10, "\nAfter Insertion Sort");
		System.out.println("\nInsertion sort comparison counter: " + sortTest.compIS);

		sortTest.readIn("test5.txt");
		sortTest.newSort();
		sortTest.display(10, "\nAfter NewSort");
		System.out.println("\nNew sort comparison counter: " + sortTest.compNewS);

	}

}
/** End of Test class **/