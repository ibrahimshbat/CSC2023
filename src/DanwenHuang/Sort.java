package DanwenHuang;

/*****************************************************/
/*** Purpose:                                      ***/
/***                                               ***/
/***     Initial Author: Jason Steggles 20/09/15   ***/
/***     Extended by: Your Name    Date            ***/
/*****************************************************/

import java.io.*;
import java.lang.reflect.Array;
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

		for (int i = 1; i < usedSize; i++) {
			// Store next value to insert (key)
			int key = A[i];
			int currentIndex = i;
			// Find correct position for key
			while (currentIndex > 0 && key < A[currentIndex - 1]) {
				compIS++;
				// Push space left
				A[currentIndex] = A[currentIndex - 1];
				currentIndex = currentIndex - 1;
			}
			// Insert key into space
			compIS++;
			A[currentIndex] = key;
		}

	}

	/**********************/

	/*** Quick Sort ***/
	/**********************/

	// Method for swapping values
	public static void swap(int A[], int pL, int pR) {
		int temp = A[pL];
		A[pL] = A[pR];
		A[pR] = temp;
	}

	// Method for partitioning
	public int partition(int A[], int left, int right) {
		// Select pivot
		int pivot = A[right];
		// Initialising pointers
		int pL = left;
		int pR = right;
		int temp;

		// Repeat until scanning pointers cross
		while (pL < pR) {

			while (A[pL] < pivot) {
				// Move pL
				pL = pL + 1;
				compQS++;
			}
			compQS++;
			while (A[pR] >= pivot && pR > left) {
				// Move pR
				pR = pR - 1;
				compQS++;
			}
			compQS++;

			// Swapping the elements around when pointers cross
			if (pL < pR) {
				swap(A, pL, pR);
			}
		}
		// Put pivot in correct position
		swap(A, pL, right);
		return pL;
	}

	// Quicksort method
	public void quickSort(int[] A, int l, int r) {

		// initialise index of pivot after partition
		int pI;

		if (r > l) {
			pI = partition(A, l, r);

			// Sort left half
			quickSort(A, l, pI - 1);
			// Sort right half
			quickSort(A, pI + 1, r);
		}
	}

	// Method to call when testing the quicksort
	public void sort() {
		// check for empty or null array
		if (A == null || A.length == 0) {
			return;
		}
		quickSort(A, 0, usedSize - 1);
	}

	/**********************/

	/*** New Sort ***/
	/**********************/

	public void newSort() {
		// Initialises position pointer
		int pos = 0;

		while (pos < usedSize) {
			// Find the minimum of the array
			int min = findMinFrom(A, pos);

			for (int i = pos; i < usedSize; i++) {
				// Swap indexes when value equals minimum
				compNewS++;
				if (A[i] == min) {
					swap(A, i, pos);
					// Increment position
					pos = pos + 1;
				}
			}
		}
	}

	public int findMinFrom(int[] A, int pos) {
		int min = A[pos];
		// Iterate through array and find minimum value
		for (int i = pos + 1; i < usedSize; i++) {
			// Sets the minimum
			compNewS++;
			if (A[i] < min) {
				min = A[i];
			}
		}
		return min;
	}

}
/** End of Sort Class **/