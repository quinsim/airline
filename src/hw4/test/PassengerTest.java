package hw4.test;

import static hw4.test.Tests.*;

import hw4.*;

public class PassengerTest {
    
    public static void testConstructor() {
        String name = "Quinten";
        char group = 'A';
        int sequence = 1;

        Passenger passenger = new Passenger(name, group, sequence);

        assertEquals(name, passenger.getName());
        assertEquals(group, passenger.getBoardingGroup());
        assertEquals(sequence, passenger.getSequenceNumber());
    }

    public static void testCompareToHigh() {
        Passenger high_priority = new Passenger("Quinten", 'A', 1);
        Passenger low_priority = new Passenger("Quin", 'C', 1);

        assertEquals(1, high_priority.compareTo(low_priority));
    }

    public static void testCompareToLow() {
        Passenger high_priority = new Passenger("Quinten", 'A', 1);
        Passenger low_priority = new Passenger("Quin", 'C', 1);

        assertEquals(-1, low_priority.compareTo(high_priority));
    }

    public static void testCompareToEquals() {
        Passenger high_priority = new Passenger("Quinten", 'A', 1);
        Passenger low_priority = new Passenger("Quin", 'A', 1);

        assertEquals(0, low_priority.compareTo(high_priority));
    }
    
    public static void testToString() {
        Passenger test = new Passenger("Quinten", 'B', 12);

        assertEquals("Quinten in seat B12", test.toString());
    }

    public static void main(String[] args) {
        PassengerTest.testConstructor();
        PassengerTest.testCompareToHigh();
        PassengerTest.testCompareToLow();
        PassengerTest.testCompareToEquals();
        PassengerTest.testToString();        
    }
}