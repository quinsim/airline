package hw4;

public class Passenger implements Comparable<Passenger> {
    private final String name;
    private final char boardingGroup;
    private final int sequenceNumber;

    public Passenger(String name, char boardingGroup, int sequenceNumber) {
        if ((boardingGroup > 'C') || (sequenceNumber < 1) || (sequenceNumber > 60)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.boardingGroup = boardingGroup;
        this.sequenceNumber = sequenceNumber;

    }

    public String getName() {
        return name;
    }
    
    public char getBoardingGroup() {
        return boardingGroup;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

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

    public String toString() {
        return String.format("%s in seat %s%s", name, boardingGroup, sequenceNumber);
    }   

    public static void main(String[] args) {
        System.out.println('c' > 'b');
    }
}