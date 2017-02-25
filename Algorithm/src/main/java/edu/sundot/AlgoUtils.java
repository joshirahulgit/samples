package edu.sundot;

import java.security.InvalidParameterException;

/**
 * Created by rahul on 2/24/17.
 */
public class AlgoUtils {

    public static String reverse(String value) {
        if (value == null) return null;

        if (value.length() == 1)
            return value;

        int size = value.length();
        char[] items = value.toCharArray();
        for (int i1 = 0; i1 < size / 2; i1++) {
            int i2 = size - 1 - i1;
            swapOnIndex(items, i1, i2);
        }
        return String.copyValueOf(items);
    }

    public static int getFactorial(int value) {
        if (value == 0)
            return 0;

        if (value == 1 || value == 2)
            return value;

        return getFactorial(value - 1) * value;
    }

    public static String swapOnIndex(String input, int index1, int index2) {
        if (input == null)
            return null;

        if (input.isEmpty())
            return "";

        if (index1 < 0 || index1 > input.length() - 1 || index2 < 0 || index2 > input.length() - 1)
            throw new IndexOutOfBoundsException("Index is too large or too small for input.");

        if (input.length() == 1 || index1 == index2)
            return input;

        char[] items = input.toCharArray();
        swapOnIndex(items, index1, index2);
        return new String(items);
    }

    private static void swapOnIndex(char[] items, int i1, int i2) {
        if (items == null)
            throw new InvalidParameterException("Items is null.");

        if (i1 < 0 || i1 > items.length - 1 || i2 < 0 || i2 > items.length - 1)
            throw new IndexOutOfBoundsException("Value of i1 or i2 is out index.");

        if (i1 == i2)
            return;

        if (items[i1] == items[i2])
            return;

        char temp = items[i1];
        items[i1] = items[i2];
        items[i2] = temp;
    }

}
