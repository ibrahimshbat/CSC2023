package HaydenJamieson;

/*************************************************/
/*** Simple test class for Sort class          ***/
/***                                           ***/
/*** Author: Jason Steggles    20/09/2015      ***/
/*************************************************/

public class TestSort {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
	}

	public static void test1() {
		Sort a = new Sort(100);
		System.out.println("\n------TEST1.TXT : 15 Elements----------");
		a.readIn("test1.txt");
		a.display(10, "Array of Integers before sorting");

		a.readIn("test1.txt");
		a.insertionSort();
		System.out.println("\n\nInsertion sort comparison counter: " + a.compIS);
		a.display(10, "Array of Integers Insertion");

		a.readIn("test1.txt");
		a.qs();
		System.out.println("\n\nQuicksort comparison counter: " + a.compQS);
		a.display(10, "Array of Integers Quicksort");
	}

	public static void test2() {
		Sort b = new Sort(100);
		System.out.println("\n\n------TEST2.TXT : 15 Elements----------");
		b.readIn("test2.txt");
		b.display(10, "Array of Integers before sorting");

		b.readIn("test2.txt");
		b.insertionSort();
		System.out.println("\n\nInsertion sort comparison counter: " + b.compIS);
		b.display(10, "Array of Integers Insertion");

		b.readIn("test2.txt");
		b.qs();
		System.out.println("\n\nQuicksort comparison counter: " + b.compQS);
		b.display(10, "Array of Integers Quicksort");
	}

	public static void test3() {
		Sort c = new Sort(100);
		System.out.println("\n\n------TEST3.TXT : 100 Elements---------");
		c.readIn("test3.txt");
		c.display(10, "Array of Integers before sorting");

		c.readIn("test3.txt");
		c.insertionSort();
		System.out.println("\n\nInsertion sort comparison counter: " + c.compIS);
		c.display(10, "Array of Integers Insertion");

		c.readIn("test3.txt");
		c.qs();
		System.out.println("\n\nQuicksort comparison counter: " + c.compQS);
		c.display(10, "Array of Integers Quicksort");

		c.readIn("test3.txt");
		c.newSort();
		System.out.println("\n\nNewSort comparison counter: " + c.compNewS);
		c.display(10, "Array Of Integers Newsort");
	}

	public static void test4() {
		Sort d = new Sort(100);
		System.out.println("\n\n------TEST4.TXT : 100 Elements---------");
		d.readIn("test4.txt");
		d.display(10, "Array of Integers before sorting");

		d.readIn("test4.txt");
		d.insertionSort();
		System.out.println("\n\nInsertion sort comparison counter: " + d.compIS);
		d.display(10, "Array of Integers Insertion");

		d.readIn("test4.txt");
		d.qs();
		System.out.println("\n\nQuicksort comparison counter: " + d.compQS);
		d.display(10, "Array of Integers Quicksort");

		d.readIn("test4.txt");
		d.newSort();
		System.out.println("\n\nNewSort comparison counter: " + d.compNewS);
		d.display(10, "Array Of Integers Newsort");
	}

	public static void test5() {
		Sort e = new Sort(100);
		System.out.println("\n\n------TEST5.TXT : 100 Elements---------");
		e.readIn("test5.txt");
		e.display(10, "Array of Integers before sorting");

		e.readIn("test5.txt");
		e.insertionSort();
		System.out.println("\n\nInsertion sort comparison counter: " + e.compIS);
		e.display(10, "Array of Integers Insertion");

		e.readIn("test5.txt");
		e.newSort();
		System.out.println("\n\nNewSort comparison counter: " + e.compNewS);
		e.display(10, "Array Of Integers Newsort");
	}

} /** End of Test class **/