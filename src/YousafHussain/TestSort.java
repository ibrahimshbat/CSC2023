package YousafHussain;

/*************************************************/
/*** Simple test class for Sort class          ***/
/***                                           ***/
/*** Author: Jason Steggles    20/09/2015      ***/
/*************************************************/

public class TestSort {
	public static void main(String[] args) {
		Sort sortTest = new Sort(100);

		/** Read in test datat into array **/
		sortTest.readIn("src/test2.txt");
		sortTest.qSort();
		// sortTest.newSort();
		// sortTest.insertionSort();

		/** Display comparison counters **/
		System.out.println("\n\nInsertion sort comparison counter: " + sortTest.compIS);
		System.out.println("Quicksort comparison counter: " + sortTest.compQS);
		System.out.println("NewSort comparison counter: " + sortTest.compNewS);

		/** Display array **/
		sortTest.display(10, "Array of Integers");
	}

} /** End of Test class **/