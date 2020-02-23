package amazin;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://www.youtube.com/watch?v=mtHelVTLKRQ
public class LongestSubString {

    public static void main(String[] args) {
//       new LongestSubString().longestSubString("abcabcbb");
//       new LongestSubString().longestSubString("abcdbbbeacc");
//       new LongestSubString().longestSubString("bbbbb");
//       new LongestSubString().longestSubString("pwwkew");

        new LongestSubString().longestSubString2("aaaa");

    }

    // https://www.youtube.com/watch?v=mtHelVTLKRQ
    private int longestSubString(String s) {
        if(s == null || s.length()==0){
            return 0;
        }

        Set<Character> set = new HashSet<Character>();
        int left =0, right = 0, max =0;

        while(right < s.length()){
            // if its not present will return true else false
            // Expanding our window
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right ++;
                max = Math.max(max, right - left);// Increment the maximum count
            } else {
                // Shifting our Window &  empty the set of unique chars
                //                map.put(s.substring(left, right), s.substring(left, right).length());
                set.remove(s.charAt(left));
                left ++;

            }
        }

        System.out.println(s  + " , "+ s.substring(left,right) + ", lenght : "+ max);
        return max;

    }




    private int longestSubString2(String s) {
        if(s == null || s.length()==0){
            return 0;
        }

        int left = 0, right = 0, max = 0;
        Set<Character> uniqueSet = new HashSet<Character>();
        //aba
        while ( right < s.length() ){

            // If dup found, reset counter and set
            //abaa
            if(uniqueSet.contains(s.charAt(right))){
                left ++;
                uniqueSet.remove(s.charAt(right));
            }else {
                //expand the window
                uniqueSet.add(s.charAt(right));
                right ++;
               max = Math.max(max , right - left) ;

            }


        }
        System.out.println(max);
        return max;
    }
}
