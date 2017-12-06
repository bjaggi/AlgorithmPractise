package amazin;

import java.util.HashMap;
// Big O is O(n)
public class AmazonCharGrouping {

    public static void main(String[] args) {
        String input = "aaaaaabbbdcdcccccccc";
        HashMap<Character, Integer> charCountMap = new HashMap();
        char[] charArray = input.toCharArray();
        for(char c : charArray){
            if(charCountMap.get(c)==null){
                charCountMap.put(c,1);
            }else{
                int count = charCountMap.get(c);
                charCountMap.put(c,++count);
            }
        }
        System.out.println(charCountMap);
    }


    public static void main2(String[] args) {
        String s = "aaaaaabbbdcdcccccccc";
        char[] c = s.toCharArray();
        s = "";
        int j = 1;
        for (int i = 0; i < c.length; i++) {
            if (i == c.length - 1)
                s = s + c[i] + j;
            else {
                if (c[i] == c[i + 1]) {
                    j++;
                } else {
                    s = s + c[i] + j;
                    j = 1;
                }
            }
        }
        System.out.println(s);

    }





}