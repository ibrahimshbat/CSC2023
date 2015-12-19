package KiyavashKandar;

/**********************************************************/
/*** Purpose: Sort arrays using 3 different algorithms  ***/
/***                                               		***/
/***     Initial Author: Jason Steggles 20/09/15   		***/
/***     Extended by: Kiyavash Kandar	05/11/2015      ***/
/**********************************************************/

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
		}

		catch (IOException e) {
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

	/***********************************************/

	/*** Sort Array Via InsertionSort Algorithm ***/
	/***********************************************/
	public void insertionSort() {
		for (int i = 1; i < usedSize; i++) {
			int key = A[i]; // The value being moved
			int j = i; // Next index to try

			/**
			 * Keep moving key backwards as long as key is larger than the
			 * compared value
			 **/
			while ((j > 0) && (key < A[j - 1])) {
				compIS++;
				A[j] = A[j - 1]; // Swap the values in the array, moving key
									// backwards
				j = j - 1;
			}
			compIS++;
			// Insert key into correct place for now
			A[j] = key;
		}
	}

	/*******************************************/
	/*** Sort Array Via QuickSort Algorithm ***/
	/*******************************************/

	/** Used so that quickSort method parameters are not needed **/
	public void callQuickSort() {
		quickSort(0, usedSize - 1);
	}

	public void quickSort(int L, int R) { // Take inputs of left and right
											// pointers to start
		int p; // Index of pivot

		if (R > L) {
			p = partition(L, R);
			/** Recursively sort left and right sides separately **/
			quickSort(L, p - 1);
			quickSort(p + 1, R);
		}
	}

	public int partition(int left, int right) {
		int pL = left;
		int pR = right;
		int v = A[right]; // Select pivot

		while (pL < pR) { // Repeat until pointers cross
			while (A[pL] < v) { // Move left pointer
				compQS++;
				pL = pL + 1;
			}
			compQS++;

			while ((A[pR] >= v) && (pR > left)) { // Move right pointer
				compQS++;
				pR = pR - 1;
			}
			compQS++;

			if (pL < pR) {
				// Swap values pointed at on the last iteration
				int temp = A[pR];
				A[pR] = A[pL];
				A[pL] = temp;
			}
		}
		// Swap to put pivot into correct position
		int temp = A[right];
		A[right] = A[pL];
		A[pL] = temp;

		return pL;
	}

	/*****************************************/

	/*** Sort Array Via NewSort Algorithm ***/
	/*****************************************/
	public void sort() {
		int min;
		int pos = 0;

		while (pos < usedSize) {
			min = findMinFrom(pos); // Find smallest value that comes AFTER the
									// value at index pos
			for (int i = pos; i < usedSize; i++) {
				if (A[i] == min) {
					int temp = A[pos]; // Swap values at indexes pos and i
					A[pos] = A[i];
					A[i] = temp;

					pos++; // Move pos forward as all previous values are sorted
				}
				compNewS++;
			}
		}
	}

	public int findMinFrom(int pos) {
		int min = A[pos];
		for (int i = pos + 1; i < usedSize; i++) {
			if (A[i] < min) {
				min = A[i]; // Set min as smallest value found after index pos
			}
			compNewS++;
		}
		return min;
	}

} /** End of Sort Class **/