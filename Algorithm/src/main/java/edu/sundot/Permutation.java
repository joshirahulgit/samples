package edu.sundot;

/**
 * Created by rahul on 2/24/17.
 */
public class Permutation {

    public static String[] getPermutationForDistinctValues(String value) {
        if (value.length() == 0) return new String[0];

        if (value.length() == 1) return new String[]{value};

        if (value.length() == 2) {
            String[] values = new String[2];
            values[0] = value;
            values[1] = reverseTwoChar(value);
            return values;
        }

        int factorial = getFactorial(value.length());
        String[] values = new String[factorial];
        int current = 0;
        int i = 0, j = 1, end = value.length();
        while (i != end) {
            String prefix = value.substring(i, j);
            String next = value.substring(0, i) + value.substring(j);
            String[] res = getPermutationForDistinctValues(next);
            for (String item : res) {
                values[current] = (prefix + item);
                current++;
            }
            i++;
            j++;
        }
        return values;
    }

    private static int getFactorial(int value) {
        if (value == 0)
            return 0;

        if (value == 1 || value == 2)
            return value;
        return getFactorial(value - 1) * value;
    }

    private static String reverseTwoChar(String value) {
        if (value.length() != 2)
            throw new StringIndexOutOfBoundsException("Exactly two characters allowed.");

        String rev = value.substring(1) + value.substring(0, 1);
        return rev;
    }

    public static void main(String[] args) {
        String[] items = getPermutationForDistinctValues("abc");
        for (String item : items) {
            System.out.println(item);
        }
        System.out.println("Total: " + items.length);
    }

}
