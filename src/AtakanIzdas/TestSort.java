package AtakanIzdas;

/*************************************************/
/***   Simple test class for Sort class        ***/
/***                                           ***/
/***   Author: Jason Steggles    20/09/2015    ***/
/***   Extended by: Atakan Izdas    05/11/15   ***/
/*************************************************/

public class TestSort {
	public static void main(String[] args) {
		Sort sortTest = new Sort(100);

		/** Read in test data into array **/
		sortTest.readIn("E:\\test3.txt"); // Change
																		// to
																		// appropriate
																		// location
																		// if
																		// need
																		// be

		/** Display array **/

		sortTest.display(10, "Array of Integers");

		/** Insertion Sort **/ // Run insertion sort method

		//sortTest.InsertionSort(Sort.A);

		//sortTest.display(10, "\nAfter Insertion Sort Algorithm: ");

		/** Quicksort **/ // Run quicksort method

		//sortTest.readIn("CE:\\test1.txt"); // Change
																		// to
																		// appropriate
																		// location
																		// if
																		// need
																		// be

		sortTest.QuickSort(Sort.A);

		sortTest.display(10, "\nAfter Quicksort Algorithm: ");

		/** New Sort **/ // Run newsort method

		//sortTest.readIn("C:\\Users\\Monster\\Downloads\\test1.txt"); // Change
																		// to
																		// appropriate
																		// location
																		// if
																		// need
																		// be

		//sortTest.newSort(Sort.A);

		//sortTest.display(10, "\nAfter NewSort Algorithm: ");

		/** Display comparison counters **/
		//System.out.println("\n\nInsertion Sort comparison counter: " + sortTest.compIS);
		System.out.println("Quicksort comparison counter: " + sortTest.compQS);
		//System.out.println("NewSort comparison counter: " + sortTest.compNewS);
	}

} /** End of Test class **/