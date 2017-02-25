package edu.sundot;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;

/**
 * Created by rahul on 2/24/17.
 */
public class PermutationTest {
    @Test
    public void getPermutationForDistinctValues() throws Exception {
        String[] items = Permutation.getPermutationForDistinctValues("abc");
        for (String item : items) {
            System.out.println(item);
        }
        System.out.println("Total: " + items.length);
    }

    @Test
    public void generateParens() throws Exception {
        String[] expected = {"()()()", "()(())", "(()())", "(())()", "((()))"};
        Set<String> items = Permutation.getAllParensPairs(3);
//        items.forEach(System.out::println);
        assert (Arrays.equals(expected, items.toArray()));
    }

}