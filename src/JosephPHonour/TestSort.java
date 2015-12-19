package JosephPHonour;

/*************************************************/
/*** Simple test class for Sort class          ***/
/***                                           ***/
/*** Author: Joe Honour		     19/10/15      ***/
/*************************************************/


public class TestSort
{
	public static void main(String[] args)
    {
		//list of file names to iterate through.
		String fileNames[] = new String[]{"test1.txt", "test2.txt", "test3.txt", "test4.txt"};

		/**
		 * Insertion Sort
		 */
        Sort insertionSort = new Sort(100);
        System.out.println("\n\n/************************ Insertion Sort ****************************/");

        //iterate through files performing insertion sort.
        for(String filename : fileNames){
        	insertionSort.readIn(filename);
        	insertionSort.display(20,"\nArray of Integers for " + filename);
        	insertionSort.insertionSort();
        	insertionSort.display(20, "\nInsertion Sorted Array");
            System.out.printf("\n\n(%s)Insertion Sort Comparisons Made: %d",
            		filename, insertionSort.compIS);
            insertionSort.compIS = 0;
        }
        System.out.println("\n\n/************************ End Insertion Sort ****************************/");

        /**
         * QuickSort
         */
        Sort quickSort = new Sort(100);
        System.out.println("\n\n/************************ Quick Sort ****************************/");
        //iterate through files performing quick sort.
        for(String filename : fileNames){
        	quickSort.readIn(filename);
        	quickSort.display(20,"\nArray of Integers for " + filename);
        	quickSort.quickSort();
        	quickSort.display(20, "\nQuickSort Sorted Array");
            System.out.printf("\n\n(%s)QuickSort Comparisons Made: %d",
            		filename, quickSort.compQS);
            quickSort.compQS = 0;
        }
        System.out.println("\n\n/************************ End Quick Sort ****************************/");


        /**
         * New Sort
         */
        System.out.println("\n\n/************************ New Sort ****************************/");
        Sort newSort = new Sort(100);
        String fileNamesNew[] = new String[]{"test3.txt", "test4.txt", "test5.txt"};
        //iterate through files performing new sort.
        for(String filename : fileNamesNew){
        	newSort.readIn(filename);
        	 newSort.display(20,"\nArray of Integers for " + filename);
        	 newSort.newSort();
        	 newSort.display(20, "\nNewSort Sorted Array");
             System.out.printf("\n\n(%s)NewSort Comparisons Made: %d",
             		filename, newSort.compNewS);
             newSort.compNewS = 0;
        }
        System.out.println("\n\n/************************ End New Sort ****************************/");

        /**
         * Insertion Sort test5.txt
         */
        System.out.println("\n\n/************************ Insertion Sort ****************************/");
        insertionSort.compIS = 0;
        insertionSort.readIn("test5.txt");
        insertionSort.display(20, "\nArray of Integers for test5.txt");
        insertionSort.insertionSort();
        insertionSort.display(20, "\nInsertion Sort Sorted Array");
        System.out.printf("\n\n(%s)Insertion Sort Comparisons Made: %d",
         		"test5.txt", insertionSort.compIS);

        System.out.println("\n\n/************************ End Insertion Sort ****************************/");
    }

} /** End of Test class **/