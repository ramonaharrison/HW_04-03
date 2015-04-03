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

    public static ArrayList<Integer> getIntArray() {                // populates an ArrayList with less than 100 random integers less than 100
        ArrayList<Integer> intArray = new ArrayList<Integer>();
        Random rand = new Random();

        int size = rand.nextInt(100);
        for (int i = 0; i < size; i++) { intArray.add(rand.nextInt(100)); }
        return intArray;

    }

    public static int search(ArrayList<Integer> alist, int x) {
        return alist.indexOf(x);                                 // searches the ArrayList for the first index of x
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> intArray = getIntArray();
        System.out.println(intArray);

        while (true) {
            System.out.println("Enter an integer between 0 and 100 to find its index in the list:");
            int x = scanner.nextInt();
            int indexOfX = search(intArray, x);

            if (indexOfX != -1) { System.out.println(x + " is at index " + indexOfX + ".\n"); }
            else { System.out.println(x + " isn't in the list.\n"); }

        }

    }

}
