/*
 * LinkedQueue.java
 *
 * Version:
 *     1.1
 *
 * Revisions:
 *     v1.0 02-07-20 - Initial write-up
 *     v1.1 02-11-20 - Javadoc commenting
 * 
 */
package hw4;

import java.util.LinkedList;

/**
 * Class that impliments the PriorityQueue to create a
 *  queue using a LinkedList
 * 
 * @author Quinten Simet
 * @author Andy Lok
 */
public class LinkedQueue implements PriorityQueue {

    /**
     * The LinkedList queue containing passengers
     */
    LinkedList<Passenger> theLinkedQueue = new LinkedList<Passenger>();
    
    /**
     * Removes the Passenger @ the head of the LinkedList
     * 
     * @return The Passenger
     */
    public Passenger dequeue() {
        return theLinkedQueue.pollFirst();
    }

    /**
     * Inserts a Passenger into the queue according
     *  to his/her boarding priority
     * 
     * @param toInsert Passenger being inserted
     */
    public void enqueue(Passenger toInsert) {
        for (Passenger current: theLinkedQueue) {
            if (toInsert.compareTo(current) == 1) {
                int index = theLinkedQueue.indexOf(current);
                theLinkedQueue.add(index, toInsert);
                break;
            }
        }
        if (!theLinkedQueue.contains(toInsert)) {
            theLinkedQueue.addLast(toInsert);
        }
    }

    /**
     * Checks if the queue is empty
     * 
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return theLinkedQueue.isEmpty();
    }

    /**
     * Gets the LinkedListQueue
     * 
     * @return the queue
     */
    public LinkedList<Passenger> getQueue() {
        return theLinkedQueue;
    }
    /**
     * Overrides the toString method to output the
     *  contents of the queue in the form of a list
     * 
     * @return String representation of the contents of the queue
     */
    @Override
    public String toString() {
        return theLinkedQueue.toString();
    }
}