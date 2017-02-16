package edu.sundot.ctci.bitmanipulation;

/**
 * Created by rahul on 2/15/17.
 */
public class SolOne {

    public static void main(String[] args) {
        int n = 1024;
        int m = 19;
        int i = 2;
        int j = 6;
        System.out.println(updateBits(n, m, i, j));
    }

    public static int updateBits(int n, int m, int i, int j) {
        int allOnes = ~0; //will be equal sequence of all 1's
        int left = allOnes << (j + 1);
        int right = (1 << i) - 1;
        int mask = left | right;
        int n_cleared = n & mask;
        int m_shifted = m << i;
        return n_cleared | m_shifted;
    }
}
