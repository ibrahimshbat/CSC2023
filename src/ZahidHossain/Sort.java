package ZahidHossain;

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

	/** get array size to use in Test Sort **/
	public int getSize() {
		/** This is used just to show array size -1. **/
		return usedSize;
	}

	/** Insertion sort algorithm (task 1) **/
	public void insertionSort() {
		/** int key will be the value to insert **/
		int key = 0;
		/** int j will be the current index location of space **/
		int j = 0;
		/** create for loop where i is less than array size **/
		for (int i = 1; i < usedSize; i++) {
			/** let key store next value to insert **/
			key = A[i];
			/** let j contain index position of i **/
			j = i;

			/** while j is bigger than 0 and key is bigger than end of array **/
			while (j > 0 && key < A[j - 1]) {
				/**
				 * change position of j to the left of the array, this is to
				 * find the next position it has to point at.
				 **/
				A[j] = A[j - 1];
				j = j - 1;
				/** array is being compared, increment comparison count **/
				compIS++;
			}
			/**
			 * if the conditions in the while loop aren't met, array will still
			 * be compared to check that condition isn't met. Increment
			 * comparison count
			 **/
			compIS++;
			/** Insert key into space. **/
			A[j] = key;
		}
	}

	/**
	 * Quick sort Partition
	 * 
	 * @return
	 **/
	public int partition(int left, int right) {
		/** pivot value **/
		int v;
		/** Left pointer **/
		int pL;
		/** Right pointer **/
		int pR;
		/** Let pivot start from the right side of the array **/
		v = A[right];
		/** Left pointer start from the left hand site **/
		pL = left;
		/** Assign pr to right of array **/
		pR = right;
		/** repeat until pointers cross (when PL is on the right of PR **/
		while (pL < pR) {
			/** move PL **/
			while (A[pL] < v) {
				pL = pL + 1;
				/** increment compQS because array is being compared **/
				compQS++;
			}
			/** increment compQS because array is being compared **/
			compQS++;
			/** move PR **/
			while (A[pR] >= v && pR > left) {
				pR = pR - 1;
				/** increment compQS because array is being compared **/
				compQS++;
			}
			/** increment compQS because array is being compared **/
			compQS++;
			/**
			 * if the right pointer is pointing to a value bigger then the one
			 * the left pointer is pointing at, swap the values.
			 */
			if (pL < pR) {
				swap(pL, pR);
			}
		}
		/** put pivot in correct position */
		swap(pL, right);
		/** return value PL contains */
		return pL;
	}

	/** QuickSort method **/
	public void quickSort(int left, int right) {
		/** p will contain the partition */
		int p;
		/** if right is bigger than left, use partition and sort them out */
		if (right > left) {
			p = partition(left, right);
			quickSort(left, p - 1);
			quickSort(p + 1, right);
		}
	}

	/** Swap method **/
	public void swap(int left, int right) {
		/** int t will temporarily contain array values */
		int t = A[left];
		/** array left equals to array right **/
		A[left] = A[right];
		/** let t contain new array values **/
		A[right] = t;
	}

	/** NewSort method **/
	public void newSort() {
		/** int min will store minimum valuie **/
		int min;
		/** let position start from 0 **/
		int pos = 0;
		/** while the size is bigger than the array perform **/
		while (pos < usedSize) {
			/** assign function findMinFrom to variable min. **/
			min = findMinFrom(pos);
			/**
			 * iterate i until you iterate through all the elements in array and
			 * then stop after iterating through the last element.
			 **/
			for (int i = pos; i <= usedSize - 1; i++) {
				/**
				 * if the element in the array is the minimum, swap the current
				 * element with the one pos is pointing to.
				 **/
				if (A[i] == min) {
					swap(i, pos);
					/** go to next position **/
					pos++;
				}
				/**
				 * increment comparison counter because there has been a
				 * comparison
				 **/
				compNewS++;
			}
		}
	}

	/** Find min from method **/
	public int findMinFrom(int pos) {

		/** min equal to the position in the array **/
		int min = A[pos];
		/**
		 * i = position 1 in array, for as long as i is equals to or less than
		 * the size go to next position
		 **/
		for (int i = pos + 1; i <= usedSize - 1; i++) {
			/**
			 * If the element in array is less than minimum make it the next new
			 * minimum
			 */
			if (A[i] < min) {
				min = A[i];
			}
			/**
			 * Increment comparison as array has been compared when it meets if
			 * statement condition and even when it doesn't meet it.
			 */
			compNewS++;
		}
		return min;
	}

} /** End of Sort Class **/