package amazin;

import java.util.Stack;

import static amazin.ReverseListFromMiddle.reverse;

public class PalindromeLinkList {


    public PalindromeLinkList(){

    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        System.out.println(new PalindromeLinkList().isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {

        if(head == null || head.next==null)
            return true;

        //find list center
        ListNode fast = head;
        ListNode slow = head;
        Stack<Integer> stack= new Stack<Integer>();

        while(fast !=null && fast.next!=null){
            System.out.println(slow.val);
            stack.push(slow.val);
            fast = fast.next.next;
            slow = slow.next;
            System.out.println("slow "+ slow.val + " , fast is now "+ fast.val );
        }
        // For cases where list is ODD only
       if(fast != null){
           slow = slow.next;
       }

       while (slow != null){
           if(stack.pop() != slow.val)
               return false;
           slow = slow.next;
       }

       return true;
    }

}
