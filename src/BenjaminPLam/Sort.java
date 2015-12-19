package BenjaminPLam;

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

		/**
		 * Reset comparison counters to zero when a new test file is read in
		 **/
		compIS = 0;
		compQS = 0;
		compNewS = 0;
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

	/** Insertion sort method **/
	public void insertionSort() {
		for (int i = 1; i < usedSize; i++) /**
											 * Loop round from 0 to last array
											 * index
											 **/
		{
			int key = A[i]; // Stores value to sort into int variable key
			int j = i; // Current index

			while ((j > 0) && (key < A[j - 1])) // Checks to avoid out of array
												// bounds index and whether key
												// is less
												// than value to left
			{
				compIS = compIS + 1; // increment comparison counter

				A[j] = A[j - 1]; // push space to left of array
				j = j - 1;
			}

			compIS = compIS + 1; // Increment comparison counter to check since
									// array value was checked
			A[j] = key; // position key into the jth index

		}
	}

	/** Method to call quicksort algorithm **/
	public void performQuickSort() {
		quickSort(A, 0, usedSize - 1); // calls the actual quicksort algorithm

	}

	/** Quicksort method **/
	public void quickSort(int[] array, int L, int R) {
		int pivotIndex;
		if (R > L) // checks if the right pointer is greater than left pointer
					// to avoid overlapping
		{
			pivotIndex = partition(array, L, R);

			/** Recursive calls to quicksort **/
			quickSort(array, L, pivotIndex - 1); // Sorts left half
			quickSort(array, pivotIndex + 1, R); // Sorts right half
		}
	}

	/** Method for partitioning an array in quicksort **/
	private int partition(int[] array, int left, int right) {
		int pivot = array[right]; // selected pivot at rightmost element

		int pL = left;
		int pR = right;

		while (pL < pR) // execute until scanning pointers intersect
		{

			while (array[pL] < pivot) // move right while the element at index
										// pL is less than the pivot
			{
				pL = pL + 1; // Increment index
				compQS = compQS + 1; // increment comparison counter
			}
			compQS = compQS + 1; // a comparison was made, so the counter is
									// again incremented

			while (array[pR] >= pivot && pR > left) // ensures that pointer does
													// not fall out of array
													// bounds
			{
				compQS = compQS + 1;

				pR = pR - 1; // decrements right pointer while the element at pR
								// is greater than or equal to pivot
			}
			compQS = compQS + 1;
			if (pL < pR) {
				swap(array, pL, pR);
			}
		}

		swap(array, pL, right);
		return pL;
	}

	/** Method to swap values in an integer array **/
	private int[] swap(int[] array, int A, int B) {

		int temp = array[B];
		/**
		 * Stores element value temporarily in a variable to enable exchange of
		 * elements
		 **/
		array[B] = array[A];
		array[A] = temp;

		return array; // returns array with Ath and Bth element swapped
	}

	// **New sort algorithm**/
	public void newSort() {
		int pos = 0;

		while (pos < usedSize) // repeats while the position does not reach end
								// of array
		{
			int min = findMinFrom(A, pos); // finds minimum value in array from
											// pos

			for (int i = pos; i <= usedSize - 1; i++) // repeats until last
														// index has been
														// reached
			{
				compNewS = compNewS + 1; // increments comparison counter
				if (A[i] == min) // if the current element is equal to minimum
				{
					swap(A, i, pos); // swap element at current element with
										// element at pos
					pos = pos + 1;
				}
			}
		}
	}

	/** Method to return minimum value in an array elements **/
	private int findMinFrom(int[] array, int pos) {
		int min = array[pos]; // the minimum element is assigned to min

		for (int i = pos + 1; i < usedSize; i++) { // loops while the end of the
													// array has not been
													// reached
			if (array[i] < min) { // if the current element is less than the
									// minimum, then the current element is
									// assigned to be minimum
				min = array[i];
			}
			compNewS = compNewS + 1;
		}
		return min; // returns the new minimum if found or original if not
	}
}
/** End of Sort Class **/