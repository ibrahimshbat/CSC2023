package CraigLHirst;

/*****************************************************/
/*** Purpose:                                      ***/
/***                                               ***/
/***     Initial Author: Jason Steggles 20/09/15   ***/
/***     Extended by: Your Name    Date            ***/
/*****************************************************/

import java.io.*;
import java.text.*;
import java.util.*;

public class Sort {

	/** Size of array **/
	private int size;

	/** Number of used elements in array **/
	private int usedSize;

	/** Array of integers **/
	private int[] A;

	/** Global variables for counting sort comparisons **/
	public int compIS;
	/** Global comparison count for Insertion Sort **/
	public int compQS;
	/** Global comparison count for Quicksort **/
	public int compNewS;
	/** Global comparison count for new sort **/

	/*****************/

	/** Constructor **/
	/*****************/
	Sort(int max) {
		/** Initialiase global sort count variables **/
		compIS = 0;
		compQS = 0;
		compNewS = 0;

		/** Initialise size variables **/
		usedSize = 0;
		size = max;

		/** Create Array of Integers **/
		A = new int[size];
	}

	/*********************************************/

	/*** Read a file of integers into an array ***/
	/*********************************************/
	public void readIn(String file) {
		try {
			/** Initialise loop variable **/
			usedSize = 0;

			/** Set up file for reading **/
			FileReader reader = new FileReader(file);
			Scanner in = new Scanner(reader);

			/** Loop round reading in data while array not full **/
			while (in.hasNextInt() && (usedSize < size)) {
				A[usedSize] = in.nextInt();
				usedSize++;
			}

		} catch (IOException e) {
			System.out.println("Error processing file " + file);
		}
	}

	/**********************/

	/*** Display array ***/
	/**********************/
	public void display(int line, String header) {
		/*** Integer Formatter - three digits ***/
		NumberFormat FI = NumberFormat.getInstance();
		FI.setMinimumIntegerDigits(3);

		/** Print header string **/
		System.out.print("\n" + header);

		/** Display array data **/
		for (int i = 0; i < usedSize; i++) {
			/** Check if new line is needed **/
			if (i % line == 0) {
				System.out.println();
			}

			/** Display an array element **/
			System.out.print(FI.format(A[i]) + " ");
		}
	}
	/**********************/

	/*** Insertion Sort ***/
	/**********************/
	public void insertionSort() {
		/** Algorithm variables **/
		int i;
		int j;
		int key;

		/** Loop round array selecting new key **/
		for (i = 1; i < usedSize; i++) {
			key = A[i];
			j = i;

			/** Compare key with value before it and swap if less than **/
			while (j > 0 && key <= A[j - 1]) {
				A[j] = A[j - 1];
				j = j - 1;
				compIS++;
			}
			A[j] = key;
			compIS++;
		}
	}
	/**********************/

	/***** Quicksort ******/
	/**********************/
	public void quicksort(int left, int right) {
		/** Algorithm variables **/
		int p;
		int l = left;
		int r = right;

		/** Initiate recursion so long as r>l **/
		if (r > l) {
			p = partition(l, r);
			quicksort(l, p - 1);
			quicksort(p + 1, r);
		}
	}

	public int partition(int left, int right) {
		/** Partition variables **/
		int key = A[right];
		int pL = left;
		int pR = right;

		/** Increment pL and pR to find values to swap **/
		while (pL < pR) {
			while (A[pL] < key) {
				pL = pL + 1;
				compQS++;
			}

			while ((A[pR] >= key) && (pR > left)) {
				pR = pR - 1;
				compQS++;
			}

			if (pL < pR) {
				swap(pL, pR);
			}
		}

		swap(pL, right);
		return pL;
	}

	/** Method to swap values in array **/
	public void swap(int a, int b) {
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}

	/** Returns usedSize value **/
	public int getUsedSize() {
		return usedSize;
	}

	public void newSort() {

		int min;
		int pos = 0;

		while (pos < usedSize) {
			min = findMinFrom(pos);
			for (int i = pos; i < usedSize; i++) {
				if (A[i] == min) {
					swap(i, pos);
					pos++;
					compNewS++;
				}
			}
		}
	}

	public int findMinFrom(int pos) {
		if (pos < 0 || pos >= usedSize) {
			throw new IllegalArgumentException("Error: Parameter is not valid index");
		}

		else {
			int min = A[pos];

			for (int i = pos + 1; i < usedSize; i++) {
				if (A[i] < min) {
					min = A[i];
					compNewS++;
				}
			}
			return min;
		}
	}

	public static void main(String[] args) {
		Sort s = new Sort(10);
		s.readIn("test1.txt");
		s.display(15, "before");
		s.newSort();
		s.display(15, "after");
		System.out.println("\n\n" + s.compNewS);

	}

}
/** End of Sort Class **/