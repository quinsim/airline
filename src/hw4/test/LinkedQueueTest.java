package hw4.test;

import static hw4.test.Tests.*;

import hw4.*;

public class LinkedQueueTest {
    
    public static void testEnqueue() {
        Passenger passenger = new Passenger("Quinten", 'A', 12);

        LinkedQueue queue = new LinkedQueue();
        queue.enqueue(passenger);

        assertEquals(passenger, queue.getQueue().getFirst());
    }

    public static void testDequeue() {
        Passenger passenger = new Passenger("Quinten", 'A', 12);
        Passenger passenger2 = new Passenger("Quinten", 'A', 1);

        LinkedQueue queue = new LinkedQueue();
        queue.enqueue(passenger);
        queue.enqueue(passenger2);

        assertEquals(passenger2, queue.dequeue());
    }

    public static void testIsEmpty() {
        LinkedQueue queue = new LinkedQueue();

        assertEquals(true, queue.isEmpty());
    }

    public static void testIsNotEmpty() {
        Passenger passenger = new Passenger("Quinten", 'A', 12);

        LinkedQueue queue = new LinkedQueue();
        queue.enqueue(passenger);

        assertEquals(false, queue.isEmpty());
    }

    public static void testToString() {
        Passenger passenger = new Passenger("Quinten", 'A', 12);

        LinkedQueue queue = new LinkedQueue();
        queue.enqueue(passenger);

        String expected = String.format("[%s]",passenger);
        assertEquals(expected, queue.toString());
    }
    public static void main(String[] args) {
        LinkedQueueTest.testEnqueue();
        LinkedQueueTest.testDequeue();
        LinkedQueueTest.testIsEmpty();
        LinkedQueueTest.testIsNotEmpty();
        LinkedQueueTest.testToString();
    }
}