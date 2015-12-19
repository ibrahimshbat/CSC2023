package LisaMariaLamprecht;

/******************************************************/
/*** Purpose: Includes the following working sorting***/
/***          methods: Insertion sort, Quicksort and***/
/***                   newSort                      ***/
/***                                                ***/
/***     Initial Author: Jason Steggles 20/09/15    ***/
/***     Extended by: Lisa-Maria Lamprecht 5/11/15 ***/
/******************************************************/

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

	/******************************/

	/*** Insertion Sort Method ***/
	/******************************/

	public void insertionSort() {
		int i; /** index of insertion value **/
		int j; /** current index to try (location of space) **/
		int key; /** value to insert **/

		for (i = 1; i < usedSize; i++) { /**
											 * start with 1 not 0 because it
											 * assumes first index is sorted
											 **/
			key = A[i]; /** store next value to insert **/
			j = i;
			/**
			 * This while loop finds the correct position for key loop stops
			 * when the current index 'j' to try is >0 and when the 'key' value
			 * to insert is <A[j-1]
			 */
			while ((j > 0) && (key < A[j - 1])) {
				A[j] = A[j - 1]; /** push space left by shifting the element **/
				j = j - 1; /** moves current index backwards towards 0 **/
				compIS++; /**
							 * increments compIS for each comparison that includes
							 * array while true
							 **/
			}
			compIS++; /**
						 * increments compIS for the comparison when while is
						 * false
						 **/
			A[j] = key; /** insert key into correct space to be sorted **/
		}
	}

	/**
	 * This is a swap method that is used several other times in other methods
	 * it is made to improve code efficiency The parameters taken in are
	 * necessary to swap elements into their correct position
	 */
	private void swap(int[] a2, int pL, int pR) {

		int temp = a2[pL]; /** creates a temp of one element in the array */
		a2[pL] = a2[pR]; /**
							 * replaces the value of the element in the array just
							 * copied with other element
							 */
		a2[pR] = temp; /**
						 * changes value of other element which was replacing
						 * another element to temp
						 */
	}

	/**************************/
	/*** Quick Sort Method ***/

	/**************************/
	/**
	 * This is a quicksort method that sorts recursively left and right
	 * represent the left and right array pointers p represents the index of the
	 * pivot after partition
	 */
	public void quickSort(int A[], int left, int right) {
		Integer p;
		/**
		 * Therefore if right>left is false it means it will stop the sort if
		 * there is only one value left because it will be sorted
		 */
		if (right > left) {
			/** partition method is called and it splits the array into two */
			p = partition(A, left, right);
			/**
			 * recursively calls itself, so that the left half of the array will
			 * be sorted
			 */
			quickSort(A, left, p - 1);
			/**
			 * recursively calls itself, so that the right half of the array
			 * will be sorted
			 */
			quickSort(A, p + 1, right);
		}

	}

	/**
	 * This quicksort method has no parameters and it overrides the quicksort
	 * method above. I have used it so that when testing I do not have to
	 * include all the parameters in quicksort each time. Therefore this saves
	 * from extra unnecessary coding
	 */
	public void quickSort() {
		quickSort(A, 0, usedSize - 1);

	}

	/**
	 * This partition method is called in quickSort and it splits the array into
	 * two which will thus enable each half of the array to be sorted at a later
	 * stage. It takes in 3 parameters like the quick sort
	 */
	private Integer partition(int[] a2, int left, int right) {
		int pivot = A[right]; /**
								 * pivot value is made assigned to right array
								 * pointer
								 **/
		int pL = left; /** scanning pointer left **/
		int pR = right; /** scanning pointer right **/

		while (pL < pR) { /** repeat until scanning pointers cross **/
			while (A[pL] < pivot) { /** move pL **/
				compQS++; /**
							 * Increment compQS to count number of array
							 * comparisons while true
							 */
				pL++; /** Increment left pointer */
			}
			compQS++; /**
						 * Increment compQS to count the array comparison for when
						 * while is false
						 */

			while ((A[pR] >= pivot) && (pR > left)) { /** move pR **/
				compQS++; /**
							 * Increment compQS to count number of array
							 * comparisons while true
							 */
				pR--; /** Decrement right pointer */
			}
			compQS++; /**
						 * Increment compQS to count the array comparison for when
						 * while is false
						 */

			if (pL < pR) { /** swap values as long as not on last iteration **/
				swap(A, pL, pR); /**
									 * calls the swap method to swap the pL and pR
									 * pointers in the array
									 */
			}
		}
		swap(A, pL, right); /**
							 * swaps the pL pointer and right in the array when
							 * scanning pointers cross
							 */
		return pL;
	}

	/***************************/
	/*** findMinFrom Method ***/

	/***************************/
	/**
	 * Find the minimum value in the array so that it can be swapped into its
	 * correct position in the newSort method the array and position parameters
	 * are passed in
	 */
	private int findMinFrom(int[] a2, int pos) {
		int min = A[pos]; /**
							 * variable min is assigned to the current position in
							 * the array
							 */
		/**
		 * the for loop increments from the current position +1 to the used size
		 * (because 'pos' needs to find a different smaller value than itself in
		 * the array) once the loop has finished min should be the smallest
		 * unsorted value in the array
		 */
		for (int i = pos + 1; i < usedSize; i++) {
			if (A[i] < min) { /**
								 * if this is true then a value smaller than min
								 * has been found
								 */
				min = A[i]; /**
							 * the min value is then assigned to the new min
							 * found
							 */
			}
			compNewS++; /**
						 * Increments compNewS to count array comparison from
						 * the if statement this will therefore count the
						 * comparison regardless of if being true or false
						 */
		}
		return min;
	}

	/***********************/
	/*** newSort Method ***/

	/***********************/
	/**
	 * Similar to the selection sort but slightly different because the number
	 * of comparisons is affected by the number of unique values in the array.
	 * The more unique values, the less comparisons because the min value has to
	 * be found less when it comes to finding/sorting the smallest unsorted
	 * value in the array
	 */

	public void newSort() {
		int min;
		int pos = 0; /** the position is assigned to 0 */
		/**
		 * while true the position is less than the used size meaning there is
		 * still part of the array that may need sorting. This is because the
		 * position 'pos' starts at 0 and is incremented each time the loop goes
		 * through and sorts a bit, when while is false it means that the array
		 * should be sorted
		 */
		while (pos < usedSize) {
			/**
			 * this calls the findMinFrom method to find the smallest unsorted
			 * value left in the array
			 */
			min = findMinFrom(A, pos);
			/**
			 * this for loop starts from the current position and increments
			 * until the whole array is used
			 */
			for (int i = pos; i < usedSize; i++) {
				if (A[i] == min) { /**
									 * if the value in the array at index i
									 * equals min then swap positions
									 */
					swap(A, i, pos); /**
										 * swaps the positions of value at index i
										 * with min
										 */
					pos++; /**
							 * increments pos so that loop will eventually run
							 * through each position
							 */
				}
				compNewS++; /**
							 * Increments compNewS to count array comparison
							 * from the if statement this will therefore count
							 * the comparison regardless of if being true or
							 * false
							 */
			}
		}
	}

} /** End of Sort Class **/