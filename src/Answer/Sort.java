package Answer;
/*****************************************************/
/*** Sort class contain a range of sorting methods ***/
/*** ***/
/*** Initial Author: Jason Steggles 20/09/15 ***/
/*** Extended by: Students Name and Date ***/

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
	/**********************************************************/
	/*** Methods below should have been written by students ***/
	/**********************************************************/
	/**********************/

	/*** Insertion sort ***/
	/**********************/
	public void insertSort() {
		int key = 0;
		int j = 0;
		/** Insert each array element in turn **/
		for (int i = 1; i < usedSize; i++) {
			/** Set current value to insert and note its position **/
			key = A[i];
			j = i;
			/** Find where to insert key **/
			while ((j > 0) && (key < A[j - 1])) {
				/** Shift space to left **/
				A[j] = A[j - 1];
				j = j - 1;
				/** Add one to number of comparisons **/
				compIS++;
			}
			/** Add one to number of comparisons for failed test **/
			compIS++;
			/** Insert current value **/
			A[j] = key;
		}
	}
	/***********************************/

	/*** Swap elements over in array ***/
	/***********************************/
	private void swap(int i, int j) {
		int temp = 0;
		/** Do swap using temp to store value **/
		temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	/***************************************************/

	/*** Partition array so LHS < pivot, RHS > pivot ***/
	/***************************************************/
	private int partition(int left, int right) {
		int pivot;
		int pL, pR;
		/** Select pivot value - rightmost **/
		pivot = A[right];
		/** Set scanning pointers **/
		pL = left;
		pR = right;
		/** Do partition **/
		while (pL < pR) {
			/** Move left pointer **/
			while (A[pL] < pivot) {
				pL++;
				/** add one to comparison count **/
				compQS++;
			}
			/** add one to comparison count **/
			compQS++;
			/** Move right pointer **/
			while ((pR > left) && (A[pR] >= pivot)) {
				pR--;
				/** add one to comparison count **/
				compQS++;
			}
			/** add one to comparison count **/
			compQS++;
			/** Swap elements as long as pointers haven't crossed **/
			if (pL < pR)
				swap(pL, pR);
		}
		/** place pivot in correct position **/
		swap(pL, right);
		return pL;
	}
	/***************************/

	/*** Quicksort algorithm ***/
	/***************************/
	private void quickSort(int left, int right) {
		if (right > left) {
			/** Partition array **/
			int pos = partition(left, right);
			/** Recursive calls **/
			quickSort(left, pos - 1);
			quickSort(pos + 1, right);
		}
	}
	/*****************************/

	/*** Main Quicksort method ***/
	/*****************************/
	public void quickSort() {
		quickSort(0, usedSize - 1);
	}
	/**************************************************************/

	/*** Find min value in array from a given starting position ***/
	/**************************************************************/
	public int findMinFrom(int pos) {
		/** Check start is within size of array **/
		if ((pos < 0) || (pos >= usedSize)) {
			/** start is out of bounds **/
			System.out.print("\nError: pos out of bounds");
			return -1;
		} else {
			/** Okay to use start as an initial position in array **/
			/** Initialise min value **/
			int min = A[pos];
			/** Look at each array element in turn **/
			for (int i = pos + 1; i < usedSize; i++) {
				/** Add one to number of comparisons for check **/
				compNewS++;
				/** Check if new min has been found **/
				if (min > A[i]) {
					/** Update min **/
					min = A[i];
				}
			}
			/** Return min value **/
			return min;
		}
	}
	/****************/

	/*** New sort ***/
	/****************/
	public void newSort() {
		/** Initialise position in array we are trying to fill **/
		int pos = 0;
		/** Initialise min value **/
		int min = 0;
		/** Insert each array element in turn **/
		while (pos < usedSize) {
			/** Update min value **/
			min = findMinFrom(pos);
			/**
			 * Find all values equal to min and place together in correct sorted
			 * place
			 **/
			for (int i = pos; i < usedSize; i++) {
				/** Add one to number of comparisons **/
				compNewS++;
				/** Check if equal to min **/
				if (A[i] == min) {
					swap(i, pos);
					pos++;
				}
			}
		}
	}
} /** End of Sort Class **/
