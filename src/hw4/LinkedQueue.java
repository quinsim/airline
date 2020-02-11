package hw4;

import java.util.LinkedList;

public class LinkedQueue implements PriorityQueue<Passenger> {

    LinkedList<Passenger> theLinkedQueue = new LinkedList<Passenger>();
    
    public LinkedQueue() {
    }

    public Passenger dequeue() {
        return theLinkedQueue.pollFirst();
    }

    public void enqueue(Passenger toInsert) {
        // System.out.print("\nInserting " + toInsert);
        // if (!theLinkedQueue.isEmpty()) {
        //     System.out.println(": After " + binarySearch(toInsert, theLinkedQueue));
        // }
        // else {
        //     System.out.println(": After null");
        // }
        for (Passenger current: theLinkedQueue) {
            if (toInsert.compareTo(current) == 1) {
                System.out.println(toInsert);
                System.out.println(current);
                int index = theLinkedQueue.indexOf(current);
                theLinkedQueue.add(index, toInsert);
                break;
            }
        }
        if (!theLinkedQueue.contains(toInsert)) {
            theLinkedQueue.addLast(toInsert);
        }
        System.out.println(theLinkedQueue);
    }

    public boolean isEmpty() {
        return theLinkedQueue.isEmpty();
    }

    public String toString() {
        return theLinkedQueue.toString();
    }

    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();
        for (int index = 10; index >= 1; index--) {
            Passenger me = new Passenger("Q", 'A', index);
            queue.enqueue(me);
        }
        System.out.println(queue);

        for (int index = 1; index < 10; index++) {
            System.out.println(queue.dequeue());
        }
    }
}