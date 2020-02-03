package amazin;

import java.util.ArrayList;
import java.util.List;

public class AddTwoLinkLists {

    private static class Node {
        int val;
        Node next;
        public Node(int val){this.val = val;}
    }

    public static void main(String[] args) {
        List<Node> aList = new ArrayList<Node>();
       Node aHead = new Node(5);
       aHead.next = new Node(2);
       aHead.next.next = new Node(6);

        Node bHead = new Node(5);
        bHead.next = new Node(2);
        bHead.next.next = new Node(6);

        printLinkList(add2List(aHead, bHead));


        System.out.println();

        Node aHead2 = new Node(6);


        Node bHead2 = new Node(5);
        bHead2.next = new Node(2);

        printLinkList(add2List(aHead2, bHead2));

    }

    private static Node add2List(Node aHead, Node bHead) {
        Node retunNode , current = null;
        Node aCurrent = aHead, bCurrent= bHead;;
        Node aPrev = null , bPrev = null;

        retunNode = current;
        int carryOver = 0;
        while ( aCurrent != null || bCurrent != null){
            int sumOfElement = 0;
            if(aCurrent != null && bCurrent != null) {
                sumOfElement = aCurrent.val + bCurrent.val + carryOver;

                carryOver = sumOfElement/10;
                if(current == null) {
                    current = new Node(sumOfElement % 10);
                    retunNode = current;
                }else {
                    current.next = new Node(sumOfElement % 10);
                    current = current.next;
                }
                aCurrent = aCurrent.next;
                bCurrent = bCurrent.next;
            }
            else if(aCurrent != null) {
                current.next = new Node(aCurrent.val+carryOver);
                current = current.next;
                aCurrent = aCurrent.next;
            }else if(bCurrent != null) {
                current.next = new Node(bCurrent.val+carryOver);
                current = current.next;
                bCurrent = bCurrent.next;
            }

        }
        if(carryOver ==1 )
            current.next = new Node(1);
     return retunNode;
    }

    public static void printLinkList(Node node){
        Node current = node;
        while ( current != null ){
            System.out.print(current.val + ", ");
            current = current.next;

        }
    }
}
