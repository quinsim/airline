/*
 * PriorityQueue.java
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

/**
 * Interface for a Priority Queue. Forces any class to implement
 *  a dequeue, endqueue, and isEmpty
 * 
 * @author Quinten Simet
 * @author Andy Lok
 */
interface PriorityQueue {

    /**
     * Class to remove Passenger(s) from the queue
     * 
     * @return The Passenger that has been removed from the queue
     */
    public Passenger dequeue();
    
    /**
     * Class to add Passenger(s) into the queue
     * 
     * @param item the Passenger
     */
    public void enqueue(Passenger item);

    /**
     * Checks if the queue is empty
     * 
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty();
}