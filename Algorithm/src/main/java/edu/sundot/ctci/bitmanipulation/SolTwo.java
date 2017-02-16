package edu.sundot.ctci.bitmanipulation;

/**
 * Created by rahul on 2/15/17.
 */
public class SolTwo {

    public static String getRealNoBetweenZeroOneUsingMul(double num) {
        if (num >= 1 || num <= 0) {
            return "ERROR";
        }

        StringBuilder result = new StringBuilder(".");

        while (num != 0) {
            if (result.length() > 32) {
                return "ERROR";
            }

            double mul = num * 2;
            if (mul >= 1) {
                result.append(1);
                num = mul - 1;
            } else {
                result.append(0);
                num = mul;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(getRealNoBetweenZeroOneUsingMul(.75));
        System.out.println(getRealNoBetweenZeroOneUsingMul(.65));
        System.out.println(getRealNoBetweenZeroOneUsingMul(.625));
    }
}
