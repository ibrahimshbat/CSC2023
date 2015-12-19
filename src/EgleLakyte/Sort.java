package EgleLakyte;

/*****************************************************/

/*** Purpose: Understanding Sort Algorithms ***/

/*** ***/

/*** Initial Author: Jason Steggles 20/09/15 ***/

/*** Extended by: Egle Lakyte 24/10/15 ***/

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

	/** Global comparison count for QuickSort **/

	public int compNewS;

	/** Global comparison count for new sort **/

	/*****************/

	/** Constructor **/

	/*****************/

	Sort(int max) {

		/** Initialise global sort count variables **/

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

		System.out.print("\n\n" + header + "\n");

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

	// methods for counting the number for comparisons made. Everytime the
	// comparison with the element from the array is used, I use this method to
	// return the same used value, but adding a comparison to account while
	// using it.

	public int countQS(int i) {

		compQS++;

		return i;

	}

	public int countIS(int i) {

		compIS++;

		return i;

	}

	public int countNewS(int i) {

		compNewS++;

		return i;

	}

	// Insertion sort

	public void insertionSort() {

		// value to insert
		int key = 0;

		// current index to try
		int j = 0;

		for (int i = 1; i < usedSize; i++) {

			key = A[i];

			j = i;

			// finds the correct position for key
			while (j > 0 && key < countIS(A[j - 1])) {

				// pushes space to left
				A[j] = A[j - 1];

				j = j - 1;

			}

			// Inserts key into the empty space
			A[j] = key;

		}

	}

	// returns the position of the last element in the array. Used for QuickSort
	public int lastElement() {

		return (usedSize - 1);

	}

	// QuickSort
	public void quickSort(int L, int R) {

		int p;

		if (R > L) {

			// splits array in two
			p = partition(L, R);

			// sorts left side
			quickSort(L, p - 1);

			// sorts right side
			quickSort(p + 1, R);

		}

	}

	// Partition
	public int partition(int left, int right) {

		// selects pivot
		int v = A[right];

		// left pointer
		int pL = left;

		// right pointer
		int pR = right;

		// repeats until scanning pointers cross
		while (pL < pR) {

			// moves left pointer
			while (countQS(A[pL]) < v) {
				pL++;
			}

			// moves right pointer
			while (countQS(A[pR]) >= v && pR > left) {
				pR--;
			}

			if (pL < pR) {

				int s = A[pL];

				A[pL] = A[pR];

				A[pR] = s;

			}

		}

		// puts pivot in correct position
		int s = A[pL];

		A[pL] = A[right];

		A[right] = s;

		return pL;

	}

	// newSort
	public void newSort() {

		int pos = 0;

		while (pos < usedSize) {

			// takes the min value
			int min = findMinFrom(pos);

			// starts on the given position and runs till reaches the end of
			// the array
			for (int i = pos; i < usedSize; i++) {

				// searches for duplicates
				if (countNewS(A[i]) == min) {

					// swaps found duplicates with the unsorted elements at the
					// start of the array
					int swap = A[i];

					A[i] = A[pos];

					A[pos] = swap;

					// increments position count
					pos++;

				}
				// repeats the for loop till all the duplicates of min are
				// sorted
			}

		}

	}

	// findMinFrom
	public int findMinFrom(int pos) {

		int min = A[pos];

		// goes from the given position to the end of array and finds min value
		for (int i = pos + 1; i < usedSize; i++) {

			if (countNewS(A[i]) < min) {

				min = A[i];

			}

		}

		// returns min value
		return min;

	}

}