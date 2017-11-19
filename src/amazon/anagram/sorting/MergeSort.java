package amazon.anagram.sorting;

/*
 * Mergesort is a so called divide and conquer algorithm.
 * 1. Divide and conquer algorithms divide original data into smaller sets of data to solve the priblem
 * 2. Mergesort will take the middle of the collection and split the collection into its left and its right part.
 * 3. The resulting collections are again recursively sorted via the Mergesort algorithm.
 * 4.Once the sorting process of the two collections is finished, the result of the two collections is combined.
 * 5.



 */
public class MergeSort {
    private int[] numbers;
    private int[] helper;

    private int number;

    public void sort(int[] values) {
        this.numbers = values;
        number = values.length;
        this.helper = new int[number];
        mergesort(0, number - 1);
    }
    public static void main(String[] args){
        int[] input = {9,2,1,0,8, -1, -0,9};
        MergeSort msorter = new MergeSort();
        msorter.sort(input);

        for(int i=0;i<input.length; i++)
            System.out.println(input[i]);

    }


    private void mergesort(int low, int high) {
        // check if low is smaller than high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            mergesort(low, middle);
            // Sort the right side of the array
            mergesort(middle + 1, high);
            // Combine them both
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {

        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
            i++;
        }
        // Since we are sorting in-place any leftover elements from the right side
        // are already at the right position.

    }
}
