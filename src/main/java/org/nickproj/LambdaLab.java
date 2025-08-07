package org.nickproj;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LambdaLab {
    public static void main(String[] args) {

//Exercise 1: The "New Way" - A Simple Lambda Expression
        // Create the same Predicate using a lambda expression.
        Predicate<String> isLong = s -> s.length() > 10;

        String str1 = "short";
        String str2 = "This is a very long string";

        System.out.println("Is '" + str1 + "' long? " + isLong.test(str1));
        System.out.println("Is '" + str2 + "' long? " + isLong.test(str2));
        //Prediction: false, true
        //Outcome: as expected
//Exercise 3: Using Predicates to Filter a List
        List<String> callSigns = new ArrayList<>();
        callSigns.add("Alpha");
        callSigns.add("Bravo");
        callSigns.add("Archangel");
        callSigns.add("Echo");
        callSigns.add("Avenger");

        // Define a predicate with a lambda to find call signs starting with "A"
        Predicate<String> startsWithA = s -> s.startsWith("A");

        // Pass the list and the predicate (the behavior) to our method
        filterAndPrint(callSigns, startsWithA, "Call signs starting with 'A'");

        //Prediction: Alpha, Archangel, Avenger
        //Outcome: as expected

//Exercise 4: Chaining Predicates (and, negate)
        callSigns = new ArrayList<>();
        callSigns.add("Alpha");
        callSigns.add("Bravo");
        callSigns.add("Archangel");
        callSigns.add("Echo");
        callSigns.add("Avenger");

        startsWithA = s -> s.startsWith("A");
        Predicate<String> hasLengthGreaterThan5 = s -> s.length() > 5;

        // Let's find call signs that start with 'A' AND have a length > 5
        Predicate<String> complexCondition = startsWithA.and(hasLengthGreaterThan5);
        filterAndPrint(callSigns, complexCondition, "Starts with 'A' AND length > 5");

        // Now let's find call signs that do NOT start with 'A'
        Predicate<String> doesNotStartWithA = startsWithA.negate();
        filterAndPrint(callSigns, doesNotStartWithA, "Does NOT start with 'A'");
        //Prediction:
//            First filter and print: Archangel, Avenger
//            Second filter and print: Bravo, Echo
        //Outcome: As expected

    }

    public static void filterAndPrint(List<String> list, Predicate<String> predicate, String description) {
        System.out.println("--- " + description + " ---");
        for (String item : list) {
            // Use the predicate's test method to filter
            if (predicate.test(item)) {
                System.out.println(item);
            }
        }
        System.out.println(); // Adds a blank line
    }
}