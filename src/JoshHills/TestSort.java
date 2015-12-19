package JoshHills;

/*************************************************/
/*** Simple test class for Sort class          ***/
/***                                           ***/
/***     Initial Author: Jason Steggles 20/09/15   ***/
/***     Extended by: Josh Hills 26/10/15          ***/
/*****************************************************/

public class TestSort {
	public static void main(String[] args) {

		// Create new Sort object with 100 spaces in array.
		Sort sortTest = new Sort(100);

		// Test insertion-sort method on specified test files.
		testIS(sortTest);

		// Test quick-sort method on specified test files.
		testQS(sortTest);

		// Test new-sort method on specified test files.
		testNS(sortTest);

	}

	/**
	 * This method encapsulates the testing of the 'insertionSort' method, for
	 * clarity and brevity of code.
	 *
	 * @param sortTest
	 *            The testing object to perform sorting upon.
	 */
	private static void testIS(Sort sortTest) {

		/* Display section of testing. */
		System.out.println("=== Insertion-sort testing: ===");

		// Perform testing and display results...
		for (int i = 1; i < 6; i++) {

			// Read in test data from file into array.
			sortTest.readIn("test" + i + ".txt");
			// Display array.
			sortTest.display(10, "Test File " + i + ":");

			// Sort the array using insertion-sort.
			sortTest.insertionSort();

			// Display sorted array and comparison information.
			sortTest.display(10, "\nArray of Integers Sorted with Insertion Sort");
			System.out.println("\n\nInsertion Sort comparison counter: " + sortTest.compIS);

		}

	}

	/**
	 * This method encapsulates the testing of the 'quickSort' method, for
	 * clarity and brevity of code.
	 *
	 * @param sortTest
	 *            The testing object to perform sorting upon.
	 */
	private static void testQS(Sort sortTest) {

		/* Display section of testing. */
		System.out.println("\n\n=== Quick-sort testing: ===");

		// Perform testing and display results...
		for (int i = 1; i < 5; i++) {

			// Read in test data from file into array.
			sortTest.readIn("test" + i + ".txt");
			// Display array.
			sortTest.display(10, "Test File " + i + ":");

			// Sort the array using quick-sort.
			sortTest.quickSort();

			// Display sorted array and comparison information.
			sortTest.display(10, "\nArray of Integers Sorted with Quick-Sort");
			System.out.println("\n\nQuicksort comparison counter: " + sortTest.compQS);

		}

	}

	/**
	 * This method encapsulates the testing of the 'newSort' method, for clarity
	 * and brevity of code.
	 *
	 * @param sortTest
	 *            The testing object to perform sorting upon.
	 */
	private static void testNS(Sort sortTest) {

		/* Display section of testing. */
		System.out.println("\n\n=== New-sort testing: ===");

		// Perform testing and display results...
		for (int i = 1; i < 6; i++) {

			// Read in test data from file into array.
			sortTest.readIn("test" + i + ".txt");
			// Display array.
			sortTest.display(10, "Test File " + i + ":");

			// Sort the array using new-sort.
			sortTest.newSort();

			// Display sorted array and comparison information.
			sortTest.display(10, "\nArray of Integers Sorted with New Sort");
			System.out.println("\n\nNew Sort comparison counter: " + sortTest.compNewS);

		}

	}

}