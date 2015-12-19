package YousafHussain;

/*****************************************************/
/*** Purpose:                                      ***/
/***                                               ***/
/***     Initial Author: Jason Steggles 20/09/15   ***/
/***     Extended by: Yousaf Hussain    Date            ***/
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
		int s = usedSize;
		int key, j = 0;

		for (int i = 1; i < s; i++) { // begin at position 1, run through
			key = A[i]; // store the next value to insert/reorder
			j = i;

			while (j > 0 && key < A[j - 1]) { // if key is higher than the value
												// on the left it moves the
												// space
				A[j] = A[j - 1]; // push one space to the left on index of array
				j--;
				compIS++;
			}
			compIS++;
			A[j] = key; // inserts key into space
		}
	}

	public void qSort() {
		quickSort(0, usedSize - 1);
	}

	public void quickSort(int L, int R) { // L/R is left and right pointer

		if (R > L) { // stops if theres only one value left

			int p = partition(L, R); // split array in two
			quickSort(L, p - 1); // sorts the left half
			quickSort(p + 1, R); // sorts the right half
		}
	}

	public int partition(int L, int R) {
		int v = A[R]; // selects pivot
		int pL = L;
		int pR = R; // scanning pointers

		while (pL < pR) { // repeats until the scanning pointers cross

			while (A[pL] < v) { // move pL
				pL++;
				compQS++;
			}

			while (pR > L && A[pR] >= v) { // move pR
				pR--;
				compQS++;
			}

			if (pL < pR) { // prevents swapping on the last iteration
				swap(pL, pR);
			}
			compQS++;
		}
		compQS++;

		swap(pL, R); // puts the pivot in the correct position
		return pL;
	}

	public void swap(int pL, int pR) { // method to swap left and right pointers

		int x = A[pL];
		A[pL] = A[pR];
		A[pR] = x;
	}

	public void newSort() {
		int pos = 0;
		int size = usedSize;
		int min;

		while (pos < size) { // only when position is less than size of array
			min = findMinFrom(pos); // pass pos through findMinFrom method

			for (int i = pos; i <= size - 1; i++) { // loop through array
				if (A[i] == min) {
					swap(i, pos); // if i == minimum value, swap position with i
					pos++; // increment position by 1
				}
				compNewS++;
			}
		}
	}

	public int findMinFrom(int pos) { // method for finding the new minimum
										// value using the incremented position
		int size = usedSize;
		int min = A[pos];
		for (int i = pos + 1; i < size - 1; i++) {
			if (A[i] < min) {
				min = A[i];
			}
			compNewS++;
		}
		return min; // new min returned to the newSort method
	}

}
/** End of Sort Class **/