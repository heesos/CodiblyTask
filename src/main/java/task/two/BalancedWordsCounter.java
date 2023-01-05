package task.two;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Class responsible for checking how many balanced substrings does the String.
 * Balanced String is a String in which every letter occurs the same amount of times.
 * @author Miłosz
 */
public class BalancedWordsCounter {

    public BalancedWordsCounter() {
    }


    /**
     * Method responsible for counting all balanced substrings in a String
     * @param input a String to check
     * @return      amount of balanced substrings
     */
    public Integer count(String input) {
        if (input == null) {
            throw new RuntimeException("Given input is null");
        } else if (anyDigit(input)) {
            throw new RuntimeException("Given input contains at least one digit");
        }

        Integer counter = 0;
        int size = input.length();

        for (int i = 0; i < size; i++) {
            for (int j = i+1; j <= size; j++) {
               String substring = input.substring(i,j);
               HashMap<Character, Integer> charRepetitions = new HashMap<>();

               for (int k = 0; k < substring.length(); k++) {
                   Character character = substring.charAt(k);
                   if (charRepetitions.containsKey(character)) {
                       Integer value = charRepetitions.get(character);
                       charRepetitions.put(character, value + 1);
                   } else {
                       charRepetitions.put(character, 1);
                   }
               }

               if (areValuesTheSame(charRepetitions)) {
                   counter++;
               }
            }
        }

        return counter;
    }

    /**
     * Method checking whether String contains any digits
     * @param input a String to check
     * @return      true if contains any digits
     */
    private boolean anyDigit(String input) {
        boolean isDigit = false;

        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                isDigit = true;
                break;
            }
        }

        return isDigit;
    }


    /**
     * Method which checks whether all values in hashMap are the same
     * @param hashMap
     * @return      true if all the values are the same
     */
    private boolean areValuesTheSame(HashMap<?,?> hashMap) {
        return (new HashSet<Object>(hashMap.values()).size() == 1);
    }
}
