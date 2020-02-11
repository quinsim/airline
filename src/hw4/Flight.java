package hw4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Flight {

    private PriorityQueue<Passenger> queue = new LinkedQueue();

    // private PriorityQueue<Passenger> queeu = new HeapQueue();

    public Flight() {
    }

    public void simulate() {
        Scanner userInterface = new Scanner(System.in);
        int userInput;
        do {
            System.out.println(simulationPrompt());
            userInput = userInput(userInterface);
        } while (userInput != 3);

        userInterface.close();
    }
    
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
            case 2: removePassenger();
                    break;
            case 3: 
                    break;
            default: System.out.println("Invalid input!");
        }
        System.out.println();
        return userInput;
    }

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

    private void removePassenger() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.printf("Removing : %s\n", queue.dequeue());
        }
    }

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