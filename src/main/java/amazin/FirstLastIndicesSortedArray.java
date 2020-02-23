package amazin;

public class FirstLastIndicesSortedArray {

    // returns leftmost (or rightmost) index at which `target` should be
    // inserted in sorted array `nums` via binary search.
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }

        return lo;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, true)-1;

        return targetRange;
    }


    public int binarySearchIterative(int[] arr, int low, int high, int target, boolean findFirst) {
        while (true) {
            if (high < low)
                return -1;
            int mid = low + (high - low) / 2;
            if (findFirst) {
                if ((mid == 0 || target > arr[mid - 1]) && arr[mid] == target) {
                    return mid;
                } else if(target > arr[mid]){
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            } else {
                if ((mid == arr.length - 1 || target < arr[mid + 1]) && arr[mid] == target) {
                    return mid;
                } else if (target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
    }
    public static void main (String[] args)
    {
        int arr[] = {1, 2, 2, 2, 2, 3, 4, 7 ,8 ,8, 8 };
        int x = 8;
        int[] op =  new FirstLastIndicesSortedArray().searchRange(arr, x);
        System.out.println(" Element 8 has its Low at : "+op[0] + ", High At "+ op[1]);

        //System.out.println(new FirstLastIndicesSortedArray().binarySearchIterative(arr, 0 , arr.length, 8, true));
       // System.out.println(new FirstLastIndicesSortedArray().binarySearchIterative(arr, 0 , arr.length, 2, false));
        System.out.println(new FirstLastIndicesSortedArray().findFirstElement(arr, 0 , arr.length, 3));
    }


   int findFirstElement(int[] arr , int low , int high, int target){

        while(true){


            if( high < low) return -1;
            int mid = low + (high - low)/2;

            if(arr[mid]==target)
                return mid;
            else if( arr[mid] < target){
                low = mid;

            }else {
                high = mid -1;
            }


        }

    }

}
