package edu.sundot;

import edu.sundot.adt.Pair;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by rahul on 2/24/17.
 */
public class NumArrayProbTest {
    @Test
    public void getAllPairForSumValue() throws Exception {
        int[] items = {5, 7, 9, 3, 2, 1, 4, 6};
        int sum = 10;

        Pair[] expected = {new Pair(7, 3), new Pair(9, 1), new Pair(4, 6)};

        List<Pair> output = NumArrayProb.getAllPairForSumValue(items, sum);
        assert (Arrays.equals(expected, output.toArray()));
    }

}