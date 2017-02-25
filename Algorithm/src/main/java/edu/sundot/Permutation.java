package edu.sundot;

import java.security.InvalidParameterException;
import java.util.*;

/**
 * Created by rahul on 2/24/17.
 */
public class Permutation {

    public static Set<String> getPermutationForDistinctValues(String value) {
        if (value.length() == 0) return new HashSet<>();

        if (value.length() == 1) {
            Set<String> result = new HashSet<>();
            result.add(value);
            return result;
        }

        if (value.length() == 2) {
            Set<String> values = new HashSet<>();
            values.add(value);
            values.add(AlgoUtils.reverse(value));
            return values;
        }

        Set<String> values = new HashSet<>();
        int i = 0, j = 1, end = value.length();
        while (i != end) {
            String prefix = value.substring(i, j);
            String next = value.substring(0, i) + value.substring(j);
            Set<String> res = getPermutationForDistinctValues(next);
            for (String item : res) {
                values.add(prefix + item);
            }
            i++;
            j++;
        }
        return values;
    }

    public static List<String> recurse(String input) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            charMap.compute(c, (key, value) -> value == null ? 1 : value + 1);
        }

        int depth = 0;
        char[] res = new char[input.length()];
        List<String> resList = new ArrayList<>();
        recurseHelper(resList, charMap, res, depth);
        return resList;
    }

    private static void recurseHelper(List<String> resList, Map<Character, Integer> charMap, char[] res, int depth) {
        if (depth == res.length) {
            resList.add(String.copyValueOf(res));
        }

        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            if (entry.getValue() == 0)
                continue;

            res[depth] = entry.getKey();
            charMap.compute(entry.getKey(), (key, value) -> value - 1);
            recurseHelper(resList, charMap, res, depth + 1);
            charMap.compute(entry.getKey(), (key, value) -> value + 1);
        }
    }

    public static void main(String[] args) {
        List<String> items = recurse("aaabbbc");
        items.forEach(System.out::println);
        System.out.println(items.size());

//        ArrayList<String> result = generateParens(3);
//        result.forEach(System.out::println);
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
