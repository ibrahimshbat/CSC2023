package AtakanIzdas;

/*****************************************************/
/*** Purpose:                                      ***/
/***                                               ***/
/***     Initial Author: Jason Steggles 20/09/15   ***/
/***     Extended by: Atakan Izdas    05/11/15     ***/
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
	public static int[] A; // why not

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

	/**********************/
	/***
	 * Insertion Sort*** / /
	 **********************/
	public void InsertionSort(int[] arr) {

		int i, j, key; // Initialize variables used

		for (i = 1; i < A.length; i++) { // To check if it reached the end of
											// the array

			compIS++; // Increment computation variable

			key = arr[i]; // Store the next value to insert

			j = i;

			while (j > 0 && key < arr[j - 1]) { // Found the correct position
												// for key?

				arr[j] = arr[j - 1]; // No - Push space to the left

				compIS++; // Increment computation variable

				j--;
			}
			arr[j] = key; // Yes! - Insert the key in space
		}
		compIS++; // Increment computation variable
	}

	/******************************/

	/*** Initialize Quicksort ***/
	/******************************/
	public void QuickSort(int[] arr) {

		runQuickSort(arr, 0, arr.length - 1); // Initial values
	}

	/********************************/

	/*** Quicksort Implementation ***/
	/********************************/
	public void runQuickSort(int[] arr, int left, int right) {

		int pivot; // Pivot point after each computation

		if (right > left) { // End loop if only one value left

			compQS++; // Increment computation variable

			pivot = Partition(arr, left, right);// Split array into two halves
			runQuickSort(arr, left, pivot - 1); // Sort left side of the array
			runQuickSort(arr, pivot + 1, right);// Sort right side of the array

		}

	}
	/******************************/

	/*** Partition Method ***/
	/******************************/
	private int Partition(int[] arr, int left, int right) {

		int pR = right; // Initialize pointers
		int pL = left;

		int getPivot = arr[right]; // Initialize rightmost element as pivot

		while (pL < pR) // Stop if pointers cross (all elements processed)

		{
			compQS++; // Increment computation variable

			while (arr[pL] < getPivot) {
				pL++; // Move left pointer (pL)
				compQS++; // Increment computation variable
			}

			while (arr[pR] >= getPivot && pR > left) // pR>left => To stop when
														// it reaches the start
														// of the array
			{
				pR--; // Move right pointer (pR)
				compQS++; // Increment computation variable
			}

			if (pL < pR) // Don't swap in last iteration!
			{
				compQS++; // Increment computation variable
				swap(arr, pL, pR);

			}
		}

		swap(arr, pL, right); // Insert pivot to its correct position

		return pL;
	}

	/*************************/

	/*** NewSort Algorithm ***/
	/*************************/
	public void newSort(int[] arr) {

		int min; // Initialize variables
		int pos = 0;

		while (pos < arr.length) // Stop if current position is at the end of
									// the array
		{
			min = getMin(arr, pos); // Get minimum value in the array(check
									// method below)

			for (int i = pos; i < arr.length; i++) // Iterate through array
			{
				compNewS++; // Increment computation variable

				if (arr[i] == min) {
					swap(arr, i, pos); // Put min value in the position
					pos++; // Next element
				}
			}
		}
	}

	public int getMin(int[] arr, int pos) {

		int min = arr[pos];

		for (int i = pos + 1; i < arr.length; i++) // Compare values in each
													// iteration */
		{
			compNewS++; // Increment computation variable

			if (arr[i] < min) // Find minimum value
			{

				min = arr[i]; // Index of min value
			}
		}

		return min;
	}

	/*******************/

	/*** Swap Method ***/
	/*******************/

	/* Basic swap method to be used in quicksort and newsort */

	private void swap(int[] arr, int i, int min) {

		int tempSwap;

		tempSwap = arr[i];
		arr[i] = arr[min];
		arr[min] = tempSwap;
	}

} /** End of Sort Class **/