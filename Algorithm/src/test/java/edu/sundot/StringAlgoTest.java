package edu.sundot;

import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * Created by Rahul on 3/2/2017.
 */
public class StringAlgoTest {
    @Test
    public void getAllSubset() throws Exception {
        int[] input = {1, 2, 3, 4};
        List<List<Integer>> output = StringAlgo.getAllSubset(input);
        output.forEach(System.out::println);
        assert (output.size() == 10);
    }
}