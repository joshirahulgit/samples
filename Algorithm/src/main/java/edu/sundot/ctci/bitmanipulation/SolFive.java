package edu.sundot.ctci.bitmanipulation;

/**
 * Created by rahul on 2/17/17.
 */
public class SolFive {
    public static int bitFlipCount(int a, int b) {
        int count = 0;
        for (int i = a ^ b; i != 0; i = i >> 1) {
            count += i & 1;
        }
        return count;
    }
}
