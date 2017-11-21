import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class HashMapLookupTest {

    public static void main(String[] args) {

        class person{
            int number;
            String name;

            public person(int number, String name) {
                this.number = number;
                this.name = name;
            }

            @Override
            public String toString() {
                return "person{" +
                        "number=" + number +
                        ", name='" + name + '\'' +
                        '}';
            }
        }

		HashMap hmap = new HashMap<Integer, person>();
		person p1 = new person(1,"A");
		person p2 = new person(2,"b");
		person p3 = new person(1,"c");
		//hmap.put(p1, "ONE");hmap.put(p2, "TWO");hmap.put(p3, "THREE");
        hmap.put(1, p1);hmap.put(2, p2);hmap.put(3, p3);

		Iterator it = hmap.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	    }


        // for key as string
        Hashtable<String, String> hmap2 = new Hashtable();
        hmap2.put("1", "one");
        hmap2.put("1", "oneee");
        System.out.println(hmap2);

    }
}
