package amazon.anagram.sorting;

import java.util.Arrays;
import java.util.List;

//Best Link
//http://www.algolist.net/Algorithms/Sorting/Quicksort
//https://www.youtube.com/watch?v=SLauY6PpjW4&t=12s
//Big O Complexity is N-LogN (Reason we do log N, N number of times)
// If we choose the worst pivot (ideal is centre) and worst is one on the edges (for edges it becomes O(N-square)
public class QuickSort {
    static int recusrsionCount = 1;

    public static void main(String[] args) {
        //List<Integer> list = Arrays.asList(9999, 1001, 1, 2, 9, 20, 89, 6, 9, 1, 99, 3);
        List<Integer> list = Arrays.asList(4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4);
        System.out.println("Input List = " + list);
        quickSort(list, 0, list.size() - 1);
    }

    private static void quickSort(List<Integer> list, int left, int right) {
        System.out.println();
        System.out.println(" *** QuickSort call number= " + recusrsionCount++);
        int index = partitionOnPivotAndSort(list, left, right);
        System.out.println(list);
        if (left < index - 1)
            quickSort(list, left, index - 1);

        if (index < right)
            quickSort(list, index, right);

    }

    private static int partitionOnPivotAndSort(List<Integer> inputList, int left, int right) {

        int pivot = Math.round(right + left) / 2;
        //int pivot =  inputList.get((left+right)/2);
        int leftPointer = left;
        int rightPointer = right;

        while (leftPointer < rightPointer) {

            while (inputList.get(leftPointer) < inputList.get(pivot))
                leftPointer++;

            while (inputList.get(rightPointer) > inputList.get(pivot))
                rightPointer--;


            if (leftPointer <= rightPointer) {
                System.out.println(String.format(" Currently Evaluating : leftPointer=%s , rightPointer=%s ", leftPointer, rightPointer));
                System.out.println(String.format(" For (PIVOT_INDEX=%S,PIVOT_VALUE=%s), Swapping index=%s with value=%s WITH index=%s with value=%s ", pivot, inputList.get(pivot), leftPointer, inputList.get(leftPointer), rightPointer, inputList.get(rightPointer)));
                // We found the problem element == SWAP
                int tempVal = -1;
                tempVal = inputList.get(leftPointer);
                inputList.set(leftPointer, inputList.get(rightPointer));
                inputList.set(rightPointer, tempVal);
                leftPointer++;
                rightPointer--;
                System.out.println();
            }

        }

        System.out.println(String.format("Completed one set of sorting leftPointer=%s , rightPointer=%s ", leftPointer, rightPointer));
        return leftPointer;
    }


}
