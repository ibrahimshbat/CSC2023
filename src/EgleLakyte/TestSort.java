package EgleLakyte;

/*************************************************/

/*** Simple test class for Sort class ***/

/*** ***/

/*** Author: Jason Steggles 20/09/2015 ***/

/*** Edited by: Egle Lakyte 24/10/2015 ***/

/*************************************************/

public class TestSort {

	public static void main(String[] args) {

		// ----------------TEST1----------------

		Sort sortTest1 = new Sort(15);

		// Read in test data into array

		sortTest1.readIn("test1.txt");

		System.out.println("TEST 1");

		// Display array

		sortTest1.display(10, "Array of Integers");

		// Run Insertion Sort method

		sortTest1.insertionSort();

		// Display array sorted with Insertion Sort

		sortTest1.display(10, "Array of Integers sorted with Insertion Sort");

		// Display comparison counter

		System.out.println("\n\nInsertion sort comparison counter: "

				+ sortTest1.compIS);

		// Read in test data into array

		sortTest1.readIn("test1.txt");

		// Run QuickSort method

		sortTest1.quickSort(0, sortTest1.lastElement());

		// Display array sorted with QuickSort

		sortTest1.display(10, "Array of Integers sorted with QuickSort");

		// Display comparison counter

		System.out.println("\n\nQuicksort comparison counter: " + sortTest1.compQS);

		// ----------------TEST2----------------

		Sort sortTest2 = new Sort(15);

		// Read in test data into array

		sortTest2.readIn("test2.txt");

		System.out.println("\n\nTEST 2");

		// Display array

		sortTest2.display(10, "Array of Integers");

		// Run Insertion Sort method

		sortTest2.insertionSort();

		// Display array sorted with Insertion Sort

		sortTest2.display(10, "Array of Integers sorted with Insertion Sort");

		// Display comparison counter

		System.out.println("\n\nInsertion sort comparison counter: "

				+ sortTest2.compIS);

		// Read in test data into array

		sortTest2.readIn("test2.txt");

		// Run QuickSort method

		sortTest2.quickSort(0, sortTest2.lastElement());

		// Display array sorted with QuickSort

		sortTest2.display(10, "Array of Integers sorted with QuickSort");

		// Display comparison counter

		System.out.println("\n\nQuickSort comparison counter: " + sortTest2.compQS);

		// ----------------TEST3----------------

		Sort sortTest3 = new Sort(100);

		// Read in test data into array

		sortTest3.readIn("test3.txt");

		System.out.println("\n\nTEST 3");

		// Display array

		sortTest3.display(10, "Array of Integers");

		// Run Insertion Sort method

		sortTest3.insertionSort();

		// Display array sorted with Insertion Sort

		sortTest3.display(10, "Array of Integers sorted with Insertion Sort");

		// Display comparison counter

		System.out.println("\n\nInsertion sort comparison counter: "

				+ sortTest3.compIS);

		// Read in test data into array

		sortTest3.readIn("test3.txt");

		// Run QuickSort method

		sortTest3.quickSort(0, sortTest3.lastElement());

		// Display array sorted with QuickSort

		sortTest3.display(10, "Array of Integers sorted with QuickSort");

		// Display comparison counter

		System.out.println("\n\nQuicksort comparison counter: " + sortTest3.compQS);

		// Read in test data into array

		sortTest3.readIn("test3.txt");

		// Run newSort method

		sortTest3.newSort();

		// Display array sorted with newSort

		sortTest3.display(10, "Array of Integers sorted with newSort");

		// Display comparison counter

		System.out.println("\n\nnewSort comparison counter: " + sortTest3.compNewS);

		// ----------------TEST4----------------

		Sort sortTest4 = new Sort(100);

		// Read in test data into array

		sortTest4.readIn("test4.txt");

		System.out.println("\n\nTEST 4");

		// Display array

		sortTest4.display(10, "Array of Integers");

		// Run Insertion Sort method

		sortTest4.insertionSort();

		// Display array sorted with Insertion Sort

		sortTest4.display(10, "Array of Integers sorted with Insertion Sort");

		// Display comparison counter

		System.out.println("\n\nInsertion sort comparison counter: "

				+ sortTest4.compIS);

		// Read in test data into array

		sortTest4.readIn("test4.txt");

		// Run QuickSort method

		sortTest4.quickSort(0, sortTest4.lastElement());

		// Display array sorted with QuickSort

		sortTest4.display(10, "Array of Integers sorted with QuickSort");

		// Display comparison counter

		System.out.println("\n\nQuicksort comparison counter: " + sortTest4.compQS);

		// Read in test data into array

		sortTest4.readIn("Test4.txt");

		// Run newSort method

		sortTest4.newSort();

		// Display array sorted with newSort

		sortTest4.display(10, "Array of Integers sorted with newSort");

		// Display comparison counter

		System.out.println("\n\nnewSort comparison counter: " + sortTest4.compNewS);

		// ----------------TEST5----------------

		Sort sortTest5 = new Sort(100);

		// Read in test data into array

		sortTest5.readIn("test5.txt");

		System.out.println("\n\nTEST 5");

		// Display array

		sortTest5.display(10, "Array of Integers");

		// Run Insertion Sort method

		sortTest5.insertionSort();

		// Display array sorted with Insertion Sort

		sortTest5.display(10, "Array of Integers sorted with Insertion Sort");

		// Display comparison counter

		System.out.println("\n\nInsertion sort comparison counter: "

				+ sortTest5.compIS);

		// Read in test data into array

		sortTest5.readIn("Test5.txt");

		// Run newSort method

		sortTest5.newSort();

		// Display array sorted with newSort

		sortTest5.display(10, "Array of Integers sorted with newSort");

		// Display comparison counter

		System.out.println("\n\nnewSort comparison counter: " + sortTest5.compNewS);

	}

}