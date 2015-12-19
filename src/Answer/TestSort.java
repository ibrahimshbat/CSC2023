package Answer;

/*************************************************/
/*** Simple test class for Sort class ***/
/*** ***/

/*** Author: Student's Name and Date ***/
/*************************************************/
public class TestSort {
	public static void main(String[] args) {
		Sort sortTest = new Sort(100);
		/** TEST INSERTION SORT **/
		/** Test 1: **/
		/** Read in test data and perform test **/
		sortTest.readIn("test1.txt");
		sortTest.display(15, "Insertion Sort Test 1: using test1.txt");
		sortTest.insertSort();
		sortTest.display(15, "Sorted:");
		System.out.println("\n\nInsertion sort comparison counter: " + sortTest.compIS);
		/** Test 2: **/
		/** Reset comparison counter **/
		sortTest.compIS = 0;
		/** Read in test data and perform test **/
		sortTest.readIn("test2.txt");
		sortTest.display(15, "Insertion Sort Test 2: using test2.txt");
		sortTest.insertSort();
		sortTest.display(15, "Sorted:");
		System.out.println("\n\nInsertion sort comparison counter: " + sortTest.compIS);
		/** Test 3: **/
		/** Reset comparison counter **/
		sortTest.compIS = 0;
		/** Read in test data and perform test **/
		sortTest.readIn("test3.txt");
		sortTest.display(15, "Insertion Sort Test 3: using test3.txt");
		sortTest.insertSort();
		sortTest.display(15, "Sorted:");
		System.out.println("\n\nInsertion sort comparison counter: " + sortTest.compIS);
		/** Test 4: **/
		/** Reset comparison counter **/
		sortTest.compIS = 0;
		/** Read in test data and perform test **/
		sortTest.readIn("test4.txt");
		sortTest.display(15, "Insertion Sort Test 4: using test4.txt");
		sortTest.insertSort();
		sortTest.display(15, "Sorted:");
		System.out.println("\n\nInsertion sort comparison counter: " + sortTest.compIS);
		/** TEST QUICKSORT **/
		/** Test 1: **/
		/** Reset comparison counter **/
		sortTest.compQS = 0;
		/** Read in test data and perform test **/
		sortTest.readIn("test1.txt");
		sortTest.display(15, "Quicksort Test 1: using test1.txt");
		sortTest.quickSort();
		sortTest.display(15, "Sorted:");
		System.out.println("\n\nQuicksort comparison counter: " + sortTest.compQS);
		/** Test 2: **/
		/** Reset comparison counter **/
		sortTest.compQS = 0;
		/** Read in test data and perform test **/
		sortTest.readIn("test2.txt");
		sortTest.display(15, "Quicksort Test 2: using test2.txt");
		sortTest.quickSort();
		sortTest.display(15, "Sorted:");
		System.out.println("\n\nQuicksort comparison counter: " + sortTest.compQS);
		/** Test 3: **/
		/** Reset comparison counter **/
		sortTest.compQS = 0;
		/** Read in test data and perform test **/
		sortTest.readIn("test3.txt");
		sortTest.display(15, "Quicksort Test 3: using test3.txt");
		sortTest.quickSort();
		sortTest.display(15, "Sorted:");
		System.out.println("\n\nQuicksort comparison counter: " + sortTest.compQS);
		/** Test 4: **/
		/** Reset comparison counter **/
		sortTest.compQS = 0;
		/** Read in test data and perform test **/
		sortTest.readIn("test4.txt");
		sortTest.display(15, "Quicksort Test 4: using test4.txt");
		sortTest.quickSort();
		sortTest.display(15, "Sorted:");
		System.out.println("\n\nQuicksort comparison counter: " + sortTest.compQS);
		/** TEST NEW SORT **/
		/** Test 1: **/
		/** Reset comparison counter **/
		sortTest.compNewS = 0;
		/** Read in test data and perform test **/
		sortTest.readIn("test3.txt");
		sortTest.display(15, "new Sort Test 1: using test3.txt");
		sortTest.newSort();
		sortTest.display(15, "Sorted:");
		System.out.println("\n\nNew sort comparison counter: " + sortTest.compNewS);
		/** Test 2: **/
		/** Reset comparison counter **/
		sortTest.compNewS = 0;
		/** Read in test data and perform test **/
		sortTest.readIn("test4.txt");
		sortTest.display(15, "new Sort Test 2: using test4.txt");
		sortTest.newSort();
		sortTest.display(15, "Sorted:");
		System.out.println("\n\nNew sort comparison counter: " + sortTest.compNewS);
		/** Test 3: **/
		/** Reset comparison counter **/
		sortTest.compNewS = 0;
		/** Read in test data and perform test **/
		sortTest.readIn("E:\\test3.txt");
		sortTest.display(15, "new Sort Test 3: using test5.txt");
		sortTest.newSort();
		sortTest.display(15, "Sorted:");
		System.out.println("\n\nNew sort comparison counter: " + sortTest.compNewS);
		/** ADDITIONAL INSERTION SORT TEST **/
		/** Test 5: **/
		/** Reset comparison counter **/
		sortTest.compIS = 0;
		/** Read in test data and perform test **/
		sortTest.readIn("E:\\test3.txt");
		sortTest.display(15, "Insertion Sort Test 5: using test5.txt");
		sortTest.insertSort();
		sortTest.display(15, "Sorted:");
		System.out.println("\n\nInsertion sort comparison counter: " + sortTest.compIS);
	}
} /** End of Test class **/