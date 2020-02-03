package amazin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        List arrList = new ArrayList<Integer>();
        arrList.add(1);
        arrList.add(5);
        arrList.add(11);
        arrList.add(12);
        int target = 23;

        Map map = new HashMap<Integer, Integer>();

        for(int i=0; i < arrList.size() ; i++) {
            map.put(arrList.get(i), i);

            //System.out.println((Integer)arrList.get(i) + ", " +(target-(Integer)arrList.get(i)));
            //System.out.println(map.get(target-(Integer)arrList.get(i)));
            if(map.get(target-(Integer)arrList.get(i))!= null)
                System.out.println(i + ", " + map.get(target-(Integer)arrList.get(i)));

        }




    }
}
