/*
 * Passenger.java
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
 * Class that simulates a Passenger on a plane. Each Passenger is assigned
 *  a name, boarding group, and sequence number which determine their boarding
 *  priority compared to their fellow passengers
 * 
 * @author Quinten Simet
 * @author Andy Lok
 */
public class Passenger implements Comparable<Passenger> {
    /**
     * The name of the Passenger
     */
    private final String name;

    /**
     * The boarding group associated with the Passenger
     *  A, B, or C
     */
    private final char boardingGroup;

    /**
     * The sequence number associated with the Passenger
     *  1 - 60
     */
    private final int sequenceNumber;

    /**
     * Class constructor that initializes the Passeneger with his name,
     *  boarding group, and sequence number
     * 
     * @param name Name of the Passenger
     * @param boardingGroup A, B, or C
     * @param sequenceNumber 1-60
     */
    public Passenger(String name, char boardingGroup, int sequenceNumber) {
        if ((boardingGroup > 'C') || (sequenceNumber < 1) || (sequenceNumber > 60)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.boardingGroup = boardingGroup;
        this.sequenceNumber = sequenceNumber;

    }

    /**
     * Gets the name of the Passenger
     * 
     * @return the name of the Passenger
     */
    public String getName() {
        return name;
    }
    
    /**
     * Gets the boarding group associated with the Passenger
     * 
     * @return the boarding group the Passenger belongs to
     */
    public char getBoardingGroup() {
        return boardingGroup;
    }

    /**
     * Gets the sequence number accociated with the Passenger
     * 
     * @return the sequence number the Passenger is assigned
     */
    public int getSequenceNumber() {
        return sequenceNumber;
    }

    /**
     * Calculates whether the Passanger is of higher, lower, or equal
     *  priority to another Passenger based on their boarding group
     *  and sequence number
     * 
     * @param passenger the passenger being compared with
     * 
     * @return 1 if the Passenger is of higher priority,
     *  -1 if the Passenger is of lower priority,
     *  0 if the Passenger is of equal priority.
     */
    @Override
    public int compareTo(Passenger passenger) {
        if (boardingGroup < passenger.getBoardingGroup()) {
            return 1;
        }
        else if (boardingGroup > passenger.getBoardingGroup()) {
            return -1;
        }
        else if (sequenceNumber > passenger.getSequenceNumber()) {
            return -1;
        }
        else if (sequenceNumber < passenger.getSequenceNumber()) {
            return 1;
        }
        else {
            return 0;
        }
    }

    /**
     * Overrides the toString method to display a Passengers
     *  boarding information in String form
     * 
     * @return A string representation of a Passengers boarding
     *  information
     */
    @Override
    public String toString() {
        return String.format("%s in seat %s%s", name, boardingGroup, sequenceNumber);
    }   
}