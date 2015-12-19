package JosephPHonour;

/*****************************************************/
/*** Purpose:                                      ***/
/***                                               ***/
/***     Initial Author: Jason Steggles 20/09/15   ***/
/***     Extended by: Joe Honour	19/10/15       ***/
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
	public int compIS; /** Global comparison count for Insertion Sort **/
	public int compQS; /** Global comparison count for Quicksort **/
	public int compNewS; /** Global comparison count for new sort **/

	/**
	 * Constructor.
	 */
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

	/**
	 * Read file of integers into the array.
	 */
	public void readIn(String file) {
		try {
			/** Initialise loop variable **/
			usedSize = 0;

			/** Set up file for reading **/
			FileReader reader = new FileReader(file);
			Scanner in = new Scanner(reader);

			/** Loop round reading in data while array not full **/
			while ( in .hasNextInt() && (usedSize < size)) {
				A[usedSize] = in .nextInt();
				usedSize++;
			}

		} catch (IOException e) {
			System.out.println("Error processing file " + file);
		}
	}

	/**
	 * Display the Array.
	 */
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

	/**
	 * Sort array using the insertion sort algorithm.
	 */
	public void insertionSort() {
		for(int i = 1; i < usedSize; i++)
		{
			int key = A[i];
			int j = i;

			while(j > 0 && key < A[j-1]){
				compIS++;
				A[j] = A[j-1];
				j = j-1;
			}
			compIS++;
			A[j] = key;
		}
	}

	/**
	 * QuickSort access method.
	 */
	public void quickSort()
	{
		quickSort(0, usedSize-1);
	}

	/**
	 * Sort array using the Quicksort algorithm.
	 */
	private void quickSort(int left, int right)
	{
		if(right > left)
		{
			int p = partition(left, right);
			quickSort(left, p-1);
			quickSort(p+1, right);
		}
	}

	/**
	 * Method used to partition the array in quicksort.
	 */
	private int partition(int left, int right)
	{
		//get pivot value.
		int v = A[right];

		//create pointers.
		int pL = left;
		int pR = right;

		//move pointers.
		while(pL < pR){
			while(A[pL] < v) {
				pL++;
				compQS++;
			}
			compQS++;
			while(A[pR] >= v && pR > left){
				pR--;
				compQS++;
			}
			compQS++;
			if(pL < pR)
				swap(pL, pR);
		}

		//place pivot in correct location.
		swap(pL, right);
		return pL;
	}

	/**
	 * Public method for using newSort to sort the array.
	 */
	public void newSort()
	{
		int pos = 0;
		while(pos < usedSize){
			int min = findMinFrom(pos);
			for(int i = pos; i < usedSize; i++){
				if(A[i] == min){
					swap(i, pos);
					pos++;
				}
				compNewS++;
			}
		}
	}

	/**
	 * Finds the minimum value from the specified position to the end of the array.
	 */
	private int findMinFrom(int pos)
	{
		int min = A[pos];
		for(int i = pos+1;i < usedSize; i++){
			if(A[i] < min){
				min = A[i];
			}
			compNewS++;
		}
		return min;
	}

	/**
	 * Swaps the data from positionTwo into PositionOne.
	 * NOTE: You are passing the index of the array not the data.
	 */
	private void swap(int positionOne, int positionTwo){
		int temp = A[positionOne];
		A[positionOne] = A[positionTwo];
		A[positionTwo] = temp;
	}
}