package edu.sundot;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
            values[1] = AlgoUtils.reverse(value);
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

    public static void main(String[] args) {
        ArrayList<String> result = generateParens(3);
        result.forEach(System.out::println);
    }

    public static ArrayList<String> generateParens(int count) {
        char[] str = new char[count * 2];
        ArrayList<String> list = new ArrayList<>();
        addParen(list, count, count, str, 0);
        return list;
    }

    private static void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int count) {
        if (leftRem < 0 || rightRem < leftRem)
            return;

        if (leftRem == 0 && rightRem == 0) {
            String s = String.copyValueOf(str);
            list.add(s);
        } else {
            if (leftRem > 0) {
                str[count] = '(';
                addParen(list, leftRem - 1, rightRem, str, count + 1);
            }

            if (rightRem > leftRem) {
                str[count] = ')';
                addParen(list, leftRem, rightRem - 1, str, count + 1);
            }
        }
    }

    public static Set<String> getAllParensPairs(int count) {
        if (count < 0)
            throw new InvalidParameterException("Count can't be negative value.");

        Set<String> parens = new HashSet<>();
        if (count == 0)
            return parens;

        if (count == 1) {
            parens.add("()");
            return parens;
        }

        Set<String> parensOfLast = getAllParensPairs(count - 1);
        for (String paren : parensOfLast) {
            for (int i = 0; i < paren.length(); i++) {
                if (paren.charAt(i) == '(') {
                    String left = getLeft(paren, i);
                    String right = getRight(paren, i);
                    parens.add(left);
                    parens.add(right);
                }
            }
        }

        return parens;
    }

    private static String getRight(String value, int i) {
        String before = i < 0 ? "" : value.substring(0, i + 1);
        String after = i < 0 ? value : value.substring(i + 1);
        return before + "()" + after;
    }

    private static String getLeft(String value, int i) {
        String before = value.substring(0, i);
        String after = value.substring(i);
        return before + "()" + after;
    }

}
