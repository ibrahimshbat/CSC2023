/*************************************************/
/*** Simple test class for Sort class          ***/
/***                                           ***/
/*** Initial Author: Jason Steggles 20/09/2015 ***/
/*** Extended by: Adam Hopper  19/10/2015      ***/
/*************************************************/

package AdamHopper;

public class TestSort {
	public static void main(String[] args) {

		/** Testing for test1.txt **/
		System.out.println("\tResults for test1.txt:");
		/* INSERTION SORT */
		/**
		 * Set up array, read in test file, perform sort and display the results
		 **/
		Sort sortTestInsert1 = new Sort(15);
		sortTestInsert1.readIn("test1.txt");
		sortTestInsert1.insertionSort();
		sortTestInsert1.display(10, "InsertionSort:");

		/* QUICKSORT */
		Sort sortTestQuick1 = new Sort(15);
		sortTestQuick1.readIn("test1.txt");
		/** Set up bounds for the quickSort params **/
		int left = 0;
		int right_1 = sortTestQuick1.getUsedSize() - 1;
		sortTestQuick1.quickSort(left, right_1);
		sortTestQuick1.display(10, "\nQuicksort:");

		System.out.println("\n\nSize of Array: " + sortTestInsert1.getUsedSize());
		System.out.println("Insertion sort comparison counter: " + sortTestInsert1.compIS);
		System.out.println("Quicksort comparison counter: " + sortTestQuick1.compQS + "\n");
		System.out.println("-------------------------------------");

		/** Testing for test2.txt **/
		System.out.println("\t Results for test2.txt:");
		/* INSERTION SORT */
		Sort sortTestInsert2 = new Sort(15);
		sortTestInsert2.readIn("test2.txt");
		sortTestInsert2.insertionSort();
		sortTestInsert2.display(10, "InsertionSort:");

		/* QUICKSORT */
		Sort sortTestQuick2 = new Sort(15);
		sortTestQuick2.readIn("test2.txt");
		int right_2 = sortTestQuick2.getUsedSize() - 1;
		sortTestQuick2.quickSort(left, right_2);
		sortTestQuick2.display(10, "\nQuicksort:");

		System.out.println("\n\nSize of Array: " + sortTestInsert2.getUsedSize());
		System.out.println("Insertion sort comparison counter: " + sortTestInsert2.compIS);
		System.out.println("Quicksort comparison counter: " + sortTestQuick2.compQS + "\n");
		System.out.println("-------------------------------------");

		/** Testing for test3.txt **/
		System.out.println("\t Results for test3.txt:");
		/* INSERTION SORT */
		Sort sortTestInsert3 = new Sort(100);
		sortTestInsert3.readIn("test3.txt");
		sortTestInsert3.insertionSort();
		sortTestInsert3.display(10, "InsertionSort:");

		/* QUICKSORT */
		Sort sortTestQuick3 = new Sort(100);
		sortTestQuick3.readIn("test3.txt");
		int right_3 = sortTestQuick3.getUsedSize() - 1;
		sortTestQuick3.quickSort(left, right_3);
		sortTestQuick3.display(10, "\nQuicksort:");

		/* NEWSORT */
		Sort sortTestNew3 = new Sort(100);
		sortTestNew3.readIn("test3.txt");
		sortTestNew3.newSort();
		sortTestNew3.display(10, "\nNewSort:");

		System.out.println("\n\nSize of Array: " + sortTestInsert3.getUsedSize());
		System.out.println("Insertion sort comparison counter: " + sortTestInsert3.compIS);
		System.out.println("Quicksort comparison counter: " + sortTestQuick3.compQS);
		System.out.println("Newsort comparison counter: " + sortTestNew3.compNewS + "\n");
		System.out.println("-------------------------------------");

		/** Testing for test4.txt **/
		System.out.println("\t Results for test4.txt:");
		/* INSERTION SORT */
		Sort sortTestInsert4 = new Sort(100);
		sortTestInsert4.readIn("test4.txt");
		sortTestInsert4.insertionSort();
		sortTestInsert4.display(10, "InsertionSort:");

		/* QUICKSORT */
		Sort sortTestQuick4 = new Sort(100);
		sortTestQuick4.readIn("test4.txt");
		int right_4 = sortTestQuick4.getUsedSize() - 1;
		sortTestQuick4.quickSort(left, right_4);
		sortTestQuick4.display(10, "\nQuicksort:");

		/* NEWSORT */
		Sort sortTestNew4 = new Sort(100);
		sortTestNew4.readIn("test4.txt");
		sortTestNew4.newSort();
		sortTestNew4.display(10, "\nNewSort:");

		System.out.println("\n\nSize of Array: " + sortTestInsert4.getUsedSize());
		System.out.println("Insertion sort comparison counter: " + sortTestInsert4.compIS);
		System.out.println("Quicksort comparison counter: " + sortTestQuick4.compQS);
		System.out.println("Newsort comparison counter: " + sortTestNew4.compNewS + "\n");
		System.out.println("-------------------------------------");

		/** Testing for test5.txt **/
		System.out.println("\t Results for test5.txt:");
		/* INSERTION SORT */
		Sort sortTestInsert5 = new Sort(100);
		sortTestInsert5.readIn("test5.txt");
		sortTestInsert5.insertionSort();
		sortTestInsert5.display(10, "InsertionSort:");

		/* NEWSORT */
		Sort sortTestNew5 = new Sort(100);
		sortTestNew5.readIn("test5.txt");
		sortTestNew5.newSort();
		sortTestNew5.display(10, "\nNewSort:");

		System.out.println("\n\nSize of Array: " + sortTestNew5.getUsedSize());
		System.out.println("Insertion sort comparison counter: " + sortTestInsert5.compIS);
		System.out.println("Newsort comparison counter: " + sortTestNew5.compNewS + "\n");

	}

} /** End of Test class **/