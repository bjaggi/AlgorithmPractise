package misc;

import java.util.Arrays;

public class CustomDesignedHashMap {
        private static final int SIZE = 32;
        private Entry[] table;

        public CustomDesignedHashMap() {
            table = new Entry[SIZE];
        }


        public static void main(String[] args){
            CustomDesignedHashMap myHashMap = new CustomDesignedHashMap();
            myHashMap.put("1","One-1");

            System.out.println(myHashMap.get("1"));
            myHashMap.put("1","One-2");
            System.out.println(myHashMap.get("1"));
            myHashMap.put("1","One-3");
            System.out.println(myHashMap.get("1"));
            myHashMap.put("1","One-4");
            myHashMap.put("2","Two");
            System.out.println(myHashMap);

            myHashMap.remove("1");
            System.out.println(myHashMap);


        }
        // VV IMP
        private void addOrUpdateNode(Entry head, Entry node) {

            if (head != null && head.key.equals(node.key)) {
                //iterate like a binary tree till you reach the leaf.
                while(head.next!=null){
                    head = head.next ;
                }
                head.next = node;
                return;
            }
        }

    /**
     *
     * @param key
     * @param value
     */
        public void put(String key, String value) {
            Entry entry = new Entry(key, value);
            int code = key.hashCode() % SIZE;
            if (table[code] == null) {
                table[code] = entry;
            } else {
                addOrUpdateNode(table[code], entry);
            }
        }

        public String get(String key) {
            int code = key.hashCode() % SIZE;
            Entry head = table[code];
            while (head != null) {
                if (head.key.equals(key)) return head.value;
                head = head.next;
            }
            return null;
        }

        public void remove(String key) {
            int code = key.hashCode() % SIZE;
            Entry head = table[code];
            Entry dummy = new Entry("0", "0");
            dummy.next = head;
            Entry prev = dummy;
            while (head != null) {
                if (head.key.equals(key)) prev.next = head.next;
                prev = head;
                head = head.next;
            }
            table[code] = dummy.next;
        }

        public boolean containsKey(String key) {
            int code = key.hashCode() % SIZE;
            Entry head = table[code];
            while (head != null) {
                if (head.key.equals(key)) return true;
                head = head.next;
            }
            return false;
        }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CustomDesignedHashMap{");
        sb.append("table=").append(table == null ? "null" : Arrays.asList(table).toString());
        sb.append('}');
        return sb.toString();
    }
}

class Entry {
    String key;
    String value;
    Entry next;
    Entry(String key, String value) {
        this.key = key;
        this.value = value;
        next = null;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Entry{");
        sb.append("key='").append(key).append('\'');
        sb.append(", value='").append(value).append('\'');

        while (next != null ) {
            //sb.append("keynext='").append(next.key).append('\'');
            sb.append(", value='").append(next.value).append('\'');
            next = next.next;
        }

        sb.append('}');
        return sb.toString();
    }
}
