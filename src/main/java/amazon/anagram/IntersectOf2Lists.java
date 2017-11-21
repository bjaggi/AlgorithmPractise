package amazon.anagram;

import java.util.*;

public class IntersectOf2Lists {
    public static void main(String[] args) {
        ArrayList<String> listVowels = new ArrayList<String>(Arrays.asList("a","e","i","o","u"));
        ArrayList<String> listJunk = new ArrayList<String>(Arrays.asList("h","e","j","a","b","m","m","m","a"));


        HashSet<String> setVowels = new HashSet<String>() ;
        HashSet<String> setJunk = new HashSet<String>() ;

        // OPTION 1 - SETS ( time complexity O(n) space complexity O(n) )
        // Sets doesnt allow duplicate
        String duplicateValues = "";
        for (String name : listJunk) {
            if (setJunk.add(name) == false) { // your duplicate element
                duplicateValues = duplicateValues + name + ", ";
            }
        }
        System.out.println(" Option 1 Way of Showing Duplicate Values is : " + duplicateValues);

        //OPTION 2 - MAP ( time complexity O(2N) space complexity O(n) )
        System.out.println(" Option 2 Way : ");
        HashMap<String, Integer> nameAndCountMap = new HashMap<String, Integer>();
        for (String name : listJunk) {
            Integer count = nameAndCountMap.get(name);
            if (count == null) {
                nameAndCountMap.put(name, 1);
            } else {
                nameAndCountMap.put(name, ++count);
            }
        }
        // Print duplicate elements from array in Java
        Set<Map.Entry<String, Integer>> entrySet = nameAndCountMap.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            if (entry.getValue() > 1) {
                System.out.printf("duplicate element '%s' and count '%d' :", entry.getKey(), entry.getValue());
            }
        }




    }


}

