package edu.sundot;

import org.junit.Test;

import static junit.framework.TestCase.assertNull;

/**
 * Created by rahul on 2/24/17.
 */
public class AlgoUtilsTest {
    @Test
    public void reverse_1() throws Exception {
        String input = "abcde";
        String output = AlgoUtils.reverse(input);
        String expected = "edcba";
        assert (expected.equals(output));
    }

    @Test
    public void reverse_2() throws Exception {
        String input = "abcdef";
        String output = AlgoUtils.reverse(input);
        String expected = "fedcba";
        assert (expected.equals(output));
    }

    @Test
    public void swapOnIndex_1() throws Exception {
        String input = null;
        String output = AlgoUtils.swapOnIndex(input, 2, 3);
        assertNull(output);
    }

    @Test
    public void swapOnIndex_2() throws Exception {
        String input = "";
        String expected = "";
        String output = AlgoUtils.swapOnIndex(input, 2, 3);
        assert (output.equals(expected));
    }

    @Test
    public void swapOnIndex_3() throws Exception {
        String input = "abcdef";
        String expected = "aecdbf";
        String output = AlgoUtils.swapOnIndex(input, 1, 4);
        assert (output.equals(expected));
    }

    @Test
    public void swapOnIndex_4() throws Exception {
        String input = "abcde";
        String expected = "adcbe";
        String output = AlgoUtils.swapOnIndex(input, 1, 3);
        assert (output.equals(expected));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void swapOnIndex_5() throws Exception {
        String input = "abcde";
//        String expected = "adcbe";
        String output = AlgoUtils.swapOnIndex(input, 1, 8);
    }
}