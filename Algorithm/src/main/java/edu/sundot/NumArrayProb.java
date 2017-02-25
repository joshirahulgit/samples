package edu.sundot;

import edu.sundot.adt.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rahul on 2/24/17.
 */
public class NumArrayProb {

    public static List<Pair> getAllPairForSumValue(int[] items, int sum) {
        List<Pair> resultPairs = new ArrayList<>();
        Map<Integer, Integer> coPair = new HashMap<>();
        if (items == null)
            return null;

        if (items.length < 2)
            return resultPairs;

        for (int item : items) {
            if (!coPair.containsKey(item))
                coPair.put(sum - item, item);
            else {
                Pair pair = new Pair(coPair.get(item), item);
                resultPairs.add(pair);
                coPair.remove(item);
            }
        }
        return resultPairs;
    }

}
