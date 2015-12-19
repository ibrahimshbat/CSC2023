package JakeHough;

/*************************************************/
/*** Simple test class for Sort class          ***/
/*** Author: Jason Steggles    20/09/2015      ***/
/*** Extended by : Jake Hough  02/11/2015      ***/
/*************************************************/

public class TestSort {
	public static void main(String[] args) {
		Sort sortTest = new Sort(100);
		Sort sortInsertion = new Sort(100);
		Sort sortQuick = new Sort(100);
		Sort sortNew = new Sort(100);

		/** Read in test data into array **/
		// Change test data here.
		String i = new String("test1.txt");
		sortTest.readIn(i);
		sortInsertion.readIn(i);
		sortQuick.readIn(i);
		sortNew.readIn(i);

		/** Display array **/
		sortTest.display(10, "Array of Integers");

		/** insertion Sort **/
		sortInsertion.insertionSort();
		sortInsertion.display(10, "\nSorted array from Insertion sort. Using test file: " + i);

		/** Quick Sort **/
		sortQuick.qSort();
		sortQuick.display(10, "\nSorted array from Quicksort. Using test file: " + i);

		/** New Sort **/
		sortNew.newSort();
		sortNew.display(10, "\nSorted array from New sort. Using test file: " + i);

		/** Display comparison counters **/
		System.out.println("\n\nInsertion sort comparison counter: " + sortInsertion.compIS);
		System.out.println("Quicksort comparison counter: " + sortQuick.compQS);
		System.out.println("New sort comparison counter: " + sortNew.compNewS);
	}

} /** End of Test class **/