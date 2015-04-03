package nyc.c4q.ramonaharrison;

/**
 * Access Code 2.1
 * Ramona Harrison
 * LettersInNumbers.java
 * Total number of letters in 'written out' numbers from 1 to 1000
 */

public class LettersInNumbers {

    public static int countLetters(int n) {

        int[] digits = {0,3,3,5,4,4,3,5,5,4};       // character lengths of numbers
        int[] teens =  {3,6,6,8,8,7,7,9,8,8};
        int[] tens =   {0,3,6,6,5,5,5,7,6,6};
        int hundred =  7;
        int thousand = 8;
        int and =      3;

        int total = 0;
        int i;

            if (n == 1000) {
                total = digits[1] + thousand;
                n = 0;
            }

            if (n >= 100) {
                i = n / 100;                        // finds how many hundreds to add to total (index of array)
                total += digits[i] + hundred;
                n = n % 100;                        // sets n < 100
                if (n > 0) {
                    total += and;                   // if n has a remainder after hundreds, adds 'and'
                }
            }

            if (n >= 20) {
                i = n / 10;                         // if n >= 20, finds how many tens to add
                total += tens[i];
                n = n % 10;                         // sets n < 10
            }

            if (n >= 10) {                          // otherwise, if n >= 10, finds what 'teen' value to add
                i = n - 10;
                total += teens[i];
                n = 0;                              // sets n to 0
            }

            if (n > 0) {                            // otherwise, if n < 10, finds what single digit to add
                i = n;
                total += digits[i];
            }

        return total;
    }

    public static void main(String[] args) {

        int sum = 0;
        for (int i = 0; i <= 1000; i++) {
            sum += countLetters(i);
        }
        System.out.println("The total is: " + sum);
    }

}
