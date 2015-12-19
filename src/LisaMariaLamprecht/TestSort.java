package LisaMariaLamprecht;

/*************************************************/
/*** Simple test class for Sort class          ***/
/***                                           ***/
/*** Author: Jason Steggles    20/09/2015      ***/
/*************************************************/

public class TestSort {
	public static void main(String[] args) {
		/****************************/
		/** Using text file test 1 **/
		/****************************/

		/** Insertion Sort **/

		/**
		 * Creates new insertion test object, one is created for each insertion
		 * test so that the test file read in will be sorted correctly
		 */
		Sort insertionTest1 = new Sort(100);
		insertionTest1.readIn("test1.txt"); /** Read in test data into array **/

		System.out.println("\n----------------------------------");
		System.out.println("\n---Tests Using test1.txt---");
		System.out.println("\n----------------------------------");
		insertionTest1.display(10,
				"Array of Integers before any sorts:"); /** Display array **/

		System.out.println("\n\nINSERTION SORT:");
		insertionTest1
				.insertionSort(); /**
									 * Calls the insertion sort to sort the array
									 */
		insertionTest1.display(10,
				"Array of Integers after Insertion Sort:"); /**
															 * Displays the
															 * sorted array so
															 * that there are 10
															 * values per line
															 */

		System.out.println("\n\nInsertion sort comparison counter: "
				+ insertionTest1.compIS); /** Display comparison counters **/

		/** Quicksort **/

		/**
		 * Creates new quicksort test object, one is created for each quicksort
		 * so that the test file read in will be sorted correctly
		 */
		Sort quickTest1 = new Sort(100);
		quickTest1.readIn("test1.txt"); /**
										 * Read in test data into array again
										 * for the new quicksort 1 test object
										 */

		System.out.println("\nQUICKSORT:");
		quickTest1.quickSort(); /** Calls the quicksort to sort array */
		quickTest1.display(10,
				"Array of Integers after Quicksort:"); /**
														 * Displays the sorted
														 * array so that there
														 * are 10 values per
														 * line
														 */

		System.out.println("\n\nQuicksort comparison counter: "
				+ quickTest1.compQS); /** Display comparison counters */

		/****************************/
		/** Using text file test 2 **/
		/****************************/

		/** Insertion Sort **/

		/**
		 * Creates new insertion test object, one is created for each insertion
		 * test so that the test file read in will be sorted correctly
		 */
		Sort insertionTest2 = new Sort(100);
		insertionTest2.readIn("test2.txt"); /** Read in test data into array **/

		System.out.println("\n----------------------------------");
		System.out.println("\n---Tests Using test2.txt---");
		System.out.println("\n----------------------------------");
		insertionTest2.display(10,
				"Array of Integers before any sorts:"); /** Display array **/

		System.out.println("\n\nINSERTION SORT:");
		insertionTest2
				.insertionSort(); /**
									 * Calls the insertion sort to sort the array
									 */
		insertionTest2.display(10,
				"Array of Integers after Insertion Sort:"); /**
															 * Displays the
															 * sorted array so
															 * that there are 10
															 * values per line
															 */

		System.out.println("\n\nInsertion sort comparison counter: "
				+ insertionTest2.compIS); /** Display comparison counters **/

		/** Quicksort **/

		/**
		 * Creates new quicksort test object, one is created for each quicksort
		 * so that the test file read in will be sorted correctly
		 */
		Sort quickTest2 = new Sort(100);
		quickTest2.readIn("test2.txt"); /**
										 * Read in test data into array again
										 * for the new quicksort 2 test object
										 */

		System.out.println("\nQUICKSORT:");
		quickTest2.quickSort(); /** Calls the quicksort to sort array */
		quickTest2.display(10,
				"Array of Integers after Quicksort:"); /**
														 * Displays the sorted
														 * array so that there
														 * are 10 values per
														 * line
														 */

		System.out.println("\n\nQuicksort comparison counter: "
				+ quickTest2.compQS); /** Display comparison counters */

		/****************************/
		/** Using text file test 3 **/
		/****************************/

		/** Insertion Sort **/

		/**
		 * Creates new insertion test object, one is created for each insertion
		 * test so that the test file read in will be sorted correctly
		 */
		Sort insertionTest3 = new Sort(100);
		insertionTest3.readIn("test3.txt"); /** Read in test data into array **/

		System.out.println("\n----------------------------------");
		System.out.println("\n---Tests Using test3.txt---");
		System.out.println("\n----------------------------------");
		insertionTest3.display(10,
				"Array of Integers before any sorts:"); /** Display array **/

		System.out.println("\n\nINSERTION SORT:");
		insertionTest3
				.insertionSort(); /**
									 * Calls the insertion sort to sort the array
									 */
		insertionTest3.display(10,
				"Array of Integers after Insertion Sort:"); /**
															 * Displays the
															 * sorted array so
															 * that there are 10
															 * values per line
															 */

		System.out.println("\n\nInsertion sort comparison counter: "
				+ insertionTest3.compIS); /** Display comparison counters **/

		/** Quicksort **/

		/**
		 * Creates new quicksort test object, one is created for each quicksort
		 * so that the test file read in will be sorted correctly
		 */
		Sort quickTest3 = new Sort(100);
		quickTest3.readIn("test3.txt"); /**
										 * Read in test data into array again
										 * for the new quicksort 3 test object
										 */

		System.out.println("\nQUICKSORT:");
		quickTest3.quickSort(); /** Calls the quicksort to sort array */
		quickTest3.display(10,
				"Array of Integers after Quicksort:"); /**
														 * Displays the sorted
														 * array so that there
														 * are 10 values per
														 * line
														 */

		System.out.println("\n\nQuicksort comparison counter: "
				+ quickTest3.compQS); /** Display comparison counters */

		/** newSort **/

		/**
		 * Creates new newsort test object, one is created for each newsort so
		 * that the test file read in will be sorted correctly
		 */
		Sort newSort3 = new Sort(100);
		newSort3.readIn("test3.txt"); /**
										 * Read in test data into array again for
										 * the new newsort 3 test object
										 */

		System.out.println("\nNEW SORT:");
		newSort3.newSort(); /** Calls the newsort to sort array */
		newSort3.display(10,
				"Array of Integers after new sort:"); /**
														 * Displays the sorted
														 * array so that there
														 * are 10 values per
														 * line
														 */

		System.out.println("\n\nNew Sort comparison counter: "
				+ newSort3.compNewS); /** Display comparison counters */

		/****************************/
		/** Using text file test 4 **/
		/****************************/

		/** Insertion Sort **/

		/**
		 * Creates new insertion test object, one is created for each insertion
		 * test so that the test file read in will be sorted correctly
		 */
		Sort insertionTest4 = new Sort(100);
		insertionTest4.readIn("test4.txt"); /** Read in test data into array **/

		System.out.println("\n----------------------------------");
		System.out.println("\n---Tests Using test4.txt---");
		System.out.println("\n----------------------------------");
		insertionTest4.display(10,
				"Array of Integers before any sorts:"); /** Display array **/

		System.out.println("\n\nINSERTION SORT:");
		insertionTest4
				.insertionSort(); /**
									 * Calls the insertion sort to sort the array
									 */
		insertionTest4.display(10,
				"Array of Integers after Insertion Sort:"); /**
															 * Displays the
															 * sorted array so
															 * that there are 10
															 * values per line
															 */

		System.out.println("\n\nInsertion sort comparison counter: "
				+ insertionTest4.compIS); /** Display comparison counters **/

		/** Quicksort **/

		/**
		 * Creates new quicksort test object, one is created for each quicksort
		 * so that the test file read in will be sorted correctly
		 */
		Sort quickTest4 = new Sort(100);
		quickTest4.readIn("test4.txt"); /**
										 * Read in test data into array again
										 * for the new quicksort 4 test object
										 */

		System.out.println("\nQUICKSORT:");
		quickTest4.quickSort(); /** Calls the quicksort to sort array */
		quickTest4.display(10,
				"Array of Integers after Quicksort:"); /**
														 * Displays the sorted
														 * array so that there
														 * are 10 values per
														 * line
														 */

		System.out.println("\n\nQuicksort comparison counter: "
				+ quickTest4.compQS); /** Display comparison counters **/

		/** newSort **/

		/**
		 * Creates new newsort test object, one is created for each newsort so
		 * that the test file read in will be sorted correctly
		 */
		Sort newSort4 = new Sort(100);
		newSort4.readIn("test4.txt"); /**
										 * Read in test data into array again for
										 * the new newsort 4 test object
										 */

		System.out.println("\nNEW SORT:");
		newSort4.newSort(); /** Calls the newsort to sort array */
		newSort4.display(10,
				"Array of Integers after new sort:"); /**
														 * Displays the sorted
														 * array so that there
														 * are 10 values per
														 * line
														 */

		System.out.println("\n\nNew Sort comparison counter: "
				+ newSort4.compNewS); /** Display comparison counters **/

		/****************************/
		/** Using text file test 5 **/
		/****************************/

		/** Insertion Sort **/

		/**
		 * Creates new insertion test object, one is created for each insertion
		 * test so that the test file read in will be sorted correctly
		 */
		Sort insertionTest5 = new Sort(100);
		insertionTest5.readIn("test5.txt"); /** Read in test data into array **/

		System.out.println("\n----------------------------------");
		System.out.println("\n---Tests Using test5.txt---");
		System.out.println("\n----------------------------------");
		insertionTest5.display(10,
				"Array of Integers before any sorts:"); /** Display array **/

		System.out.println("\n\nINSERTION SORT:");
		insertionTest5
				.insertionSort(); /**
									 * Calls the insertion sort to sort the array
									 */
		insertionTest5.display(10,
				"Array of Integers after Insertion Sort:"); /**
															 * Displays the
															 * sorted array so
															 * that there are 10
															 * values per line
															 */

		System.out.println("\n\nInsertion sort comparison counter: "
				+ insertionTest5.compIS); /** Display comparison counters **/

		/** newSort **/

		/**
		 * Creates new newsort test object, one is created for each newsort so
		 * that the test file read in will be sorted correctly
		 */
		Sort newSort5 = new Sort(100);
		newSort5.readIn("test5.txt"); /**
										 * Read in test data into array again for
										 * the new newsort 5 test object
										 */

		System.out.println("\nNEW SORT:");
		newSort5.newSort(); /** Calls the newsort to sort array */
		newSort5.display(10,
				"Array of Integers after new sort:"); /**
														 * Displays the sorted
														 * array so that there
														 * are 10 values per
														 * line
														 */

		System.out.println("\n\nNew Sort comparison counter: "
				+ newSort5.compNewS); /** Display comparison counters **/
		System.out.println("\n-------------------------------------");

	}

} /** End of Test class **/