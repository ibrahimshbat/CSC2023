/*****************************************************/
/*** Purpose: Various Integer Sorting Algorithms   ***/
/***                                               ***/
/***     Initial Author: Jason Steggles 20/09/15   ***/
/***     Extended by: Adam Hopper  19/10/15        ***/
/*****************************************************/

package AdamHopper;

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

	/***********************/

	/*** Insertion Sort ***/
	/***********************/

	public void insertionSort() {
		for (int i = 1; i < getUsedSize(); i++) {
			/** Copy and store value **/
			int key = A[i];
			int j = i;
			/**
			 * Increment compIS outside of while as even if it fails it will
			 * still compare it Set up 'space' and move it until correct
			 **/
			compIS = compIS + 1;
			while (j > 0 && key < A[j - 1]) {
				/** Increment comp **/
				compIS++;
				A[j] = A[j - 1];
				j = j - 1;
			}
			/** Insert key into space **/
			A[j] = key;
		}
	}

	/***********************/

	/****** Quicksort ******/
	/***********************/

	public void quickSort(int L, int R) {
		if (R > L) {
			/**
			 * Split into two then sort left and right based on partition return
			 **/
			int p = partition(L, R);
			quickSort(L, p - 1);
			quickSort(p + 1, R);
		}
	}

	public int partition(int left, int right) {
		/** Select pivot and set up pointers **/
		int v = A[right];
		int pL = left;
		int pR = right;
		/** Repeat until pointers cross **/
		while (pL < pR) {
			compQS++;
			/** While left pointer is < pivot value, move pointer **/
			while (A[pL] < v) {
				compQS++;
				pL = pL + 1;
			}
			compQS++;
			/**
			 * While right pointer is >= pivot and within bounds, move pointer
			 **/
			while ((A[pR] >= v) && (pR > left)) {
				compQS++;
				pR = pR - 1;
			}
			/** If left pointer is < right pointer then swap the values **/
			if (pL < pR) {
				swap(pL, pR);
			}
		}
		/**
		 * Finally, swap left pointer and end value then return pL to define
		 * where to recursively sort next
		 **/
		swap(pL, right);
		return pL;
	}

	public void swap(int i, int j) {
		/** Set up temp for the swap and then swap **/
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	/***********************/

	/******* newSort *******/
	/***********************/

	public void newSort() {
		int pos = 0;

		/** While position is within bounds of the array **/
		while (pos < getUsedSize()) { //
			/** Find the minimum value from the position onwards **/
			int min = findMinFrom(pos);
			for (int i = pos; i < getUsedSize(); i++) {
				/**
				 * Find the min value and swap it to the correct location. See
				 * InsertionSort comment on comp
				 **/
				compNewS++;
				if (A[i] == min) {
					swap(i, pos);
					/** Move position by one to narrow search **/
					pos = pos + 1;
				}
			}
		}
	}

	public int findMinFrom(int pos) {
		/** Take value of where to start in array **/
		int min = A[pos];
		/** Iterate through remaining values **/
		for (int i = pos + 1; i < getUsedSize(); i++) {
			compNewS++;
			/** If any value it finds is less than the current min... **/
			if (A[i] < min) {
				/** ... it becomes the new min value **/
				min = A[i];
			}
		}
		return min;
	}

} /** End of Sort Class **/