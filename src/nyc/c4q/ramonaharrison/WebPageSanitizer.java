package nyc.c4q.ramonaharrison;

import java.util.Scanner;
import java.net.URL;

/**
 * Access Code 2.1
 * Ramona Harrison
 * WebPageSanitizer.java
 * This class removes all script tags (and encapsulated information) from an HTML string
 *
 */

public class WebPageSanitizer {

    public static String sanitize(String HTML) {
        Scanner readHTML = new Scanner(HTML);
        readHTML.useDelimiter("[<]");
        String sanitizedHTML = "";
        int count = 0;
                                                                    // scans HTML using tag 'open bracket' as the delimiter

        while (readHTML.hasNext()) {
            String line = readHTML.next();
            if (line.startsWith("script")) {
                while (!readHTML.next().startsWith("/script")) {    // if the tag starts with 'script', ignores all content until '/script' tag is reached
                    sanitizedHTML += "";
                }
                count++;                                            // tracks number of script blocks removed
                continue;
            }
            sanitizedHTML += "<" + line;                            // otherwise, replaces open bracket and concatenates to sanitized string
        }

        return "\nHere's your sanitized HTML:\n\n" + sanitizedHTML + "\n\n[" + count + " script tag(s) removed]\n" ;
    }

    public static String grabHTML(String stringURL) {
        URL url = HTTP.stringToURL(stringURL);                      // converts input string to url and grabs content
        if (url == null) {
            return "invalid";
        }
        return HTTP.get(url);

    }





    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);                     // accepts user input for simplified testing
        System.out.println("This program removes <script> tags and their encapsulated content from an HTML document.\n");

        while (true) {
            System.out.println("Please enter a URL for the page you'd like to sanitize:");
            String userURL = input.next();                          // prompts user for url
            String htmlWithScriptTags = grabHTML(userURL);          // grabs HTML from url
            if (htmlWithScriptTags.equals("invalid")) {             // returns to prompt if url is invalid
                continue;
            }
            System.out.println(sanitize(htmlWithScriptTags));       // prints sanitized HTML with # of script tags removed
        }

    }

}
