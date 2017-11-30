package amazon.anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ListNode
    {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    class ReverseListFromMiddle
    {
        public static void main(String[] args)
        {
            ListNode node1 = new ListNode(2);
            ListNode node2 = new ListNode(1);
            ListNode node3 = new ListNode(3);
            ListNode node4 = new ListNode(4);
            ListNode node5 = new ListNode(5);
            ListNode node6 = new ListNode(6);
            ListNode node7 = new ListNode(7);
            ListNode node8 = new ListNode(8);
            node1.next = node2;
            node2.next = node3;
            node3.next = node4;
            node4.next = node5;
            node5.next = node6;
            node6.next = node7;
            node7.next = node8;

            reverseNikitaStyle() ;


        }
        public static void reverseNikitaStyle() {
            List list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));


            int midOfList = (int)Math.ceil(list.size() / 2);
            int lenthOfList = list.size();

            int counterFirstHalf =0;
            while(counterFirstHalf<midOfList){
                System.out.println(list.get(counterFirstHalf));
                counterFirstHalf++;
            }


            int counterSecondHalf = lenthOfList;
            while( counterSecondHalf > counterFirstHalf){
                counterSecondHalf--;
                System.out.println(list.get(counterSecondHalf ));


            }


        }

        public static ListNode reverse(ListNode start)
        {
            int counter = 0;
            ListNode node = start;
            ListNode pre = start;

            ListNode result = start;

            while (node!= null)// for count how many elements in linked list
            {
                counter += 1;
                node = node.next;
            }

            for (int i=0; i< (counter / 2) ; i++)//no matter counter is even or odd, when it divided by 2, the result is even
            {
                pre = start;
                start = start.next;
            }


            ListNode temp = null;
            ListNode preNext = null;// this variable is used to track the next val behind pre
            // for example, 2->1->3->4->**5**->6->7->8
            // at this moment, pre:4, start:5
            // I treated 5->6->7->8 as an independent linkedlist
            // I reversed the linkedlist
            // Finally, set the pre node's next value to the reversed linkedlist's head
            // The first half and second half have been connected together


            while (start != null)
            {
                // Simple Swap next 2 elements.
                temp = start.next;
                start.next = preNext;
                preNext = start;
                start = temp;
            }
            pre.next = preNext;

            return start;

        }
    }
