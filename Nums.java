import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Nums {

    Random rand;
    Map<Integer, Integer> numHash; // Map to hold unique number counts in values
    String[] uniqueString;

    public Nums() {
        rand = new Random();
        numHash = new HashMap<Integer, Integer>();
        uniqueString = new String[3];

        /* Initialize all the unique number's value to 0 */
        numHash.put(1, 0);
        numHash.put(2, 0);
        numHash.put(3, 0);
        numHash.put(4, 0);
        uniqueString[0] = "0000";
        uniqueString[1] = "0000";
        uniqueString[2] = "0000";
    }

    /**
     * Returns a string of four digits (1 to 4) in random order No repeats, all four
     * numbers 1 to 4 are represented
     */
    public String rando() {

        int first = rand.nextInt(4) + 1; // First item (random 1 to 4)
        String numString = Integer.toString(first); // put first into return String
        numHash.put(first, numHash.get(first) + 1); // increase first's value to 1

        int count = 1;
        while (count < 4) {
            int place = rand.nextInt(4) + 1; // Try a random num 1 to 4
            if (numHash.get(place) == 0) { // If it's value is 0, means we haven't seen it
                numString += Integer.toString(place); // Put it in string
                numHash.put(place, numHash.get(place) + 1); // increase its value
                count++;
            }
        }
        numHash.replaceAll((k, v) -> 0); // Reset all values to 0
        return numString;
    }

    /**
     * 
     * @param test1 tester
     * @param test2 array already exists
     * @return true if they are the same, false if they are different
     */
    public boolean same(String test1, String test2) {
        return (test1.charAt(0) == test2.charAt(0) || test1.charAt(1) == test2.charAt(1)
                || test1.charAt(2) == test2.charAt(2) || test1.charAt(3) == test2.charAt(3));
    }

    /**
     * Creates a set of 3 strings (length 4) that have 1 to 4 (unique) randomized in
     * each
     * 
     * @return set of strings
     */
    public void uniqueSequence() {

        int count = 0;

        while (count < 3) {

            String tester = rando();

            if (!tester.equals("1234") && !tester.equals("4321")) {

                if (!same(tester, uniqueString[0]) && !same(tester, uniqueString[1])
                        && !same(tester, uniqueString[2])) {
                    uniqueString[count] = tester;
                    count++;
                }
            }
        }
    }
}
