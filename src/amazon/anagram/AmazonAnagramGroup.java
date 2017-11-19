package amazon.anagram;

import java.util.*;
// Big O is O(n)

public class AmazonAnagramGroup {

    public static void main(String[] args) {

        List<String> inputList = new ArrayList(Arrays.asList("cat", "dog", "tac", "god", "act"));
        List<List<String>> superList = new ArrayList(new ArrayList());
        Map<String, List<String>> splMap = new HashMap();

        for (String str : inputList) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String sortedStr = new String(charArr);

            specialInsert(splMap, sortedStr, str);
        }

        System.out.println(splMap);
        System.out.println();
        System.out.println(" key act : " + splMap.get("act"));
        System.out.println(" key dog : " + splMap.get("dgo"));

    }

    public static void specialInsert(Map<String, List<String>> splMap, String key, String value) {
        List<String> list = null;


        if (splMap.get(key) != null) {
            list = splMap.get(key);
            list.add(value);
            splMap.put(key, list);
        } else {
            list = new ArrayList();
            list.add(value);

            splMap.put(key, list);
        }


    }

}
