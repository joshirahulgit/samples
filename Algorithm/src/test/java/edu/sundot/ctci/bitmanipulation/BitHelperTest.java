package edu.sundot.ctci.bitmanipulation;

import org.junit.Test;

/**
 * Created by rahul on 2/17/17.
 */
public class BitHelperTest {
    @Test
    public void testXOR() throws Exception {
        System.out.println(BitHelper.xor(5, 9));
    }

    @Test
    public void testAnd() throws Exception {
        System.out.println(BitHelper.and(12, 1));
    }
}