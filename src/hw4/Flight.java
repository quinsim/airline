/*
 * Flight.java
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

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class that simulates the creating and boarding of
 *  Passengers on a pane.
 * 
 * @author Quinten Simet
 * @author Andy Lok
 */
public class Flight {

    /**
     * The LinkedList based queue used to store the Passengers who have been created
     *  but have yet to board the plane
     */
    private PriorityQueue queue = new LinkedQueue();

    /**
     * The Heap based queue used to store the Passengers who have been created
     *  but have yet to board the plane
     */
    // private PriorityQueue<Passenger> queeu = new HeapQueue();

    /**
     * The flight simulation that will run until the simulation
     *  is terminated by entering the number 3 when prompted
     */
    public void simulate() {
        Scanner userInterface = new Scanner(System.in);
        int userInput;
        do {
            System.out.println(simulationPrompt());
            userInput = userInput(userInterface);
        } while (userInput != 3);

        userInterface.close();
    }
    
    /**
     * Prompts and accepts the users input. Will validate the users response
     *  and prompt the correct method to run based on the input
     * 
     * @param in Scanner used to read the users input from the console
     * @return the value entered in by the user
     */
    private int userInput(Scanner in) {
        System.out.print("Your choice: ");
        int userInput = 0;
        try {
            userInput = in.nextInt();
            in.nextLine();
        } catch(InputMismatchException e) {
            in.nextLine();
        }
        
        switch (userInput) {
            case 1: addPassenger(in);
                    break;
            case 2: boardPassenger();
                    break;
            case 3: 
                    break;
            default: System.out.println("Invalid input!");
        }
        System.out.println();
        return userInput;
    }

    /**
     * Simulates the creation of a Passenger. Prompts the user for
     *  the neccesary information to create a Passenger, Creates the
     *  Passenger object, and adds said Passenger into the boarding queue.
     * 
     * Assumes that all information entered by the user is valid
     * 
     * @param in Scanner used to read the users input from the console
     */
    private void addPassenger(Scanner in) {
        String name;
        char boardingGroup;
        int sequenceNumber;

        System.out.print("Passenger name: ");
        name = in.next(); in.nextLine();

        System.out.print("Boarding Group: ");
        boardingGroup = in.next().charAt(0); in.nextLine();

        System.out.print("Sequence: ");
        sequenceNumber = in.nextInt(); in.nextLine();

        Passenger me = new Passenger(name, Character.toUpperCase(boardingGroup), sequenceNumber);
        queue.enqueue(me);
    }

    /**
     * Simulates the boarding of a Passenger. Will prompt the queue to remove
     *  the Passenger at the head of the queue and print said Passenger
     *  to the user
     */
    private void boardPassenger() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.printf("Removing : %s\n", queue.dequeue());
        }
    }

    /**
     * Creates the prompt that is sent to the user to simulate
     *  the flight
     * 
     * @return the prompt sent to the user for the flight simulation
     */
    private String simulationPrompt() {
        String prompt = "Enter an option\n"
                      + "1. Add passenger to the boarding queue\n"
                      + "2. Remove and print the next passenger from the queue with the highest priority\n"
                      + "3. Quit";

        return prompt;
    }
    
    public static void main(String[] args) {
        Flight flight = new Flight();
        flight.simulate(); 
     }
}