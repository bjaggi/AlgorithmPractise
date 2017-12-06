package amazin.sorting;

import java.util.Arrays;
import java.util.List;
// https://www.youtube.com/watch?v=6Gv8vg0kcHc

public class BubbleSort {

    public static void main(String[] args){

        List<Integer> inputList = Arrays.asList(1,9,4,2,8,10,101,5,3,2);
        int min = 0, max = Integer.MAX_VALUE;
        int lenghOfList = inputList.size();


        //Classic Nsquare as loop runs twice for (lenghOfList-1)
        for(int outerCounter=0; outerCounter < (lenghOfList-1) ; outerCounter ++){
            for(int innerCounter=outerCounter;innerCounter<=(lenghOfList -1 ); innerCounter++){

                if (inputList.get(outerCounter)>inputList.get(innerCounter)){
                    //swap(inputList.get(counter),inputList.get(counter));
                    int tempVal = -1;
                    tempVal = inputList.get(outerCounter);
                    inputList.set(outerCounter,inputList.get(innerCounter));
                    inputList.set(innerCounter,tempVal);

                }
            }


        }

        System.out.println(inputList);

    }

    private static void swap(Integer integer, Integer integer1) {
    }
}
