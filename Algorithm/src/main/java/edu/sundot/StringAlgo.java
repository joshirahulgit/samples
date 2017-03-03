package edu.sundot;

import java.util.*;

/**
 * Created by Rahul on 3/2/2017.
 */
public class StringAlgo {

    public static List<List<Integer>> getAllSubset(int[] items) {
        List<List<Integer>> allSubset = new LinkedList<>();

        for (int i = 0; i < items.length; i++) {
            for (int j = i; j < items.length; j++) {
                List<Integer> newSubset = new LinkedList<>();
                for (int k = i; k <= j; k++) {
                    newSubset.add(items[k]);
                }
                allSubset.add(newSubset);
            }
        }
        return allSubset;
    }
}
