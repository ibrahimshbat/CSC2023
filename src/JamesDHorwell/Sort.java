/*****************************************************/
/*** Purpose: provide methods for different sorting
 *  algotiyhms                                      **/
/***                                               ***/
/***     Initial Author: Jason Steggles 20/09/15   ***/
/***     Extended by: Jamie Horwell   05/11/2015    ***/
/*****************************************************/
package JamesDHorwell;

import java.io.*;
import java.text.*;
import java.util.*;

public class Sort {

	/** Size of array **/
	private int size;

	/** Number of used elements in array **/
	private int usedSize;

	public int getUsedSize() {
		return usedSize;
	}

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
		int key;
		int j;
		for (int i = 1; i < usedSize; i++) {

			key = A[i];
			j = i;
			while (j > 0 && key < A[j - 1]) {
				compIS++;

				A[j] = A[j - 1];
				j = j - 1;

			}
			compIS++;

			A[j] = key;
		}

	}

	// *********Quick Sort methods****************\\
	public void quicksort(int left, int right) {
		int p;

		if (right > left) {
			p = partition(left, right);

			quicksort(left, p - 1);

			quicksort(p + 1, right);
		}

	}

	private int partition(int left, int right) {
		int pL, pR, v;
		v = A[right];
		pL = left;
		pR = right;

		while (pL < pR) {

			while (A[pL] < v) {
				compQS++;
				pL = pL + 1;
			}
			compQS++;
			while (A[pR] >= v && pR > left) {
				compQS++;
				pR = pR - 1;
			}
			compQS++;
			if (pL < pR) {

				swap(pL, pR);
			}
		}
		swap(pL, right);

		return pL;

	}

	// *************New Sort Methods**************\\
	public void newSort() {
		int pos = 0;
		int min;

		while (pos < usedSize) {
			min = findMinFrom(pos);
			for (int i = pos; i < usedSize; i++) {

				// swap all elements that are current minimum with current
				// position of array
				if (A[i] == min) {
					compNewS++;
					swap(i, pos);
					pos = pos + 1;
				} else {
					compNewS++;
				}
			}
		}

	}

	// loop through array from position, find minimum element
	public int findMinFrom(int pos) {
		int min = A[pos];
		for (int i = (pos + 1); i < usedSize; i++) {

			if (A[i] < min) {
				compNewS++;
				min = A[i];
			} else {
				compNewS++;
			}
		}
		return min;
	}

	// swap two elements of array
	private void swap(int index1, int index2) {
		int temp;
		temp = A[index1];
		A[index1] = A[index2];
		A[index2] = temp;

	}

}
/** End of Sort Class **/