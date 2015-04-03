package nyc.c4q.ramonaharrison;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Access Code 2.1
 * Ramona Harrison
 * DistributionCalculator.java
 * Calculates the distribution of alphabetic characters in a text file
 */

public class DistributionCalculator {

    public static ArrayList<Double> calculate(File textFile) throws FileNotFoundException {

        ArrayList<Double> count = new ArrayList<Double>();  // populates array with a count of each letter in the file (index 0 = a, index 25 = z)
        while(count.size() < 26) count.add(0.0);
        Scanner file = new Scanner(textFile);

        while (file.hasNext()) {
            String word = file.next().toLowerCase();
            for (int i = 0; i < word.length(); i++) {       // for each letter of each word in the file:
                char letter = word.charAt(i);
                if (letter > 96 && letter < 123) {          // if letter is alphabetic:
                    if (count.get(letter - 97) == 0) {      // - and new, add to array
                        count.set(letter - 97, 1.0);
                    } else {                                // - and already in the array, increment its count
                        count.set(letter - 97, count.get(letter - 97) + 1.0);
                    }

                }

            }

        }

        ArrayList<Double> distribution = new ArrayList<Double>();

        double totalChars = 0.0;
        for (double letterTotal : count) {                  // sums total letters in file
             totalChars += letterTotal;
        }

        for (double letterTotal : count) {                  // maps each letter's distribution to the ArrayList
            distribution.add((letterTotal/totalChars) * 100);
        }

        return distribution;

    }

    public static void main(String[] args) throws FileNotFoundException {
        File text = new File("/Users/mona/Desktop/accesscode/HW_04-03/state of the union.txt");
        ArrayList<Double> distribution = calculate(text);

        int alpha = 97;
        for (Double dist : distribution) {
            System.out.print((char) alpha);
            System.out.printf(" = %.2f", dist);
            System.out.print("%\n");
            alpha++;
        }

    }

}
