package JakeHough;

/*****************************************************/
/*** Purpose:                                      ***/
/***                                               ***/
/***     Initial Author: Jason Steggles 20/09/15   ***/
/***     Extended by: Jake Hough  02/11/2015       ***/
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

	/***********************/

	/*** Insertion Sort ***/
	/***********************/
	public void insertionSort() {
		for (int i = 1; i < usedSize; i++) {
			// Loop around all elements within the array.
			int key = A[i];
			int j = i;
			compIS = compIS + 1;

			while ((j > 0) && (key < A[j - 1]))
			// J>0 stops falling off the end of array. Key is less than element
			// to left.
			{
				A[j] = A[j - 1];
				j = j - 1;
				compIS = compIS + 1;
			}
			A[j] = key;
		}
	}

	/***********************/

	/*** quickSort ***/
	/***********************/
	public void qSort() {
		quickSort(A, 0, usedSize - 1);
	}

	public void quickSort(int[] a, int l, int r) {
		int p = 0;

		if (r > l) {
			p = partition(A, l, r);
			quickSort(A, l, p - 1);
			quickSort(A, p + 1, r);
			// Recursive call
		}
	}

	public int partition(int[] a, int left, int right) {

		int v = A[right];
		int pL = left;
		int pR = right;

		while (pL < pR) {
			compQS = compQS + 1;
			// Compare left pointer is less than right pointer
			while (A[pL] < v) {
				pL++;
				compQS = compQS + 1;
				// Compare array elements to pivot
			}
			compQS = compQS + 1;
			while ((A[pR] >= v) && (pR > left)) {
				pR--;
				compQS = compQS + 1;
				// Compare array elements to pivot, whilst making sure doesn't
				// go past left pointer
			}

			if (pL < pR) {
				swap(A, pL, pR);
			}
		}
		swap(A, pL, right);
		return pL;
		// return pL to allow for recursive call.
	}

	public void swap(int[] a, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
		// Swap function used to switch 2 elements within an array.
	}

	/***********************/

	/*** New sort ***/
	/***********************/

	public void newSort() {

		int i = 0;
		int min = 0;
		int pos = 0;

		while (pos < usedSize) {
			min = findMinForm(A, pos);
			for (i = pos; i < usedSize; i++) {
				compNewS = compNewS + 1;
				// Loop around all elements in array (whilst pos < array size)
				if (A[i] == min) {
					compNewS = compNewS + 1;
					swap(A, i, pos);
					pos = pos + 1;
					// Compare array elements to min and apply swap
				}
			}
		}
	}

	public int findMinForm(int[] a, int pos) {
		int min = A[pos];
		for (int i = pos + 1; i < usedSize; i++) {
			compNewS = compNewS + 1;
			// Loop all elements in array
			if (A[i] < min) {
				compNewS = compNewS + 1;
				min = A[i];
				// Compare array elements to min and set new min, if no elements
				// are smaller than min then
				// New sort will check all elements
			}
		}
		return min;
	}
}

/** End of Sort Class **/