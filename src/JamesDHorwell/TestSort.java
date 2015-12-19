/*************************************************/
/*** Simple test class for Sort class          ***/
/***                                           ***/
/*** Author: Jason Steggles    20/09/2015   	**/
/** 		Extended by: Jamie Horwell   05/11/2015   ***/
/*************************************************/
package JamesDHorwell;

public class TestSort {
	public static void main(String[] args) {

		// ***********Test1 Results**********\\
		System.out.println("****************TEST 1 RESULTS****************");
		testISort(new Sort(100), "test1.txt");
		testQSort(new Sort(100), "test1.txt");

		// ***********Test2 Results**********\\
		System.out.println("\n\n****************TEST 2 RESULTS****************");
		testISort(new Sort(100), "test2.txt");
		testQSort(new Sort(100), "test2.txt");

		// ***********Test3 Results**********\\
		System.out.println("\n\n****************TEST 3 RESULTS****************");
		testISort(new Sort(100), "test3.txt");
		testQSort(new Sort(100), "test3.txt");
		testNSort(new Sort(100), "test3.txt");

		// ***********Test4 Results**********\\
		System.out.println("\n\n****************TEST 4 RESULTS****************");
		testISort(new Sort(100), "test4.txt");
		testQSort(new Sort(100), "test4.txt");
		testNSort(new Sort(100), "test4.txt");

		// ***********Test5 Results**********\\
		System.out.println("\n\n****************TEST 5 RESULTS****************");
		testISort(new Sort(100), "test5.txt");
		testNSort(new Sort(100), "test5.txt");

	}

	// read in and sort array using insertion sort, print out sorted array
	// before and after
	public static void testISort(Sort sortTest, String textfile) {
		System.out.println("\n******Insertion Sort******");
		sortTest.readIn(textfile);
		sortTest.display(10, "Array of Integers");
		sortTest.insertionSort();
		sortTest.display(10, "\nSorted Array");
		System.out.println("\n\nInsertion sort comparison counter: " + sortTest.compIS);

	}

	// read in and sort array using quick sort, print out sorted array before
	// and after
	public static void testQSort(Sort sortTest, String textfile) {
		System.out.println("\n******Quick Sort******");
		sortTest.readIn(textfile);
		sortTest.display(10, "Array of Integers");
		sortTest.quicksort(0, sortTest.getUsedSize() - 1);
		sortTest.display(10, "\nSorted Array");
		System.out.println("\n\nQuicksort comparison counter: " + sortTest.compQS);
	}

	// read in and sort array using new sort, print out sorted array before and
	// after
	public static void testNSort(Sort sortTest, String textfile) {
		System.out.println("\n******New Sort******");
		sortTest.readIn(textfile);
		sortTest.display(10, "Array of Integers");
		sortTest.newSort();
		sortTest.display(10, "\nSorted Array");
		System.out.println("\n\nNewsort comparison counter: " + sortTest.compNewS);
	}
} /** End of Test class **/