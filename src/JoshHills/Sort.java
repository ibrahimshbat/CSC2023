package JoshHills;

/*****************************************************/
/*** Purpose:	Perform several sorting algorithms ***/
/***		    on an array.					   ***/
/***                                               ***/
/***     Initial Author: Jason Steggles 20/09/15   ***/
/***     Extended by: Josh Hills 26/10/15          ***/
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
	public int compNewS; /** Global comparison count for 'new sort' **/

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

			// Reset counters.
			compIS = 0;
			compQS = 0;
			compNewS = 0;

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

	/****************************************/
	/*** Perform Insertion Sort on Array ***/
	/****************************************/

	/**
	 * Method performs insertion-sort on the class' private array.
	 */
	public void insertionSort() {

		// Advance through used elements of array...
		for (int i = 1; i < usedSize; i++) {

			// Store the current value being shifted.
			int key = A[i];
			// Retrieve initial index of value.
			int j = i;

			// While the key is less than the the previous element...
			while (j > 0 && key < A[j - 1]) {

				/**
				 * Log comparison made to array element from loop condition.
				 **/
				compIS++;

				// Shift the previous value forward to make space.
				A[j] = A[j - 1];
				// Decrement index.
				j = j - 1;

			}

			/**
			 * Log comparison made to array element from 'while' condition's
			 * failure.
			 **/
			compIS++;

			// Have found correct location for key value, apply it.
			A[j] = key;

		}

	}

	/***********************************/
	/*** Perform Quick-Sort on Array ***/
	/***********************************/

	/**
	 * Method initiates a quick-sort on the class' private array.
	 */
	public void quickSort() {

		// Initiate quick sort from private array.
		quickSort(0, usedSize - 1);

	}

	/**
	 * Method recursively performs quick-sort on subsections of array.
	 *
	 * @param left
	 *            Lowest bound of elements to sort.
	 * @param right
	 *            Highest bound of elements to sort.
	 */
	public void quickSort(int left, int right) {

		// Stop if only one value left.
		if (right > left) {

			// Determine pivot.
			int p = partition(left, right);

			// Recursively call function on sides adjacent to pivot.
			quickSort(left, p - 1);
			quickSort(p + 1, right);

		}

	}

	/**
	 * Method selects a pivot from sub-section of array, arranging elements with
	 * a lower value before it, and a higher value above it.
	 *
	 * @param left
	 *            Lowest bound of elements to sort.
	 * @param right
	 *            Highest bound of elements to sort.
	 * @return Index of pivot.
	 */
	public int partition(int left, int right) {

		/*
		 * Select pivot from right-most element, according to base algorithm.
		 */
		int v = A[right];

		// Set pointers to scan array section.
		int pL = left, pR = right;

		// Until pointers cross...
		while (pL < pR) {

			// Scan from left to right, find value greater than pivot.
			while (A[pL] < v) {

				/**
				 * Log comparison made to array element in 'while' condition.
				 **/
				compQS++;

				pL = pL + 1;

			}

			/**
			 * Log comparison made to array element from 'while' condition's
			 * failure.
			 **/
			compQS++;

			// Scan from right to left, find value greater than pivot.
			while (A[pR] >= v && pR > left) {

				/**
				 * Log comparison made to array element in 'while' condition.
				 **/
				compQS++;

				pR = pR - 1;

			}

			/**
			 * Log comparison made to array element from 'while' condition's
			 * failure.
			 **/
			compQS++;

			// Pointers have crossed- last iteration, prevent swapping.
			if (pL < pR) {

				// Put values on correct side of pivot.
				swap(pL, pR);

			}

		}

		// Put pivot in correct place.
		swap(pL, right);

		// Return the index to the pivot.
		return pL;

	}

	/**
	 * Utility function mutual to quick-sort and new-sort, swaps the values of
	 * two array indices.
	 *
	 * @param firstIndex
	 * @param secondIndex
	 */
	private void swap(int firstIndex, int secondIndex) {

		// Store temporary value to prevent complete over-write.
		int temp = A[firstIndex];

		// Swap the values.
		A[firstIndex] = A[secondIndex];
		A[secondIndex] = temp;

	}

	/***********************************/
	/*** Perform 'New Sort' on Array ***/
	/***********************************/

	/**
	 * Method performs the new sort on the class' private array
	 */
	public void newSort() {

		// Begin at start of array.
		int pos = 0;

		// So long as we do not exceed the array...
		while (pos < usedSize) {

			// Retrieve the smallest value following the current position.
			int min = findMinFrom(pos);

			// Up until the end of the array...
			for (int i = pos; i < usedSize; i++) {

				// If the current value matches the minimum...
				if (A[i] == min) {

					// Swap their positions.
					swap(i, pos);

					// Advance the position counter (account for duplicates).
					pos = pos + 1;

				}

				/**
				 * Log comparison made to array element in 'while' condition.
				 **/
				compNewS++;

			}

		}

	}

	private int findMinFrom(int pos) {

		// Assume initial minimum value.
		int min = A[pos];

		// Up until the end of used array elements...
		for (int i = pos + 1; i < usedSize; i++) {

			// If the new value is less than the current minimum...
			if (A[i] < min) {

				// Set the new minimum.
				min = A[i];

			}

			/** Log comparison made to array element in 'if' condition. **/
			compNewS++;

		}

		// Return minimum value following argument.
		return min;

	}

} /** End of Sort Class **/