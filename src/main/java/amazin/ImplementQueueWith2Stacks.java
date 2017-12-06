package amazin;

import java.util.*;

//https://stackoverflow.com/questions/69192/how-to-implement-a-queue-using-two-stacks

public class ImplementQueueWith2Stacks {
    public static void main(String[] args) {
        CustomQueue csQueue = new CustomQueue();

        csQueue.enQueue(1);
        csQueue.enQueue(2);
        csQueue.enQueue(3);
        csQueue.enQueue(1);
        System.out.println(csQueue.dequeue());
        System.out.println(csQueue.dequeue());
        System.out.println(csQueue.dequeue());
        System.out.println(csQueue.dequeue());
        System.out.println(csQueue.dequeue());


    }

}

 class CustomQueue<E> {
    private Stack<E> inbox = new Stack<E>();
    private Stack<E> outbox = new Stack<E>();
    private int size = 0;

    public void enQueue(E item) {
        inbox.push(item);
        size ++;
    }

    public E dequeue() {
        // fill out all the Input if output stack is empty
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {
                outbox.push(inbox.pop());
            }
        }
        return outbox.pop();
    }

}
