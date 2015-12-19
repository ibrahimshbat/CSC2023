package HaydenJamieson;

/*****************************************************/
/*** Purpose:                                      ***/
/***                                               ***/
/*** Initial Author: Jason Steggles 20/09/15   	   ***/
/*** Extended by: Hayden Jamieson Date: 24/10/2015 ***/
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
	public int compNewS; /** Global comparison count for new sort **/

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

	public void insertionSort() {
		/**
		 * This method will use insertion sort to sort the array of integers
		 **/

		// Current index to try (location of space)
		int j = 0;

		// Value of insert
		int key = 0;

		for (int i = 1; i < usedSize; i++) {

			// Store next value to insert
			key = A[i];
			j = i;

			/** FINDS CORRECT POSITION FOR KEY **/
			while (j > 0 && key < A[j - 1]) {
				compIS++;
				// Push space left
				A[j] = A[j - 1];
				j = j - 1;
			}
			compIS++;

			// Insert key into space
			A[j] = key;
		}

	}

	public void qs() {
		qsort(0, usedSize - 1);
	}

	public void qsort(int L, int R) {

		// Index of pivot after partition
		int pivot = 0;
		if (R > L) {
			pivot = partition(L, R);
			qsort(L, pivot - 1);
			qsort(pivot + 1, R);
		}

	}

	public int partition(int left, int right) {
		int pivot;
		int pL;
		int pR;

		// Select pivot
		pivot = A[right];
		pL = left;
		pR = right;

		// Keep going round
		while (pL < pR) {
			// Moves pL
			while (A[pL] < pivot) {
				compQS++;
				pL = pL + 1;
			}
			compQS++;

			while (A[pR] >= pivot && pR > left) {
				compQS++;
				pR = pR - 1;
				// Don't swap on last iteration
			}
			compQS++;

			if (pL < pR) {
				swap(A, pL, pR);
			}
		}

		// This is a swap
		swap(A, pL, right);

		// Return pivot location
		return pL;
	}

	public void newSort() {
		int pos, min, i;
		pos = 0;

		// Loop while counter less than array size
		while (pos < usedSize) {
			// Find minimum value
			min = findMinFrom(A, pos);
			for (i = pos; i < usedSize; i++) {
				if (A[i] == min) {
					// If find minimum value
					swap(A, i, pos);
					pos = pos + 1;
				}
				compNewS++;

			}
		}
	}

	public int findMinFrom(int[] a, int pos) {
		int min, i;

		min = A[pos];

		for (i = pos + 1; i < usedSize; i++) {
			if (A[i] < min) {
				// Update min with smallest value
				min = A[i];
			}
			compNewS++;
		}

		return min;

	}

	public void swap(int[] a, int index1, int index2) {
		int temp;

		// Swap elements around
		temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}

} /** End of Sort Class **/