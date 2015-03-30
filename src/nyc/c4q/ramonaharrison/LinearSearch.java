package nyc.c4q.ramonaharrison;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Access Code 2.1
 * Ramona Harrison
 * LinearSearch.java
 * This class builds an ArrayList of up to 100 random integers then allows a user
 * to search for an integer and find its index in the array.
 */


public class LinearSearch {

    private ArrayList<Integer> integerArray;

    public LinearSearch() {
        Random rand = new Random();
        this.integerArray = new ArrayList<Integer>();
        int size = rand.nextInt(100);

        for (int i = 0; i < size; i++) {
            this.integerArray.add(rand.nextInt(100));
        }

    }

    public ArrayList<Integer> getIntegerArray() {
        return this.integerArray;
    }

    public int search(int x) {
        return this.integerArray.indexOf(x);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinearSearch intArray = new LinearSearch();

        System.out.println(intArray.getIntegerArray());
        while (true) {
            System.out.println("Enter an integer between 0 and 100 to find its index in the list:");
            int x = scanner.nextInt();
            int indexOfX = intArray.search(x);

            if (indexOfX != -1)
                System.out.println(x + " is at index " + indexOfX + ".");
            else
                System.out.println(x + " isn't in the list.");

        }

    }

}
