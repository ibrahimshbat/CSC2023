package OwenDHerman;

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

		for (int i = 1; i < A.length; i++) {

			/** storing next value to insert **/
			int key = A[i];

			/** location of space **/
			int j = i;

			compIS = compIS + 1;
			/** find correct position for the key **/
			while (j > 0 && key < A[j - 1]) {
				A[j] = A[j - 1];
				j = j - 1;

				/** add 1 to the comparison counter **/
				compIS = compIS + 1;
			}

			/** insert key into space **/
			A[j] = key;
		}

	}

	/******************/

	/*** Quicksort ***/
	/******************/

	public void quicksortParameters() {

		/** Initialize quicksort parameters **/
		quickSort(0, A.length - 1);

	}

	public void quickSort(int L, int R) {

		int p = 0;
		if (R > L) {

			/** Split array into using the partition algorithm **/
			p = partition(L, R);

			/** Sort left half **/
			quickSort(L, p - 1);

			/** Sort right half **/
			quickSort(p + 1, R);
		}

	}

	/********************************/

	/*** Partition for Quicksort ***/
	/**
	 * @return
	 ******************************/

	public int partition(int L, int R) {

		/** initialise scanning pointers **/
		int pL = L;
		int pR = R;

		/** initialise pivot value **/
		int v = A[R];
		int holding = 1;
		while (pL < pR) {

			/** move left pointer **/
			while (A[pL] < v) {
				pL = pL + 1;
				compQS = compQS + 1;
			}

			/** move right pointer **/
			while (A[pR] >= v && pR > L) {
				pR = pR - 1;
				compQS = compQS + 1;
			}

			if (pL < pR) {

				/** Swapping values within the array **/
				holding = A[pL];
				A[pL] = A[pR];
				A[pR] = holding;
			}

		}
		holding = A[pL];
		A[pL] = A[R];
		A[R] = holding;
		return pL;

	}

	/***************************************/

	/*** Find minimum value for Newsort ***/
	/**
	 * @return
	 *************************************/
	public int findMinFrom(int pos) {

		/** Locating the minimum value for new sort **/
		int min = A[pos];
		for (int i = pos + 1; i <= A.length - 1; i++) {
			if (A[i] < min) {
				min = A[i];

			}
			compNewS = compNewS + 1;
		}
		return min;
	}

	/******************/

	/*** Newsort ***/
	/******************/

	public void newSort() {
		int pos = 0;
		int holding = 1;

		while (pos < A.length) {
			int min = findMinFrom(pos);
			for (int i = pos; i <= A.length - 1; i++) {
				if (A[i] == min) {

					/** swapping the values in the array **/
					holding = A[i];
					A[i] = A[pos];
					A[pos] = holding;
					pos = pos + 1;

				}
				compNewS = compNewS + 1;
			}
		}

	}

}
/** End of Sort Class **/